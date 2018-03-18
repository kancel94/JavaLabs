import java.util.Comparator; //import comparator class

public class RegionComparator implements Comparator<BankRecords> //class for comparing objects
{
	public int compare(BankRecords o1, BankRecords o2) //compare these 2 objects (regions)
	{
		return o1.getRegion().compareTo(o2.getRegion()); //return it
	}
}

