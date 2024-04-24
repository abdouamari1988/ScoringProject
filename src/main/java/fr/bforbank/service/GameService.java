package fr.bforbank.service;

import fr.bforbank.domain.Game;
import fr.bforbank.domain.Player;

public interface GameService {


    Player winPoint(char player, Game game);

    String getScore(Game game);

    Player winGame(Game game);
}
