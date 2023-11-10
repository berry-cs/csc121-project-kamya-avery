
// to represent a list of obstacles

import java.util.Objects;

import processing.core.PApplet;

interface ILoO {
	
	/** update all the obstacles in this list */
	ILoO update();

	/** draw all the obstacles in this list */
	PApplet draw(PApplet p);

	/** produce a list with all obstacles removed that have reached x <= 1 */
	ILoO removeEscaped();

	/** determine if any of the obstacles in this list have hit the given loc */
	boolean anyCollided(Posn loc);

}

class MTLoO implements ILoO {
	
	MTLoO() {}

	@Override
	public ILoO update() {
		return this;
	}

	@Override
	public PApplet draw(PApplet p) {
		return p;
	}

	@Override
	public ILoO removeEscaped() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public boolean anyCollided(Posn loc) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

class ConsLoO implements ILoO {
	
	Obstacle first;
	ILoO rest;
	
	public ConsLoO(Obstacle first, ILoO rest) {
		
		this.first = first;
		this.rest = rest;
		
	}
	

	@Override
	public ILoO update() {
		return new ConsLoO(this.first.update(), this.rest.update());
	}

	@Override
	public PApplet draw(PApplet p) {
		this.first.draw(p);
		this.rest.draw(p);
		return p;
	}
	
	@Override
	public ILoO removeEscaped() {
		// TODO Auto-generated method stub
		return this;
	}
	
	@Override
	public boolean anyCollided(Posn loc) {
		return this.first.anyCollide(loc) || this.rest.anyCollided(loc);
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
