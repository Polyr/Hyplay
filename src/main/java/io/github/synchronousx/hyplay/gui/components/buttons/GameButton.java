package io.github.synchronousx.hyplay.gui.components.buttons;

import io.github.synchronousx.hyplay.gui.HyplayGUI;
import io.github.synchronousx.hyplay.utils.Game;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.client.config.GuiUtils;

public class GameButton extends HyplayButton {
    private final Game game;

    public GameButton(final Game game, final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos) {
        super(hyplayGUI, id, xPos, yPos, game.getDisplayName());
        this.game = game;
    }

    public GameButton(final Game game, final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final
    int width, final int height) {
        super(hyplayGUI, id, xPos, yPos, width, height, game.getDisplayName());
        this.game = game;
    }

    @Override
    public void onPress() {
        this.hyplayGUI.setLastGamePressed(this.game);
        for (final PlayButton playButton : this.hyplayGUI.getPlayButtons()) {
            this.hyplayGUI.setPlayButtonVisibility(playButton);
        }
    }

    @Override
    public void drawButton(final Minecraft mc, final int mouseX, final int mouseY) {
        if (this.visible) {
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            final int k = this.getHoverState(this.hovered);
            GuiUtils.drawContinuousTexturedBox(buttonTextures, this.xPosition, this.yPosition, 0, 46 + k * 20, this.width, this.height, 200, 20, 2, 3, 2, 2, this.zLevel);
            this.mouseDragged(mc, mouseX, mouseY);
            int color = 14737632;

            if (this.packedFGColour != 0) {
                color = this.packedFGColour;
            } else if (!this.enabled) {
                color = 10526880;
            } else if (this.hovered) {
                color = 16777120;
            }

            String buttonText = this.displayString;
            int strWidth = mc.fontRendererObj.getStringWidth(buttonText);
            final int ellipsisWidth = mc.fontRendererObj.getStringWidth("...");
            final int spaceWidth = mc.fontRendererObj.getStringWidth(" ");
            final int prependedContentWidth = Game.GAME_TEXTURE_SIZE + spaceWidth;
            final int contentWidth = prependedContentWidth + strWidth;

            if (contentWidth > this.width - 6 && strWidth > ellipsisWidth) {
                buttonText = mc.fontRendererObj.trimStringToWidth(buttonText, this.width - 6 - ellipsisWidth - prependedContentWidth).trim() + "...";
                strWidth = mc.fontRendererObj.getStringWidth(buttonText);
            }

            this.game.drawTexture(this.hyplayGUI, this.xPosition + ((this.width - strWidth - prependedContentWidth) / 2), this.yPosition + ((this.height - Game.GAME_TEXTURE_SIZE) / 2));
            this.drawCenteredString(mc.fontRendererObj, buttonText, this.xPosition + ((this.width + prependedContentWidth) / 2), this.yPosition + ((this.height - 8) / 2), color);
        }
    }
}
