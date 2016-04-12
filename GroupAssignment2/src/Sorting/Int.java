package Sorting;

import java.util.Random;

public class Int implements Comparable, Ordered
{
	public int num;
		
	public Int(int num)
	{
		this.num = num;
	}
	
	
	//Method follows for sorting
	public boolean follows(Object other) {
		
		if(other == null)
			return false;
		else if(!(other instanceof Int))
			return false;
		else
		{
			Int otherInt = (Int) other;
			return (otherInt.precedes(this));
		}
	}
	
	
	//Method precedes for sorting
	public boolean precedes(Object other) {
		
		if(other == null)
			return false;
		else if(!(other instanceof Int))
			return false;
		else
		{
			Int otherInt = (Int) other;
			return (this.num < otherInt.num);
		}
	}

	
	//Method compareTo for sorting
	public int compareTo(Object other) {
		int result = 0;
		if(this.num > ((Int) other).num)
		{
			result = 1;
		}
		else if(this.num < ((Int) other).num)
		{
			result = -1;
		}
		else if(this.num == ((Int) other).num)
		{
			result = 0;
		}
		
		return result;
	}

}
