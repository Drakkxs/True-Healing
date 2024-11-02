
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.trueheal.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TruehealModGameRules {
	public static final GameRules.Key<GameRules.IntegerValue> TRUEHEALAMP = GameRules.register("truehealamp", GameRules.Category.MOBS, GameRules.IntegerValue.create(1));
	public static final GameRules.Key<GameRules.IntegerValue> TRUEHEALTIME = GameRules.register("truehealtime", GameRules.Category.MOBS, GameRules.IntegerValue.create(200));
	public static final GameRules.Key<GameRules.IntegerValue> TRUEHEALDELAY = GameRules.register("truehealdelay", GameRules.Category.MOBS, GameRules.IntegerValue.create(100));
}
