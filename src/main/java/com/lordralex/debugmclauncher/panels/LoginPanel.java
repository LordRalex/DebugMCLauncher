package com.lordralex.debugmclauncher.panels;

import com.lordralex.debugmclauncher.LauncherMain;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.PublicKey;
import java.security.cert.Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LoginPanel extends JPanel {

    private String userName;
    private String latestVersion;
    private String downloadTicket;
    private String sessionId;

    public LoginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        usernameTextBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passwordTextBox = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        forceUpdateButton = new javax.swing.JRadioButton();

        setMaximumSize(new java.awt.Dimension(300, 150));
        setMinimumSize(new java.awt.Dimension(100, 50));
        setPreferredSize(new java.awt.Dimension(250, 100));

        jLabel1.setText("Username/Email");

        jLabel2.setText("Password");

        passwordTextBox.setToolTipText("Enter your password here");

        loginButton.setText("Log in");
        loginButton.setToolTipText("Press this to log in to your account");
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });

        forceUpdateButton.setText("Force Update");
        forceUpdateButton.setToolTipText("Check this to force update Minecraft");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTextBox)
                            .addComponent(passwordTextBox)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(forceUpdateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginButton, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(usernameTextBox)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passwordTextBox)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginButton)
                    .addComponent(forceUpdateButton))
                .addContainerGap(14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        loginButton.setText("Logging in");
        loginButton.update(loginButton.getGraphics());
        boolean loggedin = login();
        if (loggedin) {
            LauncherMain.getInstance().launchMinecraft(new String[]{userName, latestVersion, downloadTicket, sessionId});
        }

    }//GEN-LAST:event_loginButtonMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton forceUpdateButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordTextBox;
    private javax.swing.JTextField usernameTextBox;
    // End of variables declaration//GEN-END:variables

    public boolean forceUpdate() {
        return forceUpdateButton.isSelected();
    }

    public String getUserName() {
        return usernameTextBox.getText();
    }

    public String getPassword() {
        String result = "";
        char[] chars = passwordTextBox.getPassword();
        for (int i = 0; i < chars.length; i++) {
            result += chars[i];
        }
        return result;
    }

    public void setUsername(String name) {
        usernameTextBox.setText(name);
    }

    public void setPassword(String pass) {
        passwordTextBox.setText(pass);
    }

    public void setForceUpdate(String newStatus) {
        setForceUpdate(Boolean.parseBoolean(newStatus));
    }

    public void setForceUpdate(boolean newStatus) {
        forceUpdateButton.setSelected(newStatus);
    }

    public boolean login() {
        try {
            String url = "https://login.minecraft.net/";
            String details = "user=" + URLEncoder.encode(getUserName(), "UTF-8") + "&password=" + URLEncoder.encode(getPassword(), "UTF-8") + "&version=" + URLEncoder.encode("13", "UTF-8");
            HttpsURLConnection localHttpsURLConnection = null;
            try {
                URL localURL = new URL(url);
                localHttpsURLConnection = (HttpsURLConnection) localURL.openConnection();
                localHttpsURLConnection.setRequestMethod("POST");
                localHttpsURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                localHttpsURLConnection.setRequestProperty("Content-Length", "" + Integer.toString(details.getBytes().length));
                localHttpsURLConnection.setRequestProperty("Content-Language", "en-US");

                localHttpsURLConnection.setUseCaches(false);
                localHttpsURLConnection.setDoInput(true);
                localHttpsURLConnection.setDoOutput(true);

                localHttpsURLConnection.connect();
                Certificate[] arrayOfCertificate = localHttpsURLConnection.getServerCertificates();

                byte[] arrayOfByte1 = new byte[294];
                DataInputStream localDataInputStream = new DataInputStream(LoginPanel.class.getResourceAsStream("/minecraft.key"));
                localDataInputStream.readFully(arrayOfByte1);
                localDataInputStream.close();

                Certificate localCertificate = arrayOfCertificate[0];
                PublicKey localPublicKey = localCertificate.getPublicKey();
                byte[] arrayOfByte2 = localPublicKey.getEncoded();

                for (int i = 0; i < arrayOfByte2.length; i++) {
                    if (arrayOfByte2[i] != arrayOfByte1[i]) {
                        throw new InvalidKeyException("Public key mismatch");
                    }
                }

                DataOutputStream localDataOutputStream = new DataOutputStream(localHttpsURLConnection.getOutputStream());
                localDataOutputStream.writeBytes(details);
                localDataOutputStream.flush();
                localDataOutputStream.close();

                InputStream localInputStream = localHttpsURLConnection.getInputStream();
                BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream));

                StringBuilder localStringBuffer = new StringBuilder();
                String str1;
                while ((str1 = localBufferedReader.readLine()) != null) {
                    localStringBuffer.append(str1);
                    localStringBuffer.append('\r');
                }
                localBufferedReader.close();

                String result = localStringBuffer.toString().trim();
                if (result.equalsIgnoreCase("Bad login")) {
                    JOptionPane.showMessageDialog(null, "The login information is not correct", "An error has occured", JOptionPane.ERROR_MESSAGE);
                } else if (result.equalsIgnoreCase("Old version")) {
                    JOptionPane.showMessageDialog(null, "You have an old version of the launcher", "An error has occured", JOptionPane.ERROR_MESSAGE);
                } else if (result.equalsIgnoreCase("User not premium")) {
                    JOptionPane.showMessageDialog(null, "That account is not premium", "An error has occured", JOptionPane.ERROR_MESSAGE);
                } else if (result.contains(":")) {
                    String[] parts = result.split(":");
                    userName = parts[2].trim();
                    latestVersion = parts[0].trim();
                    downloadTicket = parts[1].trim();
                    sessionId = parts[3].trim();
                    return true;
                } else if (result.startsWith("Account migrated")) {
                    JOptionPane.showMessageDialog(null, "That account has been migrated. Use your e-mail for the username", "An error has occured", JOptionPane.ERROR_MESSAGE);
                } else {
                    throw new Exception("Something went wrong: reply was \"" + result + "\"");
                }

            } catch (Exception localException) {
                localException.printStackTrace(System.out);
                JOptionPane.showMessageDialog(null, localException, "An error has occured", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (localHttpsURLConnection != null) {
                    localHttpsURLConnection.disconnect();
                }
            }
        } catch (UnsupportedEncodingException ex) {
            JOptionPane.showMessageDialog(null, "UTF-8 is not a supported encoding. This is a major issue", "An error has occured", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "An error has occured", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
}
