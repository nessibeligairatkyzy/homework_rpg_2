package com.narxoz.rpg.loot;

import java.util.Arrays;
import java.util.List;

public class ShadowLootTable implements LootTable {
    @Override
    public List<String> getItems() {
        return Arrays.asList("Shadow Gem", "Dark Essence", "Shadow Rune");
    }

    @Override
    public int getGoldDrop() {
        return 280;
    }

    @Override
    public int getExperienceDrop() {
        return 2000;
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable();
    }
}