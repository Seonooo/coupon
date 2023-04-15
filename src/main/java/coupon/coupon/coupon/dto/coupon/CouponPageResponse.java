package coupon.coupon.coupon.dto.coupon;

import coupon.coupon.coupon.entity.Coupon;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponPageResponse {

    private List<CouponResponseDto> result;
    private int page;
    private int size;
    private int totalCount;
    private boolean prev;
    private boolean next;

    @Builder
    public CouponPageResponse(List<CouponResponseDto> couponList, Integer page, Integer size, Integer totalCount, boolean prev, boolean next) {
        this.result = couponList;
        this.page = page;
        this.totalCount = size;
        this.size = totalCount;
        this.prev = prev;
        this.next = next;
    }
}
