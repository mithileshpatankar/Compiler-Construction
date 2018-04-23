import java.io.*;

class macro_table
{
	static int mntc=0,mdtc=0;
	static String prog[][]=new String[100][100];
	static String mdt[][]=new String [100][100];
	static String mnt[][]=new String [100][100];
	public static void main(String ar[])throws Exception
	{
		int n=0,i,j;
		String str,temp[];
		File file= new File("D:/New Folder/macro/macro_file.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while((str=br.readLine())!=null)
		{
			temp=str.split(" ");
			for(i=0;i<4;i++)
				prog[n][i]=temp[i];
			n++;
		}
		for(i=0;i<n;i++)
			if(prog[i][1].equals("MACRO"))
				fill_table(i);
			
		System.out.println("\nMNT");
		for(i=0;i<mntc;i++)
		{
			for(j=0;j<3;j++)
				System.out.print(mnt[i][j]+"\t");
			System.out.println();
		}
		
		System.out.println("\n\nMDT");
		for(i=0;i<mdtc;i++)
		{
			for(j=0;j<4;j++)
				System.out.print(mdt[i][j]+"\t");
			System.out.println();
		}
	}
	
	static int fill_table(int i)
	{
		int j=i+1,k;
		mnt[mntc][0]= Integer.toString(mntc+1);
		mnt[mntc][1]= prog[j][1];
		mnt[mntc][2]= Integer.toString(mdtc+1);
		while(!prog[j][1].equals("MEND"))
		{
			mdt[mdtc][0]= Integer.toString(mdtc+1);
			for(k=1;k<4;k++)
				mdt[mdtc][k]= prog[j][k];
			j++;
			mdtc++;
		}
		mdt[mdtc][0]= Integer.toString(mdtc+1);
		for(k=1;k<4;k++)
				mdt[mdtc][k]= prog[j][k];
		mdtc++;
		mntc++;
		return j;
	}
}