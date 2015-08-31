import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class RsaEncryption {

	
	private BigInteger PublicKey,PrivateKey,Mod;
	private int bits;
	public RsaEncryption(int b)
	{
		bits=b;
		Random rnd = new Random(new Date().getTime());
		BigInteger p,q,n,e,d,eule;
		p=BigInteger.probablePrime(bits, rnd);
		//System.out.println(p);
		q=BigInteger.probablePrime(bits, rnd);
		//System.out.println(q);
		n=q.multiply(p);
		//System.out.println(n);
		eule=q.subtract(new BigInteger("1")).multiply(p.subtract(new BigInteger("1")));
		//System.out.println(eule);
		//do{
			e=BigInteger.probablePrime(bits+1, rnd);//}
		
		//while(!findGcd(e,eule).equals(new BigInteger("1")));
		//System.out.println(e);
		d=FindInverMod(e,eule);
		//System.out.println(d);
		PrivateKey=d;
		PublicKey=e;
		Mod=n;
	}
	public String Encryption(String s)
	{
		BigInteger[] Msg=StrToBigInt(s);
		for(int i=0;i<Msg.length;i++)
		{
			Msg[i]=Msg[i].modPow(PublicKey, Mod);
		}
		return BigIntToStr(Msg);
	}
	public String Decryption(String s)
	{
		BigInteger[] Msg=StrToBigInt(s);
		for(int i=0;i<Msg.length;i++)
		{
			Msg[i]=Msg[i].modPow(PrivateKey, Mod);
		}
		return BigIntToStr(Msg);
	}
	public void printKeys()
	{
		System.out.println("mod is "+Mod);
		System.out.println("pubkey is "+PublicKey);
		System.out.println("privatekey is "+PrivateKey);
	}
	
	public static BigInteger findGcd(BigInteger x, BigInteger y)
	{
		
		
		
		if(x.compareTo(y)<0)
		{
			BigInteger temp;
			temp=x;
			x=y;
			y=temp;
		}
		if(x.remainder(y).equals(new BigInteger("0")))
		return y;
		else return findGcd(y,x.remainder(y));
	}
	public static BigInteger FindInverMod(BigInteger c, BigInteger mod)
	{
		if(!findGcd(c,mod).equals(new BigInteger("1")))
		return new BigInteger("0");
	
		if(c.compareTo(mod)>0)
		{
			BigInteger t;
			t=mod;
			mod=c;
			c=t;
		}
		BigInteger a1=new BigInteger("1"),b1=new BigInteger("0"),a2=new BigInteger("0"),b2=new BigInteger("1"),left;            //a*x+b*y=1  a is mod, b is c, mod>c need return y
		BigInteger a=mod,b=c;                          //a1*a+b1*b, a2*a+b2*b   y=b1+b2
		BigInteger tempa,tempb,temp;
		left=b;
		while(!left.equals(new BigInteger("1")))
		{
			left=a.remainder(b);
			BigInteger k;          //a always larger then b
			k=a.subtract(left).divide(b);
			tempa=a1;
			tempb=b1;
			a1=a2;
			b1=b2;
			a2=tempa.subtract(k.multiply(a2));      //a2=a1-ka2, b2=b1-kb2
			b2=tempb.subtract(k.multiply(b2));
			temp=a;
			a=b;
			b=left;
			
			
			
		}
		while(b2.compareTo(new BigInteger("0"))<0)
		{
			b2=mod.add(b2);
		}
		return b2;
	}
	public BigInteger[] StrToBigInt(String s)
	{
		int unitlength=bits/8,length;      //unitlength is the longest string that can be encryoted once, length is the length of BigInteger[]
		byte b[] = s.getBytes();           //get bytes of msg
		
		length=b.length/unitlength;           //calculate length
		System.out.println(s);
		System.out.println("blength is" + b.length);
		System.out.println("length is" + length);
		  BigInteger[] retn=new BigInteger[length+1];
		 for(int j=0;j<=length;j++)
		 {
			 String ret = ""; 
		for (int i = 0; i < b.length; i++) {  
	        String hex = Integer.toString(b[ i ] & 0xFF);  
	    
	     ret += hex;  
	  } 
		retn[j]=new BigInteger(ret);}
		 System.out.println("retnlength is" + retn.length);
		return retn;
	}
	public  String BigIntToStr(BigInteger[] bigint)
	{   String ret = ""; 
		for(int i=0;i<bigint.length;i++)
		{
		byte[] b=bigint[i].toByteArray();
		String t = new String(b);
		ret+=t;
		
		}
		return ret;
	}
}
