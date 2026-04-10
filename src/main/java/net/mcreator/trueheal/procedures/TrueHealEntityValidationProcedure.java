package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.Entity;

public class TrueHealEntityValidationProcedure {
	public static boolean execute(Entity entityToCheck) {
		if (entityToCheck == null)
			return false;
		if (TrueHealGetSettingIgnoreListProcedure.execute()) {
			return true;
		} else if (TrueHealGetSettingUseWhitelistProcedure.execute()) {
			return TrueHealCheckWhitelistProcedure.execute(entityToCheck);
		}
		return !TrueHealCheckBlackListProcedure.execute(entityToCheck);
	}
}
