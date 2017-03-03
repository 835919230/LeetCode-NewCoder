package com.magic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by hexi on 17-2-25.
 */
public class MagicNumber {
    public static void main(String[] args) throws IOException {
        MagicNumber mg = new MagicNumber();
        mg.judge(new File("/home/hexi/1.jpg"));
        mg.judge(new File("/home/hexi/图片/5.png"));
    }

    public synchronized void judge(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toHexString(fis.read()));
        sb.append(Integer.toHexString(fis.read()));
        sb.append(Integer.toHexString(fis.read()));
        if ("FFD8FF".equalsIgnoreCase(sb.toString())) {
            System.out.println("JPG");
            return;
        }
        String s = sb.append(Integer.toHexString(fis.read())).toString();
        if ("89504E47".equalsIgnoreCase(s)) {
            System.out.println("PNG");
        } else if ("47494638".equalsIgnoreCase(s)) {
            System.out.println("GIF");
        }
    }
}
