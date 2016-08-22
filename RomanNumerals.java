import java.io.*;
import java.util.Scanner;

public class RomanNumerals {
	public static void main(String[] args) throws FileNotFoundException {

		File F = new File("roman.txt");
		Scanner s = new Scanner(F);

		 while(s.hasNextLine()){
			String rString = s.nextLine();
		 	int rNum = interpret(rString);
		 	String best = write(rNum);
		 	
		 	if(rString.length() == best.length()){
		 		System.out.println(rString + " is in its most efficient form");
		 	}else{
		 		System.out.println(rString + " written best as: " + best + " would save " + (rString.length()-best.length()) + " characters");
		 	}
		 }

	}

	public static int interpret(String x) {
		int last = read(x.substring(0, 1)), output = 0;

		for (int i = 0; i < x.length(); i++) {
			int cValue = read(x.substring(i, i + 1));

			if (x.equals("III")) {
				output += 3;
				i = x.length();
			} else if (x.equals("II")) {
				output += 2;
				i = x.length();
			} else if (x.equals("I")) {
				output += 1;
				i = x.length();
			} else if (last < cValue) {
				output += cValue - (last * 2);
				last = read(x.substring(i, i + 1));
			} else {
				output += cValue;
				last = read(x.substring(i, i + 1));
			}
		}

		return output;
	}
	

	public static int read(String x) {
		x = x.toUpperCase();

		if (x.contains("I")) {
			return 1;

		} else if (x.contains("V")) {
			return 5;

		} else if (x.contains("X")) {
			return 10;

		} else if (x.contains("L")) {
			return 50;

		} else if (x.contains("C")) {
			return 100;
		} else if (x.contains("D")) {
			return 500;

		} else if (x.contains("M")) {
			return 1000;
		}
		return 0;
	}
	

	public static String write(int x) {
		String output = "";
		while (x != 0) {
			if (x / 1000 != 0) {
				while (x / 1000 != 0) {
					output += "M";
					x -= 1000;
				}
			}
			if (x / 500 != 0) {
				while (x / 500 != 0) {
					if((x+100)/1000 == 1){
						output += "CM";
						x -= 900;
					}else{
						output += "D";
						x -= 500;
					}
				}
			}
			if (x / 100 != 0) {
				while (x / 100 != 0) {
					if((x+100)/500 == 1){
						output += "CD";
						x -= 400;
					}else{
						output += "C";
						x -= 100;
					}
				}
			}
			if (x / 50 != 0) {
				while (x / 50 != 0) {
					if((x+10)/100 == 1){
						output += "XC";
						x -= 90;
					}else{
						output += "L";
						x -= 50;
					}
				}
			}
			if (x / 10 != 0) {
				while (x / 10 != 0) {
					if ((x + 10)/50 == 1) {
						output += "XL";
						x -= 40;
					} else{ 
						output += "X";
						x -= 10;
					}
				}
			}
			if (x / 5 != 0) {
				while (x / 5 != 0) {
					if ((x + 1) /10 == 1) {
						output += "IX";
						x -= 9;
					} else {
						output += "V";
						x -= 5;
					}
				}
			}
			if (x / 1 != 0) {
				while (x / 1 != 0) {
					if ((x + 1)/5 == 1) {
						output += "IV";
						x -= 4;
					} else {
						output += "I";
						x -= 1;
					}
				}
			}
		}

		return output;
	}
}
