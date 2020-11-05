package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.db.DBConnection;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class AdminPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel pnL=new JPanel();
	private JPanel pnR=new JPanel();
	private JButton btnQL = new JButton("Quản lý");
	private JButton btnHome = new JButton("Trang chủ");
	private JButton btnDX = new JButton("Đăng xuất");
	private JButton btnTK = new JButton("Thống kê");
	private Connection conn;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new AdminPage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AdminPage() {
		super("NMCNPM");
		conn = DBConnection.getConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1150, 800);
		setLocationRelativeTo(null);
		setResizable(true);
		addEvents();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Bài tập lớn nhập môn công nghệ phần mềm");
		lblNewLabel_1.setPreferredSize(new Dimension(280, 25));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		panel_1.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 50));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Hệ thống quản lý dân cư Hà Nội");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		panel.add(lblNewLabel);
		pnL.setPreferredSize(new Dimension(230, 10));
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnL,pnR);
		pnR.setPreferredSize(new Dimension(700, 600));
		pnR.setLayout(new BorderLayout(0, 0));
		
		pnL.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Chức năng");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_2.setBounds(78, 13, 83, 23);
		pnL.add(lblNewLabel_2);
		
		
		btnHome.setBounds(50, 96, 133, 25);
		pnL.add(btnHome);
		
		btnQL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQL.setBounds(50, 166, 133, 25);
		pnL.add(btnQL);
		
		btnDX.setBounds(50, 309, 133, 25);
		pnL.add(btnDX);
		
		btnTK.setPreferredSize(new Dimension(91, 25));
		btnTK.setBounds(50, 234, 133, 25);
		pnL.add(btnTK);
		splitPane.setOneTouchExpandable(true);
		
		contentPane.add(splitPane, BorderLayout.CENTER);
		setVisible(true);
	}

	private void addEvents() {
		btnDX.addActionListener(new ActionListener() {
			  
			@Override
			public void actionPerformed(ActionEvent e) {
				new Login();
				dispose();
			}
		});
		btnQL.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnR.removeAll();
				pnR.add(new AdminQL(conn), BorderLayout.CENTER);
				pnR.updateUI();
			}
		});
		btnHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pnR.removeAll();
				pnR.setBackground(null);
			}
		});
	}
}
