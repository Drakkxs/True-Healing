package net.mcreator.trueheal.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.trueheal.procedures.PreHealOnEffectActiveTickProcedure;

public class PreHealMobEffect extends MobEffect {
	public PreHealMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6348254);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		PreHealOnEffectActiveTickProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}