package coupon.coupon.coupon.dto.coupon;

import coupon.coupon.coupon.entity.Coupon;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponResponseDto {

    private String couponCode;
    private String couponName;
    private Integer quantity;
    private Integer discount;
    private LocalDateTime startDateUse;
    private LocalDateTime deadlineUse;

    public CouponResponseDto(Coupon coupon) {
        this.couponCode = coupon.getCouponCode();
        this.couponName = coupon.getCouponName();
        this.quantity = coupon.getQuantity();
        this.discount = coupon.getDiscount();
        this.startDateUse = coupon.getStartDateUse();
        this.deadlineUse = coupon.getDeadlineUse();
    }

    @Builder
    public CouponResponseDto(String couponCode, String couponName, Integer quantity, String couponUse, Integer discount, LocalDateTime startDateUse, LocalDateTime deadlineUse) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.quantity = quantity;
        this.discount = discount;
        this.startDateUse = startDateUse;
        this.deadlineUse = deadlineUse;
    }
}
