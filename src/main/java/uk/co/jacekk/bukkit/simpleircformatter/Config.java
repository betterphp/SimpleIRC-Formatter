package uk.co.jacekk.bukkit.simpleircformatter;

import uk.co.jacekk.bukkit.baseplugin.v9.config.PluginConfigKey;

public class Config {
	
	public static final PluginConfigKey	DEFAULT_PREFIX	= new PluginConfigKey("default-prefix", "<");
	public static final PluginConfigKey	DEFAULT_SUFFIX	= new PluginConfigKey("default-suffix", "> ");
	public static final PluginConfigKey	IRC_PREFIX		= new PluginConfigKey("irc-prefix", "&b[IRC]#r");
	
}
