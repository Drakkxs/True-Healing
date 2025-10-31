/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trueheal.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.trueheal.procedures.PreHealEffectExpiresProcedure;
import net.mcreator.trueheal.potion.TrueHealMobEffect;
import net.mcreator.trueheal.potion.PreHealMobEffect;
import net.mcreator.trueheal.TruehealMod;

@EventBusSubscriber
public class TruehealModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, TruehealMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> TRUE_HEAL = REGISTRY.register("true_heal", () -> new TrueHealMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PRE_HEAL = REGISTRY.register("pre_heal", () -> new PreHealMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(PRE_HEAL)) {
			PreHealEffectExpiresProcedure.execute(entity.level(), entity);
		}
	}
}