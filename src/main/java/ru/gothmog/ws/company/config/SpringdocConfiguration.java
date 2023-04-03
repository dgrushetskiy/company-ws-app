package ru.gothmog.ws.company.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        servers = {
                @Server(url = "/", description = "Default Server URL"),
                @Server(url = "https://ingress.prmb2c-kizen.apps.dev-gen.sigma.sbrf.ru/kizen-api-gateway/prodcat-api", description = "ingress server"),
                @Server(url = "https://hapi.prmb2c-kizen.apps.dev-gen.sigma.sbrf.ru/kizen-api-gateway/prodcat-api", description = "hapi server")
        },
        info = @Info(title = "SIMPLE API Service", description = "Модуль простой микросервис", version = "1" +
        ".0"))
@Configuration
public class SpringdocConfiguration {

}
