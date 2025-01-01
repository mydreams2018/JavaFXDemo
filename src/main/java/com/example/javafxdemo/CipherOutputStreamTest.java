package com.example.javafxdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CipherOutputStreamTest {

    public static void main(String[] args) throws Exception {
        cipherImageEncode(new File("C:\\Users\\mydre\\Pictures\\testCipher"));
    }

    public static void cipherImageEncode(File fileDirectory) throws Exception {
        if (!fileDirectory.isDirectory()) {
            return;//必须是目录
        }
        File[] listFiles = fileDirectory.listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    cipherImageEncode(file);//目录迭代
                } else {
                    //读数据
                    FileInputStream fileInputStream = new FileInputStream(file);
                    byte[] readAllBytes = fileInputStream.readAllBytes();
                    fileInputStream.close();
                    //加密写出
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(CipherUtils.DEFAULTA.encryptNoIV(readAllBytes, "AES"));
                    fileOutputStream.close();
                }
            }
        }
    }

    public static void cipherEncodeText() throws Exception {
        File file = new File("C:\\Users\\mydre\\Pictures\\testCipher\\ts.txt");
        //读数据
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] readAllBytes = fileInputStream.readAllBytes();
        fileInputStream.close();
        //加密写出
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getParent(), "en" + file.getName()));
        fileOutputStream.write(CipherUtils.DEFAULTA.encryptNoIV(readAllBytes, "AES"));
        fileOutputStream.close();
    }

    public static void cipherDecodeText() throws Exception {
        File file = new File("C:\\Users\\mydre\\Pictures\\testCipher\\ents.txt");
        //读数据
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] readAllBytes = fileInputStream.readAllBytes();
        fileInputStream.close();
        //解密写出
        FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getParent(), "de" + file.getName()));
        fileOutputStream.write(CipherUtils.DEFAULTA.decryptNoIV(readAllBytes, "AES"));
        fileOutputStream.close();
    }
}
