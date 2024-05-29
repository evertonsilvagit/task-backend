package br.com.getnet.vouchers.exception;

import lombok.Getter;

@Getter
public class InvalidTaskException extends Exception {

    private String message;
    public InvalidTaskException(String message) {
        this.message = message;
    }
}
