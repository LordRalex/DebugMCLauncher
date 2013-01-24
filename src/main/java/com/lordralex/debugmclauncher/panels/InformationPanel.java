package com.lordralex.debugmclauncher.panels;

import com.lordralex.debugmclauncher.LauncherMain;
import java.net.URL;
import javax.swing.JPanel;

public final class InformationPanel extends JPanel {

    public InformationPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();

        jScrollPane2.setPreferredSize(new java.awt.Dimension(469, 304));
        jScrollPane2.setRequestFocusEnabled(false);

        jTextPane2.setEditable(false);
        jTextPane2.setBackground(new java.awt.Color(240, 240, 240));
        jTextPane2.setPreferredSize(new java.awt.Dimension(469, 304));
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane2;
    // End of variables declaration//GEN-END:variables

    public void getNewsFeed(String pageLink) {
        jTextPane2.setContentType("text/html");
        jTextPane2.setText("Loading news feed");
        jTextPane2.update(jTextPane2.getGraphics());
        FeedThread feed = new FeedThread(pageLink);
        feed.start();
    }

    private class FeedThread extends Thread {

        final String page;

        public FeedThread(String pageLink) {
            page = pageLink;
        }

        @Override
        public void run() {
            try {
                jTextPane2.setPage(new URL(page));
            } catch (Exception e) {
                e.printStackTrace(System.out);
                jTextPane2.setText("Unable to get the news feed");
            }
            jTextPane2.update(jTextPane2.getGraphics());
            InformationPanel.this.update(InformationPanel.this.getGraphics());
            LauncherMain.getInstance().updateTabbedPanel();
        }
    }
}
