package com.lordralex.debugmclauncher.progressbar;

import javax.swing.JProgressBar;

public class UpdatingProgressBar extends JProgressBar {

    @Override
    public void setString(String string) {
        super.setString(string);
        update();
    }

    public void setProgressString(String progressString) {
        this.progressString = progressString;
        update();
    }

    @Override
    public void setValue(int i) {
        super.setValue(i);
        update();
    }

    public void update() {
        this.update(this.getGraphics());
    }
}
