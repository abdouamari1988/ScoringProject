package fr.bforbank.service.impl;

import fr.bforbank.domain.Game;
import fr.bforbank.domain.Player;
import fr.bforbank.service.GameService;

public class GameServiceImpl implements GameService {


    @Override
    public Player winPoint(char player, Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        if (player1 != null && player == player1.getName()) {
            player1.winPoint();
            return player1;
        } else if (player2 != null && player == player2.getName()) {
            player2.winPoint();
            return player2;
        } else {
            throw new IllegalArgumentException("Invalid player identifier: " + player);
        }
    }

    @Override
    public String getScore(Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        Player player = winGame(game);
        if (player != null) {
            return "Player " + player.getName() + " wins the game";
        } else if (player1 != null && player2 != null) {
            int player1Score = player1.getScore();
            int player2Score = player2.getScore();

            if (player1Score >= 3 && player2Score >= 3) {
                if (player1Score == player2Score) {
                    return "Deuce";
                } else if (Math.abs(player1Score - player2Score) == 1) {
                    char leadingPlayerName = player1Score > player2Score ? player1.getName() : player2.getName();
                    return "Advantage for player " + leadingPlayerName;
                }
            } else {
                return "Player " + player1.getName() + " : " + translateScore(player1Score)
                        + " / Player " + player2.getName() + " : " + translateScore(player2Score);
            }
        }
        throw new IllegalArgumentException("We can't get players informatons");
    }

    @Override
    public Player winGame(Game game) {
        Player player1 = game.getPlayer1();
        Player player2 = game.getPlayer2();
        if (player1 != null && player2 != null) {
            int score1 = player1.getScore();
            int score2 = player2.getScore();
            if ((score1 >= 4 && score1 > score2 + 1)) {
                return player1;
            }
            if ((score2 >= 4 && score2 > score1 + 1)) {
                return player2;
            }
        }
        return null;
    }

    private String translateScore(int score) {
        return switch (score) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> throw new IllegalArgumentException("Invalid score: " + score);
        };
    }
}
