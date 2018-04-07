package io.github.synchronousx.hyplay.gui.components.buttons;

import io.github.synchronousx.hyplay.gui.HyplayGUI;
import io.github.synchronousx.hyplay.utils.Game;
import net.minecraft.client.Minecraft;

public class PlayButton extends HyplayButton {
    private final Game game;
    private final String[] playNames;

    public PlayButton(final Game game, final String[] playNames, final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos) {
        super(hyplayGUI, id, xPos, yPos, playNames[1]);
        this.game = game;
        this.playNames = playNames;
    }

    public PlayButton(final Game game, final String[] playNames, final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final int width, final int height) {
        super(hyplayGUI, id, xPos, yPos, width, height, playNames[1]);
        this.game = game;
        this.playNames = playNames;
    }

    public Game getGame() {
        return this.game;
    }

    @Override
    public void onPress() {
        Minecraft.getMinecraft().thePlayer.sendChatMessage(Game.PLAY_COMMAND_PREFIX + playNames[0]);
    }
}
