import java.util.*;


public class Game {
    private final List<Player> items = new ArrayList<>();

    public Object hashMap(String name, int strength) {
        for (Player player : findAll()) {
            if (player.getStrength() == strength && Objects.equals(player.getName(), name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        items.add(player);
    }

    public Player[] findAll() {
        return items.toArray(new Player[0]);
    }

    public int round(Player playerName1, Player playerName2) throws NotRegisteredException {
        int result = 0;
        for (Player player : findAll()) {
            if (playerName1 == null || playerName2 == null) {
                throw new NotRegisteredException("Player with name: " + player.getName() + " not registered");
            }
            if (playerName1.getStrength() > playerName2.getStrength())
                result = 1;
            else if (playerName1.getStrength() < playerName2.getStrength())
                result = 2;
            else
                result = 0;
        }
        return result;
    }
}