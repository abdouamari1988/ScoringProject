package fr.bforbank.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private char name;
    private int score;

    public Player(char name) {
        this.name = name;
        this.score = 0; // Initialize score to 0 when the player is created
    }

    // Method to increment the player's score by 1
    public void winPoint() {
        this.score++;
    }
}