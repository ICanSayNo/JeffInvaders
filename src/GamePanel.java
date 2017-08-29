import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState=MENU_STATE;
	Font titleFont;
	Rocketship r = new Rocketship(250,700,50,50);
	ObjectManager o = new ObjectManager();
	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;

	
	
public GamePanel() {
	timer = new Timer(1000/60, this);
	titleFont = new Font("Comic Sans MS", Font.PLAIN, 48);
	o.addObject(r);
	try {
		alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
		rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
		bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

void startGame() {
	timer.start();
}
public void paintComponent(Graphics g){
		if(currentState == MENU_STATE){
			drawMenuState(g);
		}else if(currentState == GAME_STATE){
			drawGameState(g);
		}else if(currentState == END_STATE){
			drawEndState(g);
		}

}
void updateMenuState(){
	
}
void updateGameState(){
	o.update();
	o.manageEnemies();
	o.manageStars();
	if(!r.isAlive){
		currentState=2;
		o.reset();
		r=new Rocketship(250,700,50,50);
		o.addObject(r);
	}
	
}
void updateEndState() {
	
}
void drawMenuState(Graphics g){
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.frameWidth, LeagueInvaders.frameHeight);
	g.setColor(Color.GREEN);
	g.setFont(titleFont); 
	g.drawString("League Invaders", 70, 400);

}
void drawGameState(Graphics g){
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.frameWidth, LeagueInvaders.frameHeight);
	o.draw(g);
	o.checkCollision();
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.frameWidth, LeagueInvaders.frameHeight);
	g.setColor(Color.BLACK);
	g.setFont(titleFont); 
	g.drawString("OH NOES!", 70, 400);
	g.setColor(Color.BLACK);
	g.setFont(titleFont); 
	g.drawString("UR IS DED!", 70, 500);
	g.setColor(Color.BLACK);
	g.setFont(titleFont); 
	g.drawString("SKOR: "+o.getScore(), 70, 600);
}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
			if(currentState == MENU_STATE){
				updateMenuState();
			}else if(currentState == GAME_STATE){
				updateGameState();
			}else if(currentState == END_STATE){
				updateEndState();
			}


	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("jeff");
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == (KeyEvent.VK_SPACE)) {
			o.addObject(new Projectile(r.x+20, r.y, 10, 10));
		}
		if(e.getKeyCode() == (KeyEvent.VK_ENTER)) {
			if(currentState == MENU_STATE){
				currentState=GAME_STATE;
			}else if(currentState == GAME_STATE){
				currentState=END_STATE;
			}else if(currentState >= END_STATE){
				currentState=MENU_STATE;
			}
			System.out.println(currentState);
		}

		
		 if(e.getKeyCode() == (KeyEvent.VK_LEFT)) {
			if(r.x>0) {
				r.x-=r.speed;
			}
		}
		else if(e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
			if(r.x<450) {
				r.x+=r.speed;
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("jeff");
	}
	

}
