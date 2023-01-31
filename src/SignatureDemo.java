import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class SignatureDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, UnsupportedEncodingException {


        //--------------------- SIGNER VIEW ---------------------

        //Creating signature instance
        Signature signature = Signature.getInstance("SHA256WithDSA");

        //generate keyPair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        //initialize signature in signing mode
        signature.initSign(keyPair.getPrivate());

        //create data to sign and feed it to the signature instance
        byte[] document = "abcdefabcdefTestTest".getBytes(StandardCharsets.UTF_8);
        signature.update(document);

        //sign
        byte[] digitalSignature = signature.sign();

        //--------------------- VERIFIER VIEW ---------------------

        byte[] receivedDocument = document;
        byte[] receivedSignature = digitalSignature;

        Signature signatureVerifier = Signature.getInstance("SHA256WithDSA");
        signatureVerifier.initVerify(keyPair.getPublic());

        signatureVerifier.update(receivedDocument);

        boolean verified = signatureVerifier.verify(receivedSignature);

        System.out.println("Is signature verified?\n" +verified);

    }
}
