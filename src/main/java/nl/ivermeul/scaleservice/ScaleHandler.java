package nl.ivermeul.scaleservice;

import nl.ivermeul.scaleservice.model.MajorScale;
import nl.ivermeul.scaleservice.model.Pitch;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ScaleHandler {

    public Mono<ServerResponse> scale(ServerRequest request) {
        MajorScale scale = new MajorScale(Pitch.findPitchByName("C"));
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(scale.getPitchesAsString()));
    }
}
