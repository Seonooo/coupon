package coupon.coupon.coupon.dto.coupon.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CouponStatus {

    USED("사용"),
    UNUSED("미사용"),
    DELETE("삭제"),
    EXPIRATION("기한만료");

    private final String status;
}
