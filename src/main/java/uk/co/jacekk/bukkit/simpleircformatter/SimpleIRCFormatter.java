package uk.co.jacekk.bukkit.simpleircformatter;

import java.io.File;

import uk.co.jacekk.bukkit.baseplugin.v8.BasePlugin;
import uk.co.jacekk.bukkit.baseplugin.v8.config.PluginConfig;

public class SimpleIRCFormatter extends BasePlugin {
	
	public void onEnable(){
		super.onEnable(true);
		
		this.config = new PluginConfig(new File(this.baseDirPath + File.separator + "config.yml"), Config.class, this.log);
		
		this.pluginManager.registerEvents(new ChatListener(this), this);
	}
	
}
