package net.mcreator.trueheal.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.trueheal.procedures.TrueHealOnEffectActiveTickProcedure;
import net.mcreator.trueheal.procedures.TrueHealActiveTickConditionProcedure;

public class TrueHealMobEffect extends MobEffect {
	public TrueHealMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -400581);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return TrueHealActiveTickConditionProcedure.execute(amplifier, duration);
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		TrueHealOnEffectActiveTickProcedure.execute(entity, amplifier);
		return super.applyEffectTick(entity, amplifier);
	}
}