import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {
 static Character[][] map;
 static  boolean[][] checkMap;
 static int i;
 static int j;
 static Direction point;
 static boolean inMap = true;
 static int total;
 static int count;
 static int first;
 static int second;
 static int watch;
 static int startX;
 static int startY;
 static int counting = 0;
 static Direction up = new Direction(){
	 public void change() {
			point = right;
		}
		public void move() {
			if(i > 0 && map[i-1][j] == '#') {
				point.change();
				count++;
			}else {
				if( i == -1) {
					inMap = false;
				}else {

				//checkMap[i][j] = true;
				i--;
				//System.out.println(i + " " + j);  
				}
							}	
			
		}
 };
 static Direction right = new Direction(){
	 public void change() {
			point = down;
			count++;
		}
		public void move() {
			if(j < 129 && map[i][j+1] == '#') {
				point.change();
			}else {
				if(j == 131) {
					inMap = false;
				}else {
				//checkMap[i][j] = true;
				j++;
				//System.out.println(i + " " + j);  
				}
				
			}	
		}
 };
static Direction down = new Direction(){
	 public void change() {
			point = left;
			count++;
		}
		public void move() {
			if(i < 129 && map[i+1][j] == '#') {
				point.change();
			}else {
				if(i == 131) {
					inMap = false;
				}else {
				//checkMap[i][j] = true;
				i++;
				//System.out.println(i + " " + j);  
				}
				
			}	
		}
 };
 static Direction left = new Direction(){
	 public void change() {
			point = up;
			count++;
		}
		public void move() {
			if(j > 0 && map[i][j-1] == '#') {
				point.change();
			}else {
				if(j <= -1) {          
					inMap = false;       
				}else {       
				 //checkMap[i][j] = true;
				 j--;
				//System.out.println(i + " " + j);  
				}

			}	
		}
 };
	public static void main(String[] args) {
		int total = 0;
		
		 try(BufferedReader reader = new BufferedReader (new FileReader("input6"))) {
			 String next = reader.readLine();
			 map = new Character[130][next.length()];
			 checkMap = new boolean[130][next.length()];
			
			 
			 point = up;
			
			 int x = 0;
			 do {
	        		for(int y = 0; y < next.length();y++) {
	        			map[x][y] = next.charAt(y);
	        			if(map[x][y] == '^') {
	        				i = x;
	        				j = y;
	        				startX = i;
	        				startY = j;
	        			}
	        		}
	        		x++;
	        	}while((next = (reader).readLine()) != null );
	               
				/*
				 * while(inMap) { point.move(); }
				 */
			 
			 for(x = 0; x < map.length; x++) {
				 for(int y = 0; y < map[x].length; y++) {
					 counting ++;
					// System.out.println(map[x][y]);
					 if(map[x][y].equals('.')) {
						
						 map[x][y] = '#';
						 count = 0;
						 first = 0;
						 second = 0;
						 watch = 0;
						 inMap = true;
						 while(inMap) { 
							 point.move();
							
							 if(count % 4 == 0) {
								// System.out.println(first + " " + i + " " + second + " " + j + " " + counting + " " + count);
								 if(first == i && second == j) {
									
									 watch += 1;
									
								 }else {
									 
									 watch = 0;
								 }
								 
								 first = i;
								 second = j;
							 }
							
							 if(count > 10000 || watch > 5) {
								 checkMap[x][y] = true;
								 inMap = false;
							 }
						 }
						 i = startX;
						j = startY;
						point = up;
						 map[x][y] = '.';
					 }
				 }
			 }
			 for ( x = 0; x < map.length ; x++) {
				 //System.out.println(x);
	                // Loop through each element in the row
	                for ( int y = 0; y < map[x].length; y++) {
	                	if(checkMap[x][y]) {
	                	
	                	total++;
	                	}
	                    
	                } 
	               //System.out.println(" ");
	            }
			 System.out.print(total);
		 } catch(IOException e) {
	            e.printStackTrace();
	        }
	}
	public interface Direction{
		public void change();
		public void move();
	}
	
}
