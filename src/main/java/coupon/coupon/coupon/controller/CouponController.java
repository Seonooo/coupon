package coupon.coupon.coupon.controller;

import coupon.coupon.coupon.dto.coupon.CouponFindDto;
import coupon.coupon.coupon.dto.coupon.CouponRequestDto;
import coupon.coupon.coupon.dto.coupon.CouponResponseDto;
import coupon.coupon.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/coupons")
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/page")
    public ResponseEntity<Page<CouponResponseDto>> getAllCouponsPage(
            @ModelAttribute CouponFindDto couponFindDto,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size", required = false, defaultValue = "10") Integer size) {
        Page<CouponResponseDto> result = couponService.getAllCouponsPage(couponFindDto, page, size);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<CouponResponseDto>> getAllCoupons(@RequestParam(value = "codeType", required = false, defaultValue = "") String codeType) {
        List<CouponResponseDto> result = couponService.getAllCoupons(codeType);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{couponCode}")
    public ResponseEntity<CouponResponseDto> getCouponByCouponCode(@PathVariable("couponCode") String couponCode) {
        CouponResponseDto result = couponService.getCoupon(couponCode);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> createCoupon(@Valid @RequestBody CouponRequestDto couponRequestDto) {
        couponService.createCoupon(couponRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PatchMapping("/{couponCode}")
    public ResponseEntity<CouponResponseDto> modifyCouponByCouponCode(@PathVariable String couponCode,
                                                                      @RequestBody CouponRequestDto couponRequestDto) {
        CouponResponseDto result = couponService.modifyCoupon(couponCode, couponRequestDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping("/{couponCode}")
    public ResponseEntity<Object> removeCouponByCouponCode(@PathVariable("couponCode") String couponCode) {
        couponService.removeCoupon(couponCode);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
