import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Day4 {

	public static void main(String[] args) {	
		int total = 0;
		 try(BufferedReader reader = new BufferedReader (new FileReader("input4"))) {
	        	String next = reader.readLine();
	        	int length = next.length();
	        	char[][] letter= new char[140][length];
	        	int i = 0;
	        	do {
	        		for(int j = 0; j < next.length(); j++) {
	        			letter[i][j] = next.charAt(j);
	        		}
	        		i++;
	        	}
	        	while((next = (reader).readLine()) != null );
	        	
	        	for ( i = 0; i < letter.length ; i++) {
	                // Loop through each element in the row
	                for ( int j = 0; j < letter[i].length; j++) {
	                	//System.out.print(letter[i][j]);
	                    if(letter[i][j] == 'A' && i > 0 && j > 0 && i < 139 && j < length - 1) {
	                    	
	                    	if(letter[i-1][j - 1] == 'M' && letter[i+1][j - 1] == 'M') { // m left
	                    		if(letter[i-1][j + 1] == 'S' && letter[i+1][j + 1] == 'S') { // m right
	                    			total++;
	                				System.out.println("" + i + " " + j + " " + 1);
		                    	}
	                    	}
	                    	if(letter[i-1][j - 1] == 'M' && letter[i-1][j + 1] == 'M') { // m top
	                    		if(letter[i+1][j - 1] == 'S' && letter[i+1][j + 1] == 'S') { // bottom
	                    			total++;
	                				System.out.println("" + i + " " + j + " " + 2);
		                    	}
	                    	}
	                    	if(letter[i-1][j + 1] == 'M' && letter[i+1][j + 1] == 'M') { // m right
	                    		if(letter[i-1][j - 1] == 'S' && letter[i+1][j - 1] == 'S') {
	                    			total++;
	                				System.out.println("" + i + " " + j + " " + 3);
	                    		}
	                    	}
	                    	if(letter[i+1][j - 1] == 'M' && letter[i+1][j + 1] == 'M') { // bottom
	                    		if(letter[i-1][j - 1] == 'S' && letter[i-1][j + 1] == 'S') { 
	                    			total++;
	                				System.out.println("" + i + " " + j + " " + 4);
	                    		}
	                    	}
	                    }
	                } 
	               // System.out.println(" ");
	            }
				/*
				 * for ( i = 0; i < letter.length ; i++) { // Loop through each element in the
				 * row for ( int j = 0; j < letter[i].length; j++) {
				 * //System.out.print(letter[i][j]); if(letter[i][j] == 'X') {
				 * 
				 * if(j > 2 && letter[i][j - 1] == 'M') { if(letter[i][j-2] == 'A') {
				 * if(letter[i][j-3] == 'S') { total++; System.out.println("yay" + i + " " + j);
				 * } } } if(j < length - 3 && letter[i][j + 1] == 'M') { if(letter[i][j+2] ==
				 * 'A') { if(letter[i][j+3] == 'S') { total++; System.out.println("yay" + i +
				 * " " + j); } } } if(i > 2 && letter[i-1][j] == 'M') { if(letter[i-2][j] ==
				 * 'A') { if(letter[i-3][j] == 'S') { total++; System.out.println("yay" + i +
				 * " " + j); } } } if(i < 137 && letter[i+1][j] == 'M') { if(letter[i+2][j] ==
				 * 'A') { if(letter[i+3][j] == 'S') { total++; System.out.println("yay" + i +
				 * " " + j); } } } if(i > 2 && j > 2 && letter[i-1][j-1] == 'M') {
				 * if(letter[i-2][j-2] == 'A') { if(letter[i-3][j-3] == 'S') { total++;
				 * System.out.println("yay" + i + " " + j); } } } if(i > 2 && j < length - 3 &&
				 * letter[i-1][j+1] == 'M') { if(letter[i-2][j+2] == 'A') { if(letter[i-3][j+3]
				 * == 'S') { total++; System.out.println("yay" + i + " " + j); } } } if(i < 137
				 * && j > 2 && letter[i+1][j-1] == 'M') { if(letter[i+2][j-2] == 'A') {
				 * if(letter[i+3][j-3] == 'S') { total++; //System.out.println("yay" + i + " " +
				 * j); } } } if(i < 137 && j < length - 3 && letter[i+1][j+1] == 'M') {
				 * if(letter[i+2][j+2] == 'A') { if(letter[i+3][j+3] == 'S') { total++;
				 * //System.out.println("yay" + i + " " + j); } } } } } //
				 * System.out.println(" "); }
				 */
	      //  	sort(first);
	        //	sort(second);
	        	
	        	System.out.println(total);
	        
	        } catch(IOException e) {
	            e.printStackTrace();
	        }
	}

}
