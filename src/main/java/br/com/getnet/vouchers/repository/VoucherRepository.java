package br.com.getnet.vouchers.repository;

import br.com.getnet.vouchers.model.Voucher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoucherRepository extends MongoRepository<Voucher, String> {

    Voucher findByCodigoVoucherAndEmail(String codigoVoucher, String email);
}
