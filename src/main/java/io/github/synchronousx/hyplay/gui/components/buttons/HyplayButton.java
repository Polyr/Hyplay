package io.github.synchronousx.hyplay.gui.components.buttons;

import io.github.synchronousx.hyplay.gui.HyplayGUI;
import net.minecraftforge.fml.client.config.GuiButtonExt;

public abstract class HyplayButton extends GuiButtonExt {
    protected final HyplayGUI hyplayGUI;

    public HyplayButton(final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final String displayString) {
        super(id, xPos, yPos, displayString);
        this.hyplayGUI = hyplayGUI;
    }

    public HyplayButton(final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final int width, final int height, final String displayString) {
        super(id, xPos, yPos, width, height, displayString);
        this.hyplayGUI = hyplayGUI;
    }

    public abstract void onPress();
}
