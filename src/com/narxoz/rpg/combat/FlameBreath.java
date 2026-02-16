package com.narxoz.rpg.combat;

import com.narxoz.rpg.combat.Ability;

public class FlameBreath implements Ability {
    @Override
    public String getName() {
        return "Flame Breath";
    }

    @Override
    public int getDamage() {
        return 45;
    }

    @Override
    public String getDescription() {
        return "Breathes fire in a cone, dealing AoE damage and applying burn.";
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}