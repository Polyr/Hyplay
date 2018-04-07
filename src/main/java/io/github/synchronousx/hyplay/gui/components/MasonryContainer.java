package io.github.synchronousx.hyplay.gui.components;

import net.minecraft.client.gui.GuiButton;

import java.util.ArrayList;
import java.util.List;

public class MasonryContainer<T extends GuiButton> {
    private final List<Row<T>> rows = new ArrayList<>();
    private final int x;
    private final int y;
    private final int width;
    private final int buttonSeparationX;
    private final int buttonSeparationY;

    public MasonryContainer(final int x, final int y, final int width, final int buttonSeparationX, final int buttonSeparationY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.buttonSeparationX = buttonSeparationX;
        this.buttonSeparationY = buttonSeparationY;
    }

    public T addButton(final T button) {
        Row<T> lastRow;
        if (rows.isEmpty() || (lastRow = rows.get(rows.size() - 1)).wouldBeFull(button)) {
            rows.add(lastRow = new Row<>(this));
        }

        return lastRow.addButton(button);
    }

    public List<Row<T>> getRows() {
        return this.rows;
    }

    public static class Row<T extends GuiButton> {
        private final List<T> buttons = new ArrayList<>();
        private final MasonryContainer masonryContainer;
        private final int y;
        private int height = 0;
        private int width = 0;

        public Row(final MasonryContainer masonryContainer) {
            this.masonryContainer = masonryContainer;
            if (this.masonryContainer.rows.isEmpty()) {
                this.y = this.masonryContainer.y;
            } else {
                final Row<T> lastRow = (Row<T>) this.masonryContainer.rows.get(this.masonryContainer.rows.size() - 1);
                this.y = lastRow.y + lastRow.height + this.masonryContainer.buttonSeparationY;
            }
        }

        public T addButton(final T button) {
            if (this.wouldBeFull(button)) {
                return null;
            }

            this.buttons.add(button);
            if (this.buttons.size() > 1) {
                this.width += this.masonryContainer.buttonSeparationX;
            }

            this.width += button.getButtonWidth();
            this.updateHeight();
            return button;
        }

        public boolean wouldBeFull(final T button) {
            return this.width + button.getButtonWidth() > this.masonryContainer.width;
        }

        private void updateHeight() {
            for (final T button : this.buttons) {
                if (button.height > this.height) {
                    this.height = button.height;
                }
            }
        }

        private void formatButtonGeometry() {
            if (this.buttons.isEmpty()) {
                return;
            }

            final int additionalWidth = (this.masonryContainer.width - this.width) / this.buttons.size();
            int nextX = this.masonryContainer.x;

            for (final T button : this.buttons) {
                button.xPosition = nextX;
                button.yPosition = this.y;
                button.setWidth(button.getButtonWidth() + additionalWidth);
                this.width += additionalWidth;
                nextX += button.getButtonWidth() + this.masonryContainer.buttonSeparationX;
            }
        }

        public List<T> getButtons() {
            this.formatButtonGeometry();
            return this.buttons;
        }
    }
}
