package fr.bforbank.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {

    @Test
    void calclulateScoreAandB() {
        GameController gameController = new GameController();
        String score = gameController.calculateScore('A', 'B', "A_B_GAME.txt");
        assertEquals("Player A : 40 / Player B : 15", score);
    }

    @Test
    void calclulateScoreCandD() {
        GameController gameController = new GameController();
        String score = gameController.calculateScore('C', 'D', "C_D_GAME.txt");
        assertEquals("Advantage for player D", score);
    }

}