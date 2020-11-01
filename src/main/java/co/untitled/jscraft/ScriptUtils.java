package co.untitled.jscraft;

import org.bukkit.plugin.java.JavaPlugin;

import javax.script.*;
import java.io.*;

public class ScriptUtils {

	private final ScriptEngineManager manager = new ScriptEngineManager();
	private final ScriptContext context = new SimpleScriptContext();

	public ScriptUtils(JavaPlugin plugin) {
		this.context.setAttribute("plugin", plugin, ScriptContext.GLOBAL_SCOPE);
	}

	/**
	 * Load a file if it exists, or just fill it with a simple program if it doesn't.
	 * @param file The file to load
	 */
	public void evaluate(File file) {
		if (file.exists()) {
			try {
				ScriptEngine engine = manager.getEngineByName("js");
				context.setAttribute("script", file, ScriptContext.ENGINE_SCOPE);
				engine.setContext(context);
				engine.eval(new FileReader(file), context);
			} catch (ScriptException | FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter writer = new FileWriter(file);
				writer.append("print(\"Hello, world\")");
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
