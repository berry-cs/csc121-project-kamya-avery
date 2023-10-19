import java.util.Objects;

class Player {

	private Posn loc;
	private int vspeed;  // vertical speed

	public Player(Posn loc) {

		this.loc = loc;
		this.vspeed = 0;

	}

	public Player(Posn loc, int vspeed) {

		this.loc = loc;
		this.vspeed = vspeed;

	}

	/** Returns the current speed */
	public int getSpeed() {

		return this.vspeed;

	}

	public Player setSpeed(int value) {

		return new Player(this.loc, value);

	}

	public Player addToSpeed(int amt) {

		return new Player(this.loc, this.vspeed + amt);

	}

	/**
	 * Produces an updated world where the player moves
	 * up or down a little bit, if it hasn't hit the top or
	 * bottom of the screen yet.
	 */
	public Player update() {

		if (this.loc.getY() + this.vspeed > 20 && this.loc.getY() + this.vspeed < 340) {
			return new Player(this.loc.translate(new Posn(0, this.vspeed)), this.vspeed);
		} else {
			return new Player(this.loc, 0);
		}

	}

	public Posn getLoc() {
		
		return this.loc;
		
	}

	public int getX(Posn loc) {

		return (int) loc.getX();

	}

	public int getY(Posn loc) {

		return (int) loc.getY();

	}

	@Override
	public int hashCode() {
		return Objects.hash(loc, vspeed);
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
		return Objects.equals(loc, other.loc) && vspeed == other.vspeed;
	}

	@Override
	public String toString() {
		return "Player [loc=" + loc + ", vspeed=" + vspeed + "]";
	}
	
}

