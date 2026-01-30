package io.github.eduardacf.gorest.config;

import io.github.eduardacf.gorest.enums.Ambiente;
import lombok.NoArgsConstructor;

import static io.github.eduardacf.gorest.config.ProvedorDotenv.obterDotEnv;
import static io.github.eduardacf.gorest.enums.Ambiente.resolverAmbienteConfigurado;

// Resolve o ambiente ativo da aplicação com base na prioridade: JVM > variável de ambiente > .env > padrão.
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public final class ConfiguracaoAmbiente {

    private static final String PADRAO = "dev";

    public static Ambiente obterAmbiente() {
        String valor = System.getProperty("ambiente", System.getenv().getOrDefault("AMBIENTE", obterDotEnv().get("AMBIENTE", PADRAO)));
        return resolverAmbienteConfigurado(valor); // Valida e converte para enum
    }
}
