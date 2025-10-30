package net.mcreator.trueheal.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trueheal.init.TruehealModMobEffects;
import net.mcreator.trueheal.init.TruehealModGameRules;

public class TrueHealEffectApplyProcedure {
	public static boolean execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return false;
		if (TrueHealEntityValidationProcedure.execute(entity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(
						new MobEffectInstance(TruehealModMobEffects.TRUE_HEAL.get(),
								(int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) * 20
										+ Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALTIME)), 0)),
								(int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALAMP)), 0), false, false));
			return true;
		}
		return false;
	}
}
