package Assignment.DataNasabah.Controller;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Response.CommonResponse;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;
import Assignment.DataNasabah.Service.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/nasabah")
public class NasabahController {

    private final NasabahService nasabahService;
    @PostMapping
    public ResponseEntity<?> createNasabah(@RequestBody NasabahRequest request){
        NasabahResponse nasabahResponse = nasabahService.createNasabah(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Nasabah created")
                        .statusCode(HttpStatus.CREATED.value())
                        .build());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getNasabahById(@PathVariable NasabahRequest id){
        NasabahResponse nasabahResponse = nasabahService.getNasabahById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Get Nasabah Successfully")
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping(value = "/{nomerKtp}")
    public ResponseEntity<?> getNasabahByKtp(@PathVariable NasabahRequest nomerKtp){
        NasabahResponse nasabahResponse = nasabahService.findByNomerKtp(nomerKtp);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Get Nasabah By KTP Successfully")
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @GetMapping(value = "/list")
    public ResponseEntity<?> getAllNasabah(){
        List<NasabahEntity> nasabahResponse = nasabahService.getAllNasabah();
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Get All Nasabah Successfully")
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping
    public ResponseEntity<?> updateNasabah(@RequestBody NasabahRequest request){
        NasabahResponse nasabahResponse = nasabahService.updateNasabah(request);
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .data(nasabahResponse)
                        .message("Nasabah Successfully Updated")
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteNasabah(@PathVariable String id){
        nasabahService.deleteNasabah(id);
        NasabahResponse nasabah = new NasabahResponse();
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .data(String.valueOf(nasabah))
                        .message("Nasabah Successfully Deleted")
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
}
