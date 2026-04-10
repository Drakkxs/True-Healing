package net.mcreator.trueheal.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trueheal.init.TruehealModMobEffects;
import net.mcreator.trueheal.init.TruehealModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class TrueHealEnvironmentProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Post event) {
		if (event.getEntity() != null) {
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
				_entity.removeEffect(TruehealModMobEffects.PRE_HEAL);
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TruehealModMobEffects.TRUE_HEAL);
		}
		if (TrueHealEntityValidationProcedure.execute(entity)) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(TruehealModMobEffects.PRE_HEAL, (int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALDELAY)), 0), 0, TrueHealGetSettingPreHealAmbientProcedure.execute(),
						TrueHealGetSettingPreHealParticlesProcedure.execute()));
		}
	}
}