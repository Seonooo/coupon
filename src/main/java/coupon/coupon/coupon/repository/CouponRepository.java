package coupon.coupon.coupon.repository;

import coupon.coupon.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, String>, QuerydslPredicateExecutor<Coupon>, CouponRepositoryCustom {

    @Query(nativeQuery = true, value = "SELECT * FROM COUPON WHERE COUPON_CODE REGEXP '[가-힣]'")
    List<Coupon> findCouponInKorCouponCode();
}
