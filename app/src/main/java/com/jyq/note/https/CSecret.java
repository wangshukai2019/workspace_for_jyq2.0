package com.jyq.note.https;

import android.util.Base64;

import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by free宇  2017/7/27. 11:44
 * author:free宇
 * email:freexiaoyu@foxmail.com
 * describe: AES加密算法
 */

public class CSecret {
    public static String KEY="";
    /**
     * @param
     * @return AES加密算法加密
     * @throws Exception
     */
    public static String encrypt(String seed, String key)
    {
        String strRet="";
        try {
            byte[] rawKey = getRawKey(key.getBytes("utf-8"));
            byte[] result = encrypt(seed.getBytes("utf-8"), rawKey);
            strRet= Base64.encodeToString(result, Base64.NO_WRAP);
        }catch (Exception e){}
        return strRet;
    }

    public static byte[] encryptByte(String seed, String key)
            throws Exception {
        byte[] rawKey = getRawKey(key.getBytes());
        return encrypt(seed.getBytes("utf-8"), rawKey);
    }


    public static String decrypt(String data, String key)
    {
        String strRet="";
        try {
            byte[] rawKey = getRawKey(key.getBytes());
            byte[] byteData = getRawKey(data.getBytes());
            strRet = decryptString(byteData,rawKey);
        }catch (Exception e){}
        return strRet;
    }
    public static String decryptString(byte[] byteData, byte[] byteKey) throws Exception {
        byte[] rawKey = getRawKey(byteKey);
        byte[] result = decrypt(byteData, rawKey);
        return new String(result, "UTF8");
    }


    /***
     * AES加密算法加密
     * @param byteData 数据
     * @param byteKey key
     * @return
     * @throws Exception
     */
    private static byte[] encrypt(byte[] byteData, byte[] byteKey) throws Exception {
        return Ase(byteData, byteKey, Cipher.ENCRYPT_MODE);
    }

    /***
     * AES加密算法解密
     * @param byteData 数据
     * @param byteKey key
     * @return
     * @throws Exception
     */
    private static byte[] decrypt(byte[] byteData, byte[] byteKey) throws Exception {
        return Ase(byteData, byteKey, Cipher.DECRYPT_MODE);
    }


    /***
     *
     * @param byteData
     * @param byteKey
     * @param opmode
     * @return
     * @throws Exception
     */
    private static byte[] Ase(byte[] byteData, byte[] byteKey, int opmode) throws Exception {
        final byte[] iv = new byte[17];
        Arrays.fill(iv, (byte) 0x00);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        SecretKeySpec skeySpec = new SecretKeySpec(byteKey, "AES");
        cipher.init(opmode, skeySpec,ivParameterSpec);
        byte[] decrypted = cipher.doFinal(byteData);
        return decrypted;
    }

    private static byte[] getRawKey(byte[] seed) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        SecureRandom sr = null;
        int sdk_version = android.os.Build.VERSION.SDK_INT;
        if (sdk_version > 23) {  // Android  6.0 以上
            sr = SecureRandom.getInstance("SHA1PRNG", new CryptoProvider());
        } else if (sdk_version >= 17) {
            sr = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        } else {
            sr = SecureRandom.getInstance("SHA1PRNG");
        }
        sr.setSeed(seed);
        kgen.init(128, sr); // 192 and 256 bits may not be available
        SecretKey skey = kgen.generateKey();
        byte[] raw = skey.getEncoded();
        return raw;
    }


    public static class CryptoProvider extends Provider {
        /**
         * Creates a Provider and puts parameters
         */
        public CryptoProvider() {
            super("Crypto", 1.0, "HARMONY (SHA1 digest; SecureRandom; SHA1withDSA signature)");
            put("SecureRandom.SHA1PRNG",
                    "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl");
            put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
        }
    }


    private static String toHex(byte[] buf) {
        final String HEX = "0123456789ABCDEF";
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            result.append(HEX.charAt((buf[i] >> 4) & 0x0f)).append(
                    HEX.charAt(buf[i] & 0x0f));
        }
        return result.toString();
    }

    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++)
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2),
                    16).byteValue();
        return result;
    }
    public static String md5(String string) {
        if (android.text.TextUtils.isEmpty(string)) {
            return "";
        }
        java.security.MessageDigest md5 = null;
        try {
            md5 = java.security.MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(string.getBytes());
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}