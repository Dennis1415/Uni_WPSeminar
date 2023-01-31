import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {

    private static String hashMessage(String s) throws NoSuchAlgorithmException {
        System.out.println("Text: "+s);

        //get instance of MessageDigest using SHA-256 algorithm
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

        //feed data to MessageDigest instance & digest/hash
        messageDigest.update(s.getBytes());
        byte[] m = messageDigest.digest();

        return misc.byteToHex(m);
    }
        public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Hash Test : "+hashMessage("Test"));
        System.out.println("Hash Test : "+hashMessage("Test"));
        System.out.println("Hash Toast: "+hashMessage("Toast"));

        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        System.out.println("getAlgorithm: "+messageDigest.getAlgorithm());
        System.out.println("getDigestLength: "+messageDigest.getDigestLength());
        System.out.println("getProvider: "+messageDigest.getProvider()+"\n");
        }
}
