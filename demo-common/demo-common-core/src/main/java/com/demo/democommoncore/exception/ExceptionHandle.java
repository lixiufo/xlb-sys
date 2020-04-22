package com.demo.democommoncore.exception;

import com.demo.democommoncore.constant.ReturnCode;
import com.demo.democommoncore.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author WPF
 * @version fission-sys
 * @date 2019/5/30.
 */
@Profile({"dev", "test","localtest"})
@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Result> runtimeExceptionHandle(HttpServletRequest request, RuntimeException exception) {
        if ("AccessDeniedException".equals(exception.getClass().getSimpleName())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Result.error(ReturnCode.ERROR_LIMIT));
        }
        log.error("url: 【" + request.getRequestURI() + "】system error:" + exception.getMessage(), exception);
        return ResponseEntity.badRequest().body(Result.error(request, exception));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Result> exceptionHandler(HttpServletRequest request, Exception exception) {
        log.error("url: 【" + request.getRequestURI() + "】system error:" + exception.getMessage(), exception);
        return ResponseEntity.badRequest().body(Result.error(request, exception));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Result> missingServletRequestParameterExceptionHandler(MissingServletRequestParameterException exception) {
        return ResponseEntity.badRequest().body(Result.error(exception.getMessage()).errorCode(ReturnCode.ERROR_PARAM.getCode()));
    }

    /**
     * validation Exception
     *
     * @param exception 参数验证错误
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public ResponseEntity<Result> bodyValidExceptionHandler(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        return ResponseEntity.badRequest().body(Result.error(fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(";"))).errorCode(ReturnCode.ERROR_PARAM.getCode()));
    }

    /**
     * validation Exception
     *
     * @param exception 参数验证错误
     * @return R
     */
    @ExceptionHandler({BizException.class})
    public ResponseEntity<Result> bizExceptionHandler(BizException exception) {
        ReturnCode returnCode = exception.getReturnCode();
        if (returnCode != null) {
            return ResponseEntity.badRequest().body(Result.error(returnCode));
        } else {
            return ResponseEntity.badRequest().body(Result.error(exception.getMessage()));
        }
    }
}
