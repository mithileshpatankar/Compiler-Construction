import java.util.*;

class left_factoring
{
	static String parts[],rs_parts[];
	public static void main(String ar[])
	{
		int i,fc;
		String prod;
		String fprod[]=new String[2];
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter the production:\t");
		prod=sc.nextLine();
		parts= prod.split("-");
		rs_parts=parts[1].split("/");
		fc=find_common();
		if(fc==0)
		{
			System.out.println("NO LEFT FACTORING REQUIRED\n");
			return;
		}
		fprod[0]=parts[0]+"-"+rs_parts[0].substring(0,fc)+parts[0]+"'";
		fprod[1]=parts[0]+"'-"+rs_parts[0].substring(fc)+"/"+rs_parts[1].substring(fc);
		System.out.println("\nFinal Production(After left factoring)");
		for(i=0;i<fprod.length;i++)
			System.out.println(fprod[i]);
	}
	
	static int find_common()
	{
		String str1,str2;
		int i,j,s=0;
		str1=rs_parts[0];
		str2=rs_parts[1];
		for(i=0;i<str1.length() || i<str2.length();i++)
			if(Character.isUpperCase(str1.charAt(i)) || Character.isUpperCase(str2.charAt(i)))
				return s;
			else if(str1.charAt(i) == str2.charAt(i))
					s++;
		return s;
	}
}	
		


A-aabAB/aabc