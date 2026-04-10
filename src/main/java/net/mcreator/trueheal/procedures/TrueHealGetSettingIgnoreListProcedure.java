package net.mcreator.trueheal.procedures;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class TrueHealGetSettingIgnoreListProcedure {
	public static boolean execute() {
		File truehealconfig = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		com.google.gson.JsonArray whitelist = new com.google.gson.JsonArray();
		com.google.gson.JsonArray blacklist = new com.google.gson.JsonArray();
		boolean use_whitelist = false;
		boolean ignore_list = false;
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
				ignore_list = subObj.get("use_whitelist").getAsBoolean();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ignore_list;
	}
}
