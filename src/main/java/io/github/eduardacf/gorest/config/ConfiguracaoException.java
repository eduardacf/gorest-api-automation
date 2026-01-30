package io.github.eduardacf.gorest.config;

import lombok.Getter;

// Exceção para falhas de configuração: Inclui código, ambiente e chave para rastreabilidade.
@Getter
public class ConfiguracaoException extends RuntimeException {

    private final String codigo;
    private final String ambiente;
    private final String chave;

    public ConfiguracaoException(String codigo, String ambiente, String chave, String mensagem) {
        super(mensagem); // Descrição detalhada
        this.codigo = codigo;
        this.ambiente = ambiente;
        this.chave = chave;
    }
}
