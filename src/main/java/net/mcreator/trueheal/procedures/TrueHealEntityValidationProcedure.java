package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class TrueHealEntityValidationProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof Player) {
			return false;
		}
		return true;
	}
}