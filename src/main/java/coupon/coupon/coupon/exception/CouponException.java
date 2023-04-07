package coupon.coupon.coupon.exception;

import lombok.Getter;

@Getter
public class CouponException extends RuntimeException {
    private final CouponErrorCode couponErrorCode;

    public CouponException(CouponErrorCode couponErrorCode) {
        this.couponErrorCode = couponErrorCode;
    }
}
