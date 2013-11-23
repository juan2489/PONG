package pong;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JComponent implements MouseMotionListener
{
	JFrame defaultWindow;
	int mouseY = 500;
	int mouseX = 510;
	int ballX = 0;
	int ballY = 0;
	int ballXspeed = 2;
	int ballYspeed = 2;
	int score = 0;
	boolean isinplay = true;
	double rightPaddleX;
	double rightPaddleY;
	Rectangle2D.Double leftPaddle = new Rectangle2D.Double(20, mouseY, 100,
			300);
	Rectangle2D.Double rightPaddle = new Rectangle2D.Double(1750, mouseY, 100, 300);
	Ellipse2D.Double ball = new Ellipse2D.Double(500, 500, 50, 50);

	public static void main(String[] args)
	{
		new Main().getGoing();
	}

	private void getGoing()
	{
		defaultWindow = new JFrame("Juan'sJFrame");
		defaultWindow.setVisible(true);
		defaultWindow.setSize(2000, 1000);
		defaultWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		defaultWindow.add(this);
		defaultWindow.addMouseMotionListener(this);
		
	}

	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.RED);
		g2.draw(leftPaddle);
		leftPaddle.y = mouseY;
		g2.fill(leftPaddle);
		g2.setColor(Color.GREEN);
		// g2.fillOval(ballX, ballY, 50, 50);
		
		g2.draw(rightPaddle);
		g2.setColor(Color.RED);
		g2.fill(rightPaddle);
		g2.setColor(Color.MAGENTA);
		g2.setStroke(new BasicStroke(5F));
		ballX = ballX + ballXspeed;
		ballY = ballY + ballYspeed;
		ball.x = ballX;
		ball.y = ballY;
		g2.fill(ball);
		// g2.drawOval(ballX, ballY, 50, 50);

		if (ball.intersects(leftPaddle))
		{
			score = score + 1;
			ballXspeed = -ballXspeed;
			ballX = 150;
			ballXspeed = ballXspeed  +1;
			ballYspeed = ballYspeed +1;
				
		}
		if (ball.intersects(rightPaddle)&&isinplay)
			             
		{
			ballXspeed = -ballXspeed;
			
		
			
		}
//		if (ballY < 0)
//		{
//			isinplay = false;
//		}
		if (ballY < rightPaddle.y&&isinplay)
		{
			
			rightPaddle.y -= 3;
			
					
		}
		if (ballY > rightPaddle.y&&isinplay)
		{
			rightPaddle.y += 3;
		}
		if (ballY > 1000)

		{
			ballYspeed = -ballYspeed;
          
		}
	     if (ballX < -110)
	     {
//	    	 YOU LoSE 
	    	 JOptionPane.showMessageDialog(null, "You lose");
	    	 ballXspeed = 0;
	    	 ballYspeed = 0;
	     }
		repaint();
		if (ballX > 1950)
			ballXspeed = -ballXspeed;

		if (ballY < 0)
			ballYspeed = -ballYspeed;
		g2.setFont(new Font("Bank Gothic", Font.BOLD, 99));
		g2.drawString(score + "", 1800, 200); 
		
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{

		mouseY = e.getY();
	}
}
