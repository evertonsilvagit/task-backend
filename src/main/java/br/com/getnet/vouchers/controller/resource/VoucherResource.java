package br.com.getnet.vouchers.controller.resource;

import br.com.getnet.vouchers.controller.dto.response.VoucherResponseDTO;
import br.com.getnet.vouchers.exception.VoucherInvalidoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface VoucherResource {

    @GetMapping("/{codigoVoucher}/{email}")
    ResponseEntity<VoucherResponseDTO> useVoucher(
            @PathVariable String codigoVoucher,
            @PathVariable String email
    ) throws VoucherInvalidoException;
}
