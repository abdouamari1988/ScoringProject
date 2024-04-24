package fr.bforbank.controller;

import fr.bforbank.domain.Game;
import fr.bforbank.processor.GameInputProcessor;
import fr.bforbank.service.GameService;
import fr.bforbank.service.impl.GameServiceImpl;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class GameController {
    private final GameService gameService = new GameServiceImpl();


    public String calculateScore(char player1, char player2, String filePath) {

        // Create the GameInputProcessor and pass the game service
        GameInputProcessor inputProcessor = new GameInputProcessor(gameService);

        // Process the game input from a text file
        try {
            Game game = new Game(player1, player2);
            inputProcessor.processGameFromFile(game, filePath);
            return gameService.getScore(game);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}
