package pe.edu.pucp.softProg.db.util;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Cifrado {
    
    private static final String llave = "Programacion3PUCP";

    // Método para cifrar con AES
    public static String cifrarAES(String texto) {
        String base64EncryptedString = "";
        try {

            // Se obtiene el hash MD5 para usar como clave de 128 bits
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(llave.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);  // AES requiere 16 bytes

            SecretKey key = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }

    // Método para descifrar con AES
    public static String descifrarAES(String textoEncriptado) {
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(llave.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 16);  // AES requiere 16 bytes
            SecretKey key = new SecretKeySpec(keyBytes, "AES");

            Cipher decipher = Cipher.getInstance("AES");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return base64EncryptedString;
    }
}
