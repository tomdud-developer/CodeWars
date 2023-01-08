package org.codewars.codewars_style_ranking_system;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    void userRankingScenario() {
        User user = new User();
        Assertions.assertEquals(-8, user.rank);
        Assertions.assertEquals(0, user.progress);
        user.incProgress(-7);
        Assertions.assertEquals(10, user.progress);
        user.incProgress(-5);
        Assertions.assertEquals(0, user.progress);
        Assertions.assertEquals(-7, user.rank);
    }

    @Test
    void calculateScore() {
        Assertions.assertEquals(1, User.calculateScore(-7, -8));
        Assertions.assertEquals(1, User.calculateScore(-6, -7));
        Assertions.assertEquals(1, User.calculateScore(-1, -2));

        Assertions.assertEquals(3, User.calculateScore(-5, -5));

        Assertions.assertEquals(10, User.calculateScore(-8, -7));
        Assertions.assertEquals(40, User.calculateScore(-8, -6));
        Assertions.assertEquals(90, User.calculateScore(-8, -5));

        Assertions.assertEquals(10, User.calculateScore(-1, 1));
        Assertions.assertEquals(Math.pow(16 - 1, 2) * 10, User.calculateScore(-8, 8));
        Assertions.assertEquals(Math.pow(6 - 1, 2) * 10, User.calculateScore(-2, 4));
    }
}

interface UserInterface {
    public void incProgress(int rank);
}
