package io.github.synchronousx.hyplay.gui;

import io.github.synchronousx.hyplay.gui.components.MasonryContainer;
import io.github.synchronousx.hyplay.gui.components.MasonryContainer.Row;
import io.github.synchronousx.hyplay.gui.components.buttons.GameButton;
import io.github.synchronousx.hyplay.gui.components.buttons.HyplayButton;
import io.github.synchronousx.hyplay.gui.components.buttons.PageButton;
import io.github.synchronousx.hyplay.gui.components.buttons.PageButton.PageButtonType;
import io.github.synchronousx.hyplay.gui.components.buttons.PlayButton;
import io.github.synchronousx.hyplay.utils.Game;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class HyplayGUI extends GuiScreen {
    public static final int GAME_BUTTON_HEIGHT = 20;
    public static final int GAME_BUTTON_SEPARATION = 2;
    public static final int GAME_PLAY_BUTTON_SEPARATION = 4;
    public static final int PLAY_BUTTON_HEIGHT = 20;
    public static final int PLAY_BUTTON_HORIZONTAL_SEPARATION = 2;
    public static final int PLAY_BUTTON_VERTICAL_SEPARATION = 2;
    public static final int PLAY_BUTTON_CONTAINER_WIDTH = 204;
    public static final int PAGE_BUTTON_HEIGHT = 40;
    public static final int PAGE_BUTTON_WIDTH = 100;
    public static final int PAGE_BUTTON_SEPARATION = 4;
    public static final int PAGE_GAME_BUTTON_SEPARATION = 4;
    public static final int GAMES_PER_PAGE = 7;
    public static final int TOTAL_PAGES = (int) Math.ceil(Game.values().length / HyplayGUI.GAMES_PER_PAGE);

    private final List<GameButton> gameButtons = new ArrayList<GameButton>();
    private final List<PlayButton> playButtons = new ArrayList<PlayButton>();
    private final List<PageButton> pageButtons = new ArrayList<PageButton>();
    private int pageNumber = 1;
    private Game lastGamePressed = null;

    private void createGameButtons() {
        for (int i = 0; i < Game.values().length; ++i) {
            final GameButton gameButton = new GameButton(Game.values()[i], this, i, ((this.width - HyplayGUI.PAGE_BUTTON_SEPARATION) / 2) - HyplayGUI.PAGE_BUTTON_WIDTH, (this.height / 2) + ((HyplayGUI.PAGE_BUTTON_HEIGHT + HyplayGUI.PAGE_GAME_BUTTON_SEPARATION - ((HyplayGUI.GAME_BUTTON_HEIGHT + HyplayGUI.GAME_BUTTON_SEPARATION) * HyplayGUI.GAMES_PER_PAGE) + HyplayGUI.GAME_BUTTON_SEPARATION) / 2) + ((HyplayGUI.GAME_BUTTON_HEIGHT + HyplayGUI.GAME_BUTTON_SEPARATION) * (i % HyplayGUI.GAMES_PER_PAGE)), HyplayGUI.PAGE_BUTTON_WIDTH * 2 + HyplayGUI.PAGE_BUTTON_SEPARATION, HyplayGUI.GAME_BUTTON_HEIGHT);
            this.setGameButtonVisibility(gameButton);
            this.gameButtons.add(gameButton);
        }

        this.buttonList.addAll(this.gameButtons);
    }

    private void createPlayButtons() {
        final List<MasonryContainer<PlayButton>> masonryContainers = new ArrayList<>();
        int id = this.gameButtons.size();

        for (final Game game : Game.values()) {
            final MasonryContainer<PlayButton> masonryContainer = new MasonryContainer<>(((this.width + HyplayGUI.PAGE_BUTTON_SEPARATION) / 2) + HyplayGUI.PAGE_BUTTON_WIDTH + HyplayGUI.GAME_PLAY_BUTTON_SEPARATION, (this.height / 2) + ((HyplayGUI.PAGE_BUTTON_HEIGHT + HyplayGUI.PAGE_GAME_BUTTON_SEPARATION - ((HyplayGUI.GAME_BUTTON_HEIGHT + HyplayGUI.GAME_BUTTON_SEPARATION) * HyplayGUI.GAMES_PER_PAGE) + HyplayGUI.GAME_BUTTON_SEPARATION) / 2), HyplayGUI.PLAY_BUTTON_CONTAINER_WIDTH, HyplayGUI.PLAY_BUTTON_HORIZONTAL_SEPARATION, HyplayGUI.PLAY_BUTTON_VERTICAL_SEPARATION);
            masonryContainers.add(masonryContainer);

            for (int i = 0; i < game.getPlayNamesArray().length; ++i) {
                final String[] playNames = game.getPlayNamesArray()[i];
                masonryContainer.addButton(new PlayButton(game, playNames, this, id++, 0, 0, this.mc.fontRendererObj.getStringWidth(playNames[1]) + 6, HyplayGUI.PLAY_BUTTON_HEIGHT));
            }
        }

        for (final MasonryContainer<PlayButton> masonryContainer : masonryContainers) {
            for (final Row<PlayButton> row : masonryContainer.getRows()) {
                for (final PlayButton playButton : row.getButtons()) {
                    this.setPlayButtonVisibility(playButton);
                    this.playButtons.add(playButton);
                    this.buttonList.add(playButton);
                }
            }
        }
    }

    private void createPageButtons() {
        for (int i = 0; i < 2; ++i) {
            final PageButton pageButton = new PageButton(this, gameButtons.size() + playButtons.size() + i, ((this.width - HyplayGUI.PAGE_BUTTON_SEPARATION) / 2) - HyplayGUI.PAGE_BUTTON_WIDTH + ((HyplayGUI.PAGE_BUTTON_WIDTH + HyplayGUI.PAGE_BUTTON_SEPARATION) * i), (this.height / 2) - ((HyplayGUI.PAGE_BUTTON_HEIGHT + HyplayGUI.PAGE_GAME_BUTTON_SEPARATION + ((HyplayGUI.GAME_BUTTON_HEIGHT + HyplayGUI.GAME_BUTTON_SEPARATION) * HyplayGUI.GAMES_PER_PAGE) - HyplayGUI.GAME_BUTTON_SEPARATION) / 2), HyplayGUI.PAGE_BUTTON_WIDTH, HyplayGUI.PAGE_BUTTON_HEIGHT, PageButtonType.values()[i]);
            pageButton.refreshPressability();
            this.pageButtons.add(pageButton);
        }

        this.buttonList.addAll(this.pageButtons);
    }

    public void setGameButtonVisibility(final GameButton gameButton) {
        gameButton.visible = gameButton.id >= ((this.pageNumber - 1) * HyplayGUI.GAMES_PER_PAGE) && gameButton.id < (this.pageNumber * HyplayGUI.GAMES_PER_PAGE);
    }

    public void setPlayButtonVisibility(final PlayButton playButton) {
        playButton.visible = (playButton.getGame() == this.lastGamePressed);
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int setPageNumber(final int pageNumber) {
        return this.pageNumber = ((pageNumber - 1) % HyplayGUI.TOTAL_PAGES) + 1;
    }

    public Game getLastGamePressed() {
        return this.lastGamePressed;
    }

    public Game setLastGamePressed(final Game lastGamePressed) {
        return this.lastGamePressed = lastGamePressed;
    }

    public List<GameButton> getGameButtons() {
        return this.gameButtons;
    }

    public List<PlayButton> getPlayButtons() {
        return this.playButtons;
    }

    public List<PageButton> getPageButtons() {
        return this.pageButtons;
    }

    public List<GuiButton> getButtonList() {
        return this.buttonList;
    }

    @Override
    public void initGui() {
        this.gameButtons.clear();
        this.playButtons.clear();
        this.pageButtons.clear();
        createGameButtons();
        createPlayButtons();
        createPageButtons();
    }

    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(final GuiButton button) {
        if (button instanceof HyplayButton) {
            ((HyplayButton) button).onPress();
        }
    }
}
