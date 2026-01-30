package io.github.eduardacf.gorest.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// Utilitário para validação de valores obrigatórios de configuração.
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidadorConfiguracao {
    public static String exigirValorObrigatorioNaoVazio(String valor, RuntimeException excecao) {
        if (valor == null || valor.isBlank()) {throw excecao;} // Falha se ausente
        return valor;
    }
}