import java.math.BigInteger;

public class misc {

    public static String byteToHex(byte[] m){

        String output = String.format("%X",new BigInteger(1,m));
        return output;

    }
}
