package coupon.coupon.coupon.service;

import coupon.coupon.coupon.dto.coupon.CouponRequestDto;
import coupon.coupon.coupon.dto.coupon.CouponResponseDto;
import coupon.coupon.coupon.entity.Coupon;
import coupon.coupon.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;
    private final String NOT_EXISTS_COUPON = "해당 쿠폰이 존재하지 않습니다.";
    private final String ALREADY_EXISTS_COUPON = "해당 쿠폰이 이미 존재합니다.";

    public List<CouponResponseDto> getAllCoupons(String codeType) {
        if ("kor".equals(codeType)) {
            List<Coupon> entityCoupons = couponRepository.findCouponInKorCouponCode();
            return entityCoupons.stream().map(Coupon::toResponse).collect(Collectors.toList());
        }
        List<Coupon> entityCoupons = couponRepository.findAll();
        return entityCoupons.stream().map(Coupon::toResponse).collect(Collectors.toList());
    }

    public CouponResponseDto getCoupon(String couponCode) {
        Coupon coupon = getCouponEntity(couponCode);
        return coupon.toResponse();
    }

    @Transactional
    public void createCoupon(CouponRequestDto couponRequestDto) {
        if (couponRepository.findById(couponRequestDto.getCouponCode()).isPresent()) {
            throw new IllegalArgumentException(ALREADY_EXISTS_COUPON);
        }
        Coupon coupon = couponRequestDto.toEntity();
        couponRepository.save(coupon);
    }

    @Transactional
    public CouponResponseDto modifyCoupon(String couponCode, CouponRequestDto couponRequestDto) {
        Coupon coupon = getCouponEntity(couponCode);
        coupon.update(couponRequestDto);
        return coupon.toResponse();
    }

    @Transactional
    public void removeCoupon(String couponCode) {
        Coupon coupon = getCouponEntity(couponCode);
        couponRepository.delete(coupon);
    }

    private Coupon getCouponEntity(String couponCode) {
        return couponRepository.findById(couponCode)
                .orElseThrow(() -> new NoSuchElementException(NOT_EXISTS_COUPON));
    }
}
