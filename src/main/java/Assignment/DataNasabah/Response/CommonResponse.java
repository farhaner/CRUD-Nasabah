package Assignment.DataNasabah.Response;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T> {
        private Integer statusCode;
        private String message;
        private Object data;
}
