package br.com.getnet.vouchers.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Voucher {

    @Id
    public String id;

    public String destinatario;
    public String nome;
    public String email;
    public String ofertaEspecial;
    public Double descontoPercentualFixo;
    public String codigoVoucher;
    public String codigoDestinatario;
    public LocalDate dataDeValidade;
    public LocalDate dataDeUso;

}
