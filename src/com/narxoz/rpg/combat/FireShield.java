package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class FireShield implements Ability {
    @Override
    public String getName() {
        return "Fire Shield";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Creates a protective fire barrier, reducing incoming damage.";
    }

    @Override
    public Ability clone() {
        return new FireShield();
    }
}
