package io.github.synchronousx.hyplay.gui.components.buttons;

import io.github.synchronousx.hyplay.gui.HyplayGUI;

public class PageButton extends HyplayButton {
    private final PageButtonType pageButtonType;

    public PageButton(final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final PageButtonType pageButtonType) {
        super(hyplayGUI, id, xPos, yPos, pageButtonType.getDisplayName());
        this.pageButtonType = pageButtonType;
    }

    public PageButton(final HyplayGUI hyplayGUI, final int id, final int xPos, final int yPos, final int width, final int height, final PageButtonType pageButtonType) {
        super(hyplayGUI, id, xPos, yPos, width, height, pageButtonType.getDisplayName());
        this.pageButtonType = pageButtonType;
    }

    public void refreshPressability() {
        this.enabled = !this.getPageButtonType().isPageLimitReached(this.hyplayGUI.getPageNumber(), HyplayGUI.TOTAL_PAGES);
    }

    public PageButtonType getPageButtonType() {
        return this.pageButtonType;
    }

    @Override
    public void onPress() {
        this.hyplayGUI.setPageNumber(hyplayGUI.getPageNumber() + this.pageButtonType.getPageNumberChange());
        for (final GameButton gameButton : this.hyplayGUI.getGameButtons()) {
            this.hyplayGUI.setGameButtonVisibility(gameButton);
        }

        for (final PageButton pageButton : this.hyplayGUI.getPageButtons()) {
            pageButton.refreshPressability();
        }
    }

    public enum PageButtonType {
        BACK("< Back", -1),
        NEXT("Next >", 1);

        private final String displayName;
        private final int pageNumberChange;

        PageButtonType(final String displayName, final int pageNumberChange) {
            this.displayName = displayName;
            this.pageNumberChange = pageNumberChange;
        }

        public boolean isPageLimitReached(final int pageNumber, final int totalPages) {
            final int nextPage = pageNumber + this.pageNumberChange;
            return nextPage < 1 || nextPage > totalPages;
        }

        public String getDisplayName() {
            return this.displayName;
        }

        public int getPageNumberChange() {
            return this.pageNumberChange;
        }
    }
}
