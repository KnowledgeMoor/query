package br.edu.iftm.query.dto;

import lombok.Data;


@Data
public class NotaFiscalDTO {
    private Long id;
    private Long id_nf;
    private Long id_item;
    private Long cod_prod;
    private Double valor_unit;
    private int quantidade;
    private int desconto;
}