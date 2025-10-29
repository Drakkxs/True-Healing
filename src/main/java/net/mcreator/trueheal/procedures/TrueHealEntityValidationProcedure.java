package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.trueheal.init.TruehealModMobEffects;

public class TrueHealEntityValidationProcedure {
	public static boolean execute(Entity entity, boolean isUnique) {
		if (entity == null)
			return false;
		if (isUnique) {
			if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TruehealModMobEffects.PRE_HEAL.get()) || entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(TruehealModMobEffects.TRUE_HEAL.get())) {
				return false;
			}
		}
		if (!(entity instanceof Player)) {
			return false;
		}
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))) {
			return false;
		}
		return true;
	}
}
