package ru.netology.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class GameTest {

    Player player1 = new Player(25, "Ира", 3);
    Player player2 = new Player(8, "Дима", 9);
    Player player3 = new Player(20, "Оля", 1);
    Player player4 = new Player(18, "Рита", 5);
    Player player5 = new Player(10, "Коля", 9);


  /* @Test
    public void playerRegistration() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

       ArrayList<Player> expected = new ArrayMap<Player>(Arrays.asList(player1,player2, player3, player4, player5));
        ArrayList<Player> actual = games.getPlayersMap();
        Assertions.assertEquals(expected, actual);
    }*/

    @Test
    public void searchByName() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

        Player expected = player3;
        Player actual = games.findByName("Оля");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void searchByUnregisteredName() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

        Player expected = null;
        Player actual = games.findByName("Катя");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void competitionsBetweenTwoRegisteredPlayersFirst() {

        Game games = new Game();

        games.register(player2);
        games.register(player4);

        int expected = 1;
        int actual = games.round("Дима", "Рита");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void competitionsBetweenTwoRegisteredPlayersSecond() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);

        int expected = 2;
        int actual = games.round("Ира", "Дима");
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void competitionsBetweenTwoRegisteredPlayersDraw() {

        Game games = new Game();

        games.register(player2);
        games.register(player5);

        int expected = 0;
        int actual = games.round("Дима", "Коля");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void competitionsBetweenTwoUnregisteredPlayers() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Катя", "Олег");
        });
    }
    @Test
    public void competitionsWithTheFirstUnregisteredPlayer() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Катя", "Коля");
        });
    }
    @Test
    public void competitionsWithTheSecondUnregisteredPlayer() {

        Game games = new Game();

        games.register(player1);
        games.register(player2);
        games.register(player3);
        games.register(player4);
        games.register(player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            games.round("Рита", "Олег");
        });
    }
}

