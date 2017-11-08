package q4.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import q4.controler.MoveUnit;
import q4.strategy.StrategyManager;

/**
 * The main frame of the application. 
 * @author ablouin
 */
public class UI extends JFrame {
	private static final long serialVersionUID = 1L;

	/** The zone where the game runs. */
	private GameZone zone;
	
	private JTextField messageField;
	
	/** The controller that permits users to interact with the game. */
	private MoveUnit moveUnit;
	
	/**
	 * Creates the frame.
	 */
	public UI() {
		super();
		messageField = new JTextField();
		messageField.setEditable(false);
		messageField.setFocusable(false);
		zone = new GameZone();
		moveUnit = new MoveUnit(zone);
		
		// Setting the layout and building the frame.
		setLayout(new BorderLayout());
		add(messageField, BorderLayout.NORTH);
		add(zone, BorderLayout.CENTER);
		
		// Mapping the controller to the keyboard.
		zone.addKeyListener(moveUnit);
		addKeyListener(moveUnit);

		setResizable(false);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-getWidth()/2, dim.height/2-getHeight()/2);
		
		// Launching the thread that will control Mechant.
		//new MechantWorker(zone, messageField).execute();

		new Thread(new StrategyManager(zone, messageField)).start();
	}
	
	/**
	 * @return The zone where the game runs.
	 */
	public GameZone getZone() {
		return zone;
	}
}
