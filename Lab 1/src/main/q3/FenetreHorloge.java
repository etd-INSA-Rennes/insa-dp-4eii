package q3;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FenetreHorloge extends JFrame implements ClockObservater {
	private static final long serialVersionUID = 1L;
	
	private JLabel label;
	private Horloge horloge;

	public FenetreHorloge() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(200, 80);

		label = new JLabel();
		horloge = new Horloge();
		
		horloge.addObservateur(this);

		label.setFont(new Font("DS-digital", Font.TYPE1_FONT, 30));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(label, BorderLayout.CENTER);
		setLocation(400, 400);
		horloge.execute();
	}

	@Override
	public void update(String hour) {
		label.setText(hour);
	}
}
