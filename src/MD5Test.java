import java.security.MessageDigest;
import java.io.*;
public class MD5Test {

	public static void main(String[] args) {
		 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
		// TODO Auto-generated method stub
		 try {
		 MessageDigest mdInst = MessageDigest.getInstance("MD5");
	     File file;
	     file=FileChooser.FilePicker();
	     FileInputStream input=new FileInputStream(file);
	     byte[] bytes= new byte[512];
	     int a=input.read(bytes);
	     mdInst.update(bytes);
	     byte[] md=mdInst.digest();
	     String b=new String(md);
	     System.out.println(b);
	     
	     int j = md.length;
	     char str[] = new char[j * 2];
         int k = 0;
         for (int i = 0; i < j; i++) {
             byte byte0 = md[i];                         
         
             str[k++] = hexDigits[byte0 >>> 4 & 0xf];
             str[k++] = hexDigits[byte0 & 0xf];
         }
         System.out.println(str);
	     
		 }
		 catch (Exception e) {
	           
	        }
	}
	public static String MD5hashHex(byte[] bytes)
	{
		 char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 
		 char[] str=null;
		 try {
			 MessageDigest mdInst = MessageDigest.getInstance("MD5");
		 
		  mdInst.update(bytes);
		     byte[] md=mdInst.digest();
		     String b=new String(md);
		     System.out.println(b);
		     
		     int j = md.length;
		     str = new char[j * 2];
	         int k = 0;
	         for (int i = 0; i < j; i++) {
	             byte byte0 = md[i];                         
	         
	             str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	             str[k++] = hexDigits[byte0 & 0xf];
	         }
	       
	}
	 
	 catch (Exception e) {
          
       }
	
     
	  return str.toString();
	  }
}
