import java.util.Comparator; //import comparator class

public class FemaleMortComparator implements Comparator<BankRecords> //class for comparing objects
{
	public int compare(BankRecords o1, BankRecords o2)
	{
		int results = o1.getSex().compareTo(o2.getSex()); //compare 2 objects (male vs female)
		
		//sort it again for mortgage
		if (results != 0)  //if results are not 0
		{ 
			return results; //return the results
		}
		return o1.getMortgage().compareTo(o2.getMortgage()); //return comparing mortgages
	}
}
