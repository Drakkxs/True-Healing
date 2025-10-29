
package net.mcreator.trueheal.potion;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.trueheal.procedures.TrueHealOnEffectActiveTickProcedure;
import net.mcreator.trueheal.procedures.TrueHealActiveTickConditionProcedure;

import java.util.List;
import java.util.ArrayList;

public class PreHealMobEffect extends MobEffect {
	public PreHealMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -6348254);
	}

	@Override
	public List<ItemStack> getCurativeItems() {
		ArrayList<ItemStack> cures = new ArrayList<ItemStack>();
		return cures;
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		TrueHealOnEffectActiveTickProcedure.execute(entity, amplifier);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return TrueHealActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
