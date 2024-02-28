package Assignment.DataNasabah.Service;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Request.Keyword;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NasabahService {
    NasabahResponse createNasabah(NasabahRequest request);
    NasabahEntity getNasabahById(String request);
    NasabahEntity findByNomerKtp(String request);
    NasabahEntity findByNamaLengkap(String request);
    List<NasabahEntity> findByNamaLengkapContaining(String request);

    List<NasabahEntity> findSearchKeyword(String request, Pageable page);

//    List<NasabahEntity> findByIdLikeOrNamaLengkapLikeOrAlamatLikeOrTempatLahirLikeOrTanggalLahirLikeOrNomerKtpLikeOrNomerHanphoneLike(String request, String requestNamaLengkap, String requestAlamat, String requestTempatlahir, String requestTanggalLahir, String requestNomerKtp, String requestNomerHandphone);
    //    Page<List<NasabahEntity>> findByIdContainingOrAlamatContainingOrNamaLengkapContainingOrTanggalLahirContainingOrTempatLahirContainingOrNomerHanphoneContainingOrNomerKtpContaining(String request, Pageable pageable);
    List<NasabahEntity> findAll();
    List<NasabahResponse> getAllNasabah();
    NasabahResponse updateNasabah(NasabahRequest request);
    void deleteNasabah(String id);

}
