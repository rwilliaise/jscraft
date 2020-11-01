package co.untitled.jscraft.scripting;

import org.bukkit.plugin.java.JavaPlugin;

public class Commands {

	private final JavaPlugin plugin;

	public Commands(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public void addCommand() {
		plugin.getServer().getPluginCommand()
	}
}
