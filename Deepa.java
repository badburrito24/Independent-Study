import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Deepa {

	public static void main(String[] args) throws FileNotFoundException {
		File deepa = new File("./deepa.dat");
		Scanner file = new Scanner(deepa);

		int cases = file.nextInt();

		for (int i = 0; i < cases; i++) {
			int bracketCount = file.nextInt();
			int income = file.nextInt();

			// arrays
			int[] amounts = new int[bracketCount];
			int[] percents = new int[bracketCount];

			for (int j = 0; j < bracketCount; j++) {
				amounts[i] = file.nextInt();
				percents[i] = file.nextInt();

			}
			calcTax(amounts, percents, income);

		}
	}

	public static double calcTax(int[] amount_array, int[] percent_array, int balance) {
		double tax = 0;
		for (int i = 0; i < amount_array.length - 1; i++) {
			if ((i + 1) != amount_array.length) {
				double taxableAmount = Math.min((amount_array[i + 1] - amount_array[i]), balance);
				tax += (taxableAmount * (percent_array[i] / 100));
				balance -= taxableAmount;
			} else {
				tax += (balance * (percent_array[i] / 100));
			}
		}

		System.out.println(tax);
		return tax;

	}
}
