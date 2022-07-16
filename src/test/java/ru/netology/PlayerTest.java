package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {
    GameStore store = new GameStore();
    Game game = store.publishGame("Сибирь", "Квест");
    Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
    Game game2 = store.publishGame("Двойной удар", "Аркады");
    Game game3 = store.publishGame("Морской бой", "Аркады");
    Game game4 = store.publishGame("Лесной бой", "Стратегия");

    @Test
    public void shouldInstallNewGame() {

        Player player = new Player("Ann");
        player.installGame(game);

        boolean expected = true;
        boolean actual = player.playedTime.containsKey(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindNotInstalledGame() {

        Player player = new Player("Ann");

        boolean expected = false;
        boolean actual = player.playedTime.containsKey(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNothingHappenWhenInstallExistingGame() {

        Player player = new Player("Ann");
        player.installGame(game);
        player.installGame(game);

        boolean expected = true;
        boolean actual = player.playedTime.containsKey(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumTimeOfNewGame() {

        Player player = new Player("Ann");
        player.installGame(game);
        player.play(game, 1);

        int expected = 1;
        int actual = player.playedTime.get(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumTimeOfOldGame() {

        Player player = new Player("Ann");
        player.installGame(game);
        player.play(game, 1);
        player.play(game, 3);
        player.play(game, 2);

        int expected = 6;
        int actual = player.playedTime.get(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowRuntimeExceptionWhenGameNotInstall() {

        Player player = new Player("Ann");

        assertThrows(RuntimeException.class, () -> {
            player.play(game, 1);
        });
    }

    @Test
    public void shouldSumGenreIfOneGame() {

        Player player = new Player("Petya");
        player.installGame(game1);
        player.play(game1, 3);

        int expected = 3;
        int actual = player.sumGenre(game1.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreInSeveralGames() {

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 1);
        player.play(game3, 4);

        int expected = 8;
        int actual = player.sumGenre(game1.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSumDifferentGenre() {

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game4);
        player.play(game1, 3);
        player.play(game2, 1);
        player.play(game4, 4);

        int expected = 4;
        int actual = player.sumGenre(game1.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSumGenreOfDifferentPlayer() {

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.play(game1, 3);
        player.play(game2, 1);

        Player player1 = new Player("Ann");
        player1.installGame(game2);
        player1.play(game2, 4);

        int expected = 4;
        int actual = player.sumGenre(game2.getGenre());

        assertEquals(expected, actual);
    }

    @Test
    public void shouldShowMostPlayedGame() {

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.play(game1, 3);
        player.play(game2, 1);
        player.play(game3, 4);

        Game expected = game3;
        Game actual = player.mostPlayerByGenre("Аркады");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNullIfNotPlayThisGenre() {

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game4);
        player.play(game, 3);
        player.play(game1, 1);

        Game expected = null;
        Game actual = player.mostPlayerByGenre("Стратегия");

        assertEquals(null, actual);
    }
}
