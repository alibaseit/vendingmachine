package com.principleglobal.vendingmachine;

import java.util.Collection;

public interface IVendingMachine {

    /**
     * Part 1
     * This function returns the optimal change for a given number of Euro.
     * An unlimited supply of coins assumed.
     *
     * @param cents
     * @return
     */
    public Collection<Coin> getOptimalChangeFor(int cents);

    /**
     * Part 2
     * This function  returns the change for a given number of Euro based on a limited supply of coins
     * The available coins stored in a file named coin-inventory.properties with format
     * denomination=coinCount e.g.
     *
     * @param cents
     * @return
     */
    public Collection<Coin> getChangeFor(int cents);
}
