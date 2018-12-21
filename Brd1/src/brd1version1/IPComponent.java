package brd1version1;

public class IPComponent {
	double principal, rateOfInterest;
	int noOfInstallmentsPerYear, periodInMonths;
	double monthlyInstallmentAmount;
	int count1 = 0,count2=0;

	public IPComponent(double principal, double rateOfInterest, int noOfInstallmentsPerYear, int periodInMonths, double monthlyInstallment) {
		this.principal = principal;	this.rateOfInterest = rateOfInterest;	this.noOfInstallmentsPerYear = noOfInstallmentsPerYear;	this.periodInMonths = periodInMonths;	this.monthlyInstallmentAmount = monthlyInstallment;
  }

	void component(int installmentNo) {
			float[] interestComponent = new float[periodInMonths + 1];
			float[] principalComponent = new float[periodInMonths + 1];
			float[] outstandingPrincipal = new float[periodInMonths + 1];
			outstandingPrincipal[0] = (float) principal;
			for (int monthNo = 0; monthNo < periodInMonths; monthNo++) {
				interestComponent[monthNo] = (outstandingPrincipal[monthNo]) * ((float) rateOfInterest) /12.0f;                 //((float)t*12.0f);        
				principalComponent[monthNo] = ((float) monthlyInstallmentAmount - interestComponent[monthNo]);
				if (monthNo < periodInMonths) {
					outstandingPrincipal[monthNo + 1] = outstandingPrincipal[monthNo] - principalComponent[monthNo];
					if (count1++ == 0&&installmentNo==0)
						System.out.println("s.no          O/s   \t     I               P         Installment");
					if (installmentNo == 0)
						System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (monthNo + 1), outstandingPrincipal[monthNo], interestComponent[monthNo], principalComponent[monthNo], monthlyInstallmentAmount);
				} else {
					outstandingPrincipal[periodInMonths] = outstandingPrincipal[monthNo] - principalComponent[monthNo];
				}

			}
			if (installmentNo != 0) {
				int b1 = installmentNo - 1;
				try {
					if (periodInMonths >= installmentNo)

					{
						if (count2++ ==0)

							System.out.println("\ns.no          O/s   \t     I               P         Installment");
					}
					System.out.printf("%d\t%10.2f\t%10.2f\t%10.2f\t%10.2f\n", (b1), outstandingPrincipal[b1], interestComponent[b1], principalComponent[b1], monthlyInstallmentAmount);
				} catch (IndexOutOfBoundsException ex1) {
					System.out.printf(
							"You entered the tenure for \"%d months\" and trying to retrieve the break component for the \"%dth month\"!\n",
							periodInMonths, installmentNo);
				}
			}

	}

}
