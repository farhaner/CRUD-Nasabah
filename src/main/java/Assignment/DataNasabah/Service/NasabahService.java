package Assignment.DataNasabah.Service;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;

import java.util.List;

public interface NasabahService {
    NasabahResponse createNasabah(NasabahRequest request);
    NasabahResponse getNasabahById(NasabahRequest request);
    NasabahResponse findByNomerKtp(NasabahRequest nomerKtp);
    List<NasabahEntity> getAllNasabah();
    NasabahResponse updateNasabah(NasabahRequest request);
    void deleteNasabah(String id);

}
