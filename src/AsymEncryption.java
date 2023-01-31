import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class AsymEncryption {


    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        //generate key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(512);
        KeyPair keyPair =keyPairGenerator.generateKeyPair();

        //print public & private key
       System.out.println("Public : "+misc.byteToHex(keyPair.getPublic().getEncoded()));
       System.out.println("Private: "+misc.byteToHex(keyPair.getPrivate().getEncoded()));



       //message to encrypt
       byte[] plainText = "This is a test message to encrypt !".getBytes();
       System.out.println("Plaintext: "+new String(plainText,StandardCharsets.UTF_8));

        //encrypt
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RSA");

        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
        byte[] encryptedText = cipher.doFinal(plainText);
        System.out.println("Encrypted: "+new String(encryptedText,StandardCharsets.UTF_8));

        //decrypt
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
        byte[] decryptedText = cipher.doFinal(encryptedText);
        System.out.println("Decrypted: "+new String(decryptedText,StandardCharsets.UTF_8));
    }
}
