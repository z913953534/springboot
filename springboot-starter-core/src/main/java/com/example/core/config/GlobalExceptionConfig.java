package com.example.core.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.core.base.Result;
import com.example.core.constants.BaseEnums;
import com.example.core.exception.AuthorityException;
import com.example.core.exception.BaseException;
import com.example.core.exception.ServiceException;
import com.example.core.util.Results;

/**
 * 全局异常处理
 *
 * @author bojiangzhou 2018-02-06
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionConfig {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionConfig.class);

    /**
     * 处理 ServiceException 异常
     */
    @ExceptionHandler(ServiceException.class)
    public Result handleServiceException(ServiceException e){
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.BAD_REQUEST.value());
        logger.info("ServiceException[code: {}, message: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 AuthorityException 异常
     */
    @ExceptionHandler(AuthorityException.class)
    public Result handleAuthorityException(AuthorityException e){
        Result result = Results.failure(BaseEnums.FORBIDDEN.code(), BaseEnums.FORBIDDEN.description());
        result.setStatus(HttpStatus.FORBIDDEN.value());
        logger.info("AuthorityException[code: {}, message: {}]", e.getCode(), e.getMessage());
        return result;
    }

    /**
     * 处理 NoHandlerFoundException 异常. <br/>
     * 需配置 [spring.mvc.throw-exception-if-no-handler-found=true]
     * 需配置 [spring.resources.add-mappings=false]
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handleNotFoundException(NoHandlerFoundException e){
        Result result = Results.failure(BaseEnums.NOT_FOUND.code(), BaseEnums.NOT_FOUND.description());
        result.setStatus(HttpStatus.NOT_FOUND.value());
        logger.info(e.getMessage());
        return result;
    }

    /**
     * 处理 BaseException 异常
     */
    @ExceptionHandler(BaseException.class)
    public Result handleBaseException(BaseException e){
        Result result = Results.failure(e.getCode(), e.getMessage());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error("BaseException[code: {}, message: {}]", e.getCode(), e.getMessage(), e);
        return result;
    }

    /**
     * 处理 Exception 异常
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        Result result = Results.failure(BaseEnums.ERROR.code(), BaseEnums.ERROR.description());
        result.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.error(e.getMessage(), e);
        return result;
    }

}