package com.principleglobal.vendingmachine;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dogan
 */
public class Inventory {
    private Map<Coin, Integer> inventory; // = new HashMap<>();


    public Inventory() {
        this.inventory = InventoryUtil.loadInventory();
    }

    public void saveToFile() {
        InventoryUtil.saveInventory(inventory);
    }

    public Map<Coin, Integer> getInventory() {
        return inventory;
    }

    public boolean reduce(Coin coin) {
        Integer value = inventory.getOrDefault(coin, 0);
        if (value > 0) {
            inventory.put(coin, value - 1);
            return true;
        }
        return false;
    }

    public boolean isInInventory(Coin coin) {
        return inventory.getOrDefault(coin, 0) > 0;
    }

}
