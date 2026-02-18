package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class Vanish implements Ability {
    @Override
    public String getName() {
        return "Vanish";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Allows the enemy to vanish, increasing evasion and avoiding attacks for 1 turn.";
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}