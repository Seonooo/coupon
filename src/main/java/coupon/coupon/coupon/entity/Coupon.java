package coupon.coupon.coupon.entity;

import coupon.coupon.coupon.dto.coupon.CouponRequestDto;
import coupon.coupon.coupon.dto.coupon.CouponResponseDto;
import coupon.coupon.coupon.dto.coupon.type.CouponStatus;
import coupon.coupon.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Coupon extends BaseTimeEntity {

    @Id
    private String couponCode;
    private String couponName;
    private Integer quantity;
    private Integer discount;
    private CouponStatus couponStatus;
    private LocalDateTime startDateUse;
    private LocalDateTime deadlineUse;

    @Builder
    public Coupon(String couponCode, String couponName, Integer quantity, Integer discount, LocalDateTime startDateUse, LocalDateTime deadlineUse) {
        this.couponCode = couponCode;
        this.couponName = couponName;
        this.quantity = quantity;
        this.discount = discount;
        this.couponStatus = CouponStatus.UNUSED;
        this.startDateUse = startDateUse;
        this.deadlineUse = deadlineUse;
    }

    public CouponResponseDto toResponse() {
        return CouponResponseDto.builder()
                .couponCode(couponCode)
                .couponName(couponName)
                .discount(discount)
                .quantity(quantity)
                .startDateUse(startDateUse)
                .deadlineUse(deadlineUse)
                .build();
    }

    public void update(CouponRequestDto requestDto) {
        this.quantity = requestDto.getQuantity();
        this.couponName = requestDto.getCouponName();
        this.couponStatus = CouponStatus.USED;
    }

    public void delete() {
        this.couponStatus = CouponStatus.DELETE;
    }

}
