package coupon.coupon.coupon.dto.coupon;

import coupon.coupon.coupon.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponRequestDto {
    @NotBlank(message = "쿠폰코드를 입력해주세요.")
    private String couponCode;
    @NotBlank(message = "쿠폰이름을 입력해주세요.")
    private String couponName;
    @NotNull(message = "쿠폰수량을 입력해주세요.")
    private Integer quantity;
    private String couponType;
    @NotNull(message = "할인가격을 입력해주세요.")
    private Integer discount;
    @NotNull(message = "시작일을 입력해주세요.")
    private LocalDateTime startDateUse;
    @NotNull(message = "마감일을 입력해주세요.")
    private LocalDateTime deadlineUse;

    public Coupon toEntity() {
        return Coupon.builder()
                .couponCode(couponCode)
                .couponName(couponName)
                .quantity(quantity)
                .discount(discount)
                .startDateUse(startDateUse)
                .deadlineUse(deadlineUse)
                .build();
    }
}
