import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Deepa {

	public static void main(String[] args) throws FileNotFoundException {
		File deepa = new File("./deepa.dat");
		Scanner file = new Scanner(deepa);
		double taxRate = 0;
		int cases = file.nextInt();
		file.nextLine();

		for (int i = 0; i < cases; i++) {
			int bracketCount = file.nextInt();
			double income = file.nextInt();
			file.nextLine();

			// arrays
			double[] amounts = new double[bracketCount];
			double[] percents = new double[bracketCount];

			for (int j = 0; j < bracketCount; j++) {
				amounts[j] = file.nextInt();
				percents[j] = file.nextInt();
				file.nextLine();
			}
			//System.out.println(Arrays.toString(amounts));
			//System.out.println(Arrays.toString(percents));
			taxRate = ((calcTax(amounts, percents, income)) / income) * 100;
			System.out.println("Case #" + (i + 1) + ": " + calcTax(amounts, percents, income) + " " + taxRate);

		}
	}

	public static double calcTax(double[] amount_array, double[] percent_array, double balance) {
		double tax = 0;
		double taxableAmount = 0;

		for (int i = 0; i < amount_array.length - 1; i++) {
			double percent = percent_array[i];
			taxableAmount = Math.min((amount_array[i + 1] - amount_array[i]), balance);
			tax += (taxableAmount * (percent / 100.0));
			balance -= taxableAmount;

		}
		double percent = percent_array[percent_array.length - 1];
		tax += (balance * (percent / 100));

		// System.out.println(tax);

		return tax;

	}

}