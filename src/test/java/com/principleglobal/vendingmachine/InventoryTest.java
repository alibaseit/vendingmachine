package com.principleglobal.vendingmachine;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertThat;

public class InventoryTest {

    @Test
    public void testPropertiesLoad() throws Exception {
        InventoryUtil.setPropertiesFileName("src/test/resources/coin-inventory-test.properties");
        Inventory inventory = new Inventory();
        final Set<Map.Entry<Coin, Integer>> entries = inventory.getInventory().entrySet();
        Map<Coin, Integer> inventoryList = inventory.getInventory();

        entries.forEach(entry -> System.out.println(entry.getKey() + " : "+ entry.getValue()));

        assertThat(inventoryList.get(Coin.ONE_EURO), Matchers.is(11));
        assertThat(inventoryList.get(Coin.FIFTY_CENT), Matchers.is(24));
        assertThat(inventoryList.get(Coin.TEN_CENT), Matchers.is(99));
        assertThat(inventoryList.get(Coin.TWENTY_CENT), Matchers.is(0));
        assertThat(inventoryList.get(Coin.ONE_CENT), Matchers.is(23));
        assertThat(inventoryList.get(Coin.FIVE_CENT), Matchers.is(200));
        assertThat(inventoryList.get(Coin.TWO_CENT), Matchers.is(11));
    }


}