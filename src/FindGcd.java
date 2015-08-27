import java.math.*;
import java.text.*;
import java.util.Date;
import java.util.Random;
public class FindGcd 
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger result;
		BigInteger a=new BigInteger("37685432423534656547567868764343248554"),b=new BigInteger("23454645634324235643243257658435435433243245472366");
		System.out.println(FindGcd.findGcd(a, b));
		BigInteger gcd=FindGcd.findGcd(a, b);
		if(!gcd.equals(new BigInteger("1")))
		{
			a=a.divide(gcd);
			b=b.divide(gcd);
		}
		//System.out.println(a.toString()+b.toString());
		//System.out.println(a.modInverse(b));
		long startMili=System.currentTimeMillis();
		result=FindGcd.FindInverMod(a,b);
		System.out.println(result);
		System.out.println(FindGcd.IsInverMod(a, result, b));
		long endMili=System.currentTimeMillis();
		System.out.println("time used"+(endMili-startMili));
		
		
		 startMili=System.currentTimeMillis();
		//result=FindGcd.FindInverMod2(a,b);
		System.out.println(result);
		System.out.println(FindGcd.IsInverMod(a, result, b));
		 endMili=System.currentTimeMillis();
		System.out.println("time used"+(endMili-startMili));
		Random rnd = new Random(new Date().getTime());
	    System.out.println(BigInteger.probablePrime(1024, rnd));
	

}
	public static BigInteger StringToBig(String s)
	{
		return new BigInteger(s);
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
	public static BigInteger FindInverMod2(BigInteger c, BigInteger mod)
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
		BigInteger left=c,k=new BigInteger("1");
		while(!left.equals(new BigInteger("0")))
		{
			//left=(1+k*mod)%c;
			left=new BigInteger("1").add(k.multiply(mod)).remainder(c);
			k=k.add(new BigInteger("1"));
		
		}
		//return (1+(k-1)*mod)/c;
		k=k.subtract(new BigInteger("1"));
		k=new BigInteger("1").add(k.multiply(mod));
		return k.divide(c);
		//return (new BigInteger("1").add(k.subtract((new BigInteger("1")).multiply(mod))).divide(c);
	}
	public static boolean IsInverMod(BigInteger c, BigInteger inverse, BigInteger mod)
	{
		//return c*inverse%mod==1;
		return c.multiply(inverse).remainder(mod).equals(new BigInteger("1"));
	}

}
