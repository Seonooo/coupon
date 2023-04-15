package coupon.coupon.coupon.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import coupon.coupon.coupon.dto.coupon.CouponFindDto;
import coupon.coupon.coupon.entity.Coupon;
import coupon.coupon.coupon.entity.QCoupon;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;


@RequiredArgsConstructor
public class CouponRepositoryCustomImpl implements CouponRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<Coupon> getAllCouponsPage(CouponFindDto couponFindDto, Pageable pageable) {
        List<Coupon> couponList = jpaQueryFactory.selectFrom(QCoupon.coupon)
                .where(searchCouponNameContains(couponFindDto.getCouponName()))
                .orderBy(QCoupon.coupon.couponCode.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> total = jpaQueryFactory.select(QCoupon.coupon.count()).from(QCoupon.coupon)
                .where(searchCouponNameContains(couponFindDto.getCouponName()));

        return PageableExecutionUtils.getPage(couponList, pageable, total::fetchCount);
    }

    private BooleanExpression searchCouponNameContains(String couponName) {
        if(couponName == null){
            return null;
        }
        return QCoupon.coupon.couponName.contains(couponName);
    }
}
