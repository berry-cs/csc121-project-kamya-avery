
// to represent a list of obstacles

import java.util.Objects;

interface ILoO {

}

class MTLoO implements ILoO {
	
	MTLoO() {}
	
}

class ConsLoO implements ILoO {
	
	Obstacle first;
	ILoO rest;
	
	public ConsLoO(Obstacle first, ILoO rest) {
		
		this.first = first;
		this.rest = rest;
		
	}
	
	/* TEMPLATE:
	  public ??? ilobMethod(...) {
	    ... this.first ...     -- Obstacle
	    ... this.rest ...     -- ILoO
	 
	    ... this.first.obstabcleMethod(...) -- ???
	    ... this.rest.ilooMethod(...) -- ???
	}
	*/

	@Override
	public int hashCode() {
		return Objects.hash(first, rest);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsLoO other = (ConsLoO) obj;
		return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
	}

	@Override
	public String toString() {
		return "ConsLoO [first=" + first + ", rest=" + rest + "]";
	}
	
}
