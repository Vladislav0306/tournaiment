import java.util.*;
import java.util.HashMap;

public class Game {
    Map<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.getName(), player.getId());
    }

    public Map<String, Integer> findAll() {
        return new HashMap<>(map);
    }

    public int round(Player playerName1, Player playerName2) throws NotRegisteredException {
        int result = 0;
        for (Map.Entry<String, Integer> ignored : map.entrySet()) {
            if (playerName1 == null || playerName2 == null) {
                throw new NotRegisteredException("Player with name: " + map.values() + " not registered");
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