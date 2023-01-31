import java.security.Provider;
import java.security.Security;
//import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class SecProvider {
    public static void main(String[] args) {
        //Security.addProvider(new BouncyCastleProvider());

        //get Provider names
        Provider[] providers = Security.getProviders();
        System.out.println("Anzahl installierte Provider: "+providers.length);
        for (int i=0; i != providers.length; i++){
            System.out.println("Name: " +providers[i].getName()
                                + " Version: " + providers[i].getVersionStr()
                                +"\n Info: "+providers[i].getInfo());
        }
    }
}
