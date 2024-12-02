package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.Arrays;


public class Day1 {
	static int[] first = new int[1000];
    static int[] second = new int[1000];
    static int total;
     
	public static int read() {
		int temp = 0;
		int hold;
		for(int i = 0; i < first.length; i++) {
			hold = Math.abs(first[i]-second[i]);
			temp += hold;
		}
		return temp;
	}
	public static void sort(int[] toSort) {
		 for (int i = 0; i < toSort.length; i++) {
		        int min_idx = i;

		        for (int j = i ; j < toSort.length; j++) {
		            if (toSort[j] < toSort[min_idx]) {

		                min_idx = j; 
		            }
		        }

		        int temp = toSort[i];
		        toSort[i] = toSort[min_idx];
		        toSort[min_idx] = temp;
		    }
		 
	}
		
	public static int similar() {
		int temp = 0;
		for(int i = 0; i < first.length ; i++) {
			for(int j = 0; j < second.length ;j++) {
				if(first[i] == second [j]) {
					temp += first[i];
				}
				
			}
		}
		return temp;
	}
	public static void main(String[] args) {
		total = 0;
        try(BufferedReader reader = new BufferedReader (new FileReader("input"))) {
        	String next;
        	int i = 0;
        	while((next = (reader).readLine()) != null ) {
        		first[i] = Integer.parseInt(next.substring(0, 5));
        		second[i] = Integer.parseInt(next.substring(8));
 
        	System.out.println(Arrays.toString(first) + " " + Arrays.toString(second));
        	i++;
        	}
      //  	sort(first);
        //	sort(second);
        	total += similar();

        	System.out.println(total);
        
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
