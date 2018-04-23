import java.util.*;

class ffirst
{
	static int n,k=0;
	static String f[]= new String[100];
	static String prod[];
	static String prodf[][] = new String [100][100];
	public static void main(String ar[])
	{
		int i,j;
		char temp;
		String str;
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the no. of lines in production:\t");
		n=sc.nextInt();
		System.out.println("Enter the productions: ");
		prod =new String[n+1];
		for(i=0;i<=n;i++)
			prod[i]=sc.nextLine();
		for(i=0;i<n;i++)
			prodf[i]=prod[i+1].split(" ");
        
        for(i=0;i<n;i++)
			System.out.println(prodf[i]);
		while(true)
		{
			System.out.print("Enter the variable (to find its first) OR type 'exit' to exit:\t");
			str=sc.nextLine();
			if(str.equals("exit"))
				return;
			flush_first();
			find_first(str);
			System.out.print("FIRST("+str+"): {");
			for(i=0;i<k;i++)
				System.out.print(f[i]+" ");
			System.out.println("}");
		}
		
	}
	
	static void find_first(String temp)
	{
		int i,val,f_loc,z,j,present=0,l=0;
		int loc[] = new int [100];
		l=find_prod(temp,loc,l);
		for(z=0;z<l;z++)
		{
			f_loc=loc[z];
			char ch=prodf[f_loc][2].charAt(0);
			if(Character.isUpperCase(ch))
				find_first(prodf[f_loc][2]);
			else
			{
				for(j=0;j<k;j++)
					if(f[j].equals(prodf[f_loc][2]))
						present++;
				if(present==0)
					f[k++]=prodf[f_loc][2];
			}
		}
	}
	
	static int find_prod(String temp, int loc[], int l)
	{
		int i;
		for(i=0;i<n;i++)
			if(prodf[i][0].equals(temp))
				loc[l++]=i;
		return l;
	}
	
	static void flush_first()
	{
		for(int i=0;i<f.length;i++)
			f[i]="null";
		k=0;
	}
}


E - T E'
E' - + T E
E' - ep
T - F T'		