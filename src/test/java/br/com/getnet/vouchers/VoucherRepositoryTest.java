package br.com.getnet.vouchers;

import br.com.getnet.vouchers.model.Voucher;
import br.com.getnet.vouchers.repository.VoucherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class VoucherRepositoryTest {

    @Autowired
    private VoucherRepository voucherRepository;

    @Test
    public void createVoucher(){

        voucherRepository.save(
                Voucher
                    .builder()
                        .destinatario("Everton")
                        .nome("Everton Carvalho da Silva")
                        .email("everton_ere93@hotmail.com")
                        .ofertaEspecial("PS5")
                        .descontoPercentualFixo(50.0)
                        .codigoVoucher(UUID.randomUUID().toString())
                        .codigoDestinatario(UUID.randomUUID().toString())
                        .dataDeValidade(LocalDate.now().plusDays(30l))
                    .build()
        );

    }

    @Test
    public void validaVoucher(){

        Voucher voucher = voucherRepository.findByCodigoVoucherAndEmail("bb9cfe6c-019b-4e6d-afb2-c01467d046f7", "everton_ere93@hotmail.com");

        assertNotNull(voucher);

    }

}
