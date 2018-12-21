package brd1version1;
import java.util.Scanner;
public class EmiMain {
	private static Scanner sc;

	static double installment(double principal, double rateOfInterest, int periodInMonths, int noOfInstallmentsPerYear) {
		double monthlyInstallmentAmount;
		monthlyInstallmentAmount = (principal * (rateOfInterest / noOfInstallmentsPerYear)) / (1 - 1 / Math.pow((1 + rateOfInterest / noOfInstallmentsPerYear), periodInMonths));
		return monthlyInstallmentAmount;

	}

	public static void main(String[] args) {
		double principal=0.0;
		double rateOfInterest=0.0;// rate of interest
		int totalNoOfInstallments=0;// no of installments for the tenure
		int noOfInstallmentsPerYear=0;// no of installments per year
		int periodInMonths=0;// no of years|period
		double monthlyInstallmentAmount=0.0;// installment amount
		int option2 = 1, option1;
		sc = new Scanner(System.in);
		OUT: do {

			System.out.println("Please enter the following details:\nLoan amount:");
			principal = sc.nextDouble();
			System.out.println("Rate of interest in percent:");
			rateOfInterest = sc.nextDouble();
			System.out.println("Period or tenure of loan in months:");
			periodInMonths = sc.nextInt();
			for (; periodInMonths < 0;) {
				System.out.println("Months can't be negative right! Please enter positive number of months  ");
				periodInMonths = sc.nextInt();

			}
			rateOfInterest = rateOfInterest / 100;
			System.out.println("Enter the number of payments for year:");
			noOfInstallmentsPerYear = sc.nextInt();
			// t=12;
			totalNoOfInstallments = (periodInMonths * noOfInstallmentsPerYear) / 12;
			if (totalNoOfInstallments == 0) {
				System.out.printf("The installment for the given values is:%f\n", (principal + principal * rateOfInterest));
				// System.exit(0);
				continue OUT;
			}

			System.out.println(
					"Enter one among the following options:\n1.Calculate Installment for given conditions\n2.Want to generate the repayment schedule\n3.Installment components for a particular installment:");
			option1 = sc.nextInt();
			switch (option1) {
			case 1: {//
				monthlyInstallmentAmount = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear); // calculation emi
				System.out.printf("%.2f",monthlyInstallmentAmount);
				break;
			}
			case 2: {
				int bc = 0;
				double monthlyInstallment = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear);
				IPComponent ip = new IPComponent(principal, rateOfInterest, noOfInstallmentsPerYear, periodInMonths, monthlyInstallment);
				ip.component(bc);
				break;
			}
			case 3: {
				double x1 = installment(principal, rateOfInterest, totalNoOfInstallments, noOfInstallmentsPerYear);
				System.out.println("Enter the month for which break up is required");
				int installmentNO = sc.nextInt();
				IPComponent ip = new IPComponent(principal, rateOfInterest, noOfInstallmentsPerYear, periodInMonths, x1);
				ip.component(installmentNO);
				break;
			}
			}
			System.out.println("\nDo you want to calculate for some other loan parameter values:\n1.yes\n2.no");
			option2 = sc.nextInt();
			System.out.flush();
		} while (option2 == 1);

	}

}
