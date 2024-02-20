package Assignment.DataNasabah.Request;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class NasabahRequest {

    private String id;
    private String namaLengkap;
    private String alamat;
    private String tempatLahir;
    private String tanggalLahir;
    private String nomerKtp;
    private String nomerHanphone;

}
