package Assignment.DataNasabah.Repository;

import Assignment.DataNasabah.Entity.NasabahEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface NasabahRepository extends JpaRepository<NasabahEntity, String> {
        NasabahEntity findByNomerKtp(String nomerKtp);
        NasabahEntity findByNamaLengkap(String namaLengkap);

    List<NasabahEntity> findByNamaLengkapContaining(String namaLengkap);
//    List<NasabahEntity> findByIdContainingOrNamaLengkapContainingOrAlamatContainingOrTempatLahirContainingOrTanggalLahirContainingOrNomerKtpContainingOrNomerHanphoneContaining(String request);
    @Query(value = "SELECT * FROM customer WHERE id LIKE %?1% OR nama_lengkap LIKE %?1% OR alamat LIKE %?1% OR tempat_lahir LIKE %?1% OR tanggal_lahir LIKE %?1% OR no_ktp LIKE %?1% OR no_hp LIKE %?1%", nativeQuery = true)
    List<NasabahEntity> findSearchKeyword(String keyword, Pageable pageable);

//    List<NasabahEntity> findByIdLikeOrNamaLengkapLikeOrAlamatLikeOrTempatLahirLikeOrTanggalLahirLikeOrNomerKtpLikeOrNomerHanphoneLike(String requestId, String requestNamaLengkap, String requestAlamat, String requestTempatlahir, String requestTanggalLahir, String requestNomerKtp, String requestNomerHandphone);


    //    List<NasabahEntity> findAll
//    Page<List<NasabahEntity>> findByIdContainingOrAlamatContainingOrNamaLengkapContainingOrTanggalLahirContainingOrTempatLahirContainingOrNomerHanphoneContainingOrNomerKtpContaining(String id, String namaLengkap, String tanggalLahir, String tempatLahir, String nomerHandphone, String nomerktp, String alamat, Pageable pageable);
//    List<NasabahEntity> findByIdContaining(String id);
//    List<NasabahEntity> findByAlamatContaining(String alamat);
//
//    List<NasabahEntity> findByTempatLahirContaining(String tempatLahir);
//    List<NasabahEntity> findByTempatLahirContaining(String te)
    }
