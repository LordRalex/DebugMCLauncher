package com.lordralex.debugmclauncher.mclauncher;

import com.lordralex.debugmclauncher.progressbar.UpdatingProgressBar;
import com.lordralex.debugmclauncher.textfields.UpdatingTextField;
import com.lordralex.debugmclauncher.utils.OS;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
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

    public void update() {
        this.update(this.getGraphics());
    }

    public void downloadFiles() {
        recursiveDelete(new File(OS.getFolderFile(), "bin"));
        File downloadDir = new File(OS.getFolderFile(), "bin");
        downloadDir.mkdirs();
        File nativesDir = new File(downloadDir, "natives");
        nativesDir.mkdirs();
        List<DownloadFile> files = new ArrayList<DownloadFile>();
        files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/minecraft.jar", "minecraft.jar", downloadDir));
        files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/lwjgl_util.jar", "lwjgl_util.jar", downloadDir));
        files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/lwjgl.jar", "lwjgl.jar", downloadDir));
        files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/jinput.jar", "jinput.jar", downloadDir));
        switch (OS.getOS()) {
            case WINDOWS:
                files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/windows_natives.jar", "windows_natives.jar", nativesDir, true));
                break;
            case LINUX:
                files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/linux_natives.jar", "linux_natives.jar", nativesDir, true));
                break;
            case MAC:
                files.add(new DownloadFile("http://s3.amazonaws.com/MinecraftDownload/macos_natives.jar", "macos_natives.jar", nativesDir, true));
                break;
            default:
                break;
        }

        for (DownloadFile df : files) {
            try {
                progressTextField.setText("Downloading " + df.fileName);
                download(df);
                if (df.extract) {
                    extract(df.fileName, df.path);
                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private void download(DownloadFile file) throws IOException {
        String urlPath = file.url;
        String savePath = new File(file.path, file.fileName).getCanonicalPath();
        download(urlPath, savePath);
    }

    private void extract(DownloadFile file) throws IOException {
        extract(file.fileName, file.path);
    }

    private void recursiveDelete(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || files.length == 0) {
                return;
            }
            for (File f : files) {
                recursiveDelete(f);
            }
        }
        file.delete();
    }

    private void download(String path, String fileName) throws IOException {
        System.out.println("Downloading " + path + " to " + fileName);
        URL test = new URL(path);
        HttpURLConnection httpcon = (HttpURLConnection) test.openConnection();
        httpcon.addRequestProperty("User-Agent", "Mozilla/5.0");
        ReadableByteChannel rbc = Channels.newChannel(httpcon.getInputStream());
        FileOutputStream fos = new FileOutputStream(fileName);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        fos.close();
        rbc.close();
        httpcon.disconnect();
    }

    private void extract(String fileName, File pathToFolder) throws IOException {
        System.out.println("Extracting " + fileName + " to " + pathToFolder);
        Enumeration entries;
        ZipFile zipFile;
        zipFile = new ZipFile(new File(pathToFolder, fileName));
        entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = (ZipEntry) entries.nextElement();
            if (entry.getName().startsWith("META-INF")
                    || entry.getName().startsWith("MOJANG")
                    || entry.getName().startsWith("MANIFEST")) {
                continue;
            }
            copyInputStream(zipFile.getInputStream(entry),
                    new BufferedOutputStream(new FileOutputStream(new File(pathToFolder, entry.getName()))));
        }
        zipFile.close();
        new File(pathToFolder, fileName).delete();
    }

    private void copyInputStream(InputStream in, OutputStream out) {
        try {
            byte[] buffer = new byte[16384];
            int len;
            while ((len = in.read(buffer)) >= 0) {
                out.write(buffer, 0, len);
            }
            in.close();
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private class DownloadFile {

        final public String url;
        final public String fileName;
        final public File path;
        final public boolean extract;

        public DownloadFile(String u, String f, File p) {
            this(u, f, p, false);
        }

        public DownloadFile(String u, String f, File p, boolean e) {
            url = u;
            fileName = f;
            path = p;
            extract = e;
        }
    }
}
