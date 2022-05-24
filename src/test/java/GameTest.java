import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    Game game = new Game();

    @Test
    public void shouldRegister() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(2, "Роналдо", 100);
        game.register(player1);
        game.register(player2);
        Player[] expected = {player1, player2};
        Player[] actual = game.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRegisteredException1() {
        Player player1 = new Player(1, "Аршавин", 100);
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1, null));
    }

    @Test
    public void shouldNotRegisteredException2() {
        Player player1 = null;
        Player player2 = new Player(1, "Аршавин", 100);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class, () -> game.round(player1, player2));
    }

    @Test
    public void shouldDraw() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(2, "Роналдо", 100);
        game.register(player1);
        game.register(player2);
        int expected = 0;
        int actual = game.round(player1, player2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer1Win() {
        Player player1 = new Player(1, "Аршавин", 150);
        Player player2 = new Player(2, "Роналдо", 100);
        game.register(player1);
        game.register(player2);
        int expected = 1;
        int actual = game.round(player1, player2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldPlayer2Win() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(2, "Роналдо", 150);
        game.register(player1);
        game.register(player2);
        int expected = 2;
        int actual = game.round(player1, player2);
        assertEquals(expected, actual);
    }
}