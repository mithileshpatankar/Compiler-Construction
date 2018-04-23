import java.util.*;

 

class lex

{

      public static void main(String ar[])

      {

            String str;

            int i,j,f;

            String dl[]={";","(",")","{","}","\"",","};

            String op[]={"+","-","/","*","%","="};

            String kw[]={"int","float","double","break","if","else","for","void","do","while"};

           

            Scanner sc=new Scanner(System.in);

            System.out.print("Enter a sentence: ");

            str=sc.nextLine();

            String str1[]=str.split(" ");

           

            for(i=0;i<str1.length;i++)

            {

                  f=0;

                  for(j=0;j<dl.length;j++)

                        if(str1[i].equals(dl[j]))

                        {

                              System.out.print("\n"+str1[i]+" -->Delimiter");

                              f=1;

                        }

                  for(j=0;j<op.length;j++)

                        if(str1[i].equals(op[j]))

                        {

                              System.out.print("\n"+str1[i]+" -->Operator");

                              f=1;

                        }

                  for(j=0;j<kw.length;j++)

                        if(str1[i].equals(kw[j]))

                        {

                              System.out.print("\n"+str1[i]+" -->Keyword");

                              f=1;

                        }

                  if(f==0)

                        System.out.print("\n"+str1[i]+" -->Variable");

            }

            System.out.println();

      }    

}


