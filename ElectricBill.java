package ElectricalBills;

//Venus H
//1048875
//CIS 084
//Java Programming
//Feb 27 to March 5 Lab Assignment

import java.util.InputMismatchException;
import java.util.Scanner;

public class ElectricBill {

        public static final int TIER1_LIMIT = 350;
        public static final int TIER2_LIMIT = 1450;
        public static final int TIER3_LIMIT = Integer.MAX_VALUE;

        public static final double TIER1_RATE = 0.23;
	public static final double TIER2_RATE = 0.29;
	public static final double TIER3_RATE = 0.45;
	public static final double ENERGY_TAX_RATE = 0.20;;

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		do {
			double kWh = 0;
			double tier1_kWh = 0;
			double tier2_kWh = 0;
			double tier3_kWh = 0;
			double tier1_bill = 0;
			double tier2_bill = 0;
			double tier3_bill = 0;
			double energy_tax = 0;
			double total_bill = 0;

			try {
				System.out.print("Please enter the number of kWh: ");
				kWh = userInput.nextDouble();

				if (kWh < 0) {
					System.out.println("Invalid input. Please enter a positive number.");
					continue;
				} else if (kWh == 0) {
					System.out.println("The number of kWh cannot be zero.");
					continue;
				}

			} catch (InputMismatchException e) {
				System.out.println("You have entered an invalid number. Please enter a number.");
				userInput.nextLine();
				continue;
			}

			if (kWh > TIER2_LIMIT) {
				tier3_kWh = kWh - TIER2_LIMIT;
				tier2_kWh = TIER2_LIMIT - TIER1_LIMIT;
				tier1_kWh = TIER1_LIMIT;
			} else if (kWh > TIER1_LIMIT) {
				tier2_kWh = kWh - TIER1_LIMIT;
				tier1_kWh = TIER1_LIMIT;
			} else {
				tier1_kWh = kWh;
			}

			tier1_bill = tier1_kWh * TIER1_RATE;
			tier2_bill = tier2_kWh * TIER2_RATE;
			tier3_bill = tier3_kWh * TIER3_RATE;
			energy_tax = ENERGY_TAX_RATE;
			total_bill = tier1_bill + tier2_bill + tier3_bill + energy_tax;

			System.out.println("Tier 1 kWh: " + tier1_kWh);
			System.out.println("Tier 2 kWh: " + tier2_kWh);
			System.out.println("Tier 3 kWh: " + tier3_kWh);
			System.out.println("Tier 1 bill: $" + String.format("%.2f", tier1_bill));
			System.out.println("Tier 2 bill: $" + String.format("%.2f", tier2_bill));
			System.out.println("Tier 3 bill: $" + String.format("%.2f", tier3_bill));
			System.out.println("Energy tax: $" + String.format("%.2f", energy_tax));
			System.out.println("Total bill: $" + String.format("%.2f", total_bill));

			System.out.print("Do you want to calculate another bill? (Y/N): ");
			String answer = userInput.next();
			if (!answer.equalsIgnoreCase("Y")) {
				break;
			}
		} while (true);

		userInput.close();

	}
}
        
