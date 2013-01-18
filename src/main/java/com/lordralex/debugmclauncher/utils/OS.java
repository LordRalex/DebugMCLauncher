package com.lordralex.debugmclauncher.utils;

import java.io.File;

public enum OS {

    LINUX,
    WINDOWS,
    MAC,
    OTHER;
    private static OS os = null;

    private OS() {
    }

    public static String getFolder() {
        os = OS.getOS();
        String path = "";
        switch (os) {
            case LINUX:
                path = System.getProperty("user.home", ".") + File.separator + ".minecraft" + File.separator;
                break;
            case WINDOWS:
                String appdata = System.getenv("APPDATA");
                if (appdata == null) {
                    appdata = System.getenv("APPDATA");
                }
                path = appdata + File.separator + ".minecraft" + File.separator;
                break;
            case MAC:
                path = System.getProperty("user.home", ".") + File.separator + "Library/Application Support/minecraft" + File.separator;
                break;
            case OTHER:
                break;
            default:
                path = System.getProperty("user.home", ".") + File.separator + "minecraft" + File.separator;
                break;
        }
        return path;
    }

    public static File getFolderFile() {
        return new File(getFolder());
    }

    public static OS getOS() {
        if (os == null) {
            String name = System.getProperty("os.name").toLowerCase();
            System.out.println("OS: " + name);
            if (name.startsWith("win")) {
                os = OS.WINDOWS;
            } else if (name.startsWith("mac")) {
                os = OS.MAC;
            } else if (name.startsWith("linux")) {
                os = OS.LINUX;
            }
        }
        return os;
    }
}
