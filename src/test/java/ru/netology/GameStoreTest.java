package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void AddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Зума", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void AddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Зума", "Аркады");
        Game game2 = new Game("Call of duty", "Стратегия", store);
        Game game3 = new Game("Rayman", "Джамп-н-ран", store);
        assertFalse(store.containsGame(game3));
    }

    @Test
    public void ContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Call of duty", "Стратегия", store);
        Game game3 = new Game("Rayman", "Джамп-н-ран", store);
        assertFalse(store.containsGame(game3));
    }

    @Test
    public void MostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 3);
        store.addPlayTime("Slava", 9);
        store.addPlayTime("Chester", 16);


        String actual = store.getMostPlayer();
        String expected = "Chester";
        assertEquals(expected, actual);
    }
    @Test
    public void MostPlayer2() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 3);
        store.addPlayTime("Slava", 9);
        store.addPlayTime("Chester", 6);


        String actual = store.getMostPlayer();
        String expected = "Slava";
        assertEquals(expected, actual);
    }
    @Test
    public void MostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Call of duty", "Стратегия");

        store.addPlayTime("Alena", 1);

        String actual = store.getMostPlayer();
        String expected = "Alena";
        assertEquals(expected, actual);
    }

    @Test
    public void MostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void MostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Call of duty", "Стратегия");

        store.addPlayTime("Alena", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void RegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 4);
        store.addPlayTime("Alex", 2);


        String actual = store.getMostPlayer();
        String expected = "Alena";
        assertEquals(expected, actual);
    }

    @Test
    public void PlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 2);

        String actual = store.getMostPlayer();
        String expected = "Alex";
        assertEquals(expected, actual);
    }

    @Test
    public void SumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 1);
        store.addPlayTime("Slava", 4);
        store.addPlayTime("Chester", 8);

        int actual = store.getSumPlayedTime();
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    public void ZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void SumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 0);
        store.addPlayTime("Slava", 0);
        store.addPlayTime("Chester", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void SumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 0);
        store.addPlayTime("Slava", 1);
        store.addPlayTime("Chester", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}

