package br.com.getnet.vouchers.service;

import br.com.getnet.vouchers.exception.VoucherInvalidoException;
import br.com.getnet.vouchers.model.Voucher;
import br.com.getnet.vouchers.repository.VoucherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Service
public class VoucherService {

    private VoucherRepository voucherRepository;

    public Voucher useVoucher(String codigoVoucher, String email) throws VoucherInvalidoException {

        Voucher voucher = voucherRepository.findByCodigoVoucherAndEmail(codigoVoucher, email);

        if (!voucher.dataDeValidade.isAfter(LocalDate.now())){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            throw new VoucherInvalidoException("O voucher " + codigoVoucher + " estava válido até: " + dateTimeFormatter.format(voucher.dataDeValidade));
        }

        return voucher;

    }
}
