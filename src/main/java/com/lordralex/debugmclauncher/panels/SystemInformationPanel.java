package com.lordralex.debugmclauncher.panels;

import com.lordralex.debugmclauncher.textfields.UpdatingTextField;
import com.lordralex.debugmclauncher.utils.OS;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SystemInformationPanel extends JPanel {

    public SystemInformationPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        osTextField = new UpdatingTextField();
        jLabel2 = new JLabel();
        archTextField = new UpdatingTextField();
        jLabel3 = new JLabel();
        javaTextField = new UpdatingTextField();
        freeRamTextField = new UpdatingTextField();
        totalRamTextField = new UpdatingTextField();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel4 = new JLabel();
        lwjglTextField = new UpdatingTextField();
        dxdiagButton = new JButton();
        jLabel7 = new JLabel();
        jTextField4 = new UpdatingTextField();
        jLabel9 = new JLabel();
        mcVersionTextField = new UpdatingTextField();
        jLabel8 = new JLabel();
        moddedTextField = new UpdatingTextField();

        jLabel1.setText("OS");

        osTextField.setEditable(false);

        jLabel2.setText("Arch");

        archTextField.setEditable(false);

        jLabel3.setText("Java");

        javaTextField.setEditable(false);

        freeRamTextField.setEditable(false);

        totalRamTextField.setEditable(false);

        jLabel5.setText("Free RAM");

        jLabel6.setText("Total RAM");

        jLabel4.setText("Lwjgl");

        lwjglTextField.setEditable(false);

        dxdiagButton.setText("Get Dxdiag");

        jLabel7.setText("Dxdiag");

        jTextField4.setEditable(false);
        jTextField4.setHorizontalAlignment(JTextField.CENTER);
        jTextField4.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

        jLabel9.setText("MC Version");

        mcVersionTextField.setEditable(false);

        jLabel8.setText("Modded");

        moddedTextField.setEditable(false);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(javaTextField, GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(archTextField)
                    .addComponent(osTextField)
                    .addComponent(freeRamTextField)
                    .addComponent(totalRamTextField)
                    .addComponent(lwjglTextField)
                    .addComponent(dxdiagButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField4)
                    .addComponent(mcVersionTextField)
                    .addComponent(moddedTextField))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(osTextField)
                    .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(archTextField)
                    .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(javaTextField)
                    .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                    .addComponent(freeRamTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(totalRamTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(lwjglTextField)
                    .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(dxdiagButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(jLabel9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mcVersionTextField))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(Alignment.LEADING, false)
                    .addComponent(jLabel8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(moddedTextField))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextField archTextField;
    private JButton dxdiagButton;
    private JTextField freeRamTextField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JTextField jTextField4;
    private JTextField javaTextField;
    private JTextField lwjglTextField;
    private JTextField mcVersionTextField;
    private JTextField moddedTextField;
    private JTextField osTextField;
    private JTextField totalRamTextField;
    // End of variables declaration//GEN-END:variables

    public void getSystemInfo() {
        SystemInfoThread systemInfo = new SystemInfoThread();
        systemInfo.start();
    }

    private class SystemInfoThread extends Thread {

        public SystemInfoThread() {
            super("System_Info_Thread");
        }

        @Override
        public void run() {
            osTextField.setText(System.getProperty("os.name"));
            archTextField.setText(System.getProperty("os.arch"));
            javaTextField.setText(System.getProperty("java.version") + " "
                    + (System.getProperty("java.vm.name").endsWith("64-Bit Server VM") ? "64-bit" : "32-bit"));

            //OS dependent RAM calls are here
            //linux: free -m
            //windows: systeminfo
            //mac: total: sysctl hw.memsize | awk '{print $NF}' | tr '\n' 'Z' | sed 's/Z/ \/ 1024 \/ 1024/' | bc
            //mac: free: top -l 1 | grep PhysMem: | awk '{print $10}' | sed 's/M//g'
            String free = "Unknown";
            String total = "Unknown";
            freeRamTextField.setText("Determining");
            totalRamTextField.setText("Determining");
            new Thread() {
                @Override
                public void run() {
                    String free = "Unknown";
                    String total = "Unknown";
                    switch (OS.getOS()) {
                        case WINDOWS:
                            try {
                                try {
                                    Process pr = Runtime.getRuntime().exec("systeminfo");
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        if (line.startsWith("Available Physical Memory")) {
                                            free = line.split(":")[1].trim();
                                        } else if (line.startsWith("Total Physical Memory")) {
                                            total = line.split(":")[1].trim();
                                        }
                                    }
                                    reader.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case LINUX:
                            try {
                                try {
                                    Process pr = Runtime.getRuntime().exec("free -m");
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        if (line.startsWith("-/+ buffers/cache:")) {
                                            String temp = line.split(":")[1].trim();
                                            String[] split = temp.split(" ");
                                            free = split[0] + " MB";
                                            total = split[split.length - 1] + " MB";
                                        }
                                    }
                                    reader.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        case MAC:
                            try {
                                try {
                                    Process pr = Runtime.getRuntime().exec("top -n 1 -b");
                                    BufferedReader reader = new BufferedReader(new InputStreamReader(pr.getInputStream()));
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        total = line + " MB";
                                    }
                                    reader.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } catch (Exception ex) {
                                Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                        default:

                    }
                    freeRamTextField.setText(free);
                    totalRamTextField.setText(total);
                }
            }.start();

            //Since MC does not use an accessible variable, we have to "hackily" get the information
            new Thread() {
                @Override
                public void run() {
                    String mcversion = "Loading";
                    /*try {
                     URL[] urls = new URL[]{
                     new File(OS.getFolderFile(), "bin" + File.separator + "minecraft.jar").toURI().toURL()
                     };
                     ClassLoader loader = URLClassLoader.newInstance(urls, this.getClass().getClassLoader());
                     Class cl = Class.forName("le", true, loader);
                     System.out.println("---");
                     Constructor cn = null;
                     for (Constructor con : cl.getDeclaredConstructors()) {
                     for (Class cla : con.getParameterTypes()) {
                     System.out.print(cla.getName() + " ");
                     }
                     cn = con;
                     System.out.println("---");
                     }
                     Object in = cn.newInstance("debug_mc_launcher", null);
                     Method md = cl.getDeclaredMethod("g");
                     md.setAccessible(true);
                     try {
                     md.invoke(in);
                     } catch (InvocationTargetException e) {
                     //we expected this to be thrown since the method will return an NPE like this
                     }
                     Field fl = cl.getDeclaredField("a");
                     fl.setAccessible(true);
                     Map map = (Map) fl.get(in);
                     mcversion = (String) map.get("version");
                     } catch (Exception e) {
                     e.printStackTrace(System.out);
                     mcversion = "Unknown";
                     }*/
                    mcversion = "Unknown";

                    mcVersionTextField.setText(mcversion);
                }
            }.start();

            //load lwjgl jars here and check version
            new Thread() {
                @Override
                public void run() {
                    String version = "Unknown";
                    try {
                        String s = OS.getFolder() + "bin" + File.separator + "natives";
                        // This is a hack method to load the lwjgl
                        dynamicLoad(s);
                        URL[] urls = new URL[]{
                            new File(OS.getFolderFile(), "bin" + File.separator + "lwjgl.jar").toURI().toURL()
                        };
                        ClassLoader loader = URLClassLoader.newInstance(urls, this.getClass().getClassLoader());
                        Class<?> cl = Class.forName("org.lwjgl.Sys", true, loader);
                        version = (String) cl.asSubclass(org.lwjgl.Sys.class).getMethod("getVersion").invoke(null);
                    } catch (Throwable ex) {
                        Logger.getLogger(SystemInformationPanel.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    lwjglTextField.setText(version);
                }
            }.start();

            //read minecraft.jar and look for meta-inf
            new Thread() {
                @Override
                public void run() {
                    JarFile file;
                    try {
                        file = new JarFile(new File(new File(OS.getFolderFile(), "bin"), "minecraft.jar"));
                        Manifest mf = file.getManifest();
                        if (mf != null) {
                            moddedTextField.setText("Unlikely");
                        } else {
                            moddedTextField.setText("Likely");
                        }
                    } catch (IOException e) {
                        e.printStackTrace(System.out);
                        moddedTextField.setText("No jar found");
                    }
                }
            }.start();
        }
    }

    // This enables the java.library.path to be modified at runtime
    // From a Sun engineer at http://forums.sun.com/thread.jspa?threadID=707176
    private synchronized void dynamicLoad(String s) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            for (int i = 0; i < paths.length; i++) {
                if (s.equals(paths[i])) {
                    return;
                }
            }
            String[] tmp = new String[paths.length + 1];

            System.arraycopy(paths, 0, tmp, 0, paths.length);
            tmp[paths.length] = s;

            field.set(null, tmp);
            System.setProperty("java.library.path", System.getProperty("java.library.path") + File.pathSeparator + s);
        } catch (IllegalAccessException e) {
            throw new IOException("Failed to get permissions to set library path");
        } catch (NoSuchFieldException e) {
            throw new IOException("Failed to get field handle to set library path");
        }
    }
}