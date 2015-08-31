import java.math.*;
import java.util.*;
import java.text.*;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startMili=System.currentTimeMillis();
		String msg=new String("avcd");
		
		RsaEncryption Rsa=new RsaEncryption(1024);
		Rsa.printKeys();
		System.out.println(Rsa.StrToBigInt(msg)[0]);
		msg=Rsa.Encryption(msg);
		System.out.println(msg);
		msg=Rsa.Decryption(msg);
		System.out.println(msg);
		long endMili=System.currentTimeMillis();
		System.out.println("time used"+(endMili-startMili));
		
		 String s = "avcd";//String变量 

		 byte b[] = s.getBytes();//String转换为byte[] 
		 System.out.println(b);
		 System.out.println(b[0]&0xFF);
		 String ret = "111";  
		
			for (int i = 0; i < b.length; i++) {  
		        String hex = Integer.toString(b[ i ] & 0xFF);  
		        if (hex.length() == 2) {  
		            hex = '0' + hex;  }
		     ret += hex;  
		  } 
		 
		 System.out.println(ret);
		 
		 BigInteger a=new BigInteger(ret);
		 System.out.println(a);
		 //byte[] t=a.toByteArray();
		 
		
	
		 byte[] array = a.toByteArray();
		 if (array[0] == 0) {
		     byte[] tmp = new byte[array.length - 1];
		     System.arraycopy(array, 1, tmp, 0, tmp.length);
		     array = tmp;
		 }
		 ret = "111";  
		 for (int i = 0; i < array.length; i++) {  
		        String hex = Integer.toString(array[ i ] & 0xFF);  
		        if (hex.length() == 2) {  
		            hex = '0' + hex;  }
		     ret += hex;  
		  } 
			System.out.println(ret);
			 
		 
}}
