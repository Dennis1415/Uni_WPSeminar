import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;

public class SecureRandomDemo {

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {

    SecureRandom secureRandom = new SecureRandom();

    System.out.println("Used algorithm: "+secureRandom.getAlgorithm()); //Deterministic Random Bit Generator

    //random values
    System.out.println("random int: "+secureRandom.nextInt());
    System.out.println("random bounded int: "+secureRandom.nextInt(10));
    System.out.println("random long: "+secureRandom.nextLong());
    System.out.println("random float: "+secureRandom.nextFloat());
    System.out.println("random double: "+secureRandom.nextDouble());
    System.out.println("random boolean: "+secureRandom.nextBoolean());

    //random seed
    System.out.println("random seed: "+misc.byteToHex(secureRandom.generateSeed(32)));
    }
}

