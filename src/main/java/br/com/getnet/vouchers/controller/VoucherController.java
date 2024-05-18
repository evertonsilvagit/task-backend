package br.com.getnet.vouchers.controller;

import br.com.getnet.vouchers.controller.dto.response.VoucherResponseDTO;
import br.com.getnet.vouchers.controller.resource.VoucherResource;
import br.com.getnet.vouchers.exception.VoucherInvalidoException;
import br.com.getnet.vouchers.model.Voucher;
import br.com.getnet.vouchers.service.VoucherService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class VoucherController implements VoucherResource {

    private VoucherService voucherService;

    public ResponseEntity<VoucherResponseDTO> useVoucher(String codigoVoucher, String email) throws VoucherInvalidoException {

        Voucher voucher = voucherService.useVoucher(codigoVoucher, email);

        return new ResponseEntity<>(
                VoucherResponseDTO
                        .builder()
                            .descontoPercentualFixo(voucher.descontoPercentualFixo)
                            .dataDeUso(voucher.dataDeUso)
                        .build(),
                HttpStatus.OK
        );
    }

}
