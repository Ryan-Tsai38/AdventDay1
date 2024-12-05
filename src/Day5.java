import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Day5 {
	static boolean[] check = new boolean[193];
	static int[][] rules = new int[1176][2];
	static int[][] list = new int[193][];
	public static void main(String[] args) {
		int total = 0;
		
		 try(BufferedReader reader = new BufferedReader (new FileReader("input5"))) {
			 String next;
			 boolean[] check2 = new boolean[193];
			 int i = 0;
				while(!(next = (reader).readLine()).equals("")) {
	        		int find = next.indexOf('|');
	        		int end = next.indexOf("0");
	        		rules[i][0] = Integer.parseInt(next.substring(0,find)); 
	        		rules[i][1] = Integer.parseInt(next.substring(find+1));
	        		
	        		i++;
				}
				
				i = 0;
				while((next = (reader).readLine()) != null) {
					int j = 1;
					int curr;
					int prev = 0;
					
	        		while (next.indexOf(',', prev) != -1) {
	        			curr = next.indexOf(',',prev  );
	        			prev = curr + 1;
	        			j++;
	        		}
	        		list[i] = new int[j];
	        		j = 0;
	        		prev = 0;
	        		curr = 0;
	        		while (next.indexOf(",", prev) != -1) {
	        			curr = next.indexOf(',',prev);
	        			list[i][j] = Integer.parseInt(next.substring(prev,curr)); 
	        			prev = curr + 1;
	        			j++;
	        		}list[i][j] = Integer.parseInt(next.substring(prev)); 
	        		
	        		i++;
				}
				
				for ( i = 0; i < list.length ; i++) {
	                check[i] = true;
	                
	                for ( int j = 0; j < list[i].length; j++) {
	                	for(int k = 0; k < rules.length; k++) {
	                		if(rules[k][0] == list[i][j]) {
	                			for(int l = j; l > -1; l--) {
	                				if(rules[k][1] == list[i][l]) {
	                					check[i] = false;
	                					 check2[i] = true;
	                					while(!check[i]) {
		               						 check[i] = random(list[i]);	               					
	                				}
	                				}
	                			}
	                		}
	                	}
	                } 
	               //System.out.println(" ");
	            }
				int total2 = 0;
				  for ( i = 0; i < list.length ; i++) { // Loop through each element in the
					  if(check2[i]) {
						  
						  int temp = list[i].length/2;
						  total2 += list[i][temp];
					  }
					  if(check[i]) {
						  
						  int temp = list[i].length/2;
						  total += list[i][temp];
					  }

				  }
				  System.out.println(total - total2);
				  System.out.println(total2);
				 
				 
				 
	               
	       
		 } catch(IOException e) {
	            e.printStackTrace();
	        }
	}
	public static boolean random(int[] fix) {
	
			for ( int j = 0; j < fix.length; j++) {
            	for(int k = 0; k < rules.length; k++) {
            		if(rules[k][0] == fix[j]) {
            			for(int l = j; l > -1; l--) {
            				if(rules[k][1] == fix[l]) {
            					int temp = fix[j];
            		            fix[j] = fix[l];
            		            fix[l] = temp;
            					return false;
            				}
            			}
            		}
            	}
            } return true;
		}

	

}
