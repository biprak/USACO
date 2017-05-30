/*
ID: bk3721
LANG: JAVA
TASK: ride
 */

import java.io.*;
import java.util.*;

class ride {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String comet = f.readLine();
		String group = f.readLine();

		int len1 = comet.length();
		int len2 = group.length();

		int prod1 = nameToProduct(comet);
		int prod2 = nameToProduct(group); 

		if ((prod1 % 47) == (prod2 % 47)){
			out.println("GO");
		}
		else {
			out.println("STAY");
		}

		out.close();
	}

	public static int nameToProduct(String name) {
		int len = name.length();
		int prod = 1;

		for (int i = 0; i < len; i++){
			char c = name.charAt(i);
			int alphabetValue = Character.getNumericValue(c);
			alphabetValue = alphabetValue - 9;
			prod = prod * alphabetValue;
		}

		return prod;	
	}
}
