package uk.co.jacekk.bukkit.simpleircformatter;

import uk.co.jacekk.bukkit.baseplugin.v8.BasePlugin;

public class SimpleIRCFormatter extends BasePlugin {
	
	public void onEnable(){
		super.onEnable(false);
		
		this.pluginManager.registerEvents(new ChatListener(this), this);
	}
	
}
