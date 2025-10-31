package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.trueheal.init.TruehealModMobEffects;

public class PreHealOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TruehealModMobEffects.TRUE_HEAL)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TruehealModMobEffects.TRUE_HEAL);
		}
	}
}