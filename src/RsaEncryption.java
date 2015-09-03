
import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

public class RsaEncryption {

	
	private BigInteger PublicKey,PrivateKey,Mod;
	public RsaEncryption(int bits)
	{
		Random rnd = new Random(new Date().getTime());
		BigInteger p,q,n,e,d,eule;
		p=BigInteger.probablePrime(bits, rnd);
		q=BigInteger.probablePrime(bits, rnd);
		n=q.multiply(p);
		eule=q.subtract(new BigInteger("1")).multiply(p.subtract(new BigInteger("1")));
		do{e=BigInteger.probablePrime(bits, rnd);}
		
		while(!findGcd(e,eule).equals(new BigInteger("1")));
		d=FindInverMod(e,eule);
		PrivateKey=d;
		PublicKey=e;
		Mod=n;
	}
	public BigInteger Encryption(BigInteger Msg)
	{
		return Msg.modPow(PublicKey, Mod);
	}
	public BigInteger Decryption(BigInteger Msg)
	{
		return Msg.modPow(PrivateKey, Mod);
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
}
