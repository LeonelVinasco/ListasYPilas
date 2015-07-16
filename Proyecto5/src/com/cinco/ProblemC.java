package project5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

import org.omg.IOP.CodecPackage.FormatMismatch;

public class ProblemC
{
	
	public static void main(String[] args) throws Exception
	{

		Scanner scan;
		File f = new File("C_3.in");

		if (f.exists())
		{
			scan = new Scanner(f);
		} else
		{
			scan = new Scanner(System.in);
		}

		int cases = Integer.parseInt(scan.nextLine());

		int countCases = 1;
		while (countCases <= cases)
		{
			int nOperations = Integer.parseInt(scan.nextLine());
			int countOperation = nOperations;
			System.out.println("Test #" + countCases + ":");
			int n = 1;
			TreeMap<String, Integer> squares = new TreeMap<String, Integer>();
			while (countOperation > 0)
			{
				StringTokenizer square = new StringTokenizer(scan.nextLine()," ");
				
				String z = square.nextToken();
				int b= Integer.parseInt(square.nextToken());
				int h= Integer.parseInt(square.nextToken());
				
				if( squares.containsKey(z) )
				{
					squares.replace(z, squares.get(z)+(b*h));
				}
				else
				{
					squares.put(z, (b*h));
				}
				countOperation--;
			}
			
			String mayorName="";
			Integer mayorSum = 0;
			for(Entry<String, Integer> entry: squares.entrySet())
			{
				if(mayorSum <entry.getValue())
				{
					mayorSum=entry.getValue();
					mayorName= entry.getKey();
				}
				if(mayorSum ==entry.getValue())
				{
					// poner el de menor orden lexicografico
					//entry.getKey()<mayorName
					if(mayorName.compareTo(entry.getKey())<1)
					{
						mayorSum=entry.getValue();
						mayorName= entry.getKey();
					}
				}
				
			}
			
			System.out.println(mayorName+" "+mayorSum);
			
			countCases++;
		}

	}

}
