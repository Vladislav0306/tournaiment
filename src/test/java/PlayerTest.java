import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    void setId() {
        Player player = new Player();
        player.setId(1);
        int expected = 1;
        int actual = player.getId();
        assertEquals(expected, actual);
    }

    @Test
    void setStrength() {
        Player player = new Player();
        player.setStrength(100);
        int expected = 100;
        int actual = player.getStrength();
        assertEquals(expected, actual);
    }

    @Test
    void setName() {
        Player player = new Player();
        player.setName("Аршавин");
        String expected = "Аршавин";
        String actual = player.getName();
        assertEquals(expected, actual);
    }

    @Test
    void equals1() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(player1.getId(), player1.getName(), player1.getStrength());
        assertEquals(player1, player2);
    }

    @Test
    void equals2() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player();
        assertNotEquals(player1, player2);
    }

    @Test
    void equals3() {
        Player player1 = new Player(1, "Аршавин", 100);
        Object o = null;
        assertNotEquals(player1, o);
    }

    @Test
    void equals4() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(player1.getStrength(), player1.getName(), player1.getId());
        assertNotEquals(player1, player2);
    }

    @Test
    void equals5() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(2, "Роналдо", 150);
        assertNotEquals(player1, player2);
    }

    @Test
    void equals6() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(1, "Роналдо", 150);
        assertNotEquals(player1, player2);
    }

    @Test
    void equals7() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(1, "Роналдо", 100);
        assertNotEquals(player1, player2);
    }

    @Test
    void equals8() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(2, "Аршавин", 150);
        assertNotEquals(player1, player2);
    }

    @Test
    void equals9() {
        Player player = new Player(1, "Аршавин", 100);
        Object o = player;
        assertEquals(player, o);
    }

    @Test
    void toString1() {
        Player player = new Player(1, "Аршавин", 100);
        String string = player.toString();
        assertNotEquals(player, string);
    }

    @Test
    void hashCode1() {
        Player player1 = new Player(1, "Аршавин", 100);
        Player player2 = new Player(player1.getId(), player1.getName(), player1.getStrength());
        assertEquals(player1.hashCode(), player2.hashCode());
    }

    @Test
    void compareTo1() {
        Player player = new Player(1, "Аршавин", 100);
        int expected = 0;
        int actual = player.compareTo(player);
        assertEquals(expected, actual);
    }
}