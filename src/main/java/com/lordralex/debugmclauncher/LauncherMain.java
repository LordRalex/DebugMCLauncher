package com.lordralex.debugmclauncher;

import com.lordralex.debugmclauncher.mclauncher.DisplayFrame;
import com.lordralex.debugmclauncher.panels.IconPanel;
import com.lordralex.debugmclauncher.panels.InformationPanel;
import com.lordralex.debugmclauncher.panels.LoginPanel;
import com.lordralex.debugmclauncher.panels.SystemInformationPanel;
import com.lordralex.debugmclauncher.utils.OS;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class LauncherMain extends JFrame {

    private static LauncherMain instance;

    public LauncherMain() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel1 = new LoginPanel();
        systemInformationPanel1 = new SystemInformationPanel();
        iconPanel1 = new IconPanel();
        webPagesTabPanel = new JTabbedPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));

        loginPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        systemInformationPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        iconPanel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        iconPanel1.setPreferredSize(new Dimension(423, 100));

        GroupLayout iconPanel1Layout = new GroupLayout(iconPanel1);
        iconPanel1.setLayout(iconPanel1Layout);
        iconPanel1Layout.setHorizontalGroup(
            iconPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );
        iconPanel1Layout.setVerticalGroup(
            iconPanel1Layout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        webPagesTabPanel.setToolTipText("");
        webPagesTabPanel.setRequestFocusEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(iconPanel1, GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(loginPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(webPagesTabPanel)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(systemInformationPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(systemInformationPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(webPagesTabPanel))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(iconPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(final String args[]) {
        System.out.println("Starting launcher");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.out.println("Creating new instance");
                instance = new LauncherMain();
                System.out.println("Setting visible");
                instance.setVisible(true);
                if (args.length >= 1) {
                    instance.loginPanel1.setUsername(args[0]);
                    if (args.length >= 2) {
                        instance.loginPanel1.setPassword(args[1]);
                        if (args.length >= 3) {
                            instance.loginPanel1.setForceUpdate(args[2]);
                        }
                    }
                }
                System.out.println("Creating site pages");
                try {
                    URL pageList = new URL("https://raw.github.com/LordRalex/DebugMCLauncher/master/pages.txt");
                    BufferedReader reader = new BufferedReader(new InputStreamReader(pageList.openStream()));
                    String line;
                    List<String> list = new ArrayList<String>();
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                        System.out.println(line.substring(0, line.indexOf("|")).trim());
                        System.out.println(line.substring(line.indexOf("|") + 1).trim());
                        list.add(line);
                    }
                    reader.close();
                    for (String page : list) {
                        if (page == null || !page.contains("|")) {
                            continue;
                        }
                        String tabName = page.substring(0, page.indexOf("|")).trim();
                        String link = page.substring(page.indexOf("|") + 1).trim();
                        InformationPanel panel = new InformationPanel();
                        instance.webPagesTabPanel.addTab(tabName, panel);
                        panel.getNewsFeed(link);
                    }
                } catch (IOException e) {
                    e.printStackTrace(System.out);
                    instance.webPagesTabPanel.removeAll();
                    System.out.println("Loading MC tumblr");
                    InformationPanel mcupdate = new InformationPanel();
                    instance.webPagesTabPanel.addTab("Minecraft Tumblr", mcupdate);
                    mcupdate.getNewsFeed("http://mcupdate.tumblr.com/");
                    System.out.println("Loading SG page");
                    InformationPanel supportguru = new InformationPanel();
                    instance.webPagesTabPanel.addTab("Support Guru", supportguru);
                    supportguru.getNewsFeed("http://supportgurus.org/");
                }
                System.out.println("Loading system information");
                instance.systemInformationPanel1.getSystemInfo();
                System.out.println("Refreshing main screen");
                instance.update(instance.getGraphics());
            }
        });
        System.out.println("Event invoked");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private IconPanel iconPanel1;
    private LoginPanel loginPanel1;
    private SystemInformationPanel systemInformationPanel1;
    private JTabbedPane webPagesTabPanel;
    // End of variables declaration//GEN-END:variables

    public static LauncherMain getInstance() {
        return instance;
    }

    public IconPanel getIconPanel() {
        return iconPanel1;
    }

    public LoginPanel getLoginPanel() {
        return loginPanel1;
    }

    public synchronized void updateTabbedPanel() {
        webPagesTabPanel.update(webPagesTabPanel.getGraphics());
    }

    public void launchMinecraft(String[] args) {
        this.setVisible(false);

        if (loginPanel1.forceUpdate()) {
            DisplayFrame displayFrame = new DisplayFrame();
            displayFrame.setVisible(true);
            displayFrame.downloadFiles();
            displayFrame.setVisible(false);
        }

        ArrayList<String> command = new ArrayList<String>();
        command.add("java");
        command.add("-Xmx512M");
        command.add("-Xms128M");
        command.add("-cp");
        command.add("\"%BIN%\\minecraft.jar" + File.pathSeparatorChar
                + "%BIN%\\lwjgl.jar" + File.pathSeparatorChar
                + "%BIN%\\lwjgl_util.jar" + File.pathSeparatorChar
                + "%BIN%\\jinput.jar\"");
        command.add("-Djava.library.path=\"%BIN%\\natives\"");
        command.add("net.minecraft.client.Minecraft");
        command.add(args[0]);
        command.add(args[3]);

        File bin = new File(OS.getFolderFile(), "bin");

        for (int i = 0; i < command.size(); i++) {
            command.set(i, command.get(i).replace("%BIN%", bin.getPath()));
        }

        ProcessBuilder builder = new ProcessBuilder().command(command).inheritIO();
        try {
            Process process = builder.start();
            InputStream error = process.getErrorStream();
            InputStream input = process.getInputStream();
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(error));
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(input));
            EchoThread errorThread = new EchoThread(errorReader);
            EchoThread inputThread = new EchoThread(inputReader);
            errorThread.start();
            inputThread.start();
            process.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(LauncherMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LauncherMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }

    private class EchoThread extends Thread {

        BufferedReader input;

        public EchoThread(BufferedReader reader) {
            input = reader;
        }

        @Override
        public void run() {
            try {
                String line;
                while ((line = input.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }
}
