package coupon.coupon.coupon.dto.coupon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class CouponFindDto {

    private final String couponName;

    public CouponFindDto(String couponName) {
        this.couponName = couponName;
    }
}
