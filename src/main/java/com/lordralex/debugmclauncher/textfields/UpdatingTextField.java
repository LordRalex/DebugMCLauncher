package com.lordralex.debugmclauncher.textfields;

import javax.swing.JTextField;

public class UpdatingTextField extends JTextField {

    @Override
    public synchronized void setText(String newText) {
        super.setText(newText);
        update();
    }

    public synchronized void update() {
        super.update(this.getGraphics());
    }
}
