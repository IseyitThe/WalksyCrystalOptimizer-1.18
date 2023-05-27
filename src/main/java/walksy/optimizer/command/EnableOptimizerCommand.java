package walksy.optimizer.command;

import ca.weblite.objc.Client;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.network.ClientCommandSource;
import net.minecraft.text.Text;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;


public class EnableOptimizerCommand {

    public static boolean fastCrystal = true;

    public static void displayMessage(String message) {
        // Make sure that they are in game.
        if (!inGame()) return;

        MinecraftClient client = MinecraftClient.getInstance();
        ChatHud chatHud = client.inGameHud.getChatHud();

        chatHud.addMessage(Text.of(message));
    }

    public static Boolean inGame() {
        MinecraftClient client = MinecraftClient.getInstance();
        return client.player != null && client.getNetworkHandler() != null;
    }
}
