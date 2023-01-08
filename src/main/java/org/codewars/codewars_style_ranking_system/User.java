package org.codewars.codewars_style_ranking_system;

public class User implements UserInterface{

    public int rank;
    public int progress;

    public User() {
        rank = -8;
        progress = 0;
    }
    @Override
    public void incProgress(int difficulty) throws IllegalArgumentException{
        this.progress += calculateScore(this.rank, difficulty);
        while(this.progress >= 100) {
            this.rank += 1;
            this.progress -= 100;

            if (this.rank == 0) this.rank = 1;
        }
        if (this.rank >= 8) {
            this.rank = 8;
            this.progress = 0;
        }
    }

    static public int calculateScore(int rank, int difficulty) throws IllegalArgumentException{
        if(rank == 0 || difficulty == 0
                || rank > 8 || rank < -8
                || difficulty > 8 || difficulty < -8)
            throw new IllegalArgumentException("Invalid range");

        //The idea is decrement the positive numbers ranks and difficulty
        //This eliminates 0 rank when scores is calculated
        if(rank > 0) rank--;
        if(difficulty > 0) difficulty--;

        int score = 0;
        if(difficulty == rank)
            score = 3;
        else if(rank - difficulty == 1)
            score = 1;
        else if(rank - difficulty >= 2)
            score = 0;
        else {
            int d = Math.abs(rank - difficulty);
            score = 10 * d * d;
        }

        return score;
    }
}

interface UserInterface {
    void incProgress(int rank) throws IllegalArgumentException;
}

