package space;

import java.util.ArrayList;


public class Mission implements Comparable<Mission>
{
	private String			destination;
	private float			cost;
	
	
	public Mission(String destination, Float cost)
	{
		this.destination = destination;
		this.cost = cost;
	}
	
	
	public String getDestination()
	{
		return destination;
	}
	
	
	public float getCost()
	{
		return cost;
	}

	// Compare by cost, then by destination.
	public int compareTo(Mission that) 
	{ 		

		int costComparison = Float.compare(this.cost, that.cost);
    	if (costComparison != 0) {
        return costComparison;
    }
    	return this.destination.compareTo(that.destination);

	}
	
	
	// Let compareTo() do the work. This method should just be 1 line.
	public boolean equals(Object x)
	{
		if (this == x) return true;
		if (x == null || this.getClass() != x.getClass()) return false;
		return this.compareTo((Mission) x) == 0;
	}
	
	// Return the destination’s hash code.
	public int hashCode()
	{
		// hints: use Java String hashCode() Method
		return destination.hashCode();
	}
	
	
	public String toString()
	{
		return "Mission to " + destination + " will cost " + cost;
	}
}
