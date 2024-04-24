package fr.bforbank.processor;

import fr.bforbank.domain.Game;
import fr.bforbank.service.GameService;
import fr.bforbank.service.impl.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameInputProcessorTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl();
    }

    @Test
    void processGameFromFile() {
        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);
        assertDoesNotThrow(() -> inputProcessor.processGameFromFile(new Game('A', 'B'), "A_B_GAME.txt"));
    }

    @Test
    void processGameFromFileKo() {
        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);
        assertThrows(NullPointerException.class, () -> inputProcessor.processGameFromFile(new Game('A', 'B'), "A_qq_GAME.txt"));
    }
}