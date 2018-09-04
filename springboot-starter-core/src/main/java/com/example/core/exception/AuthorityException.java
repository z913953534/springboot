package com.example.core.exception;

/**
 * @author Enzo
 * @Description TODO
 * @date 2018-9-4 0:47
 */
public class AuthorityException extends BaseException{
    public AuthorityException() {}

    public AuthorityException(String message) {
        super(message);
    }

    public AuthorityException(String code, String message) {
        super(code, message);
    }
}
