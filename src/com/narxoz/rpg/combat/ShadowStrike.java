package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class ShadowStrike implements Ability {
    @Override
    public String getName() {
        return "Shadow Strike";
    }

    @Override
    public int getDamage() {
        return 60;
    }

    @Override
    public String getDescription() {
        return "Strikes from shadows dealing high single-target damage and applying blind effect.";
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}