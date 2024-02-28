package Assignment.DataNasabah.Controller;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Request.Keyword;
import Assignment.DataNasabah.Request.NasabahRequestKTP;
import Assignment.DataNasabah.Response.CommonResponse;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;
import Assignment.DataNasabah.Service.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/nasabah")
public class NasabahController {

    private final NasabahService nasabahService;
    private Keyword request;

    @PostMapping
    public ResponseEntity<?> createNasabah(@RequestBody NasabahRequest request) {
        NasabahResponse nasabahResponse = nasabahService.createNasabah(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Nasabah created")
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @PostMapping(value = "/search")
    public ResponseEntity<?> getNasabahBySearch(@RequestBody Keyword request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getRow());
        List<NasabahEntity> searchByKeyword = nasabahService.findSearchKeyword(request.getKeyword(), pageable);
        if (searchByKeyword != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(searchByKeyword)
                            .message("Get Data Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(searchByKeyword)
                            .message("Get Data Failed")
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }
    }

    @PostMapping(value = "/V1/")
    public ResponseEntity<?> getNasabahByKtpWithReqBody(@RequestBody NasabahRequestKTP request){
        NasabahEntity nasabahResponse = nasabahService.findByNomerKtp(request.getNomerKtp());
        NasabahEntity nasabahResponse1 = nasabahService.findByNamaLengkap(request.getNamaLengkap());
        List<NasabahEntity> nasabahNameContaining = nasabahService.findByNamaLengkapContaining(request.getNamaLengkap());
        //        System.out.println(request.getNamaLengkap());
        if (nasabahResponse != null && nasabahResponse1 != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Get Nasabah Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());
        } else if (nasabahResponse != null || nasabahNameContaining != null) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse != null ? nasabahResponse : nasabahNameContaining)
                            .message("Get Nasabah Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());
    }else if (nasabahResponse != null || nasabahResponse1 != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse != null ? nasabahResponse : nasabahResponse1)
                            .message("Get Nasabah By KTP Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .message("Get Nasabah With KTP "+ request +" Is Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }
    }

    @GetMapping(value = "/V1/{nomerKtp}")
    public ResponseEntity<?> getNasabahByKtp(@PathVariable String nomerKtp){
        NasabahEntity nasabahResponse = nasabahService.findByNomerKtp(nomerKtp);
        if (nasabahResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Get Nasabah By KTP Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .message("Get Nasabah With KTP "+nomerKtp+" Is Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }

        }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNasabahById(@PathVariable String id){
        NasabahEntity nasabahResponse = nasabahService.getNasabahById(id);
        if (nasabahResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Get Nasabah Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .message("Get Nasabah With Id "+id+" Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllNasabah(){
        List<NasabahResponse> nasabahResponse = nasabahService.getAllNasabah();
        if (nasabahResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Get All Nasabah Successfully")
                            .statusCode(HttpStatus.OK.value())
                            .build());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Nasabah Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());

        }
    }

    @PutMapping
    public ResponseEntity<?> updateNasabah(@RequestBody NasabahRequest request){
        NasabahResponse nasabahResponse = nasabahService.updateNasabah(request);
        if (nasabahResponse != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Nasabah Successfully Updated")
                            .statusCode(HttpStatus.OK.value())
                            .build());

        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .data(nasabahResponse)
                            .message("Nasabah With Id "+ request +" Is Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }
        }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteNasabah(@PathVariable String id) {
//        NasabahResponse nasabah = new NasabahResponse();
        NasabahEntity nasabahResponse = nasabahService.getNasabahById(id);
        if (nasabahResponse != null){
            nasabahService.deleteNasabah(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(CommonResponse.builder()
                            .message("Nasabah Successfully Deleted")
                            .statusCode(HttpStatus.OK.value())
                            .build());

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(CommonResponse.builder()
                            .message("Nasabah With Id "+ id +" Not Found")
                            .statusCode(HttpStatus.NOT_FOUND.value())
                            .build());
        }

//        try {
//            NasabahEntity nasabahResponse = nasabahService.getNasabahById(id);
//            if (nasabahResponse != null) {
//                nasabahService.deleteNasabah(id);
//                return ResponseEntity.status(HttpStatus.OK)
//                        .body(CommonResponse.builder()
//                                .message("Nasabah Successfully Deleted")
//                                .statusCode(HttpStatus.OK.value())
//                                .build());
//
//            }catch(NoSuchElementException e){
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body(CommonResponse.builder()
//                                .message("Nasabah With Id " + id + " Not Found")
//                                .statusCode(HttpStatus.NOT_FOUND.value())
//                                .build());
//            }
//        }
    }
}
