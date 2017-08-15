import java.awt.Graphics;

public class gameObject {
	int x;
	int y;
	int width;
	int height;
void update(){
	x++;
	y++;
	width=100;
	height=100;
}
void draw(Graphics g) {
	g.fillRect(x, y, width, height);
}
}
