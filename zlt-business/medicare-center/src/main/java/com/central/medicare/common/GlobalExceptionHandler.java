package com.central.medicare.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.central.medicare.constant.SystemConstant;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResponseObject exceptionHandler(RuntimeException e, HttpServletResponse response, HttpServletRequest request) {
        if (e instanceof ConstraintViolationException) {
            return ResponseObject.newErrorResponseObject(SystemConstant.REQ_ILLEGAL_CODE, SystemConstant.PARAM_FORMAT_INCOR);
        }
        logger.error("接口: {}, 出现异常: {}", request.getRequestURI(), e.getMessage());
        return ResponseObject.newErrorResponseObject(SystemConstant.ERROR_INNER_CODE, SystemConstant.ERROR_INNER);
    }
}
