package io.github.eduardacf.gorest.factory;

import io.github.eduardacf.gorest.config.ConfiguracaoException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// Responsável por criar exceções padronizadas relacionadas a falhas de configuração.
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfiguracaoExceptionFactory {

    public static ConfiguracaoException erroAmbienteInvalido(String valorAtual) {
        return new ConfiguracaoException("CFG-000", "N/A", "AMBIENTE", """
                [CFG-000] Ambiente inválido.
                
                Valor atual: "%s"
                
                Como configurar (escolha 1):
                - JVM: -Dambiente=dev|uat
                - Variável de ambiente: AMBIENTE=dev|uat
                - .env: AMBIENTE=dev|uat
                """.formatted(valorAtual));
    }

    public static ConfiguracaoException erroBaseUrlNaoConfigurada(String ambiente, String chaveEsperada) {
        return new ConfiguracaoException("CFG-001", ambiente, chaveEsperada, """
                [CFG-001] Base URL não configurada.
                
                Ambiente: %s
                Chave esperada no .env: %s
                
                Como configurar (escolha 1):
                - JVM: -DbaseUrl=https://...
                - Variável de ambiente: BASE_URL=https://...
                - .env: %s=https://...
                
                Exemplo .env:
                AMBIENTE=dev
                DEV_BASE_URL=https://gorest.co.in/public/v2
                UAT_BASE_URL=https://gorest.co.in/public/v2
                """.formatted(ambiente, chaveEsperada, chaveEsperada));
    }

    public static ConfiguracaoException erroTokenNaoConfigurado(String ambiente, String chaveEsperada) {
        return new ConfiguracaoException("CFG-002", ambiente, chaveEsperada, """
                [CFG-002] Token não configurado.
                
                Ambiente: %s
                Chave esperada no .env: %s
                
                Como configurar (escolha 1):
                - JVM: -Dtoken=SEU_TOKEN
                - Variável de ambiente: GOREST_TOKEN=SEU_TOKEN
                - .env: %s=SEU_TOKEN
                
                Exemplo .env:
                AMBIENTE=dev
                DEV_GOREST_TOKEN=SEU_TOKEN_DEV
                UAT_GOREST_TOKEN=SEU_TOKEN_UAT
                """.formatted(ambiente, chaveEsperada, chaveEsperada));
    }
}
