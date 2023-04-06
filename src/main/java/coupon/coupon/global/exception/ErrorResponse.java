package coupon.coupon.global.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorResponse {

    private final String errorMessage;

    public ErrorResponse(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
