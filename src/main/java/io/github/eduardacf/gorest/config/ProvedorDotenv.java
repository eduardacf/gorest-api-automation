package io.github.eduardacf.gorest.config;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

// Fornece acesso centralizado à instância do Dotenv
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProvedorDotenv {
    private static final Dotenv DOTENV = Dotenv.configure().ignoreIfMissing().load(); // Carrega .env uma única vez
    public static Dotenv obterDotEnv() {
        return DOTENV;
    }
}
