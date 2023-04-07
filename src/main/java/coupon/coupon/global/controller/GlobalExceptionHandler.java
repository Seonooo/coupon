package coupon.coupon.global.controller;

import coupon.coupon.coupon.exception.CouponException;
import coupon.coupon.global.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CouponException.class)
    public ResponseEntity<ErrorResponse> handlerIllegalArgumentException(CouponException ex) {
        log.error("handlerIllegalArgumentException : {}", ex.getMessage());
        return ErrorResponse.toResponseEntity(ex.getCouponErrorCode());
    }

}
