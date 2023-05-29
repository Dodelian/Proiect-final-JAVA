package com.rockpaperscissorsgame.RPSG;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @PostMapping("/play")
    public String playGame(@RequestBody String move) {
        // Available moves: rock, paper, scissors
        String computerMove = getRandomMove();
        String result = determineWinner(move, computerMove);
        return "Computer's move: " + computerMove + "\nResult: " + result;
    }

    private String getRandomMove() {
        String[] moves = {"rock", "paper", "scissors"};
        int randomIndex = (int) (Math.random() * 3);
        return moves[randomIndex];
    }

    private String determineWinner(String move1, String move2) {
        if (move1.equals(move2)) {
            return "It's a tie!";
        }

        if (move1.equals("rock")) {
            if (move2.equals("scissors")) {
                return "Player 1 wins!";
            } else {
                return "Player 2 wins!";
            }
        } else if (move1.equals("paper")) {
            if (move2.equals("rock")) {
                return "Player 1 wins!";
            } else {
                return "Player 2 wins!";
            }
        } else if (move1.equals("scissors")) {
            if (move2.equals("paper")) {
                return "Player 1 wins!";
            } else {
                return "Player 2 wins!";
            }
        }

        return "Invalid move!";
    }
}
