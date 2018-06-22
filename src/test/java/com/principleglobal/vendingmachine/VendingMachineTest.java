package com.principleglobal.vendingmachine;

import com.principleglobal.vendingmachine.exception.NotSufficientCoinageException;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class VendingMachineTest {
    @Before
    public void setUp() {
        InventoryUtil.setPropertiesFileName("coin-inventory-test.properties");
    }

    @Test
    public void test_getOptimalChangeFor() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        final Collection<Coin> optimalChangeFor = vendingMachine.getOptimalChangeFor(231);
        assertThat(optimalChangeFor.size(), Matchers.is(5));
        assertEquals(optimalChangeFor.stream().filter(c -> Coin.ONE_EURO == c).count(), 2L);;
        assertEquals(optimalChangeFor.stream().filter(c -> Coin.ONE_CENT == c).count(), 1L);
        assertEquals(optimalChangeFor.stream().filter(c -> Coin.TWENTY_CENT == c).count(), 1L);
        System.out.println(optimalChangeFor);
    }

    @Test
    public void test_getOptimalChangeFor_One_Cents() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        final Collection<Coin> optimalChangeFor = vendingMachine.getOptimalChangeFor(1);
        assertThat(optimalChangeFor.size(), Matchers.is(1));
        System.out.println(optimalChangeFor);
    }

    @Test
    public void test_getOptimalChangeFor_Invalid_Cents() throws Exception {
        VendingMachine vendingMachine = new VendingMachine();
        final Collection<Coin> optimalChangeFor = vendingMachine.getOptimalChangeFor(0);
        assertThat(optimalChangeFor.size(), Matchers.is(0));
        System.out.println(optimalChangeFor);
    }

    @Test
    public void getChangeFor() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.disableSavingInventoryAfterOperation();
        final Collection<Coin> changeFor = vendingMachine.getChangeFor(1211);
        assertThat(changeFor.size(), Matchers.is(15));
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_EURO == c).count(), 11L);;
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_CENT == c).count(), 1L);
        assertEquals(changeFor.stream().filter(c -> Coin.FIFTY_CENT == c).count(), 2L);
        System.out.println(changeFor);
    }

    @Test(expected = NotSufficientCoinageException.class)
    public void getChangeForNotSufficientCoins() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.disableSavingInventoryAfterOperation();
        final Collection<Coin> changeFor = vendingMachine.getChangeFor(569777799);
        assertThat(changeFor.size(), Matchers.is(368));
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_EURO == c).count(), 11L);;
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_CENT == c).count(), 23L);
        assertEquals(changeFor.stream().filter(c -> Coin.FIFTY_CENT == c).count(), 24L);
    }

    @Test
    public void getChangeFor_For_All_the_Coinage_Amount() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.disableSavingInventoryAfterOperation();
        final Collection<Coin> changeFor = vendingMachine.getChangeFor(4335);
        assertThat(changeFor.size(), Matchers.is(368));
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_CENT == c).count(), 23L);
        assertEquals(changeFor.stream().filter(c -> Coin.TEN_CENT == c).count(), 99L);
        assertEquals(changeFor.stream().filter(c -> Coin.FIVE_CENT == c).count(), 200L);
        assertEquals(changeFor.stream().filter(c -> Coin.FIFTY_CENT == c).count(), 24L);
        assertEquals(changeFor.stream().filter(c -> Coin.TWENTY_CENT == c).count(), 0L);
        assertEquals(changeFor.stream().filter(c -> Coin.ONE_EURO == c).count(), 11L);
    }
}