package coupon.coupon.global.exception;

import coupon.coupon.coupon.exception.CouponErrorCode;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
public class ErrorResponse {

    private final String errorMessage;


    public static ResponseEntity<ErrorResponse> toResponseEntity(CouponErrorCode couponErrorCode) {
        return ResponseEntity
                .status(couponErrorCode.getCode())
                .body(ErrorResponse.builder()
                        .errorMessage(couponErrorCode.getMessage()).build());
    }
}
