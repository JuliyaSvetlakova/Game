package ru.netology.Game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;


public class Game {
    ArrayList<Player> playersList = new ArrayList<>();


    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public ArrayList<Player> register(Player player) {
        this.playersList.add(player);
        return playersList;
    }


    public Player findByName(String name) {
        for (Player player : playersList) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        if (findByName(playerName1) == null) {
            throw new NotRegisteredException(" The player with the name " + playerName1 + " is not registered");
        }
        if (findByName(playerName2) == null) {
            throw new NotRegisteredException(" The player with the name" + playerName2 + " is not registered");
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
