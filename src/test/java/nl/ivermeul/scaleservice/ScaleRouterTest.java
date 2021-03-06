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
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("pitchesPerDegree.TONIC.names[0]").isEqualTo("C");
    }

    @Test
    public void testSetAsharpAsRootGetMajorScaleByDefault() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("tonic", Pitch.ASHARP.getNames().get(0))
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("pitchesPerDegree.TONIC.names[0]").isEqualTo("A-sharp")
                .jsonPath("pitchesPerDegree.SUPERTONIC.names[0]").isEqualTo("C")
                .jsonPath("pitchesPerDegree.MEDIANT.names[0]").isEqualTo("D")
                .jsonPath("pitchesPerDegree.SUBDOMINANT.names[0]").isEqualTo("D-sharp")
                .jsonPath("pitchesPerDegree.DOMINANT.names[0]").isEqualTo("F")
                .jsonPath("pitchesPerDegree.SUBMEDIANT.names[0]").isEqualTo("G")
                .jsonPath("pitchesPerDegree.LEADING_TONE.names[0]").isEqualTo("A");
    }

    @Test
    public void testGetDsharpMajorScaleBySettingParams() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("tonic", Pitch.DSHARP.getNames().get(0))
                .queryParam("type", ScaleType.MAJOR.getName())
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("pitchesPerDegree.TONIC.names[0]").isEqualTo("D-sharp")
                .jsonPath("pitchesPerDegree.SUPERTONIC.names[0]").isEqualTo("F")
                .jsonPath("pitchesPerDegree.MEDIANT.names[0]").isEqualTo("G")
                .jsonPath("pitchesPerDegree.SUBDOMINANT.names[0]").isEqualTo("G-sharp")
                .jsonPath("pitchesPerDegree.DOMINANT.names[0]").isEqualTo("A-sharp")
                .jsonPath("pitchesPerDegree.SUBMEDIANT.names[0]").isEqualTo("C")
                .jsonPath("pitchesPerDegree.LEADING_TONE.names[0]").isEqualTo("D");
    }

    @Test
    public void testGetBNaturalMinorScaleBySettingParams() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("tonic", Pitch.B.getNames().get(0))
                .queryParam("type", "natural-minor")
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("pitchesPerDegree.TONIC.names[0]").isEqualTo("B")
                .jsonPath("pitchesPerDegree.SUPERTONIC.names[0]").isEqualTo("C-sharp");
    }

    @Test
    public void testThrowsExceptionIfScaleTypeUnknown() {
        webTestClient
                .get().uri(uriBuilder -> uriBuilder.path("/scale")
                .queryParam("tonic", Pitch.DSHARP.getNames().get(0))
                .queryParam("type", "Dorian")
                .build())
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isBadRequest();
    }
}