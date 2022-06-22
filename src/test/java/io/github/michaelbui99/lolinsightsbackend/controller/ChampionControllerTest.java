package io.github.michaelbui99.lolinsightsbackend.controller;

import io.github.michaelbui99.lolinsightsbackend.service.ChampionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ChampionControllerTest {
    private ChampionService championServiceMock;
    private ChampionsController controller;

    @BeforeEach
    public void setup() {
        championServiceMock = Mockito.mock(ChampionService.class);
        controller = new ChampionsController(championServiceMock);
    }

    @Test
    public void getAll_ChampionServiceThrowsException_ControllerReturnsInternalServerError() {
        // Arrange
        when(championServiceMock.getAll()).thenThrow(RuntimeException.class);

        // Act & Assert
        assertEquals(ResponseEntity.internalServerError().build(), controller.getAll());
    }

    @Test
    public void constructor_InitialiseController_CreatesControllerInstance() {
        // Arrange
        ChampionsController controllerUnderTest;

        try {
            // Act
            controllerUnderTest = new ChampionsController(championServiceMock);

            // Assert
            assertNotNull(controllerUnderTest);
        } catch (Exception e) {
            fail("Calling constructor with valid service injected should not throw exception");
        }
    }
}