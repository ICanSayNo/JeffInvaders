import java.awt.Color;
import java.awt.Graphics;

public class Star extends GameObject {
		Star(int x, int y, int width, int height){
			super(x, y, width, height);
		}
		void update() {
			super.update();
			y+=15;
			if(y>800) {
				isAlive=false;
			}
		}

		void draw(Graphics g) {
			g.setColor(Color.WHITE);
			g.fillRect(x, y, 4, 4);
		}

}
