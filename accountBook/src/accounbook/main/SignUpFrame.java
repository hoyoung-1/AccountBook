package accounbook.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import accountbook.dao.UserinfoDAO;

public class SignUpFrame {

	private JFrame frame;
	private JTextField tfInputId;
	private JTextField tfInputPw;
	private JTextField tfInputPwCheck;
	private JTextField tfInputName;
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpFrame window = new SignUpFrame();
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
	public SignUpFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 800);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() { // x버튼을 누르면 SignUpFrame만 닫힘. 그리고 Loginframe은 다시 실행
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				new LoginFrame().getFrame().setVisible(true);
			}
		});
		frame.getContentPane().setLayout(null);
		
		JPanel signUpPanel = new JPanel();
		signUpPanel.setBounds(0, 0, 528, 744);
		frame.getContentPane().add(signUpPanel);
		signUpPanel.setLayout(null);
		
		JLabel lbsignUp = new JLabel("Sign-Up");
		lbsignUp.setBounds(210, 34, 120, 50);
		lbsignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lbsignUp.setHorizontalAlignment(JLabel.CENTER);
		signUpPanel.add(lbsignUp);
		
		JPanel panel = new JPanel();
		panel.setBounds(42, 103, 450, 589);
		signUpPanel.add(panel);
		
		JLabel lbInputId = new JLabel("ID");
		lbInputId.setBounds(80, 112, 18, 21);
		
		tfInputId = new JTextField();
		tfInputId.setBounds(207, 106, 154, 27);
		tfInputId.setColumns(10);
		
		JLabel lbPw = new JLabel("PW");
		lbPw.setBounds(80, 180, 27, 21);
		
		tfInputPw = new JPasswordField();
		tfInputPw.setBounds(207, 174, 154, 27);
		tfInputPw.setColumns(10);
		
		JLabel lbinputPwCheck = new JLabel("PW_Check");
		lbinputPwCheck.setBounds(80, 237, 88, 21);
		
		tfInputPwCheck = new JPasswordField();
		tfInputPwCheck.setBounds(207, 231, 154, 27);
		tfInputPwCheck.setColumns(10);
		
		JLabel lbInputName = new JLabel("Name");
		lbInputName.setBounds(80, 299, 49, 21);
		
		tfInputName = new JTextField();
		tfInputName.setBounds(207, 293, 154, 27);
		tfInputName.setColumns(10);
		
		JButton btnSignUp = new JButton("등록");
		btnSignUp.setBounds(185, 392, 100, 40);
		btnSignUp.setFont(new Font("맑은 고딕", Font.PLAIN, 24));
		
		panel.setLayout(null);
		panel.add(lbInputId);
		panel.add(lbPw);
		panel.add(lbinputPwCheck);
		panel.add(lbInputName);
		panel.add(tfInputPw);
		panel.add(tfInputName);
		panel.add(tfInputPwCheck);
		panel.add(tfInputId);
		panel.add(btnSignUp);
		
		JLabel lbError = new JLabel("");
		lbError.setFont(new Font("굴림", Font.PLAIN, 22));
		lbError.setForeground(Color.GREEN);
		lbError.setBounds(80, 357, 280, 25);
		lbError.setHorizontalAlignment(JLabel.CENTER);
		panel.add(lbError);
		
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String id = tfInputId.getText();
				String password = tfInputPw.getText();
				String pwCheck = tfInputPwCheck.getText();
				String name = tfInputName.getText();
				
				if(password.equals(pwCheck)) {
					UserinfoDAO dao = new UserinfoDAO();
					try{
						int check = dao.insert(id, password, name);
						
						if(check > 0) {
							JOptionPane.showMessageDialog(null, "등록되었습니다.");
							frame.setVisible(false);
							new LoginFrame().getFrame().setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, "등록되지 않았습니다.");
						}
					}catch (Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
				}else {
					lbError.setText("비밀번호가 틀림");
				}
				
			}
		});
	} // End initialize
	
	
}
