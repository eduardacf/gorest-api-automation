package io.github.eduardacf.gorest.config;

import io.github.eduardacf.gorest.factory.ConfiguracaoExceptionFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.function.BiFunction;

import static io.github.eduardacf.gorest.config.ConfiguracaoAmbiente.obterAmbiente;
import static io.github.eduardacf.gorest.config.ProvedorDotenv.obterDotEnv;
import static io.github.eduardacf.gorest.config.ValidadorConfiguracao.exigirValorObrigatorioNaoVazio;

/* ======
  Centraliza a configuração da integração com a API GoRest
  (URL base e token), respeitando a prioridade:
  JVM > variável de ambiente > .env.
  ====== */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfiguracaoIntegracaoGoRest {

    public static String obterBaseUrl() {
        return obterObrigatorio("baseUrl", "BASE_URL",
                "_BASE_URL", ConfiguracaoExceptionFactory::erroBaseUrlNaoConfigurada);
    }

    public static String obterToken() {
        return obterObrigatorio("token", "GOREST_TOKEN",
                "_GOREST_TOKEN", ConfiguracaoExceptionFactory::erroTokenNaoConfigurado);
    }

    private static String obterObrigatorio(String propriedadeJvm, String variavelAmbiente, String sufixoPorAmbiente, BiFunction<String, String, RuntimeException> fabricaErro) {

        String ambiente = obterAmbiente().name();
        String chaveEnv = ambiente + sufixoPorAmbiente; // Ex: DEV_BASE_URL
        String valor = System.getProperty(propriedadeJvm, System.getenv().getOrDefault(variavelAmbiente, obterDotEnv().get(chaveEnv)));

        return exigirValorObrigatorioNaoVazio(valor, fabricaErro.apply(ambiente, chaveEnv)); // Garante que não está vazio
    }
}

