import java.math.*;
import java.text.*;
public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BigInteger result;
		BigInteger a=new BigInteger("37685432423534656547567868764343248554"),b=new BigInteger("23454645634324235643243257658435435433243245472366");
		System.out.println(FindGcd.FindGcd(a, b));
		BigInteger gcd=FindGcd.FindGcd(a, b);
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
		result=FindGcd.FindInverMod2(a,b);
		System.out.println(result);
		System.out.println(FindGcd.IsInverMod(a, result, b));
		 endMili=System.currentTimeMillis();
		System.out.println("time used"+(endMili-startMili));
	

}}
