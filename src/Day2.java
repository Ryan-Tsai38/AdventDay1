import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Day2 {
	static Node head = null;
	static boolean check = false;
	static boolean state = true;
	static boolean lmao = true;
	static boolean precheck = false;
 	static int total = 0;
	public Day2() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		
        try(BufferedReader reader = new BufferedReader (new FileReader("input2"))) {
        	String next;
        	int i = 0;
        	while((next = (reader).readLine()) != null ) {
        		Scanner scanner = new Scanner(next);
        	
        		while(scanner.hasNext()) {
        			i = Integer.parseInt(scanner.next());
        			if(head != null && lmao) {
        				if(head.getDatum() < i) {
        					state = true;
        				}else {
        					state = false;
        				}
        				lmao = false;
        				head = new Node(i, head);
        				if(Math.abs(head.getDatum() - head.getNext().getDatum()) > 3 || head.getNext().getDatum() == i){
        					if(precheck == true) {
        						check = true;
        					}
        					else {
        						precheck = true;
        						head = head.getNext();
        					
        					}
        					}
        		
        			}else {
        				addFront(i);
        			}
        			
        			}
        		Node temp = head;
        		while(temp != null) {
        			System.out.print(temp.getDatum() + " ");
        			temp = temp.getNext();
        		}
        		
        		if(!check) {
        			total++;
        			System.out.print("yay");
        		}
        		System.out.println(" ");
        		check = false;
        		head = null;
        		lmao = true;
        	}
      //  	sort(first);
        //	sort(second);
        	
        	System.out.println(total);
        
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
	public static void addFront(int item) {
		head = new Node(item, head);
		if((head.getNext() != null)) {
				if(state && (head.getDatum() <= head.getNext().getDatum() || Math.abs(head.getDatum() - head.getNext().getDatum()) > 3)) {
					if(precheck == true) {
						check = true;
					}
					else {
						precheck = true;
						head = head.getNext();
					
					}
		}else if(!state && (head.getDatum() >= head.getNext().getDatum() || Math.abs(head.getDatum() - head.getNext().getDatum()) > 3)) {
			if(precheck == true) {
				check = true;
			}
			else {
				precheck = true;
				head = head.getNext();
			
			}
				}
		}
	}
}
