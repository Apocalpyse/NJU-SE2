package presentation.webmanagerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class WebmarketerUI extends JFrame{
	private static final long serialVersionUID = 1L;
	private Font font = new Font("微软雅黑", Font.BOLD, 16);
	private JFrame Frame;
	private JFrame creditFrame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton back;
	private JButton prePage;
	private JButton nextPage;
	private JButton search;
	private JButton edit;
	private JTextField idInput;

	public static void main(String[] args) {
		WebmarketerUI ui = new WebmarketerUI();
	}

	public WebmarketerUI() {
		Frame = new JFrame();
		creditFrame = new JFrame();
		Dimension preferredSize6 = new Dimension(70, 20);// 设置尺寸短button
		Dimension preferredSize = new Dimension(85, 20);// 设置尺寸中button
		Dimension preferredSize2 = new Dimension(95, 20);// 设置尺寸长button
		Dimension preferredSize3 = new Dimension(800, 70);// 设置尺寸

		//
		panel1 = new JPanel();
		panel1.setPreferredSize(preferredSize3);
		SpringLayout layout = new SpringLayout();
		panel1.setLayout(layout);
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel3.setPreferredSize(preferredSize3);
		//
		back = new JButton("返回");
		back.setPreferredSize(preferredSize6);
		idInput = new JTextField();
		idInput.setPreferredSize(preferredSize2);
		search = new JButton("搜索");
		search.setPreferredSize(preferredSize6);
		edit = new JButton("编辑");
		edit.setPreferredSize(preferredSize6);
		prePage = new JButton("上一页");
		prePage.setPreferredSize(preferredSize);
		nextPage = new JButton("下一页");
		nextPage.setPreferredSize(preferredSize);
		//
		Object[][] p = { { new Integer(666666), "A", "07316734520", "NJU-尼玛啊" },
				{ new Integer(666667), "B", "13007567292", "XL-老友记" },
				{ new Integer(666668), "C",  "13874546528", "XL-杨铭宇" },
				{ new Integer(666669), "D",  "14777889900", "XL-coco" },
				{ new Integer(666670), "E",  "13002506630", "XL-东北屯" },
				{ new Integer(666671), "F",  "16303532678", "XL-麻辣意境" },
				{ new Integer(666672), "G",  "14723456789", "XL-青春盛宴" },
				{ new Integer(666673), "H",  "17089896767", "XL-辣鸡" }, };
		String[] n = { "ID", "用户名", "用户电话", "所属企业" };
		DefaultTableModel defaultModel = new DefaultTableModel(p,n);
		JTable table=new JTable(defaultModel);
	    table.setPreferredScrollableViewportSize(new Dimension(780, 220));
	    table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.add(idInput);
		panel1.add(search);
		panel1.add(back);
		layout.putConstraint(SpringLayout.WEST, back, 10, SpringLayout.WEST, panel1);
		layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.EAST, search, -10, SpringLayout.EAST, panel1);
		layout.putConstraint(SpringLayout.NORTH, search, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.NORTH, idInput, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.EAST, idInput, -10, SpringLayout.WEST, search);

		panel2.add(scrollPane);
		panel3.add(prePage);
		panel3.add(nextPage);
		panel3.add(edit);
		edit.setVisible(false);
		Frame.add(panel1, BorderLayout.NORTH);
		Frame.add(panel2, BorderLayout.CENTER);
		Frame.add(panel3, BorderLayout.SOUTH);
		//
		Frame.setBackground(Color.darkGray);
		Frame.setTitle("DS酒店管家");
		Frame.setSize(850, 450);

		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm = Frame.getSize();
		if (tm.width > dm.width) { // 修正
			tm.width = dm.width;
		}
		if (tm.height > dm.height) {
			tm.height = dm.height;
		}
		Frame.setLocation(dm.width / 2 - tm.width / 2, dm.height / 2 - tm.height / 2);// 设置尺寸
																						// 为屏幕中央
		Frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Frame.setFont(font);
		Frame.setVisible(true);
		Frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					Frame.dispose();
				} else {
					WebmarketerUI ui = new WebmarketerUI();
				}
			}
		});

		creditFrame.setBackground(Color.darkGray);
		creditFrame.setTitle("DS酒店管家");
		creditFrame.setSize(400, 250);

		Dimension dm2 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm2 = creditFrame.getSize();
		if (tm2.width > dm2.width) { // 修正
			tm2.width = dm2.width;
		}
		if (tm2.height > dm2.height) {
			tm2.height = dm2.height;
		}
		creditFrame.setLocation(dm2.width / 2 - tm2.width / 2, dm2.height / 2 - tm2.height / 2);// 设置尺寸
		//界面居中设置																						// 为屏幕中央

		creditFrame.setFont(font);
		creditFrame.setVisible(false);
		creditFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame.dispose();
				} else {
					return;
				}
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebManagerMainUI mainui = new WebManagerMainUI();
				Frame.dispose();
			}
		});
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		prePage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				
				edit.setVisible(true);// 选中时设为true
		
			}
		});
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				creditFrame.setVisible(true);
			}
		});
	}
	// set
}
