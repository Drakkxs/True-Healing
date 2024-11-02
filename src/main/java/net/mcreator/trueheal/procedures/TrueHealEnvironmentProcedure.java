package net.mcreator.trueheal.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.trueheal.init.TruehealModMobEffects;
import net.mcreator.trueheal.init.TruehealModGameRules;
import net.mcreator.trueheal.TruehealMod;

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
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TruehealModMobEffects.TRUE_HEAL.get())) && !(entity instanceof Player)) {
			TruehealMod.queueServerWork((int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALDELAY)), 0), () -> {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) == (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(TruehealModMobEffects.TRUE_HEAL.get(),
								(int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) - (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)) * 20
										+ Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALTIME)), 0)),
								(int) Math.max((world.getLevelData().getGameRules().getInt(TruehealModGameRules.TRUEHEALAMP)), 0), false, false));
				}
			});
		}
	}
}
