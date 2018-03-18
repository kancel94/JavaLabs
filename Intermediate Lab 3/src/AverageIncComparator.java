import java.util.Comparator; //import comparator class

public class AverageIncComparator implements Comparator<BankRecords>  //class for comparing objects
{
	public int compare(BankRecords o1, BankRecords o2) //compare 2 objects (income)
	{
		return Double.compare(o1.getIncome(), o2.getIncome()); //have to use Double.compare since this deals with money and not integers/string
	}
}
