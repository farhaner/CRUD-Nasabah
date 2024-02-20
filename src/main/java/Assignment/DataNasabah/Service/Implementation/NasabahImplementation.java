package Assignment.DataNasabah.Service.Implementation;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;
import Assignment.DataNasabah.Repository.NasabahRepository;
import Assignment.DataNasabah.Service.NasabahService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class NasabahImplementation implements NasabahService {
    private final NasabahRepository nasabahRepository;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public NasabahResponse createNasabah(NasabahRequest request) {
        NasabahEntity nasabah = NasabahEntity.builder()
                .id(request.getId())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tempatLahir(request.getTempatLahir())
                .tanggalLahir(request.getTanggalLahir())
                .nomerKtp(String.valueOf(request.getNomerKtp()))
                .nomerHanphone(request.getNomerHanphone())
                .build();
        nasabahRepository.save(nasabah);
        return new NasabahResponse();
    }

    @Override
    public NasabahResponse getNasabahById(NasabahRequest request) {
        NasabahEntity nasabah = nasabahRepository.findById(String.valueOf(request)).get();
        return new NasabahResponse();

    }

    @Override
    public NasabahResponse findByNomerKtp(NasabahRequest nomerKtp) {
        NasabahResponse nasabah = nasabahRepository.findByNomerKtp(String.valueOf(nomerKtp));
        if (nasabah == null) {
            NasabahEntity nasabah1 = nasabahRepository.findById(String.valueOf(nomerKtp)).get();
            return null;
        }
        return nasabah;
    }

    @Override
    public List<NasabahEntity> getAllNasabah() {
        List<NasabahEntity> nasabahResponses = nasabahRepository.findAll();
        List<NasabahRequest> nasabahRequests = new ArrayList<>();
        for (NasabahEntity nasabah : nasabahResponses) {
            List<NasabahEntity> allNasabah = getAllNasabah();
            nasabahRequests.add((NasabahRequest) allNasabah);
        }
        return nasabahResponses;
    }
    @Override
    public NasabahResponse updateNasabah(NasabahRequest request) {
        NasabahEntity nasabah = nasabahRepository.findById(request.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nasabah not found"));
        if (Objects.nonNull(nasabah)) {
            nasabah.setNamaLengkap(request.getNamaLengkap());
            nasabah.setAlamat(request.getAlamat());
            nasabah.setTempatLahir(request.getTempatLahir());
            nasabah.setTanggalLahir(request.getTanggalLahir());
            nasabah.setNomerKtp(String.valueOf(request.getNomerKtp()));
            nasabah.setNomerHanphone(request.getNomerHanphone());
            nasabahRepository.save(nasabah);

            return nasabahResponse(nasabah);
        }

        return null;
    }

        @Override
        public void deleteNasabah(String request) {
        nasabahRepository.deleteById(request);
        }

        private static NasabahResponse nasabahResponse (NasabahEntity nasabah){
            return NasabahResponse.builder()
                    .namaLengkap(nasabah.getNamaLengkap())
                    .alamat(nasabah.getAlamat())
                    .tempatLahir(nasabah.getTempatLahir())
                    .tanggalLahir(nasabah.getTanggalLahir())
                    .nomerKtp(nasabah.getNomerKtp())
                    .nomerHanphone(nasabah.getNomerHanphone())
                    .build();
        }

}
