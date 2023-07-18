package ru.netology.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<String, Player> playersMap = new HashMap<>();


    /*public HashMap<String, Player> getPlayersMap() {
        return playersMap;
    }*/

    public HashMap<String, Player> register(Player player) {
        this.playersMap.put(player.getName(), player);
        return playersMap;
    }


    public Player findByName(String name) {
        for (String names : playersMap.keySet()) {
            if (names.equals(name)) {
                return playersMap.get(names);
            }
        }
        return null;
    }

    public int round (String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException( " The player with the name " + playerName1 + " is not registered" );
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException( " The player with the name" + playerName2 + " is not registered");
        }
        if (findByName(playerName1).getStrength() < findByName(playerName2).getStrength()) {
            return 2;
        } else if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 0;
        }

    }


}
