import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;


public class Game {
    private final List<Player> items = new ArrayList<>();

    public Player[] findAll() {
        return items.toArray(new Player[0]);
    }

    public void register(Player player) {
        items.add(player);
    }

    public int round(Player playerName1, Player playerName2) throws NotRegisteredException {
        int result = 0;
        for (Player player : findAll()) {
            if (playerName1 == null || playerName2 == null) {
                throw new NotRegisteredException("Player with name: " + player.getName() + " not registered");
            }
            if (playerName1.getStrength() > playerName2.getStrength()) {
                result = 1;
            } else {
                if (playerName1.getStrength() < playerName2.getStrength()) {
                    result = 2;
                } else {
                    result = 0;
                }
            }
        }
        return result;
    }
}