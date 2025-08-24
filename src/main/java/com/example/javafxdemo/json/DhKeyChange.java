package com.example.javafxdemo.json;

import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.util.Base64;
public class DhKeyChange {

        public static void main(String[] args) throws Exception {
            // 初始化 Alice 和 Bob 的密钥对生成器
            KeyPairGenerator aliceKpg = KeyPairGenerator.getInstance("DH");

            // 第一步：Alice 生成自己的密钥对（并发送公钥给 Bob）
            aliceKpg.initialize(2048); //使用2048位密钥长度
            KeyPair alicePair = aliceKpg.generateKeyPair();
            PublicKey alicePublicKey = alicePair.getPublic();
            PrivateKey alicePrivateKey = alicePair.getPrivate();
            // 第二步：Bob 使用 Alice 的公钥参数生成自己的密钥对
            DHPublicKey dhAlicePub = (DHPublicKey) alicePublicKey;
            DHParameterSpec aliceParams = dhAlicePub.getParams();

            KeyPairGenerator bobKpg = KeyPairGenerator.getInstance("DH");
            bobKpg.initialize(aliceParams); // 使用相同的 DH 参数
            KeyPair bobPair = bobKpg.generateKeyPair();
            PublicKey bobPublicKey = bobPair.getPublic();
            PrivateKey bobPrivateKey = bobPair.getPrivate();

            // 第三步：双方使用对方的公钥和自己的私钥计算共享密钥

            // Alice 计算共享密钥
            KeyAgreement aliceKa = KeyAgreement.getInstance("DH");
            aliceKa.init(alicePrivateKey);
            aliceKa.doPhase(bobPublicKey, true);
            byte[] aliceSharedSecret = aliceKa.generateSecret();

            // Bob 计算共享密钥
            KeyAgreement bobKa = KeyAgreement.getInstance("DH");
            bobKa.init(bobPrivateKey);
            bobKa.doPhase(alicePublicKey, true);
            byte[] bobSharedSecret = bobKa.generateSecret();

            // 验证共享密钥是否相同
            System.out.println("Alice's shared secret: " + Base64.getEncoder().encodeToString(aliceSharedSecret));
            System.out.println("Bob's shared secret:   " + Base64.getEncoder().encodeToString(bobSharedSecret));
            if (java.util.Arrays.equals(aliceSharedSecret, bobSharedSecret)) {
                System.out.println("✅ 共享密钥一致！密钥交换成功。");
            } else {
                System.out.println("❌ 共享密钥不一致！");
            }
            System.out.println("共享密钥长度（字节）: " + aliceSharedSecret.length);
        }
}
