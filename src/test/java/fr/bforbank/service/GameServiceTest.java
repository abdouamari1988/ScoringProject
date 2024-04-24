package fr.bforbank.service;

import fr.bforbank.domain.Game;
import fr.bforbank.domain.Player;
import fr.bforbank.service.impl.GameServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl();
    }

    @Test
    void winPoint() {
        Player player = gameService.winPoint('A', new Game('A', 'B'));
        assertEquals('A', player.getName());
        assertEquals(1, player.getScore());
    }

    @Test
    void getScoreForAWinGame() {
        Game game = new Game('A', 'B');
        Player player1 = new Player('A');
        player1.setScore(4);
        Player player2 = new Player('B');
        player2.setScore(1);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        String score = gameService.getScore(game);
        assertEquals("Player A wins the game",score);
    }

    @Test
    void getScoreFor40To30() {
        Game game = new Game('A', 'B');
        Player player1 = new Player('A');
        player1.setScore(3);
        Player player2 = new Player('B');
        player2.setScore(2);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        String score = gameService.getScore(game);
        assertEquals("Player A : 40 / Player B : 30",score);
    }

    @Test
    void winGame() {
        Game game = new Game('A', 'B');
        Player player1 = new Player('A');
        player1.setScore(1);
        Player player2 = new Player('B');
        player2.setScore(4);
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        Player player = gameService.winGame(game);
        assertEquals('B', player.getName());
    }
}