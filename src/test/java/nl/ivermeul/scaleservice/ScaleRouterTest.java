package nl.ivermeul.scaleservice;

import nl.ivermeul.scaleservice.model.Pitch;
import nl.ivermeul.scaleservice.model.ScaleType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@ContextConfiguration(classes = {ScaleRouter.class, ScaleHandler.class})
public class ScaleRouterTest {

    @Autowired
    private ApplicationContext context;

    private WebTestClient webTestClient;

    @BeforeEach
    public void setUp() {
        webTestClient = WebTestClient.bindToApplicationContext(context).build();
    }

    @Test
    public void testReturnCMajorScaleByDefault() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale").build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("C D E F G A B");
    }

    @Test
    public void testSetAsharpAsRootGetMajorScaleByDefault() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("root", Pitch.ASHARP.getNames().get(0))
                .build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("A-sharp C D D-sharp F G A");
    }

    @Test
    public void testGetDsharpMajorScaleBySettingParams() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("root", Pitch.DSHARP.getNames().get(0))
                .queryParam("type", ScaleType.MAJOR.getName())
                .build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("D-sharp F G G-sharp A-sharp C D");
    }

    @Test
    public void testThrowsExceptionIfScaleTypeUnknown() {
        //todo: test fails, add error handling to service
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("root", Pitch.DSHARP.getNames().get(0))
                .queryParam("type", "Dorian")
                .build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectStatus().isBadRequest();
    }
}