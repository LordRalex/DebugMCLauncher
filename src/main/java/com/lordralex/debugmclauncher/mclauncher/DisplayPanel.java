package com.lordralex.debugmclauncher.mclauncher;

import com.lordralex.debugmclauncher.progressbar.UpdatingProgressBar;
import com.lordralex.debugmclauncher.textfields.UpdatingTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DisplayPanel extends JPanel {

    public DisplayPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressTextField = new UpdatingTextField();
        totalProgressBar = new UpdatingProgressBar();
        itemProgressBar = new UpdatingProgressBar();

        progressTextField.setEditable(false);
        progressTextField.setHorizontalAlignment(JTextField.LEFT);
        progressTextField.setToolTipText("");

        totalProgressBar.setStringPainted(true);

        itemProgressBar.setStringPainted(true);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(progressTextField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalProgressBar, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(itemProgressBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(progressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(itemProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(totalProgressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private UpdatingProgressBar itemProgressBar;
    private UpdatingTextField progressTextField;
    private UpdatingProgressBar totalProgressBar;
    // End of variables declaration//GEN-END:variables
}
