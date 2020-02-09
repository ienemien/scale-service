package nl.ivermeul.scaleservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ScaleRouter {

    @Bean
    public RouterFunction<ServerResponse> route(ScaleHandler scaleHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/scale")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), scaleHandler::scale);
    }
}
