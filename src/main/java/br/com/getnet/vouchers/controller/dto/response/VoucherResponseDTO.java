package br.com.getnet.vouchers.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class VoucherResponseDTO {

    private Double descontoPercentualFixo;
    private LocalDate dataDeUso;
}
