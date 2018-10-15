/*
 * Decompiled with CFR 0_133.
 * 
 * Could not load the following classes:
 *  org.apache.commons.codec.binary.Base64
 *  org.bukkit.ChatColor
 */
package main.java.me.heraldry.Utils;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.ChatColor;

public class stringUtils {
    private static final int iterations = 100;
    private static final int saltLen = 32;
    private static final int desiredKeyLen = 256;

    public static String colour(String string) {
        return ChatColor.translateAlternateColorCodes((char)'&', (String)string);
    }

    public static String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(32);
        return Base64.encodeBase64String((byte[])salt) + "$" + stringUtils.hash(password, salt);
    }

    public static boolean check(String password, String stored) throws Exception {
        String[] saltAndPass = stored.split("\\$");
        if (saltAndPass.length != 2) {
            throw new IllegalStateException("The stored password have the form 'salt$hash'");
        }
        String hashOfInput = stringUtils.hash(password, Base64.decodeBase64((String)saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }

    private static String hash(String password, byte[] salt) throws Exception {
        if (password == null || password.length() == 0) {
            throw new IllegalArgumentException("Empty passwords are not supported.");
        }
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(password.toCharArray(), salt, 100, 256));
        return Base64.encodeBase64String((byte[])key.getEncoded());
    }
}
