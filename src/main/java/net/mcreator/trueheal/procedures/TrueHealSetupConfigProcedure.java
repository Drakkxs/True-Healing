package net.mcreator.trueheal.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TrueHealSetupConfigProcedure {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		File truehealconfig = new File("");
		com.google.gson.JsonObject mainObj = new com.google.gson.JsonObject();
		com.google.gson.JsonObject subObj = new com.google.gson.JsonObject();
		com.google.gson.JsonArray blacklist = new com.google.gson.JsonArray();
		com.google.gson.JsonArray whitelist = new com.google.gson.JsonArray();
		truehealconfig = TrueHealGetConfigProcedure.execute();
		if (!truehealconfig.exists()) {
			try {
				truehealconfig.getParentFile().mkdirs();
				truehealconfig.createNewFile();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
			mainObj.add("settings", subObj);
			subObj.addProperty("use_whitelist", false);
			subObj.addProperty("ignore_list", false);
			subObj.addProperty("preheal_ambient", false);
			subObj.addProperty("preheal_particles", false);
			subObj.addProperty("trueheal_ambient", false);
			subObj.addProperty("trueheal_particles", false);
			mainObj.add("blacklist", blacklist);
			mainObj.add("whitelist", whitelist);
			blacklist.add("minecraft:player");
			blacklist.add("minecraft:creeper");
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(truehealconfig);
					fileWriter.write(mainGSONBuilderVariable.toJson(mainObj));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}
