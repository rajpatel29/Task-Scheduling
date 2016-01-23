import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution
{
	private static Scanner scanner;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("input"));
		
		scanner = new Scanner(System.in);
		int noOfTask;
		int D[];
		int M[];
		int diff[]; 
		String elementsInLine[];
		
		
		noOfTask = Integer.parseInt(br.readLine());
//		noOfTask = Integer.parseInt(scanner.nextLine());

		D = new int[noOfTask];
		M = new int[noOfTask];
		diff = new int[noOfTask];
		
		String line[] = new String[noOfTask];
		
		ArrayList<Integer> bucket = new ArrayList<>();
		
		for (int i = 0; i < noOfTask ; i++)
		{
			line[i] = br.readLine();
//			line[i] = scanner.nextLine();
		}
		
	
		long startTime = System.currentTimeMillis();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		int total = 0;

//---		
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> sortedList = new ArrayList<>();
		 

		for (int i = 0; i < noOfTask ; i++) 
		{
			diff[i] = D[i] - M[i]; 
			map.put(line[i] + " " +(i + 1), diff[i]);
		
//---			
			list.add(line[i] + " " +(i + 1));
			total = total + M[i];
			
		
//			Map<String,Integer> sortedMap = Solution.sortByValue(map , total);
			
			sorting(sortedList , line[i] + " " +(i + 1) , total);
		
			
			 
			 int answer = 0;
			 int previousAnswer = 0;
			 int previousSpace = 0;
			 
			 int currentTime = 0; 
		 
		 
			for (int j = 0; j < sortedList.size() ; j++) 
			{
		 
        	String str[] = sortedList.get(j).split(" ");
        	int d = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	int taskNo = Integer.parseInt(str[2]);

        	
        	if(previousSpace > 0 )
        	{
        		currentTime = currentTime + m;
        		if(m > previousSpace)
        		{
        			m = m - previousSpace;
        			
        		}
        		else
        		{
        			previousSpace = previousSpace - m;
        		}
        		
        		
        		previousAnswer = d - currentTime ;
        		
        		if(previousAnswer > 0)
        		{
        			previousSpace = previousAnswer;
        			previousAnswer = answer;
        		}
        	}
        	else
        	{
        		currentTime = currentTime + m;
        		previousAnswer = d - currentTime;
        		
        		if(previousAnswer > 0)
        		{
        			previousSpace = previousAnswer;
        			previousAnswer = answer;
        		}
        	}
        	
        	if(   Math.abs(previousAnswer) > answer)
        	{
        		answer = Math.abs(previousAnswer);
        	}
        	
        }
		
        System.out.println( answer);
        
        
		}	
        
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("It took : "  + totalTime/1000);
	}
	
	
	
	
	
	
	
	
	
	
	
	 private static void sorting(ArrayList<String> sortedList, String next, int total) 
	 {
		 if(sortedList.size() == 0)
		 {
			 sortedList.add(next);
		}
		 else
		 {
			 for (int i = sortedList.size() - 1 ; i >= 0  ; i--) 
			 {
				 String current = sortedList.get(i);
				 String str1[] = current.split(" ");
				 int d1 = Integer.parseInt(str1[0])  - total;
				 
				 
				 String str2[] = next.split(" ");
				 int d2 = Integer.parseInt(str2[0]) - total;
				 
				 
				 if(d1 > d2)
				 {
					 if(i == 0)
					 {
						 sortedList.remove(i);
						 sortedList.add(i, next);
						 sortedList.add(i + 1, current);
					 }
					 continue;
				 }
				 else
				 {
					 sortedList.add(i+1 , next);
					 break;
				 }
				 
			 }
		 }
		 
	 }











	public static Map<String, Integer> sortByValue(Map<String, Integer> map ,  int  total) 
	 {
	
	        List list = new LinkedList(map.entrySet());
	        Collections.sort(list, new Comparator() {

	            @Override
	            public int compare(Object o1, Object o2) 
	            {
	            	
	            	
	            	Map.Entry entry1 = (Map.Entry) (o1);
	            	String temp1[] = ( (String)  entry1.getKey() ).split(" ");

	            	Map.Entry entry2 = (Map.Entry) (o2);
	            	String temp2[] = ( (String)  entry2.getKey() ).split(" ");
	            	
	            	int x1 = (Integer.parseInt( temp1[0] ) - total);
	            	int x2 = (Integer.parseInt( temp2[0] ) - total);
	            	
	            	
	            	return x1 - x2;

	           
	            	
	            	
//	            	return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
	            }
	        });

	        Map result = new LinkedHashMap();
	        for (Iterator it = list.iterator(); it.hasNext();) {
	            Map.Entry entry = (Map.Entry) it.next();
	            result.put(entry.getKey(), entry.getValue());
	        }
	        return result;
	}
}



/*

public static Map<String, Integer> sortByValue(Map<String, Integer> map ,  int  total) 
	 {
	
	        List list = new LinkedList(map.entrySet());
	        Collections.sort(list, new Comparator() {

	            @Override
	            public int compare(Object o1, Object o2) 
	            {
	            	
	            	System.out.println("hhhhheeeeyyyyy");
	            	
	            	Map.Entry entry1 = (Map.Entry) (o1);
	            	String temp1[] = ( (String)  entry1.getKey() ).split(" ");

	            	Map.Entry entry2 = (Map.Entry) (o2);
	            	String temp2[] = ( (String)  entry2.getKey() ).split(" ");
	            	
	            	int x1 = (Integer.parseInt( temp1[0] ) - total);
	            	int x2 = (Integer.parseInt( temp2[0] ) - total);
	            	
	            	
	            	return x1 - x2;

	           
	            	
	            	
//	            	return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
	            }
	        });

	        Map result = new LinkedHashMap();
	        for (Iterator it = list.iterator(); it.hasNext();) {
	            Map.Entry entry = (Map.Entry) it.next();
	            result.put(entry.getKey(), entry.getValue());
	        }
	        return result;
	}

*/