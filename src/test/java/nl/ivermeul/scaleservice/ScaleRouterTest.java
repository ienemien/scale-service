package nl.ivermeul.scaleservice;

import nl.ivermeul.scaleservice.model.Pitch;
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
    public void testScaleC() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("root", Pitch.C.getNames().get(0)).build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("C D E F G A B");
    }

    @Test
    public void testScaleDsharp() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("root", Pitch.DSHARP.getNames().get(0)).build())
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("D-sharp F G G-sharp A-sharp C D");
    }
}