package coupon.coupon.coupon.service;

import coupon.coupon.coupon.dto.coupon.CouponRequestDto;
import coupon.coupon.coupon.dto.coupon.CouponResponseDto;
import coupon.coupon.coupon.entity.Coupon;
import coupon.coupon.coupon.exception.CouponErrorCode;
import coupon.coupon.coupon.exception.CouponException;
import coupon.coupon.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {

    private final CouponRepository couponRepository;

    public Page<CouponResponseDto> getAllCouponsPage(String couponCode, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return couponRepository
                .getAllCouponsPage(couponCode, pageable)
                .map(Coupon::toResponse);
    }

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
            throw new CouponException(CouponErrorCode.ALREADY_EXISTS_COUPON);
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
        coupon.delete();
    }

    private Coupon getCouponEntity(String couponCode) {
        return couponRepository.findById(couponCode)
                .orElseThrow(() -> new CouponException(CouponErrorCode.NOT_EXISTS_COUPON));
    }
}
