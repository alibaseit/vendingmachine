package com.principleglobal.vendingmachine;

public enum Coin {
    ONE_CENT(1), TWO_CENT(2), FIVE_CENT(5), TEN_CENT(10), TWENTY_CENT(20), FIFTY_CENT(50), ONE_EURO(100);

    private int denomination;

    private Coin(int denomination) {
        this.denomination = denomination;
    }

    public int getDenomination() {
        return denomination;
    }

    public static Coin fromId(int id) {
        for (Coin coin : values()) {
            if (coin.getDenomination() == id) {
                return coin;
            }
        }
        return null;
    }
}