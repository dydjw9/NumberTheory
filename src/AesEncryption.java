import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.Random;
import java.security.*;
public class AesEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content,password;
		content=new String("mydeart");
		password=new String("123666");
		
		 try {             
             KeyGenerator kgen = KeyGenerator.getInstance("AES");  
             kgen.init(128, new SecureRandom(password.getBytes()));  
             SecretKey secretKey = kgen.generateKey();  
             byte[] enCodeFormat = secretKey.getEncoded();  
             SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");  
             Cipher cipher = Cipher.getInstance("AES");
             byte[] byteContent = content.getBytes("utf-8");  
             cipher.init(Cipher.ENCRYPT_MODE, key);
             byte[] result = cipher.doFinal(byteContent);  
             for(int i=0;i<result.length;i++)
             {
            	 System.out.print(" "+result[i]);
             }
             AesEncryption a=new AesEncryption();
             System.out.println("later is content");
             a.des(result);
           
     } catch (NoSuchAlgorithmException e) {  
             e.printStackTrace();  
     } catch (NoSuchPaddingException e) {  
             e.printStackTrace();  
     } catch (InvalidKeyException e) {  
             e.printStackTrace();  
     } catch (UnsupportedEncodingException e) {  
             e.printStackTrace();  
     } catch (IllegalBlockSizeException e) {  
             e.printStackTrace();  
     } catch (BadPaddingException e) {  
             e.printStackTrace();  
     }  
     


	}
	
	public void des(byte[] encry)
	{	String content,password;
	content=new String("mydeart");
	password=new String("123666");
	System.out.println("result is "+new String(encry));
	{    try {  
        KeyGenerator kgen = KeyGenerator.getInstance("AES");  
        kgen.init(128, new SecureRandom(password.getBytes()));  
        SecretKey secretKey = kgen.generateKey();  
        byte[] enCodeFormat = secretKey.getEncoded();  
        SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");              
        Cipher cipher = Cipher.getInstance("AES");// 创建密码器  
       cipher.init(Cipher.DECRYPT_MODE, key);// 初始化  
       byte[] result = cipher.doFinal(encry);  
    System.out.println("result is "+new String(result));
     
} catch (NoSuchAlgorithmException e) {  
       e.printStackTrace();  
} catch (NoSuchPaddingException e) {  
       e.printStackTrace();  
} catch (InvalidKeyException e) {  
       e.printStackTrace();  
} catch (IllegalBlockSizeException e) {  
       e.printStackTrace();  
} catch (BadPaddingException e) {  
       e.printStackTrace();  
}  
		
	}

}
}