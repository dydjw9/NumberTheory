import java.math.*;
import java.util.*;
import java.text.*;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startMili=System.currentTimeMillis();
		BigInteger msg=new BigInteger("122231765657675685878762886077");
		RsaEncryption Rsa=new RsaEncryption(1024);
		Rsa.printKeys();
		msg=Rsa.Encryption(msg);
		System.out.println(msg);
		msg=Rsa.Decryption(msg);
		System.out.println(msg);
		long endMili=System.currentTimeMillis();
		System.out.println("time used"+(endMili-startMili));
	    

}}
