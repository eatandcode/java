package randomgame;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class RandomPanel 
{
	JPanel panel = new JPanel();
	JPanel infoPanel = new JPanel();
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label;
	int i;
	//int[] score=new int[3];
	int x;
	JFrame frame = new JFrame();
	private int WINDOW_WIDTH = 800;
	private int WINDOW_HEIGHT = 600;
	Random rand = new Random();
	BorderLayout border = new BorderLayout();
	
	public static void main(String[] args) throws IOException
	{
	   new RandomPanel();
	}
	
	
	public RandomPanel() throws IOException
	{	
		JWindow window = new JWindow();
		window.getContentPane().add(
		new JLabel("loading...", new ImageIcon(new URL("https://cdn.dribbble.com/users/710124/screenshots/2556521/x.gif")), SwingConstants.CENTER));
		//https://cdn.dribbble.com/users/710124/screenshots/2556521/x.gif
		window.setBackground(Color.BLACK);
		window.setBounds(500, 150, 300, 200);
		window.setVisible(true);
		try 
		{
		    Thread.sleep(4000);
		} 
		catch (InterruptedException e) 
		{
		    e.printStackTrace();
		}
		window.setVisible(false);
		
		frame = new JFrame();
		//frame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		frame.setPreferredSize(new Dimension(700, 600));
		frame.setLayout(new GridLayout(2,1));
		frame.setTitle("Random Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setLocationRelativeTo(window);
		buildInfoPanel();
		buildPanel();
		frame.add(infoPanel, border.NORTH);
		frame.add(panel, border.SOUTH);
		frame.pack();
		frame.setVisible(true);
		
	}
	public void buildInfoPanel() throws MalformedURLException
	{
		infoPanel = new JPanel();
		infoPanel.setBackground(Color.YELLOW);
		JLabel label = new JLabel(new ImageIcon(new URL("https://i.pinimg.com/originals/c4/85/25/c48525fa2233aeb354c5cdc03befadb5.jpg")), SwingConstants.CENTER);
		JLabel textLabel = new JLabel("LETS PLAY A GAME\n");
		JLabel scoreLabel = new JLabel("\nScore: " + x);
		infoPanel.add(label, border.NORTH);
		infoPanel.add(textLabel, border.CENTER);
		infoPanel.add(scoreLabel,border.NORTH);
		
	}
	public void buildPanel()
	{
		panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		button1 = new JButton ("Button 1");
		button2 = new JButton ("Button 2");
		button3 = new JButton ("Button 3");
		
		button1.addActionListener (new ButtonListener());
		button2.addActionListener (new ButtonListener());
		button3.addActionListener (new ButtonListener());
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
	}

	private class ButtonListener implements ActionListener
    {
		public void actionPerformed (ActionEvent event)
		{
			/* i randomly is set to 1, 2 or 3. 
			 * if i = 2 the panel will change to green and you can continue playing
			 * if i = 1 or 3, you loose and play again.
			 */
			i = rand.nextInt(3);			
			
				if (i == 2)
				{
					x+=1;	
					panel.setBackground(Color.GREEN);
					infoPanel.setBackground(Color.GREEN);
					JOptionPane.showMessageDialog(null, "you win\nyour score is: " +x);
					
					panel.setBackground(Color.YELLOW);
					infoPanel.setBackground(Color.YELLOW);
					//for(int x=0;x<score.length;x++)
						//score[x]=score[x+1] ;	
				}
				else
				{
					//System.exit(0);
					JOptionPane.showMessageDialog(null,"you lose");
				}
			
		}
   }
}
