package io.github.synchronousx.hyplay.utils;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public enum Key {
    OPEN_GUI("key.hyplay.openGUI", Keyboard.KEY_RSHIFT, Key.CATEGORY);

    public static final String CATEGORY = "key.categories.hyplay";
    private final KeyBinding keyBinding;

    Key(final String description, final int keyCode, final String category) {
        this.keyBinding = new KeyBinding(description, keyCode, category);
    }

    public static void registerKeyBindings() {
        for (final Key key : Key.values()) {
            ClientRegistry.registerKeyBinding(key.getKeyBinding());
        }
    }

    public KeyBinding getKeyBinding() {
        return this.keyBinding;
    }
}
