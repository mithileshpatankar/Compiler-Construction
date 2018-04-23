import java.util.*;

class left_recursion
{
	static String prod,parts[],rs_parts[];
	static String fprod[]=new String[2];
	public static void main(String ar[])
	{
		int i, s=-1;
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the production:\t");
		prod= sc.nextLine();
		parts= prod.split("-");
		rs_parts=parts[1].split("/");
		for(i=0;i<rs_parts.length;i++)
			if(parts[0].charAt(0) == rs_parts[i].charAt(0))
				s=i;
		if(s==-1)
		{
			System.out.println("NO LEFT RECURSION PRESENT");
			return;
		}
		//System.out.println("num: "+s);
		alter_prod(s);
		System.out.println("\nFinal Production(After left recursion)");
		for(i=0;i<fprod.length;i++)
			System.out.println(fprod[i]);
	}
	
	static void alter_prod(int s)
	{
		String str;
		String a=new String();
		String b=new String();
		int i;
		for(i=0;i<rs_parts.length;i++)
			if(i==s)
				a=rs_parts[i].substring(1);
			else b=rs_parts[i];
		str=parts[0]+"'";
		fprod[0]=parts[0]+"-"+b+str;
		fprod[1]=str+"-"+a+str+"/ep";
	}
}
		
		