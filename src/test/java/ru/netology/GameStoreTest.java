package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Зума", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Зума", "Аркады");
        Game game2 = new Game("Call of duty", "Стратегия", store);
        Game game3 = new Game("Rayman", "Джамп-н-ран", store);
        assertFalse(store.containsGame(game3));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Call of duty", "Стратегия", store);
        Game game3 = new Game("Rayman", "Джамп-н-ран", store);
        assertFalse(store.containsGame(game3));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 3);
        store.addPlayTime("Slava", 9);
        store.addPlayTime("Chester", 16);


        String actual = store.getMostPlayer();
        String expected = "Chester";
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetMostPlayerFour() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 3);
        store.addPlayTime("Slava", 9);
        store.addPlayTime("Chester", 6);
        store.addPlayTime("Chester", 10);

        String actual = store.getMostPlayer();
        String expected = "Chester";
        assertEquals(expected, actual);
    }
    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Call of duty", "Стратегия");

        store.addPlayTime("Alena", 0);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Call of duty", "Стратегия");

        store.addPlayTime("Alena", -1);

        String actual = store.getMostPlayer();
        String expected = null;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 4);
        store.addPlayTime("Alena", 2);


        String actual = store.getMostPlayer();
        String expected = "Alena";
        assertEquals(expected, actual);
    }

    @Test
    public void  shouldGetMostPlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("Alex", 10);
        store.addPlayTime("Slava",2 );
        store.addPlayTime("Chester", 10);
        String actual = store.getMostPlayer();
        String expected = "Alex";
        assertEquals(expected, actual);
    }

    @Test
    public void  shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 1);
        store.addPlayTime("Slava", 4);
        store.addPlayTime("Chester", 8);

        int actual = store.getSumPlayedTime();
        int expected = 13;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 0);
        store.addPlayTime("Slava", 0);
        store.addPlayTime("Chester", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Alena", 0);
        store.addPlayTime("Slava", 1);
        store.addPlayTime("Chester", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}

