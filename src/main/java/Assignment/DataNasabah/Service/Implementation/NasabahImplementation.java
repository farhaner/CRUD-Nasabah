package Assignment.DataNasabah.Service.Implementation;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Repository.NasabahRepository;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;
import Assignment.DataNasabah.Service.NasabahService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NasabahImplementation implements NasabahService {
    private final NasabahRepository nasabahRepository;

    @Transactional
    @Override
    public NasabahResponse createNasabah(NasabahRequest request) {
        NasabahEntity nasabah = NasabahEntity.builder()
                .id(request.getId())
                .namaLengkap(request.getNamaLengkap())
                .alamat(request.getAlamat())
                .tempatLahir(request.getTempatLahir())
                .tanggalLahir(request.getTanggalLahir())
                .nomerKtp(request.getNomerKtp())
                .nomerHanphone(request.getNomerHanphone())
                .build();
        nasabahRepository.save(nasabah);
        return nasabahResponse(nasabah);
    }

    @Override
    public List<NasabahResponse> getAllNasabah() {
        List<NasabahEntity> nasabahEntities = nasabahRepository.findAll();
        List<NasabahResponse> nasabahResponses = nasabahEntities.stream()
                .map(nasabah -> nasabahResponse(nasabah)).collect(Collectors.toList());
        return nasabahResponses;
    }

    @Override
    public NasabahEntity getNasabahById(String request) {
        NasabahEntity nasabahEntities = nasabahRepository.findById(request).get();
        return nasabahEntities;
    }

    @Override
    public NasabahEntity findByNomerKtp(String request) {
        return nasabahRepository.findByNomerKtp(request);
    }
    @Override
    public NasabahResponse updateNasabah(NasabahRequest request) {
        NasabahEntity nasabah = nasabahRepository.findById(request.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nasabah not found"));
        if (Objects.nonNull(nasabah)) {
            nasabah.getId();
            nasabah.setNamaLengkap(request.getNamaLengkap());
            nasabah.setAlamat(request.getAlamat());
            nasabah.setTempatLahir(request.getTempatLahir());
            nasabah.setTanggalLahir(request.getTanggalLahir());
            nasabah.setNomerKtp(String.valueOf(request.getNomerKtp()));
//            nasabah.setno
            nasabah.setNomerHanphone(request.getNomerHanphone());
            nasabahRepository.saveAndFlush(nasabah);

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
                    .id(nasabah.getId())
                    .namaLengkap(nasabah.getNamaLengkap())
                    .alamat(nasabah.getAlamat())
                    .tempatLahir(nasabah.getTempatLahir())
                    .tanggalLahir(nasabah.getTanggalLahir())
                    .nomerKtp(nasabah.getNomerKtp())
                    .nomerHanphone(nasabah.getNomerHanphone())
                    .build();
        }

}
