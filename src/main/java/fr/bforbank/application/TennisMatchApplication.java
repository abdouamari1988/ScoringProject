package fr.bforbank.application;

import fr.bforbank.controller.GameController;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TennisMatchApplication {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        log.info(gameController.calculateScore('A', 'B', "A_B_GAME.txt"));
        log.info(gameController.calculateScore('C', 'D', "C_D_GAME.txt"));
    }
}
