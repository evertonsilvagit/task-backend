package br.com.getnet.vouchers.exception;

import lombok.Getter;

@Getter
public class VoucherInvalidoException extends Exception {

    private String message;
    public VoucherInvalidoException(String message) {
        this.message = message;
    }
}
