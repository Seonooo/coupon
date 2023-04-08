package coupon.coupon.coupon.repository;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import coupon.coupon.coupon.dto.coupon.CouponFindDto;
import coupon.coupon.coupon.entity.Coupon;
import coupon.coupon.coupon.entity.QCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;


@RequiredArgsConstructor
public class CouponRepositoryCustomImpl implements CouponRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Coupon> getAllCouponsPage(CouponFindDto couponFindDto, Pageable pageable) {
        QueryResults<Coupon> results = jpaQueryFactory.selectFrom(QCoupon.coupon)
                .where(searchCouponNameLike(couponFindDto.getCouponName()))
                .orderBy(QCoupon.coupon.couponCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();
        List<Coupon> couponList = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(couponList, pageable, total);
    }

    private BooleanExpression searchCouponNameLike(String couponName) {
        return QCoupon.coupon.couponName.like("%" + couponName + "%");
    }
}
