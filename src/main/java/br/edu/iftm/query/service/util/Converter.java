package br.edu.iftm.query.service.util;

import org.springframework.stereotype.Component;

import br.edu.iftm.query.domain.NotaFiscal;
import br.edu.iftm.query.dto.NotaFiscalDTO;

@Component
public class Converter {

    public NotaFiscalDTO convertToDTO(NotaFiscal notaFiscal) {
        NotaFiscalDTO notaFiscalDTO = new NotaFiscalDTO();
        notaFiscalDTO.setId(notaFiscal.getId());
        notaFiscalDTO.setId_nf(notaFiscal.getId_nf());
        notaFiscalDTO.setId_item(notaFiscal.getId_item());
        notaFiscalDTO.setCod_prod(notaFiscal.getCod_prod());
        notaFiscalDTO.setValor_unit(notaFiscal.getValor_unit());
        notaFiscalDTO.setQuantidade(notaFiscal.getQuantidade());
        notaFiscalDTO.setDesconto(notaFiscal.getDesconto());
        return notaFiscalDTO;
    }

    public NotaFiscal convertToEntity(NotaFiscalDTO notaFiscalDTO) {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setId(notaFiscalDTO.getId());
        notaFiscal.setId_nf(notaFiscalDTO.getId_nf());
        notaFiscal.setId_item(notaFiscalDTO.getId_item());
        notaFiscal.setCod_prod(notaFiscalDTO.getCod_prod());
        notaFiscal.setValor_unit(notaFiscalDTO.getValor_unit());
        notaFiscal.setQuantidade(notaFiscalDTO.getQuantidade());
        notaFiscal.setDesconto(notaFiscalDTO.getDesconto());
        return notaFiscal;
    }
}
