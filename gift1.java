/*
ID: bk3721
LANG: JAVA
TASK: gift1
 */

import java.io.*;
import java.util.*;

public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		int NP = Integer.parseInt(f.readLine());

		Map<String, Integer> balance = new LinkedHashMap<String, Integer>();

		for (int i = 0; i < NP; i++){
			String p = f.readLine();
			balance.put(p, 0);
		}

		for (int j = 0; j < NP; j++) {
			String p = f.readLine();
			StringTokenizer st = new StringTokenizer(f.readLine());

			int giving = Integer.parseInt(st.nextToken());
			int numPeople = Integer.parseInt(st.nextToken());

			if (numPeople != 0) {
				int toGive = giving/numPeople; 
				int leftOver = giving % numPeople; 

				int oldValue = balance.get(p);
				int newValue = oldValue - giving + leftOver; 
				balance.put(p, newValue);

				for (int k = 0; k < numPeople; k++) {
					String pReceive = f.readLine();
					oldValue = balance.get(pReceive);
					newValue = oldValue + toGive; 
					balance.put(pReceive, newValue);
				}
			}

		}

		for (String key : balance.keySet()) {
		    out.println(key + " " + balance.get(key));
		}

		out.close();
	}

}
