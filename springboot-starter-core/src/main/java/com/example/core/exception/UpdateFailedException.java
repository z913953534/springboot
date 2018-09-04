package com.example.core.exception;

/**
 * @author Enzo
 * @Description TODO
 * @date 2018-9-4 0:47
 */
public class UpdateFailedException extends BaseException{
    public UpdateFailedException() {}

    public UpdateFailedException(String message) {
        super(message);
    }

    public UpdateFailedException(String code, String message) {
        super(code, message);
    }
}
