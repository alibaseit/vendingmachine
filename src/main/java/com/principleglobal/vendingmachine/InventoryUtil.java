package com.principleglobal.vendingmachine;

import com.principleglobal.vendingmachine.exception.InventoryLoadingException;
import com.principleglobal.vendingmachine.exception.InventorySavingException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class for loading from properties file and saving inventory to properties file
 *
 * @author dogan
 */
public class InventoryUtil {
    private static final Logger LOGGER = Logger.getLogger(InventoryUtil.class.getName());

    private static String propertiesFile;

    /**
     * load inventory from properties file
     *
     * @return
     */
    public static Map<Coin, Integer> loadInventory() {
        Map<Coin, Integer> inventory = new HashMap<>();
        try (FileInputStream input = new FileInputStream(propertiesFile)) {
            Properties prop = new Properties();
            prop.load(input);
            Enumeration<?> element = prop.propertyNames();
            while (element.hasMoreElements()) {
                String name = (String) element.nextElement();
                try {
                    Integer value = Integer.parseInt(prop.getProperty(name));
                    Coin coin = Coin.fromId(Integer.parseInt(name));
                    Integer prevValue = inventory.getOrDefault(coin, 0);
                    inventory.put(coin, prevValue + value);
                } catch (Exception e) {
                    //if it is not a valid property continue
                    continue;
                }
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new InventoryLoadingException(e.getMessage());
        }
        return inventory;
    }

    /**
     * Save Inventory to properties file
     *
     * @param inventory
     */
    public static void saveInventory(Map<Coin, Integer> inventory) {
        Properties prop = new Properties();
        try (FileOutputStream output = new FileOutputStream(propertiesFile)) {
            inventory.forEach((coin, amount) -> {
                prop.setProperty(Integer.toString(coin.getDenomination()), Integer.toString(amount));
            });
            prop.store(output, null);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage(), e);
            throw new InventorySavingException(e.getMessage());
        }
    }

    public static void setPropertiesFileName(String fileName) {
        propertiesFile = fileName;
    }
}
