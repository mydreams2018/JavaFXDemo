package com.example.javafxdemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CipherOutputStreamTest {

    public static void main(String[] args) throws Exception {
        cipherImageEncode();
    }

    public static void cipherImageEncode() throws Exception {
        File fileD = new File("C:\\Users\\mydre\\Pictures\\testCipher");
        File[] listFiles = fileD.listFiles();
        for (File file : listFiles) {
            //读数据
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] readAllBytes = fileInputStream.readAllBytes();
            fileInputStream.close();
            //加密写出
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file.getParent(), "en" + file.getName()));
            fileOutputStream.write(CipherUtils.DEFAULTA.encryptNoIV(readAllBytes, "AES"));
            fileOutputStream.close();
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
