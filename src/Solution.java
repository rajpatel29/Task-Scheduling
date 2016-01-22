import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.Map.Entry;


public class Solution
{
	private static Scanner scanner;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("input"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("output"));
		
		scanner = new Scanner(System.in);
		int noOfTask;
		int D[];
		int M[];
		int diff[]; 
		String elementsInLine[];
		String line[];
		
		noOfTask = Integer.parseInt(br.readLine());
		D = new int[noOfTask];
		M = new int[noOfTask];
		diff = new int[noOfTask];
		line = new String[noOfTask];
		
		for (int i = 0; i < noOfTask ; i++)
		{
			line[i] = br.readLine();
		}
		
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		
		long startTime = System.currentTimeMillis();
		
		
		for (int k = 1;  k<= noOfTask; k++) 
		{
			int counter = k;
		
				//add in the map
				for (int i = 0; i < counter ; i++) 
				{
					elementsInLine = line[i].split(" ");
					D[i] = Integer.parseInt( elementsInLine[0] );
					M[i] = Integer.parseInt( elementsInLine[1] );
					diff[i] = D[i] - M[i]; 
					map.put(line[i] + " " + (i+1), diff[i]);
				}
				
				
				 Map<String,Integer> sortedMap = Solution.sortByValue(map);
				
				 
				 
				 int differ[] = new int[counter+1];
				 String info[] = new String[counter+1];
				 differ[counter] = 1000000000;
				 info[counter] = "";
				 
				int c = 0;
		        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) 
		        {
//		            System.out.println("Item is:" + entry.getKey() + " with value:" + entry.getValue());
		        	
		        	info[c] = entry.getKey();
		        	differ[c] = entry.getValue();
		        	c++;
		        }
			
		    	
		    	int currentTime = 0;
		    	int answer = 0;
		    	

		    	for (int i = 0; i < c; i++) 
		    	{
//					System.out.println("Info " + info[i] + "Difference : " +  differ[i]);
				}
		    	
	
		    	System.out.println("Starts  here");
		    	
		    	while(differ[0] != 1000000000)
		    	{
					currentTime++;
					boolean  check = true;
		
					for (int x = 0; x < counter; x++) 
					{
//						System.out.println("" + x + " ------    " + differ[x]);
	
						if(differ[x] == 1000000000)
						{
							break;
						}
					
							 if(check)
							 {
								 String str[] = info[x].split(" ");
								 int d = Integer.parseInt(str[0]);
								 int m = Integer.parseInt(str[1]);
								 int taskNo = Integer.parseInt(str[2]);
								 int difference = d - (  m + (currentTime - 1) );
								
//								 System.out.println("d :  " + d + "   m  :   " + m  + "    takno :  " + taskNo  + "   difference : " + difference);
								 
								 if(m == 1 && difference > 0)
								 {
									 differ[x] = (d - ( currentTime + m) );
									 info[x] =  d + " " + m + " " + taskNo;
									 
									 continue;
								 }
								 else
								 {
									 check= false;
//									 System.out.println("2");
									 m--;
									 if(m==0)
									 {
										 
										 int temp = Math.abs(d - currentTime);
										 if(temp > answer)
										 {
											answer = temp;
										 }
//										 System.out.println("In"  + answer);
										 
										 for (int q = x + 1; q <= counter; q++) 
										 {
											 differ[q - 1] = differ[q];
											info[q - 1] = info[q];
										 }
										 
										
									
										 x--;
										 continue;
									 }
									 else
									 {
//										 System.out.println("hhhh");
										 differ[x] = d - ( currentTime + m);
										 info[x] =  d + " " + m + " " + taskNo;
										 
										 String tempo1 = info[x] ;
										 int tempo2 = differ[x];
										
										 for (int i = 0; i <= c; i++) 
										 {
//											System.out.println("Before : " +  i + "   inf " + info[i] + "   differ " + differ[i]  );
										}
										 
										 
										 for (int w = x + 1; w < counter; w++) 
										 {
											 
//											 System.out.println("differ[w] " +  differ[w] + "    //   " +   " tempo2 "  + tempo2 ) ;
											if(differ[w] < tempo2)
											{
												info[w-1] = info[w];
												differ[w-1] = differ[w];
												
												info[w] = tempo1;
												differ[w] = tempo2;
											}
											else
											{
												break;
											}
										}
										 for (int i = 0; i <= c; i++) 
											 {
//												System.out.println("" +  i + "   inf " + info[i] + "   differ " + differ[i]  );
											}
									 }
									
								 }
							 }
							 else
							 {
								 differ[x] = differ[x] - 1;
								 info[x] =  info[x];
							 }
							 
//							 for (int i = 0; i <= c; i++) 
//							 {
//								System.out.println("" +  i + "   inf " + info[i] + "   differ " + differ[i]  );
//							}
							 
//							 System.out.println("------------------------------");
							
					     }

//					System.out.println("##################");
					
/*					
					 for (int i = 0; i < counter; i++) 
					 {
						 System.out.println("Info " + info[i]);
						String str[] = info[i].split(" ");
						System.out.println("Task no: " + str[2] +"  D : " + str[1] + "  M: " + str[0] + " difference : " + differ[i]);
						System.out.println("");
					 }
*/					
					
//					System.out.println("=========");
				}
				System.out.println("Answer is: " +  answer);
				
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
	}	
		
		br.close();
		bw.close();
		
		long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("It took : "  + totalTime/1000);
				
		
	}
	
	
	
	
	
	
	
	
	
	
	 public static Map<String, Integer> sortByValue(Map<String, Integer> map) 
	 {
	        List list = new LinkedList(map.entrySet());
//	        System.out.println("List Before sorting : " +list);
	        
	        
	        // If you want reverse order then replace o1 with o2 and vice versa in return statement
	        Collections.sort(list, new Comparator() {

	            @Override
	            public int compare(Object o1, Object o2) 
	            {
	                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
	            }
	        });
	        
//	        System.out.println("List After sorting : " +list);
	        
	        Map result = new LinkedHashMap();
	        for (Iterator it = list.iterator(); it.hasNext();) {
	            Map.Entry entry = (Map.Entry) it.next();
	            result.put(entry.getKey(), entry.getValue());
	        }
	        return result;
	}
}
