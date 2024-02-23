package Assignment.DataNasabah.Repository;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Response.NasabahResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface NasabahRepository extends JpaRepository<NasabahEntity, String> {
        NasabahEntity findByNomerKtp(String nomerKtp);
    }
