import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Day3 {
	static int total;
	static boolean check = true;
	static String lmao;

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader("input3"))) {
			String next;
			int start;
			int comma = 0;
			int close;
			int open;
			 int prev = 0;
			boolean check2 = true;

			while ((next = (reader).readLine()) != null) {
				while ((next.indexOf("mul(", prev)) != -1) {
						start = next.indexOf("mul(", prev);
						comma = next.indexOf(",", start);
						close = next.indexOf(")", start);
						open = next.indexOf("(", start);
						check = checkNext(next, prev, start);
						for (int i = open + 1; i < close; i++) {
							Character temp = next.charAt(i);
							if (temp == ',' || Character.isDigit(temp)) {

							} else {
								check2 = false;
							}
						}
						if ((comma - open) <= 4 && (comma - open) > 1 && (close - comma) <= 4 && (close - comma) > 1
								&& check2) {
							int first = Integer.parseInt(next.substring(open + 1, comma));
							int second = Integer.parseInt(next.substring(comma + 1, close));
							System.out.println(first + "  " + second);
							if(check) {
								total += (first * second);
							}
							prev = close;
						} else {
							prev = start + 4;	
							check2 = true;
						}
						

				}
				start = 0;
				prev = 0;
				comma = 0;
				close = 0;
				open = 0;
				check2 = true;
				System.out.println(total);
			}
			System.out.println(total);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkNext(String next, int start, int stop) {
		for (int i = start; i < stop; i++) {
			lmao = next.substring(i, i + 2);
			System.out.println(lmao);
			if (lmao.equals("do")) {
				
				lmao = next.substring(i, i + 4);
				if (lmao.equals("don'")) {
					lmao = next.substring(i, i + 7);
					System.out.println(lmao);
					if (lmao.equals("don't()")) {
						return false;
					}
				} else if (lmao.equals("do()")) {
					System.out.println("1");
					return true;
				}
			}
	
		}		return check;
	}

}
