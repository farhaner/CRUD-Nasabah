package Assignment.DataNasabah.Response;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NasabahResponse {

    private String namaLengkap;
    private String alamat;
    private String tempatLahir;
    private String tanggalLahir;
    private String nomerKtp;
    private String nomerHanphone;

}
