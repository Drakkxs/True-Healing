package net.mcreator.trueheal.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trueheal.init.TruehealModMobEffects;
import net.mcreator.trueheal.init.TruehealModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TrueHealEnvironmentProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(TruehealModGameRules.TRUEHEALCD)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TruehealModMobEffects.TRUE_HEAL.get());
		}
		if (TrueHealEntityValidationProcedure.execute(entity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TruehealModMobEffects.PRE_HEAL.get(), (int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALDELAY)), 0), 0, false, false));
		}
	}
}
