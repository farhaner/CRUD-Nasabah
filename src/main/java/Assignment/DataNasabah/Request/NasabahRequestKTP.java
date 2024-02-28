package Assignment.DataNasabah.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NasabahRequestKTP {
    private String namaLengkap;
    private String nomerKtp;
}
