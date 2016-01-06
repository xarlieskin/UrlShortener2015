package urlshortener2015.heatwave.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtils {

    public static String hashSHA512(String text) {
        MessageDigest md;
        String response = null;
        try {
            md = MessageDigest.getInstance("SHA-512");
            md.update(text.getBytes("UTF-8"));
            byte[] digest = md.digest();
            // Formats result string to hexadecimal with left zero padding (for better management).
            response = String.format("%064x", new java.math.BigInteger(1, digest));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Fatal error: could not encrypt text with SHA-512 algorithm.");
        } catch (UnsupportedEncodingException e) {
            System.out.println("Fatal error: UnsupportedEncodingException making hash from text.");
        }
        return response;
    }
}
