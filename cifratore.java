import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;
import javax.swing.plaf.synth.SynthStyle;

public class cifratore{
    private BigInteger P;
    private BigInteger Q;
    private BigInteger N;
    private BigInteger PHI;
    private BigInteger e;
    private BigInteger d;

    public cifratore()
    {   // P e Q 2 primi molto grandi 
        P = new BigInteger("98119457177177456194561724762503888691938293642142451297968507870583737771514159291299379638843494312511987054774798425528620093256045677540267506368412110655769152899066022717382899231969388620230724848564583398802062701246682361958217103771200807946141870029213354432546296183847887638587751445008949682347");
        Q = new BigInteger("149336347147865278549887965757749952865985907212076429225371224200250696756834223269154275743380004182792683912899651862144353623425164765006925042161442020631777141612339616187492161886057689765039496777934852122926312447851830367844031442614398559621497552003378503400258700330187571405953939832942662475707");
        // encription-key (e,phi)=1 relativamente primi -> massimo comune divisiore 1.
        e = new BigInteger("7633168947462819717485203006812527651131230849694635025588248671905957571963977981866292752183560629682660167043421303801377638631685783259524187324016423");
        N = P.multiply(Q); // chiave pubblica
        //phi = (p-1)*(q-1)
        PHI = P.subtract(BigInteger.ONE).multiply(Q.subtract(BigInteger.ONE));
        // decripton-key -> ed congr 1 mod f(n)
        d = e.modInverse(PHI);
    }

    public cifratore(BigInteger e, BigInteger d, BigInteger N)
    {
        this.e = e;
        this.d = d;
        this.N = N;
    }


    public static void main(String[] arguments) throws IOException
    {
        cifratore rsa = new cifratore();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter message you wish to send.");
        String messaggioInserito = in.nextLine(); // il messaggio quando si preme invia viene inserito qui.
        String msgB = bToS(messaggioInserito.getBytes());
        System.out.println("il messaggio in byte è: " + msgB);
        BigInteger messaggioCifrato = new BigInteger(msgB);
        BigInteger msgCriptato = rsa.encryptMessage(messaggioCifrato);
        System.out.println("il messaggio criptato è " + msgCriptato);
    }

    public static String bToS(byte[] cipher)
    {
        String temp = "";
        for (byte b : cipher)
        {
            temp += Byte.toString(b);
        }
        return temp;
    }

 
    // Encrypting the message
    public BigInteger encryptMessage(BigInteger numeroMessaggio)
    {
        return numeroMessaggio.modPow(e, N);
    }    
 
}