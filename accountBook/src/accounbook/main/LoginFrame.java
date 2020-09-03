package accounbook.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import accountbook.dao.UserinfoDAO;
import accountbook.vo.UserinfoVO;

public class LoginFrame {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtPw;
	private JLabel lbName;

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
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setBounds(200, 200, 595, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.WHITE);
		loginPanel.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		loginPanel.setBounds(40, 15, 483, 516);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

		JLabel lbTitle = new JLabel("Account Book");
		lbTitle.setBounds(100, 30, 300, 50);
		lbTitle.setFont(new Font("맑은고딕", Font.BOLD, 40));
		lbTitle.setHorizontalAlignment(JLabel.CENTER);
		loginPanel.add(lbTitle);

		txtId = new JTextField();
		txtId.setFont(new Font("맑은 고딕", Font.PLAIN, 23));
		txtId.setBorder(BorderFactory.createLineBorder(Color.green));
		txtId.setBackground(Color.WHITE);
		txtId.setBounds(170, 140, 250, 40);
		loginPanel.add(txtId);
		txtId.setColumns(10);

		txtPw = new JPasswordField();
		txtPw.setBorder(BorderFactory.createLineBorder(Color.green));
		txtPw.setColumns(10);
		txtPw.setBounds(170, 220, 250, 40);
		loginPanel.add(txtPw);

		JLabel lbdl = new JLabel("ID");
		lbdl.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbdl.setBounds(43, 157, 82, 21);
		loginPanel.add(lbdl);

		JLabel lbPw = new JLabel("PW");
		lbPw.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbPw.setBounds(43, 239, 82, 21);
		loginPanel.add(lbPw);

		/// 이름은 받아서 AccountFrame으로 보냄
		lbName = new JLabel("");
		lbName.setBounds(158, 379, 82, 21);
		lbName.setVisible(false);
		loginPanel.add(lbName);

		JButton btnSignIn = new JButton("Sign-In");
		btnSignIn.setBackground(Color.white);
		btnSignIn.setBorder(BorderFactory.createLineBorder(Color.green));
		btnSignIn.setForeground(Color.BLACK);
		btnSignIn.setBounds(170, 300, 100, 30);
		// SignIn 버튼을 누르면 AccountMainClass
		btnSignIn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btnSignIn 눌림");
				// 로그인 인증 로직
				UserinfoDAO dao = new UserinfoDAO();

				String id = txtId.getText();
				String password = txtPw.getText();

				UserinfoVO vo = dao.getSignIn(id, password); // 아이디와 비밀번호을 찾음

				System.out.println("loginFrame input id : " + id);
				System.out.println("loginFrame input pw : " + password);

				// 여기서 vo.getId()와 vo.getPassword() 가 맞다면 boolean으로 true
				boolean flag = false;
				if (vo.getId() == null || vo.getPassword() == null) {
					System.out.println("다 null 임");
				} else if (vo.getId().equals(id) && vo.getPassword().equals(password)) {
					System.out.println("아이디, 비밀번호 통과 ");
					flag = true;
				} 

				// 입력된 값이 정상적이라면 로그인 처리를 해줌.
				if (flag) {
					JOptionPane.showMessageDialog(null, "인증되었습니다.");
					lbName.setText(vo.getName());
					AccountFrame af = new AccountFrame();
					af.getLblConnectUser().setText(lbName.getText());
					frame.setVisible(false);
					af.getFrame().setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "아이디,비밀번호를 확인해주세요");
				}
			}

		});
		loginPanel.add(btnSignIn);

		JButton btnSignUp = new JButton("Sign-Up");
		btnSignUp.setBackground(Color.white);
		btnSignUp.setBorder(BorderFactory.createLineBorder(Color.gray));
		btnSignUp.setForeground(Color.BLACK);
		btnSignUp.setBounds(320, 300, 100, 30);
		//
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				SignUpFrame suf = new SignUpFrame();
				System.out.println("회원가입창 ");
				suf.getFrame().setVisible(true);
			}
		});
		loginPanel.add(btnSignUp);



	}
}
