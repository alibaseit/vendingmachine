package com.principleglobal.vendingmachine;

import com.principleglobal.vendingmachine.exception.NotSufficientCoinageException;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author dogan
 */
public class VendingMachine implements IVendingMachine {
    private boolean saveInventory = true;


    @Override
    public Collection<Coin> getOptimalChangeFor(int cents) {
        if (cents <= 0)
            return Collections.emptyList();
        Collection<Coin> changeList = new ArrayList<>();
        List<Coin> sortedListOfCoinEnum = Arrays.stream(Coin.values())
                .sorted((c1, c2) -> c2.getDenomination() - c1.getDenomination())
                .collect(Collectors.toList());
        int balance = cents;
        for (Coin coin : sortedListOfCoinEnum) {
            while ((balance > 0) && (coin.getDenomination() <= balance)) {
                changeList.add(coin);
                balance -= coin.getDenomination();
            }
            if (balance <= 0)
                break;
        }
        return changeList;
    }

    @Override
    public Collection<Coin> getChangeFor(int cents) {
        if (cents <= 0)
            return Collections.emptyList();
        Collection<Coin> changeList = new ArrayList<>();
        Inventory inventory = new Inventory();
        final List<Coin> sortedListOfCoinEnum = Arrays.stream(Coin.values())
                .filter(c -> inventory.isInInventory(c))
                .sorted((c1, c2) -> c2.getDenomination() - c1.getDenomination())
                .collect(Collectors.toList());
        int balance = cents;
        for (Coin coin : sortedListOfCoinEnum) {
            while ((balance > 0) && (coin.getDenomination() <= balance)) {
                if (inventory.reduce(coin)) {
                    changeList.add(coin);
                    balance -= coin.getDenomination();
                } else
                    break;
            }
            if (balance <= 0)
                break;
        }
        if (balance > 0)
            throw new NotSufficientCoinageException("Not Sufficient coinage. Needed Coinage amount is " + balance);
        if (saveInventory)
            inventory.saveToFile();
        return changeList;
    }


    /**
     * just for unit testing purpose.
     * When it is unit testing the properties not being saved for getChangeFor operation
     */
    public void disableSavingInventoryAfterOperation() {
        saveInventory = false;
    }
}
