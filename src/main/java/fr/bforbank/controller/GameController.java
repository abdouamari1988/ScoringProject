package fr.bforbank.controller;

import fr.bforbank.processor.GameInputProcessor;
import fr.bforbank.service.GameService;
import fr.bforbank.service.impl.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GameController {
    private final GameService gameService = new GameServiceImpl();


    public String calculateScore(char player1, char player2, String filePath) {
        gameService.startGame(player1, player2);

        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);

        // Process the game input from a text file
        try {
            inputProcessor.processGameFromFile(filePath);
            return gameService.getScore();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
