import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class StopWatch implements ActionListener {
	
	JFrame frame = new JFrame();
	JLabel timeLabel = new JLabel();
	JButton startButton = new JButton("Start");
	JButton resetButton = new JButton("Reset");
	int elapsedTime = 0;
	int hours = 0;
	int minutes = 0;
	int seconds = 0;
	String string_hours = String.format("%02d", hours);
	String string_minutes = String.format("%02d", minutes);
	String string_seconds = String.format("%02d", seconds);
	boolean started = false;
	
	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			elapsedTime += 1000;
			hours = (elapsedTime/ 3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			
			String string_hours = String.format("%02d", hours);
			String string_minutes = String.format("%02d", minutes);
			String string_seconds = String.format("%02d", seconds);
			
			timeLabel.setText(string_hours+":"+string_minutes+":"+string_seconds);
		}
		
	});
	
	StopWatch() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		frame.setLayout(null);
		
		timeLabel.setBounds(100, 100, 300, 150);
		timeLabel.setText(string_hours+":"+string_minutes+":"+string_seconds);
		timeLabel.setFont(new Font("Ink Free", Font.BOLD, 45));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		
		startButton.setBounds(100, 250, 150, 50);
		startButton.setFocusable(false);
		startButton.setFont(new Font("Mv Boli", Font.PLAIN, 30));
		startButton.addActionListener(this);
		
		resetButton.setBounds(250, 250, 150, 50);
		resetButton.setFocusable(false);
		resetButton.setFont(new Font("Mv Boli", Font.PLAIN, 30));
		resetButton.addActionListener(this);
		
		frame.add(startButton);
		frame.add(resetButton);
		frame.add(timeLabel);
		frame.setVisible(true);
		
	}
	
	public void start() {
		
	     timer.start();
	}
	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == startButton) {
			
			if(started ==  false) {
				start();
			    started = true;
			    startButton.setText("Stop");
		    }
			else {
				stop();
			    started = false;
			    startButton.setText("Start");
			}
		}
			
		
        if(e.getSource() == resetButton) {
        	
        	timer.stop();
        	elapsedTime=0;
        	hours = 0;
        	minutes = 0;
        	seconds = 0;
        	started = false;
        	startButton.setText("Start");
			timeLabel.setText(string_hours+":"+string_minutes+":"+string_seconds);
		}
	}


}
