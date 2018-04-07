package io.github.synchronousx.hyplay;

import io.github.synchronousx.hyplay.listeners.KeyListener;
import io.github.synchronousx.hyplay.utils.Key;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = HyplayMod.MODID, useMetadata = true, clientSideOnly = true)
public class HyplayMod {
    public static final String MODID = "hyplay";

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event) {
        Key.registerKeyBindings();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new KeyListener());
    }
}
