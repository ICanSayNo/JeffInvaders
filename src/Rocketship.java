import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
int speed;
	Rocketship(int x, int y, int width, int height){
	super(x, y, width, height);
	speed = 20;
	}
void update() {
	super.update();
	}

	void draw(Graphics g) {
		g.drawImage(GamePanel.rocketImg, x, y, width, height, null);
	}
}

