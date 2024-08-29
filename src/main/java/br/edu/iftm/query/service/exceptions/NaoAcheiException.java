package br.edu.iftm.query.service.exceptions;

public class NaoAcheiException extends RuntimeException {
                public NaoAcheiException(Long id) {
                                super("Não achei o id " + id);
                }
        
}