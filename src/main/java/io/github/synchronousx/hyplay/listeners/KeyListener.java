package io.github.synchronousx.hyplay.listeners;

import io.github.synchronousx.hyplay.gui.HyplayGUI;
import io.github.synchronousx.hyplay.utils.Key;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class KeyListener {
    @SubscribeEvent
    public void onKeyDown(final ClientTickEvent event) {
        if (event.phase == Phase.END && Key.OPEN_GUI.getKeyBinding().isKeyDown()) {
            Minecraft.getMinecraft().displayGuiScreen(new HyplayGUI());
        }
    }
}
