package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class FrostBreath implements Ability {
    @Override
    public String getName() {
        return "Frost Breath";
    }

    @Override
    public int getDamage() {
        return 40;
    }

    @Override
    public String getDescription() {
        return "Exhales freezing air, damaging and slowing enemies.";
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}
