package net.mcreator.trueheal.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.BuiltInRegistries;

import java.io.File;

public class TrueHealCheckWhitelistProcedure {
	public static boolean execute(Entity entityToCheck) {
		if (entityToCheck == null)
			return false;
		File truehealconfig = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		com.google.gson.JsonArray blacklist = new com.google.gson.JsonArray();
		com.google.gson.JsonArray whitelist = new com.google.gson.JsonArray();
		double i = 0;
		boolean use_whitelist = false;
		boolean ignore_list = false;
		boolean match = false;
		whitelist = TrueHealGetWhitelistProcedure.execute();
		for (int index0 = 0; index0 < (int) whitelist.size(); index0++) {
			if ((BuiltInRegistries.ENTITY_TYPE.getKey(entityToCheck.getType()).toString()).equals(blacklist.get((int) i).getAsString())) {
				match = true;
				break;
			}
			i = i + 1;
		}
		return match;
	}
}