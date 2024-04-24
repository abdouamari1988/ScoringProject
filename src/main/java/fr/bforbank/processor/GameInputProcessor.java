package fr.bforbank.processor;

import fr.bforbank.service.GameService;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
public class GameInputProcessor {
    private final GameService gameService;

    public GameInputProcessor(GameService gameService) {
        this.gameService = gameService;
    }

    public void processGameFromFile(String filePath) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(filePath)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                // Convert BufferedReader to String
                int character;
                while ((character = reader.read()) != -1) {
                    char player = (char) character;
                    processPoint(player);
                }
            }
        }
    }

    private void processPoint(char player) {
            gameService.winPoint(player);
    }
}
