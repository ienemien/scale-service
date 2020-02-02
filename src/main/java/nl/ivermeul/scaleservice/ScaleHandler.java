package nl.ivermeul.scaleservice;

import nl.ivermeul.scaleservice.model.MajorScale;
import nl.ivermeul.scaleservice.model.Pitch;
import nl.ivermeul.scaleservice.model.Scale;
import nl.ivermeul.scaleservice.model.ScaleType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class ScaleHandler {

    public Mono<ServerResponse> scale(ServerRequest request) {
        String root = request.queryParam("root").orElse("C");
        ScaleType type = ScaleType.getScaleTypeByName(request.queryParam("type").orElse(ScaleType.MAJOR.getName()));

        Scale scale = switch (type) {
            case MAJOR -> new MajorScale(Pitch.findPitchByName(root));
            case NATURAL_MINOR, HARMONIC_MINOR, MELODIC_MINOR -> throw new UnsupportedOperationException("Scale type not yet supported.");
        };

        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(scale.getPitchesAsString()));
    }
}
