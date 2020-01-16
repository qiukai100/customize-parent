package com.customize.redis.config;

import com.customize.common.component.CommonResult;
import com.customize.common.exception.CustomException;
import com.customize.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

import static com.customize.common.component.CommonResult.error;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {

    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CustomException.class)
    public CommonResult customExceptionHandler(CustomException e, HttpServletRequest request) {
        printLog(request, e, e.getMessage());
        return error(e.getCode(), e.getMessage());
    }

    @ResponseStatus
    @ExceptionHandler(Exception.class)
    public CommonResult exceptionHandler(Exception e, HttpServletRequest request) {
        printLog(request, e, "未知异常");
        return error(getMessage("未知异常", e));
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public CommonResult noHandlerFoundExceptionHandler(NoHandlerFoundException e, HttpServletRequest request) {
        printLog(request, e, "未找到接口");
        return error(getMessage("未找到接口", e));
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
        printLog(request, e, "请求方式错误");
        return error(getMessage("请求方式错误", e));
    }

    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public CommonResult missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException e, HttpServletRequest request) {
        printLog(request, e, "缺少重要参数");
        return error(getMessage("缺少重要参数", e));
    }

    @ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public CommonResult methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        printLog(request, e, "参数不匹配");
        return error(getMessage("参数不匹配", e));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    public CommonResult bindExceptionHandler(BindException e, HttpServletRequest request) {
        printLog(request, e, "数据绑定异常");
        return error(getMessage("数据绑定异常", e));
    }

    private void printLog(HttpServletRequest request, Exception e, String msg) {
        log.error(request.getRequestURI().concat(msg), e);
    }

    private String getMessage(String msg, Exception e) {
        if (StringUtils.isBlank(msg) && e == null)
            return "系统异常";
        if (StringUtils.isBlank(msg))
            return e.getMessage();
        if (e == null)
            return msg;
        return msg.concat(": ").concat(e.getMessage());
    }
}
