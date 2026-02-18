package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class IceShield implements Ability {
    @Override
    public String getName() {
        return "Ice Shield";
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "Creates an icy barrier reducing incoming damage and possibly freezing attackers.";
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}