import processing.core.PApplet;
import processing.core.PImage;

public class ImageLibrary {

	private static PImage fireball_image = null;
	private static PImage player_image = null;
	
	static PImage getFireballImage(PApplet p) {
		if (fireball_image == null) {
    		fireball_image = p.loadImage("fire-ball.png");
    	}
		return fireball_image;
	}
	
	static PImage getSuperHeroImage(PApplet p) {
		if (player_image == null) {
			player_image = p.loadImage("super-hero.png");
    	}
		return player_image;
	}

}
