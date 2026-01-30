package io.github.eduardacf.gorest.enums;

import java.util.Locale;

import static io.github.eduardacf.gorest.config.ValidadorConfiguracao.exigirValorObrigatorioNaoVazio;
import static io.github.eduardacf.gorest.factory.ConfiguracaoExceptionFactory.erroAmbienteInvalido;

// Representa os ambientes disponíveis da aplicação.
public enum Ambiente {

    DEV,
    UAT;

    public static Ambiente resolverAmbienteConfigurado(String valor) {
        String normalizado = exigirValorObrigatorioNaoVazio(valor, erroAmbienteInvalido(valor))
                .trim().toUpperCase(Locale.ROOT); // Normaliza entrada
        try {
            return Ambiente.valueOf(normalizado); // Converte para enum
        } catch (IllegalArgumentException e) {
            throw erroAmbienteInvalido(valor);
        }
    }
}