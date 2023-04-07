package coupon.coupon.coupon.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Getter
public enum CouponErrorCode {

    NOT_EXISTS_COUPON(BAD_REQUEST, "해당 쿠폰이 존재하지 않습니다."),
    ALREADY_EXISTS_COUPON(BAD_REQUEST, "해당 쿠폰이 이미 존재합니다.");

    private final HttpStatus code;
    private final String message;

    CouponErrorCode(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

}
