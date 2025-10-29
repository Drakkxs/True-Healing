package net.mcreator.trueheal.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

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

	public static void execute(LevelAccessor world, Entity entity, boolean isUnique) {
		execute(null, world, entity, isUnique);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, boolean isUnique) {
		if (entity == null)
			return;
		if (world.getLevelData().getGameRules().getBoolean(TruehealModGameRules.TRUEHEALCD)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TruehealModMobEffects.TRUE_HEAL.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(TruehealModMobEffects.PRE_HEAL.get());
		}
		TrueHealEffectApplyProcedure.execute(world, entity, isUnique);
	}
}
