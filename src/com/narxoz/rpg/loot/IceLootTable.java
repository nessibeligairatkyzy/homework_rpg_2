package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class IceLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return Arrays.asList("Ice Gem", "Frost Scale", "Frozen Rune");
    }

    @Override
    public int getGoldDrop() {
        return 220;
    }

    @Override
    public int getExperienceDrop() {
        return 1600;
    }

    @Override
    public LootTable clone() {
        return new IceLootTable();
    }
}