package beans.service;

public class LoanCalculator {
	public float calculateLoan(Long princpal,int noOfYears,float rateOfInt) {
		return (princpal*noOfYears*rateOfInt)/100;
	}
}
