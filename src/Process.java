import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Process {
	static Stacks s = new Stacks();
	public static void main(String[] args) {
		
		/*
		Scanner scan = new Scanner(System.in);
		StringBuilder expression = new StringBuilder(scan.nextLine());	
		scan.close();
		*/
		File file = new File(args[0]);
		BufferedReader br;
		StringBuilder expression = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			expression = new StringBuilder(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		expression.append("#");
		s.push('#');
		
		for(int i = 0; i < expression.length(); i++) {
			char out = expression.charAt(i);
			try {
				while(Operator.pri_compare(s.pri_peek(), out) == '>') {
					s.Process(s.pri_peek_index());
					System.out.println("R");
				}
				if(Operator.pri_compare(s.pri_peek(), out) == '=' && out == '#')return;
				s.push(out);
				System.out.println("I" + out);
			} catch (Error e) {
				System.out.print(e);
				break;
			}
		}
		
	}

}
