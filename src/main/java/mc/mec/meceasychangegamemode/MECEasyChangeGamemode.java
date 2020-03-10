package mc.mec.meceasychangegamemode;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class MECEasyChangeGamemode extends JavaPlugin {

    String _prefix = "§c§l[MECG]";

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!sender.hasPermission("change.gamemode")) {
            sender.sendMessage("§4You don't have permission.");
        } else if (cmd.getName().equals("1")) {
            setCreative((Player) sender);
            sender.sendMessage(_prefix + "ゲームモードをクリエイティブに変更しました。");
        } else if (cmd.getName().equals("2")) {
            setAdventure((Player) sender);
            sender.sendMessage(_prefix + "ゲームモードをアドベンチャーに変更しました。");
        } else if (cmd.getName().equals("3")) {
            setSpectator((Player) sender);
            sender.sendMessage(_prefix + "ゲームモードをスペクテイターに変更しました。");
        } else if (cmd.getName().equals("0")) {
            setSurvival((Player) sender);
            sender.sendMessage(_prefix + "ゲームモードをサバイバルに変更しました。");
        }

        if (cmd.getName().equals("gm")) {
            if (!sender.hasPermission("change.gamemode")) {
                sender.sendMessage("§4You don't have permission.");
            } else if (args.length == 0) {
                ShowHelp(sender);
                return false;
            }
            if (args[0].equalsIgnoreCase("1")) {
                setCreative((Player) sender);
                sender.sendMessage(_prefix + "ゲームモードをクリエイティブに変更しました。");
            }
            if (args[0].equalsIgnoreCase("2")) {
                setAdventure((Player) sender);
                sender.sendMessage(_prefix + "ゲームモードをアドベンチャーに変更しました。");
            }
            if (args[0].equalsIgnoreCase("3")) {
                setSpectator((Player) sender);
                sender.sendMessage(_prefix + "ゲームモードをスペクテイターに変更しました。");
            }
            if (args[0].equalsIgnoreCase("0")) {
                setSurvival((Player) sender);
                sender.sendMessage(_prefix + "ゲームモードをサバイバルに変更しました。");
            }
        }
        return true;
    }

    public void setCreative(Player p){
        p.setGameMode(GameMode.CREATIVE);
    }

    public void setSurvival(Player p){
        p.setGameMode(GameMode.SURVIVAL);
    }

    public void setAdventure(Player p){
        p.setGameMode(GameMode.ADVENTURE);
    }
    public void setSpectator(Player p){
        p.setGameMode(GameMode.SPECTATOR);
    }

    void ShowHelp(CommandSender sender){
        sender.sendMessage(_prefix + "§f/gm <0/1/2/3>");
        sender.sendMessage(_prefix + "§f/<0/1/2/3>");
        sender.sendMessage(_prefix + "§fこのどちらかの操作をすることによってゲームモードを簡単に変えられます。");
    }
}
