package accounbook.main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import accountbook.dao.AccountDAO;
import accountbook.vo.AccountVO;

public class AccountFrame {
	private JFrame frame;
	private JLabel lblConnectUser;
	private AccountDAO dao;
	private JTextField tfInputHistory;
	private JTextField tfInputIncome;
	private JTextField tfInputExpenses;
	private JTextField tfTotal;
	private JTable table;

	/**
	 * @return the lblConnectUser
	 */
	public JLabel getLblConnectUser() {
		return lblConnectUser;
	}

	/**
	 * @param lblConnectUser the lblConnectUser to set
	 */
	public void setLblConnectUser(JLabel lblConnectUser) {
		this.lblConnectUser = lblConnectUser;
	}

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
					AccountFrame window = new AccountFrame();
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
	public AccountFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setSize(1200, 800);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);

		JPanel accountPanel = new JPanel();
		accountPanel.setBounds(0, 0, 1178, 744);
		frame.getContentPane().add(accountPanel);
		accountPanel.setLayout(null);

		JPanel listPanel = new JPanel();

		JScrollPane jp = new JScrollPane();
		jp.setBounds(27, 70, 860, 540);
		listPanel.add(jp);

		// 좌측에 있는 버튼 모음
		JButton btnList = new JButton("List");
		btnList.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btnList.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		btnList.setBackground(Color.WHITE);
		btnList.setBounds(0, 80, 220, 60);
		accountPanel.add(btnList);

		JButton btnInsert = new JButton("Insert");
		btnInsert.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		btnInsert.setBorder(BorderFactory.createLineBorder(Color.black));
		btnInsert.setBackground(Color.WHITE);
		btnInsert.setBounds(0, 140, 220, 60);
		accountPanel.add(btnInsert);

		LoginFrame lf = new LoginFrame();

		
		// loginFrame 에서 getlbName의 값을 가져오면 ?
		lblConnectUser = new JLabel("");
		lblConnectUser.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lblConnectUser.setHorizontalAlignment(JLabel.RIGHT);
		lblConnectUser.setBounds(867, 30, 220, 30);
		accountPanel.add(lblConnectUser);

		listPanel.setBackground(Color.WHITE); // test
		listPanel.setBounds(225, 80, 930, 640);
		listPanel.setVisible(false);
		accountPanel.add(listPanel);
		listPanel.setLayout(null);

		JLabel lbListTitle = new JLabel("List");
		lbListTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lbListTitle.setHorizontalAlignment(JLabel.CENTER);
		lbListTitle.setBounds(17, 25, 82, 30);
		listPanel.add(lbListTitle);


		////////////////////////////////////////////////////////////////////////

		// Insert Panel
		JPanel insertPanel = new JPanel();
		insertPanel.setBounds(225, 80, 930, 640);
		insertPanel.setVisible(false);
		accountPanel.add(insertPanel);
		insertPanel.setLayout(null);

		JLabel lbInsertTitle = new JLabel("Insert");
		lbInsertTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 30));
		lbInsertTitle.setBounds(17, 25, 82, 30);
		insertPanel.add(lbInsertTitle);

		JLabel lbInsertHistory = new JLabel("History");
		lbInsertHistory.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbInsertHistory.setBounds(17, 109, 82, 21);
		insertPanel.add(lbInsertHistory);

		tfInputHistory = new JTextField();
		tfInputHistory.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfInputHistory.setBounds(116, 106, 610, 27);
		insertPanel.add(tfInputHistory);
		tfInputHistory.setColumns(10);

		JLabel lbIncome = new JLabel("Income");
		lbIncome.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbIncome.setBounds(17, 172, 82, 21);
		insertPanel.add(lbIncome);

		tfInputIncome = new JTextField();
		tfInputIncome.setText("원");
		tfInputIncome.setHorizontalAlignment(JTextField.RIGHT);
		tfInputIncome.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfInputIncome.setBounds(116, 171, 166, 27);
		insertPanel.add(tfInputIncome);
		tfInputIncome.setColumns(10);

		JLabel lbExpenses = new JLabel("Expenses");
		lbExpenses.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbExpenses.setBounds(338, 174, 90, 21);
		insertPanel.add(lbExpenses);

		tfInputExpenses = new JTextField();
		tfInputExpenses.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfInputExpenses.setHorizontalAlignment(JTextField.RIGHT);
		tfInputExpenses.setText("원");
		tfInputExpenses.setBounds(455, 171, 166, 27);
		insertPanel.add(tfInputExpenses);
		tfInputExpenses.setColumns(10);

		JLabel lbTotal = new JLabel("Total");
		lbTotal.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		lbTotal.setBounds(17, 276, 82, 21);
		insertPanel.add(lbTotal);

		tfTotal = new JTextField();
		tfTotal.setText("원");
		tfTotal.setHorizontalAlignment(JTextField.RIGHT);
		tfTotal.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
		tfTotal.setEnabled(false);
		tfTotal.setBounds(116, 275, 166, 27);
		insertPanel.add(tfTotal);
		tfTotal.setColumns(10);
		
		JButton btnInserAccount = new JButton("Add");
		btnInserAccount.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		btnInserAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String history = tfInputHistory.getText();
				
				int income = checkStr(tfInputIncome.getText());
				
				int expenses =  checkStr(tfInputExpenses.getText());
				
				String name = lblConnectUser.getText();
				int totalSum = income+dao.totalSum(name);
				
				int total = totalSum - expenses;
				
				System.out.println("name : " + name);
				System.out.println("income : " + income);
				System.out.println("expenses : " + expenses);
				System.out.println("total : " + total );
				
				boolean flag = dao.insert(name, history, income, expenses, total);
				if(flag) {
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
				}else {
					JOptionPane.showMessageDialog(null, "등록에 실패하였습니다.");
				}
			}
		});
		btnInserAccount.setBounds(608, 487, 129, 29);
		insertPanel.add(btnInserAccount);

		JLabel lbAccountTitle = new JLabel("Account Book");
		lbAccountTitle.setLocation(20, 0);
		lbAccountTitle.setFont(new Font("맑은 고딕", Font.PLAIN, 40));
		lbAccountTitle.setSize(500, 65);
		lbAccountTitle.setHorizontalAlignment(SwingConstants.LEFT);
		accountPanel.add(lbAccountTitle);
		
		JLabel lbSubName = new JLabel("님");
		lbSubName.setHorizontalAlignment(SwingConstants.RIGHT);
		lbSubName.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		lbSubName.setBounds(1087, 30, 74, 30);
		accountPanel.add(lbSubName);

		/// 이벤트 관련 기능추가 // btnList를 누르면
		btnList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { 
				tfInputExpenses.setText("");
				tfInputHistory.setText("");
				tfInputIncome.setText("");
				
				String name = lblConnectUser.getText();
				System.out.println("넘어온 이름 : " + name);

				dao = new AccountDAO();
				List<AccountVO> list = dao.getList(name);
				String tag[] = { "내용", "지출", "수입", "총액", "날짜" };
				String values[][] = new String[list.size()][tag.length];
				int num = 0;

				for (AccountVO vo : list) {
					String hiStory = vo.getHistory();
					System.out.println("내용 : " + hiStory);
					int expenses = vo.getExpenses();
					int income = vo.getIncome();
					int total = vo.getTotal();
					Date updatedate = vo.getUpdateDate();
					// System.out.println("list사이즈 : " + list.size());
					values[num][0] = hiStory;
					values[num][1] = expenses + "";
					values[num][2] = income + "";
					values[num][3] = total + "";
					values[num][4] = updatedate + "";
					num++;
				} // End for

				System.out.println("확인");
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < tag.length; j++) {
						System.out.print(values[i][j] + " ");
					}
					System.out.println();
				}

				DefaultTableModel model = new DefaultTableModel(values, tag);

				table = new JTable(model);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
				table.setAutoCreateRowSorter(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				table.getColumnModel().getColumn(0).setPreferredWidth(500);
				table.getColumnModel().getColumn(1).setPreferredWidth(80); // 240
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(3).setPreferredWidth(80);
				table.getColumnModel().getColumn(4).setPreferredWidth(117);
				jp.setViewportView(table);

				listPanel.setVisible(true);
				insertPanel.setVisible(false);

			}

		}); // End btnList

		// btnInsert를 누르면
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listPanel.setVisible(false);
				insertPanel.setVisible(true);
			}
		}); // End btnInsert

	}
	
	public int checkStr(String str) {
		int a = 0;
		
		if(str.equals("")) { // 빈칸일 때
			return a;
		}else { // 숫자일 때. ( 문자구별 해야함) 
			a = Integer.parseInt(str);
			return a;
		}
		
	}
}
