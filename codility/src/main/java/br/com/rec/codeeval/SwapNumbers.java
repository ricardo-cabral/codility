package br.com.rec.codeeval;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SwapNumbers {

	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		//System.out.println(file.exists());
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		while ((line = buffer.readLine()) != null) {
			line = line.trim();
			//System.out.println(line);
			// Process line of input Here
			String[] words = line.split(" ");
			StringBuffer result = new StringBuffer();
			for (String string : words) {
				//System.out.println(string);
				// System.out.println(string.substring(0,1));
				// System.out.println(string.substring(string.length()-1,
				// string.length()));

				result.append(string.substring(string.length() - 1,
						string.length()));
				result.append(string.substring(1, string.length() - 1));
				result.append(string.substring(0, 1) + " ");
				result.toString();
			}
			System.out.println(result.toString());
		}
	}

}
