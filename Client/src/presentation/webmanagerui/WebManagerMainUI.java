package presentation.webmanagerui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WebManagerMainUI extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		WebManagerMainUI ui = new WebManagerMainUI();
	}

	private Font font = new Font("微软雅黑", Font.BOLD, 16);
	private JFrame mainFrame;
	private JPanel panel1;
	private JPanel panel2;
	private JButton customer;
	private JButton hotel;
	private JButton webmarketer;
	private JButton hotelworker;

	public WebManagerMainUI() {
		mainFrame = new JFrame();
		panel1 = new JPanel();
		panel2 = new JPanel();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 40));
		panel1.setLayout(new GridLayout(1, 2, 50, 50));
		panel2.setLayout(new GridLayout(1, 2, 50, 50));

		Dimension preferredSize = new Dimension(240, 135);// 设置尺寸
		customer = new JButton("客户管理");// ,new ImageIcon(getClass().getResource("项目名.png"))
		customer.setPreferredSize(preferredSize);
		customer.setFont(font);
		hotel = new JButton("酒店管理");
		hotel.setPreferredSize(preferredSize);
		hotel.setFont(font);
		webmarketer = new JButton("营销人员管理");
		webmarketer.setPreferredSize(preferredSize);
		webmarketer.setFont(font);
		hotelworker = new JButton("酒店管理人员");
		hotelworker.setPreferredSize(preferredSize);
		hotelworker.setFont(font);
		// setSize
		panel1.add(customer);
		panel1.add(hotel);
		panel2.add(webmarketer);
		panel2.add(hotelworker);
		//
		mainFrame.add(panel1, BorderLayout.NORTH);
		mainFrame.add(panel2, BorderLayout.SOUTH);
	
		mainFrame.setBackground(Color.darkGray);
		mainFrame.setTitle("DS酒店管家");
		mainFrame.setSize(850, 500);
		mainFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm = mainFrame.getSize();
		if (tm.width > dm.width) { // 修正
			tm.width = dm.width;
		}
		if (tm.height > dm.height) {
			tm.height = dm.height;
		}
		mainFrame.setLocation(dm.width / 2 - tm.width / 2, dm.height / 2 - tm.height / 2);// 设置尺寸
		mainFrame.setDefaultCloseOperation(0);																		// 为屏幕中央
		mainFrame.setFont(font);
		mainFrame.setVisible(true);
		// set
		// add to JFrame
		mainFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					mainFrame.dispose();
				} else {
					return;
				}
			}
		});
		customer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebcustomerUI ui = new WebcustomerUI();
				mainFrame.dispose();
			}
		});
		hotel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebhotelUI ui = new WebhotelUI();
				mainFrame.dispose();
			}
		});
		webmarketer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebmarketerUI ui = new WebmarketerUI();
				mainFrame.dispose();
			}
		});
		hotelworker.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebhotelworkerUI ui = new WebhotelworkerUI();
				mainFrame.dispose();
			}
		});
		
	}

}
