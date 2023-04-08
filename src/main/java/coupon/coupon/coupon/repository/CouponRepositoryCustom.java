package coupon.coupon.coupon.repository;

import coupon.coupon.coupon.dto.coupon.CouponFindDto;
import coupon.coupon.coupon.entity.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CouponRepositoryCustom  {
    Page<Coupon> getAllCouponsPage(CouponFindDto couponFindDto, Pageable pageable);
}
