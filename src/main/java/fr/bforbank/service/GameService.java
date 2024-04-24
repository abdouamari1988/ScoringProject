package fr.bforbank.service;

import fr.bforbank.domain.Player;

public interface GameService {
    void startGame(char player1Name, char player2Name);

    void winPoint(char player);

    String getScore();

    Player winGame();
}
