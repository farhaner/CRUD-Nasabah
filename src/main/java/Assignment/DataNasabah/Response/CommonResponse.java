package Assignment.DataNasabah.Response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CommonResponse<T> {
        private Integer statusCode;
        private String message;
        private T data;
}
