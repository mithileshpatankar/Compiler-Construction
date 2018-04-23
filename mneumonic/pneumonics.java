import java.util.*;
import java.io.*;

class pneumonics
{
	public static void main(String ar[])throws Exception
	{
		int i,j,n=0;
		String str;
		String temp[]=new String[10];
		String prog[][]=new String[100][100];
		File file= new File("D:/New Folder/mneumonic/file2.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((str=br.readLine())!=null)
		{
			temp=str.split(" ");
			for(i=0;i<4;i++)
				prog[n][i]=temp[i];
			n++;
		}
		System.out.println("PNEUMONICS ARE: ");
		for(i=0;i<n;i++)
			System.out.println(prog[i][1]);
	}
}