/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trueheal.init;

import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.GameRules;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class TruehealModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> TRUEHEALAMP;
	public static GameRules.Key<GameRules.IntegerValue> TRUEHEALTIME;
	public static GameRules.Key<GameRules.IntegerValue> TRUEHEALDELAY;
	public static GameRules.Key<GameRules.BooleanValue> TRUEHEALCD;

	@SubscribeEvent
	public static void registerGameRules(FMLCommonSetupEvent event) {
		TRUEHEALAMP = GameRules.register("truehealamp", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
		TRUEHEALTIME = GameRules.register("truehealtime", GameRules.Category.MOBS, GameRules.IntegerValue.create(200));
		TRUEHEALDELAY = GameRules.register("truehealdelay", GameRules.Category.MOBS, GameRules.IntegerValue.create(100));
		TRUEHEALCD = GameRules.register("truehealcd", GameRules.Category.MOBS, GameRules.BooleanValue.create(true));
	}
}