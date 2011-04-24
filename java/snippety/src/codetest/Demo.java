package codetest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Demo class for Snippety
 * 	Input:
 * 		stdin => document
 *  	command line parameter => query
 *  Output:
 *  	stdout => snippet string
 */
public class Demo {
	public static void main(String[] args) throws IOException  {
		// query as command argument
		StringBuffer query = new StringBuffer();
		for(int i = 0; i < args.length; i++){
			if(i!=0) query.append(' ');
			query.append(args[i]);
		}
		
		// document is from stdin
		StringBuffer document = new StringBuffer();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = null;
		while((line = br.readLine()) != null){
			document.append(line);
			document.append('\n');
		}
		
		// generate snippet
		Snippety snippety = new Snippety();
		String snippet = snippety.highlight(document.toString(), query.toString());
		System.out.println(snippet);
		
	}
}
