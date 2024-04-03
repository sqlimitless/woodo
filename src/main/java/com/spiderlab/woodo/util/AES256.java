package com.spiderlab.woodo.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


@Component
public class AES256 {
    private final static String alg = "AES/CBC/PKCS5Padding";
    private final String key = "woodo88woodo2024";
    private final String iv = key.substring(0, 16);

    public String encrypt(String text) {
        byte[] encrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(iv.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String cipherText) {
        byte[] decrypted = null;
        try {
            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(iv.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(cipherText);
            decrypted = cipher.doFinal(decodedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(decrypted, StandardCharsets.UTF_8);
    }
}
