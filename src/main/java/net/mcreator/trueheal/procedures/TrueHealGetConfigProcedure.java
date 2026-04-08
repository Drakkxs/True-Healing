package net.mcreator.trueheal.procedures;

import net.neoforged.fml.loading.FMLPaths;

import java.io.File;

public class TrueHealGetConfigProcedure {
	public static File execute() {
		File file = new File("");
		return new File((FMLPaths.GAMEDIR.get().toString() + "/config"), File.separator + "trueheal.json");
	}
}