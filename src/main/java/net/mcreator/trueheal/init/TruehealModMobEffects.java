
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trueheal.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.trueheal.potion.TrueHealMobEffect;
import net.mcreator.trueheal.TruehealMod;

public class TruehealModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, TruehealMod.MODID);
	public static final RegistryObject<MobEffect> TRUE_HEAL = REGISTRY.register("true_heal", () -> new TrueHealMobEffect());
}
