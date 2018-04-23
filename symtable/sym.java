import java.util.*;
import java.io.*;

class sym
{
	static String assdir[]={"START","USING","END","DROP","EQU"};
	public static void main(String ar[])throws Exception
	{
		int i,j,n=0,s=0,lc=0,val;
		String str;
		char ch[];
		String temp[]=new String[10];
		String prog[][]=new String[100][100];
		String sym_table[][]= new String[10][10];
		File file= new File("D:/New Folder/symtable/file2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((str=br.readLine())!=null)
		{
			temp=str.split(" ");
			for(i=0;i<4;i++)
				prog[n][i]=temp[i];
			n++;
		}
		for(i=1;i<n;i++)
		{
			if(!prog[i-1][0].equals("-"))
			{
				sym_table[s][0]=prog[i-1][0];
				sym_table[s][1]=Integer.toString(lc);
				s++;
			}
			if(check_dl(prog[i-1][1])==1)
			{
				str=prog[i-1][1];
				if(str.equals("DC"))
				{
					val=find_val(prog[i-1][2]);
					lc+=val;
				}
				else
				{
					val=find_val(prog[i-1][3]);
					lc=lc+val*(Integer.parseInt(prog[i-1][2]));
				}
			}
			else if(check_dl(prog[i-1][1])==0 && check_dir(prog[i-1][1])==0)
			{
				ch = prog[i-1][1].toCharArray();
				if(Character.toString(ch[ch.length-1]).equals("R"))
					lc+=2;
				else lc+=4;
			}
		}
		System.out.println("SYMBOL TABLE: ");
		for(i=0;i<s;i++)
			System.out.println(sym_table[i][0]+"\t"+sym_table[i][1]);
		
	}
	
	static int check_dl(String temp)
	{
		if(temp.equals("DC") || temp.equals("DS"))
			return 1;
		return 0;
	}
	
	static int check_dir(String temp)
	{
		int i;
		for(i=0;i<assdir.length;i++)
			if(assdir[i].equals(temp))
				return 1;
		return 0;
	}
	
	static int find_val(String temp)
	{
		if(temp.equals("B"))
			return 1;
		if(temp.equals("H"))
			return 2;
		if(temp.equals("F"))
			return 4;
		if(temp.equals("D"))
			return 8;
		return 0;
	}
}