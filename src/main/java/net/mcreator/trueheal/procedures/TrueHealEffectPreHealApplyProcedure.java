package net.mcreator.trueheal.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trueheal.init.TruehealModMobEffects;
import net.mcreator.trueheal.init.TruehealModGameRules;

public class TrueHealEffectPreHealApplyProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, boolean isUnique) {
		if (entity == null)
			return false;
		if (TrueHealEntityValidationProcedure.execute(entity, isUnique)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TruehealModMobEffects.PRE_HEAL.get(), (int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALDELAY)), 0),
						(int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALAMP)), 0), false, false));
			return true;
		}
		return false;
	}
}
