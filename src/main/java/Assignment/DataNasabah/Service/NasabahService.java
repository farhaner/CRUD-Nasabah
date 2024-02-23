package Assignment.DataNasabah.Service;

import Assignment.DataNasabah.Entity.NasabahEntity;
import Assignment.DataNasabah.Request.NasabahRequest;
import Assignment.DataNasabah.Response.NasabahResponse;

import java.util.List;

public interface NasabahService {
    NasabahResponse createNasabah(NasabahRequest request);
    NasabahEntity getNasabahById(NasabahRequest request);
    NasabahResponse findByNomerKtp(NasabahRequest request);
    List<NasabahResponse> getAllNasabah();
    NasabahResponse updateNasabah(NasabahRequest request);
    void deleteNasabah(String id);

}
