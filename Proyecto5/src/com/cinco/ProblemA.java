package project5;

import java.io.File;
import java.util.Scanner;
import java.util.TreeMap;

public class ProblemA
{

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{

		Scanner scan;
		File f = new File("A_3.in");

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
			TreeMap<String, Integer> hour = new TreeMap<String, Integer>();
			while (countOperation > 0)
			{
				String z = scan.nextLine();

				if (hour.containsKey(z))
				{
					int map = hour.get(z);
					hour.replace(z, map + 1);
					int auxMap = hour.get(z);
					if ( auxMap > n)
						n = auxMap;
				} else
				{
					hour.put(z, 1);

				}

				countOperation--;
			}
			System.out.println(n);
			n = 0;
			countCases++;
		}

	}
}
