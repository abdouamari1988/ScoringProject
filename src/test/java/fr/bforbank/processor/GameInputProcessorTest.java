package fr.bforbank.processor;

import fr.bforbank.service.GameService;
import fr.bforbank.service.impl.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class GameInputProcessorTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl();
    }

    @Test
    void processGameFromFile() {
        gameService.startGame('A', 'B');
        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);
        assertDoesNotThrow(() -> inputProcessor.processGameFromFile("A_B_GAME.txt"));
    }

    @Test
    void processGameFromFileKo() {
        gameService.startGame('A', 'B');
        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);
        assertThrows(NullPointerException.class,() -> inputProcessor.processGameFromFile("A_qq_GAME.txt"));
    }
}