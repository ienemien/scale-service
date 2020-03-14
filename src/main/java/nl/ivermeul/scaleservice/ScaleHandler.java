package nl.ivermeul.scaleservice;

import lombok.extern.slf4j.Slf4j;
import nl.ivermeul.scaleservice.exceptions.ScaleCreationException;
import nl.ivermeul.scaleservice.factory.ScaleFactory;
import nl.ivermeul.scaleservice.model.Scale;
import nl.ivermeul.scaleservice.model.ScaleType;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ScaleHandler {

    public Mono<ServerResponse> scale(ServerRequest request) {
        String type = request.queryParam("type").orElse(ScaleType.MAJOR.getName());
        String tonicName = request.queryParam("tonic").orElse("C");

        try {
            Scale scale = ScaleFactory.createScale(
                    type,
                    tonicName);

            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(scale));
        } catch (Exception e) {
            return Mono.error(new ScaleCreationException(HttpStatus.BAD_REQUEST, String.format("Could not create scale with type %s and tonic %s", type, tonicName)));
        }
    }
}
