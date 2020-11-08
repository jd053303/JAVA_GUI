import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TurnThePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TurnThePage window = new TurnThePage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TurnThePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("PageSlide");
		frame.setBounds(100, 100, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel end = new JPanel();
		end.setBounds(0, 0, 796, 572);
		frame.getContentPane().add(end);
		end.setLayout(null);
		
		JButton btnbefore = new JButton("GO TO LAST");
		btnbefore.setBounds(507, 42, 239, 347);
		end.add(btnbefore);
		
		JPanel start = new JPanel();
		start.setBounds(0, 0, 796, 572);
		frame.getContentPane().add(start);
		start.setLayout(null);
		
		JButton btnnext = new JButton("GO TO NEXT");
		btnnext.setBounds(77, 38, 223, 461);
		start.add(btnnext);
		
		end.setVisible(false);
		
		btnnext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				end.setVisible(true);
				start.setVisible(false);
			}
		});
		
		btnbefore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				end.setVisible(false);
				start.setVisible(true);
				
			}
			
		});
	
	}
}
