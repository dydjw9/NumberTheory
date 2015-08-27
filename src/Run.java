import java.math.*;
import java.util.*;
import java.text.*;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		BigInteger msg=new BigInteger("12223176575685878762886077");
		RsaEncryption Rsa=new RsaEncryption(1024);
		//Rsa.printKeys();
		msg=Rsa.Encryption(msg);
		System.out.println(msg);
		msg=Rsa.Decryption(msg);
		System.out.println(msg);
	    

}}
