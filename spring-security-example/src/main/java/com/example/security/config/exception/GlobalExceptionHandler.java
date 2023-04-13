package com.example.security.config.exception;


import com.example.security.config.base.HttpStatusEnum;
import com.example.security.config.base.RequestResult;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * 全局异常处理器
 *
 * @author Shen
 * @date 2022/6/9 17:21
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public RequestResult<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return RequestResult.error(HttpStatusEnum.STATUS_500);
    }


}
