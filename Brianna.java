import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Brianna {

	public static void main(String[] args) throws FileNotFoundException {
		File brianna = new File("./brianna.dat");
		Scanner file = new Scanner(brianna);
		int min = file.nextInt();
		int max = file.nextInt();
		int range = 0;
		while (file.hasNextInt()) {
			int current = file.nextInt();
			if (current < min)
				min = current;
			if (current > max)
				max = current;
		}
		System.out.println(min + " " + max + " " + (max-min));

	}

}
