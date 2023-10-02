import java.util.Objects;

class Player {
	
	Posn loc;

	public Player(Posn loc) {
		
		this.loc = loc;
		
	}
	
	/**
     * Produces an updated world where the player moves
     * up or down a little bit, if it hasn't hit the top or 
     * bottom of the screen yet.
     */
	
    public Player update(float m) {        
    	
    	if (this.loc.getY() > 0 || this.loc.getY() < 400) {
            return new Player(this.loc.translate(new Posn(0, m)));
        } else {
            return this;
        }
    	
    }

	@Override
	public int hashCode() {
		return Objects.hash(loc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(loc, other.loc);
	}

	@Override
	public String toString() {
		return "Player [loc=" + loc + "]";
	}

}
