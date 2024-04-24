package fr.bforbank.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {
    private Player player1;
    private Player player2;

    public Game(char player1Name, char player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }


}
