import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Font;
import java.util.Timer;

public class Robot {

	private JFrame frame;
	public int posx=321,posy=186;
	public int i=0, j=0;
	private JTextField txtComandos;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Robot window = new Robot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Robot() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 660, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtComandos = new JTextField();
		txtComandos.setFont(new Font("Dialog", Font.PLAIN, 10));
		txtComandos.setBackground(UIManager.getColor("Button.background"));
		txtComandos.setBounds(123, 393, 329, 19);
		frame.getContentPane().add(txtComandos);
		txtComandos.setColumns(10);
		

		final JLabel r = new JLabel();
		r.setBounds(321, 186, 15, 15);
		r.setIcon(new ImageIcon(Robot.class.getResource("/img/robot.png")));
		frame.getContentPane().add(r);
		
		JButton btnEjecutar = new JButton("EJECUTAR");
		btnEjecutar.setBackground(UIManager.getColor("Button.shadow"));
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sentencia = txtComandos.getText();
				String[] comandos = sentencia.split(" ");
				for (String c : comandos) {
					if (c.equals("NORTE")) {
						j++;
						posy = posy - 27;
						JLabel n = new JLabel(".");
						n.setBounds(posx, posy, 15, 15);
						n.setFont(UIManager.getFont("Button.font"));
						n.setForeground(Color.YELLOW);
						frame.getContentPane().add(n);
						r.setBounds(posx, posy, 15, 15);
					} else if (c.equals("SUR")) {
						j--;
						posy = posy + 27;
						JLabel n = new JLabel(".");
						n.setBounds(posx, posy, 15, 15);
						n.setFont(UIManager.getFont("Button.font"));
						n.setForeground(Color.YELLOW);
						frame.getContentPane().add(n);
						r.setBounds(posx, posy, 15, 15);
					} else if (c.equals("ESTE")) {
						i++;
						posx = posx + 27;
						JLabel n = new JLabel(".");
						n.setBounds(posx, posy, 15, 15);
						n.setFont(UIManager.getFont("Button.font"));
						n.setForeground(Color.YELLOW);
						frame.getContentPane().add(n);
						r.setBounds(posx, posy, 15, 15);
					} else if (c.equals("OESTE")) {
						i--;
						posx = posx - 27;
						JLabel n = new JLabel(".");
						n.setBounds(posx, posy, 15, 15);
						n.setFont(UIManager.getFont("Button.font"));
						n.setForeground(Color.YELLOW);
						frame.getContentPane().add(n);
						r.setBounds(posx, posy, 15, 15);
					} else if (c.equals("SALIR")) {
						JOptionPane.showMessageDialog(null, "POSICION FINAL -> ("+i+","+j+")", "SALIDA", 0);
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(null, "ERROR. Sentencia Errada -> " + c, "ERROR", 0);
					}
				}
			}
		});
		btnEjecutar.setBounds(12, 386, 100, 32);
		frame.getContentPane().add(btnEjecutar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(321, 186, 15, 15);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("NORTE, SUR, ESTE, OESTE o SALIR");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 10));
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setBounds(462, 403, 186, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblInstrucciones = new JLabel("INSTRUCCIONES:");
		lblInstrucciones.setForeground(Color.WHITE);
		lblInstrucciones.setBounds(462, 386, 186, 15);
		frame.getContentPane().add(lblInstrucciones);
	}
}