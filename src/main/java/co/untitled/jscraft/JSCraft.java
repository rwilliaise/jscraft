package co.untitled.jscraft;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class JSCraft extends JavaPlugin {

	private final ScriptUtils utils = new ScriptUtils(this);

	@Override
	public void onEnable() {
		this.getDataFolder().mkdirs();
		for (File file : this.getDataFolder().listFiles()) {
			if (file.isDirectory()) {
				utils.evaluate(new File(file, "main.js"));
			} else if (file.getName().endsWith(".js")) {
				utils.evaluate(file);
			}
		}
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
