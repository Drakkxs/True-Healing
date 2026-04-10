package net.mcreator.trueheal.procedures;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class TrueHealGetSettingPreHealParticlesProcedure {
	public static boolean execute() {
		File truehealconfig = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		com.google.gson.JsonArray whitelist = new com.google.gson.JsonArray();
		com.google.gson.JsonArray blacklist = new com.google.gson.JsonArray();
		boolean use_whitelist = false;
		boolean ignore_list = false;
		boolean trueheal_ambient = false;
		boolean trueheal_particles = false;
		boolean preheal_ambient = false;
		boolean preaheal_particles = false;
		truehealconfig = TrueHealGetConfigProcedure.execute();
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(truehealconfig));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				mainObj = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				subObj = mainObj.get("settings").getAsJsonObject();
				preaheal_particles = subObj.get("preheal_particles").getAsBoolean();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return preaheal_particles;
	}
}
