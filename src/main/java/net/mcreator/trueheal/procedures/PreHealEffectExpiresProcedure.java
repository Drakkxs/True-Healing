package net.mcreator.trueheal.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class PreHealEffectExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		TrueHealEffectApplyProcedure.execute(world, entity);
	}
}