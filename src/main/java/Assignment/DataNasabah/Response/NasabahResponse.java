package Assignment.DataNasabah.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder(toBuilder = true)
public class NasabahResponse {

    private String id;
    private String namaLengkap;
    private String alamat;
    private String tempatLahir;
    private String tanggalLahir;
    private String nomerKtp;
    private String nomerHanphone;

}
