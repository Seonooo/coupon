package coupon.coupon.coupon.exception;

public enum CouponException {

    NOT_EXISTS_COUPON("해당 쿠폰이 존재하지 않습니다."),
    ALREADY_EXISTS_COUPON("해당 쿠폰이 이미 존재합니다.");

    private String message;
    CouponException(String message) {
        this.message = message;
    }

    private String getMessage(String message){
        return message;
    }
}
