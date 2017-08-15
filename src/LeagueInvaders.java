import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	final static int frameHeight=800;
	final static int frameWidth=500;
	GamePanel gamePanel;
	public LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
		frame.addKeyListener(gamePanel);
		setup();
	}
	public static void main(String[] args) {
		LeagueInvaders l = new LeagueInvaders();
	}
	void setup() {
		frame.add(gamePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(frameWidth, frameHeight);
		gamePanel.startGame();
	}
}
