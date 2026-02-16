package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class FireLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return Arrays.asList("Fire Gem", "Dragon Scale", "Flame Rune");
    }

    @Override
    public int getGoldDrop() {
        return 250;
    }

    @Override
    public int getExperienceDrop() {
        return 1800;
    }

    @Override
    public LootTable clone() {
        return new FireLootTable();
    }
}