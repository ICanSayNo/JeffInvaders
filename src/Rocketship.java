import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Rocketship extends GameObject {
int x;
int y;
int width;
int height;
int speed;
	Rocketship(int x, int y, int width, int height){
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	speed = 20;
	}
void update() {
		
	}

	void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);

	}
}

