package br.edu.iftm.query.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.query.domain.NotaFiscal;
import br.edu.iftm.query.dto.NotaFiscalDTO;
import br.edu.iftm.query.repository.NotaFiscalRepository;
import br.edu.iftm.query.service.exceptions.NaoAcheiException;
import br.edu.iftm.query.service.util.Converter;

@Service
public class NotaFiscalService {
    
    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    @Autowired
    private Converter converter;

    public NotaFiscalDTO findById(Long id) {
        NotaFiscal notaFiscal = notaFiscalRepository.findById(id).orElseThrow( () -> new NaoAcheiException(id) );
        return converter.convertToDTO(notaFiscal);
    }

    public List<NotaFiscalDTO> findItemsSoldWithoutDiscount() {
        return notaFiscalRepository.findItemsSoldWithoutDiscount().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findItemsSoldWithDiscount() {
        return notaFiscalRepository.findItemsSoldWithDiscount().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findItemsOrderByValorUnitDesc() {
        return notaFiscalRepository.findItemsOrderByValorUnitDesc().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<Object[]> findTopSellingProduct() {
        return notaFiscalRepository.findTopSellingProduct();
    }

    public List<NotaFiscalDTO> findNFWithMoreThan10UnitsSold() {
        return notaFiscalRepository.findNFWithMoreThan10UnitsSold().stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<Object[]> findTotalNFValueGreaterThan500OrderByDesc() {
        return notaFiscalRepository.findTotalNFValueGreaterThan500OrderByDesc();
    }
}