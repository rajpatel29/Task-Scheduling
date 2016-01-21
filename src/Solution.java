import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution
{
	private static Scanner scanner;
	
	public static void main(String args[])
	{
		scanner = new Scanner(System.in);
		int noOfTask;
		int D[];
		int M[];
		
		System.out.println("Enter: ");
		noOfTask = Integer.parseInt(scanner.nextLine());
		D = new int[noOfTask];
		M = new int[noOfTask];
		
		
		String line[] = new String[noOfTask];
		String elementsInLine[];
		
		
		
		int diff[] = new int[noOfTask];
		
		ArrayList<Integer> bucket = new ArrayList<>();
		
		for (int i = 0; i < noOfTask ; i++)
		{
			line[i] = scanner.nextLine();
		
		}
	
		
		
		for (int l = 1 ; l <= noOfTask  ; l++) 
		{
			for (int j = 0; j < l; j++)
			{
				bucket.add(j);
			}
		
			int min = 1000000000;
			int index = -1;
			
			for (int k = 0; k < l; k++) 
			{
				elementsInLine =  line[k].split(" ");
				D[k] = Integer.parseInt( elementsInLine[0] );
				M[k] = Integer.parseInt( elementsInLine[1] );
				diff[k] = D[k] - M[k];
				
				if(diff[k] < min)
				{
					min = diff[k];
					index = k;
				}
			}
			
			
			boolean first = true; 
			int currentTime = 0;
			int answer = 0;
			
			System.out.println();
			System.out.println();
			while(!bucket.isEmpty())
			{
				currentTime++;
				
				if(first)
				{
					first = false;
					
					
					
					
					M[index]--;
					if(M[index]==0)
					{
						int temp = Math.abs(D[index] - currentTime);
						if(temp > answer)
						{
							answer = temp;
						}
						
						
						bucket.remove(index);
					}
				}
				else
				{
					
					int r = 1000000000;
					for (int i = 0; i < bucket.size(); i++) 
					{
						int ind = bucket.get(i);
						
						int temp1 = D[ind] - (currentTime - 1 + M[ind]);
						
						if(r > temp1 )
						{
							r = temp1 ;
							index =  ind;
						}
					}
			//		System.out.println(index);
				
					
					
					M[index]--;
					if(M[index]==0)
					{
						int temp = Math.abs(D[index] - currentTime);
						if(temp > answer)
						{
							answer = temp;
						}
						
						bucket.remove(new Integer(index));
						
					}
					
				}
				
				
			}
			
			System.out.println("answer : " + answer);
			bucket.clear();
		}
		
		System.out.println("done :) be happy ");
		
	}
}
