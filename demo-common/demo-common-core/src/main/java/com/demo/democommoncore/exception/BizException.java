package com.demo.democommoncore.exception;

import com.demo.democommoncore.constant.ReturnCode;
import lombok.Getter;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/4/7.
 */
@Getter
public class BizException extends RuntimeException {

    private ReturnCode returnCode;

    public BizException(ReturnCode returnCode) {
        super(returnCode.getMsg());
        this.returnCode = returnCode;
    }

    public BizException(String message) {
        super(message);
    }
}
