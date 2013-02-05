package uk.co.jacekk.bukkit.simpleircformatter;

import net.milkbowl.vault.chat.Chat;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.plugin.RegisteredServiceProvider;

import uk.co.jacekk.bukkit.baseplugin.v8.event.BaseListener;
import uk.co.jacekk.bukkit.baseplugin.v8.util.ChatUtils;
import uk.co.jacekk.bukkit.simpleirc.RemotePlayerChatEvent;

public class ChatListener extends BaseListener<SimpleIRCFormatter> {
	
	public static final String DEFAULT_PREFIX = ChatColor.RED + "[E]" + ChatColor.RESET + "<";
	public static final String DEFAULT_SUFFIX = "> ";
	
	private Chat chat;
	
	public ChatListener(SimpleIRCFormatter plugin){
		super(plugin);
		
		RegisteredServiceProvider<Chat> chatProvider = plugin.server.getServicesManager().getRegistration(Chat.class);
		
		if (chatProvider != null){
			this.chat = chatProvider.getProvider();
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onPlayerRemoteChat(RemotePlayerChatEvent event){
		String playerName = event.getPlayerName();
		String worldName = plugin.server.getWorlds().get(0).getName();
		String message = ChatColor.stripColor(event.getMessage());
		
		if (message.isEmpty()){
			event.setCancelled(true);
		}
		
		String prefix = this.chat.getPlayerPrefix(worldName, playerName);
		String suffix = this.chat.getPlayerSuffix(worldName, playerName);
		
		prefix = ChatColor.AQUA + "[IRC]" + ChatColor.RESET + ((prefix.isEmpty()) ? DEFAULT_PREFIX : ChatUtils.parseFormattingCodes(prefix));
		suffix = (suffix.isEmpty()) ? DEFAULT_SUFFIX : ChatUtils.parseFormattingCodes(suffix);
		
		event.setFormat(prefix + "%s" + suffix + "%s");
	}
	
}
