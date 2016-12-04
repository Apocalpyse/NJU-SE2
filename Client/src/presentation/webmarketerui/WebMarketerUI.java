package presentation.webmarketerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

import businesslogic.customerbl.CustomerController;
import vo.CustomerVO;

public class WebMarketerUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("微软雅黑", Font.BOLD, 16);
	Dimension preferredSize6 = new Dimension(70, 20);// 设置尺寸短button
	Dimension preferredSize = new Dimension(85, 20);// 设置尺寸中button
	Dimension preferredSize2 = new Dimension(95, 20);// 设置尺寸长button
	Dimension preferredSize3 = new Dimension(800, 70);// 设置尺寸
	Dimension preferredSize4 = new Dimension(45, 20);// 设置尺寸短label
	Dimension preferredSize5 = new Dimension(75, 20);// 设置尺寸长label
	Dimension preferredSize7 = new Dimension(850, 550);// 设置尺寸
	private JPanel customer;
	private JPanel member;
	private JPanel order;
	private JPanel promotion;
	private JFrame frame;
	private JTabbedPane tab;
	//
	private Label ID;
	private Label id;
	private Label TIME;
	private Label time;
	private Label STATE;
	private Label state;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton back;
	private JButton prePage;
	private JButton nextPage;
	private JButton search;
	private JButton apply;
	private JButton creat;
	private JButton edit;
	private JTextField idInput;
	// promotion
	private Label ID2;
	private Label id2;
	private Label NAME2;
	private JTextArea name2;
	private Label TIME2;
	private Label time2;
	private Label STATE2;
	private Label state2;
	private JPanel panel12;
	private JPanel panel22;
	private JPanel panel32;
	private JButton back2;
	private JButton prePage2;
	private JButton nextPage2;
	private JButton newLine2;
	private JButton delLine2;
	private JButton search2;
	private JButton apply2;
	private JButton creat2;
	private JButton save2;
	private JTextField idInput2;
	// member
	private JPanel panel13;
	private JPanel panel23;
	private JPanel panel33;
	private JButton back3;
	private JButton prePage3;
	private JButton nextPage3;
	private JButton search3;
	private JButton edit3;
	private JTextField idInput3;

	private JFrame creditFrame3;
	private JLabel CUSTOMER3;
	private JLabel customer3;
	private JLabel AMOUNT3;
	private JTextArea amount3;
	private JButton sure3;
	private JButton cancle3;
	// customer credit

	private JFrame creditFrame4;
	private JPanel panel14;// normal,executed
	private JPanel panel24;// unexecuted
	private JPanel panel34;// abnormal
	private JPanel panel44;// cancled

	private JPanel p14;
	private JPanel p24;
	private JPanel p34;
	private JButton back4;
	private JButton search4;
	private JButton prePage4;
	private JButton nextPage4;
	private JButton edit4;
	private JTextField idInput4;
	// normal
	private JPanel p15;
	private JPanel p25;
	private JPanel p35;
	private JButton back5;
	private JButton search5;
	private JButton prePage5;
	private JButton nextPage5;
	private JButton edit5;
	private JTextField idInput5;
	// unexcuted
	private JPanel p16;
	private JPanel p26;
	private JPanel p36;
	private JButton back6;
	private JButton search6;
	private JButton prePage6;
	private JButton nextPage6;
	private JButton edit6;
	private JTextField idInput6;
	// abnormal
	private JPanel p17;
	private JPanel p27;
	private JPanel p37;
	private JButton back7;
	private JButton search7;
	private JButton prePage7;
	private JButton nextPage7;
	private JButton edit7;
	private JTextField idInput7;

	// cancled
	// order
	public static void main(String[] args) {
		WebMarketerUI ui = new WebMarketerUI();
	}

	public WebMarketerUI() {

		frame = new JFrame();
		customer = new JPanel();
		customer.setPreferredSize(preferredSize7);
		member = new JPanel();
		member.setPreferredSize(preferredSize7);
		order = new JPanel();
		order.setPreferredSize(preferredSize7);
		promotion = new JPanel();
		promotion.setPreferredSize(preferredSize7);
		tab = new JTabbedPane(JTabbedPane.LEFT);
		// 容器

		tab.add(promotion, "促销策略制定");
		tab.add(member, "会员策略制定");
		tab.add(customer, "信用充值");
		tab.add(order, "订单处理");

		frame.add(tab);
		frame.setBackground(Color.darkGray);
		frame.setTitle("DS酒店管家");
		frame.setSize(1000, 550);
		Dimension dm = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm = frame.getSize();
		if (tm.width > dm.width) { // 修正
			tm.width = dm.width;
		}
		if (tm.height > dm.height) {
			tm.height = dm.height;
		}
		frame.setLocation(dm.width / 2 - tm.width / 2, dm.height / 2 - tm.height / 2);// 设置尺寸
																						// 为屏幕中央
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setFont(font);
		frame.setVisible(true);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					frame.dispose();
				} else {

				}
			}
		});
		// 界面框架
		//
		panel1 = new JPanel();
		panel1.setPreferredSize(preferredSize3);
		SpringLayout layout = new SpringLayout();
		panel1.setLayout(layout);
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel3.setLayout(layout);
		panel3.setPreferredSize(preferredSize3);
		//
		back = new JButton("返回");
		back.setPreferredSize(preferredSize6);
		ID = new Label("ID:");
		ID.setPreferredSize(preferredSize4);
		id = new Label("600001");
		id.setPreferredSize(preferredSize5);
		TIME = new Label("TIME:");
		TIME.setPreferredSize(preferredSize4);
		time = new Label("2016-11-29");
		time.setPreferredSize(preferredSize5);
		STATE = new Label("STATE:");
		STATE.setPreferredSize(preferredSize4);
		state = new Label("Using");
		state.setPreferredSize(preferredSize5);
		idInput = new JTextField();
		idInput.setPreferredSize(preferredSize2);
		search = new JButton("搜索");
		search.setPreferredSize(preferredSize6);
		creat = new JButton("新建");
		creat.setPreferredSize(preferredSize6);
		edit = new JButton("保存更改");
		edit.setPreferredSize(preferredSize2);
		apply = new JButton("应用");
		apply.setPreferredSize(preferredSize6);
		prePage = new JButton("上一个");
		prePage.setPreferredSize(preferredSize);
		nextPage = new JButton("下一个");
		nextPage.setPreferredSize(preferredSize);
		//
		Object[][] p = { { "2016-11-29", "2016-11-30", "1%", "ALL", "ALL" },
				{ "2016-11-29", "2016-11-29", "2%", "ALL", "ALL" }, { "2016-11-29", "2016-11-29", "4%", "ALL", "ALL" },
				{ "2016-11-29", "2016-11-29", "8%", "ALL", "ALL" }, { "2016-11-29", "2016-11-29", "10%", "ALL", "ALL" },
				{ "2016-11-29", "2016-11-29", "15%", "ALL", "ALL" },
				{ "2016-11-29", "2016-11-29", "20%", "ALL", "ALL" },
				{ "2016-11-29", "2016-11-29", "25%", "ALL", "ALL" } };
		String[] n = { "起始时间", "结束时间", "折扣", "参与商圈", "享折对象" };
		DefaultTableModel defaultModel = new DefaultTableModel(p, n);
		JTable table = new JTable(defaultModel);
		table.setPreferredScrollableViewportSize(new Dimension(780, 220));
		table.setRowHeight(25);
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.add(idInput);
		panel1.add(search);
		panel1.add(ID);
		panel1.add(id);
		panel1.add(TIME);
		panel1.add(time);
		panel1.add(back);
		layout.putConstraint(SpringLayout.WEST, back, 10, SpringLayout.WEST, panel1);
		layout.putConstraint(SpringLayout.NORTH, back, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.EAST, search, -10, SpringLayout.EAST, panel1);
		layout.putConstraint(SpringLayout.NORTH, search, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.EAST, idInput, -10, SpringLayout.WEST, search);
		layout.putConstraint(SpringLayout.NORTH, idInput, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.WEST, ID, 20, SpringLayout.EAST, back);
		layout.putConstraint(SpringLayout.NORTH, ID, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.WEST, id, 0, SpringLayout.EAST, ID);
		layout.putConstraint(SpringLayout.NORTH, id, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.WEST, TIME, 5, SpringLayout.EAST, id);
		layout.putConstraint(SpringLayout.NORTH, TIME, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.WEST, time, 0, SpringLayout.EAST, TIME);
		layout.putConstraint(SpringLayout.NORTH, time, 25, SpringLayout.NORTH, panel1);

		panel2.add(scrollPane);

		panel3.add(prePage);
		panel3.add(nextPage);
		panel3.add(edit);
		panel3.add(apply);
		panel3.add(STATE);
		panel3.add(state);
		panel3.add(creat);
		layout.putConstraint(SpringLayout.EAST, nextPage, -(800 / 2 - 85 - 5), SpringLayout.EAST, panel3);
		layout.putConstraint(SpringLayout.NORTH, nextPage, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, prePage, -10, SpringLayout.WEST, nextPage);
		layout.putConstraint(SpringLayout.NORTH, prePage, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, apply, -10, SpringLayout.EAST, panel3);
		layout.putConstraint(SpringLayout.NORTH, apply, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, edit, -10, SpringLayout.WEST, apply);
		layout.putConstraint(SpringLayout.NORTH, edit, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, creat, -10, SpringLayout.WEST, edit);
		layout.putConstraint(SpringLayout.NORTH, creat, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.WEST, STATE, 20, SpringLayout.WEST, panel3);
		layout.putConstraint(SpringLayout.NORTH, STATE, 5, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.WEST, state, 0, SpringLayout.EAST, STATE);
		layout.putConstraint(SpringLayout.NORTH, state, 5, SpringLayout.NORTH, panel1);
		promotion.add(panel1, BorderLayout.NORTH);
		promotion.add(panel2, BorderLayout.CENTER);
		promotion.add(panel3, BorderLayout.SOUTH);
		//

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

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
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		// promotion

		SpringLayout layout2 = new SpringLayout();
		panel12 = new JPanel();
		panel12.setPreferredSize(preferredSize3);
		panel12.setLayout(layout2);
		panel22 = new JPanel();
		panel32 = new JPanel();
		panel32.setLayout(layout2);
		panel32.setPreferredSize(preferredSize3);
		//
		back2 = new JButton("返回");
		back2.setPreferredSize(preferredSize6);
		ID2 = new Label("ID:");
		ID2.setPreferredSize(preferredSize4);
		id2 = new Label("500001");
		id2.setPreferredSize(preferredSize5);
		NAME2 = new Label("NAME:");
		NAME2.setPreferredSize(preferredSize4);
		name2 = new JTextArea("name");
		name2.setPreferredSize(preferredSize5);
		TIME2 = new Label("TIME:");
		TIME2.setPreferredSize(preferredSize4);
		time2 = new Label("2016-11-29");
		time2.setPreferredSize(preferredSize5);
		STATE2 = new Label("STATE:");
		STATE2.setPreferredSize(preferredSize4);
		state2 = new Label("Using");
		state2.setPreferredSize(preferredSize5);
		idInput2 = new JTextField();
		idInput2.setPreferredSize(preferredSize2);
		search2 = new JButton("搜索");
		search2.setPreferredSize(preferredSize6);
		creat2 = new JButton("新建");
		creat2.setPreferredSize(preferredSize6);
		save2 = new JButton("保存");
		save2.setPreferredSize(preferredSize6);
		apply2 = new JButton("应用");
		apply2.setPreferredSize(preferredSize6);
		prePage2 = new JButton("上一个");
		prePage2.setPreferredSize(preferredSize);
		nextPage2 = new JButton("下一个");
		nextPage2.setPreferredSize(preferredSize);
		newLine2 = new JButton("新增行");
		newLine2.setPreferredSize(preferredSize);
		delLine2 = new JButton("删除行");
		delLine2.setPreferredSize(preferredSize);
		//
		Object[][] p2 = { { new Integer(0), new Integer(0), "1%" }, { new Integer(1), new Integer(1000), "2%" },
				{ new Integer(2), new Integer(10000), "4%" }, { new Integer(3), new Integer(50000), "8%" },
				{ new Integer(4), new Integer(100000), "10%" }, { new Integer(5), new Integer(200000), "15%" },
				{ new Integer(6), new Integer(400000), "20%" }, { new Integer(7), new Integer(600000), "25%" },
				{ new Integer(8), new Integer(1000000), "30%" } };
		String[] n2 = { "等级", "信用值(>=)", "折扣" };
		DefaultTableModel defaultModel2 = new DefaultTableModel(p2, n2);
		JTable table2 = new JTable(defaultModel2);
		table2.setPreferredScrollableViewportSize(new Dimension(780, 240));
		table2.setRowHeight(25);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		panel12.add(idInput2);
		panel12.add(search2);
		panel12.add(ID2);
		panel12.add(id2);
		panel12.add(NAME2);
		panel12.add(name2);

		panel12.add(back2);
		layout2.putConstraint(SpringLayout.EAST, search2, -10, SpringLayout.EAST, panel12);
		layout2.putConstraint(SpringLayout.NORTH, search2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.NORTH, idInput2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.EAST, idInput2, -10, SpringLayout.WEST, search2);
		layout2.putConstraint(SpringLayout.WEST, back2, 10, SpringLayout.WEST, panel12);
		layout2.putConstraint(SpringLayout.NORTH, back2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, ID2, 20, SpringLayout.EAST, back2);
		layout2.putConstraint(SpringLayout.NORTH, ID2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, id2, 0, SpringLayout.EAST, ID2);
		layout2.putConstraint(SpringLayout.NORTH, id2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, NAME2, 5, SpringLayout.EAST, id2);
		layout2.putConstraint(SpringLayout.NORTH, NAME2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, name2, 0, SpringLayout.EAST, NAME2);
		layout2.putConstraint(SpringLayout.NORTH, name2, 25, SpringLayout.NORTH, panel12);

		panel22.add(scrollPane2);

		panel32.add(prePage2);
		panel32.add(nextPage2);
		panel32.add(save2);
		panel32.add(apply2);
		panel32.add(STATE2);
		panel32.add(state2);
		panel32.add(TIME2);
		panel32.add(time2);
		panel32.add(creat2);
		panel32.add(newLine2);
		panel32.add(delLine2);
		layout2.putConstraint(SpringLayout.EAST, nextPage2, -(800 / 2 - 85 - 5), SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.NORTH, nextPage2, 25, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, prePage2, -10, SpringLayout.WEST, nextPage2);
		layout2.putConstraint(SpringLayout.NORTH, prePage2, 25, SpringLayout.NORTH, panel32);

		layout2.putConstraint(SpringLayout.EAST, apply2, -10, SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.SOUTH, apply2, -10, SpringLayout.SOUTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, save2, -10, SpringLayout.WEST, apply2);
		layout2.putConstraint(SpringLayout.SOUTH, save2, -10, SpringLayout.SOUTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, creat2, -10, SpringLayout.WEST, save2);
		layout2.putConstraint(SpringLayout.SOUTH, creat2, -10, SpringLayout.SOUTH, panel32);

		layout2.putConstraint(SpringLayout.EAST, delLine2, -10, SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.NORTH, delLine2, 10, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, newLine2, -10, SpringLayout.WEST, delLine2);
		layout2.putConstraint(SpringLayout.NORTH, newLine2, 10, SpringLayout.NORTH, panel32);

		layout2.putConstraint(SpringLayout.WEST, STATE2, 20, SpringLayout.WEST, panel32);
		layout2.putConstraint(SpringLayout.NORTH, STATE2, 25, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.WEST, state2, 0, SpringLayout.EAST, STATE2);
		layout2.putConstraint(SpringLayout.NORTH, state2, 25, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.WEST, TIME2, 5, SpringLayout.EAST, state2);
		layout2.putConstraint(SpringLayout.NORTH, TIME2, 25, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.WEST, time2, 0, SpringLayout.EAST, TIME2);
		layout2.putConstraint(SpringLayout.NORTH, time2, 25, SpringLayout.NORTH, panel32);

		member.add(panel12, BorderLayout.NORTH);
		member.add(panel22, BorderLayout.CENTER);
		member.add(panel32, BorderLayout.SOUTH);
		// member
		back2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		search2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		delLine2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int rowcount = defaultModel2.getRowCount() - 1;// getRowCount返回行数，rowcount<0代表已经没有任何行了。
				if (rowcount >= 0) {
					defaultModel2.removeRow(rowcount);
					defaultModel2.setRowCount(rowcount);
				}
				table2.revalidate();
			}
		});
		// 从最后一行删除开始
		newLine2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				defaultModel2.addRow(new Vector());
				table2.revalidate();
			}
		});
		// 添加一行
		prePage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		nextPage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		creat2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				defaultModel2.setRowCount(9);
				for (int i = 0; i < table2.getRowCount(); i++) {
					for (int j = 0; j < table2.getColumnCount(); j++) {
						table2.setValueAt("", i, j);
					}
				}

			}
		});
		save2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		apply2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(1);
			}
		});
		//

		creditFrame3 = new JFrame();
		panel13 = new JPanel();
		panel13.setPreferredSize(preferredSize3);
		SpringLayout layout3 = new SpringLayout();
		panel13.setLayout(layout3);
		panel23 = new JPanel();
		panel33 = new JPanel();
		panel33.setPreferredSize(preferredSize3);
		//
		back3 = new JButton("返回");
		back3.setPreferredSize(preferredSize6);
		idInput3 = new JTextField();
		idInput3.setPreferredSize(preferredSize2);
		search3 = new JButton("搜索");
		search3.setPreferredSize(preferredSize6);
		edit3 = new JButton("充值");
		edit3.setPreferredSize(preferredSize6);
		edit3.setVisible(false);
		prePage3 = new JButton("上一页");
		prePage3.setPreferredSize(preferredSize);
		nextPage3 = new JButton("下一页");
		nextPage3.setPreferredSize(preferredSize);
		//
		Object[][] p3 = { { new Integer(666666), "A", new Integer(500), "07316734520", "NJU" },
				{ new Integer(666667), "B", new Integer(700), "13007567292", "NJU" },
				{ new Integer(666668), "C", new Integer(500), "13874546528", "NJU" },
				{ new Integer(666669), "D", new Integer(7000), "14777889900", "NJU" },
				{ new Integer(666670), "E", new Integer(500), "13002506630", "NJU" },
				{ new Integer(666671), "F", new Integer(700), "16303532678", "NJU" },
				{ new Integer(666672), "G", new Integer(500), "14723456789", "NJU" },
				{ new Integer(666673), "H", new Integer(700), "17089896767", "NJU" }, };
		String[] n3 = { "ID", "用户名", "信用值", "用户电话", "所属单位" };
		DefaultTableModel defaultModel3 = new DefaultTableModel(p3, n3);
		JTable table3 = new JTable(defaultModel3);
		table3.setPreferredScrollableViewportSize(new Dimension(780, 240));
		table3.setRowHeight(25);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		panel13.add(idInput3);
		panel13.add(search3);
		panel13.add(back3);
		layout3.putConstraint(SpringLayout.WEST, back3, 10, SpringLayout.WEST, panel13);
		layout3.putConstraint(SpringLayout.NORTH, back3, 25, SpringLayout.NORTH, panel13);
		layout3.putConstraint(SpringLayout.EAST, search3, -10, SpringLayout.EAST, panel13);
		layout3.putConstraint(SpringLayout.NORTH, search3, 25, SpringLayout.NORTH, panel13);
		layout3.putConstraint(SpringLayout.EAST, idInput3, -10, SpringLayout.WEST, search3);
		layout3.putConstraint(SpringLayout.NORTH, idInput3, 25, SpringLayout.NORTH, panel13);

		panel23.add(scrollPane3);
		panel33.add(prePage3);
		panel33.add(nextPage3);
		panel33.add(edit3);
		customer.add(panel13, BorderLayout.NORTH);
		customer.add(panel23, BorderLayout.CENTER);
		customer.add(panel33, BorderLayout.SOUTH);
		//

		AMOUNT3 = new JLabel("充值额度:");
		AMOUNT3.setPreferredSize(preferredSize5);
		amount3 = new JTextArea();
		amount3.setPreferredSize(preferredSize2);
		CUSTOMER3 = new JLabel("充值对象:");
		CUSTOMER3.setPreferredSize(preferredSize5);
		customer3 = new JLabel();
		customer3.setPreferredSize(preferredSize2);
		sure3 = new JButton("确定");
		sure3.setPreferredSize(preferredSize6);
		cancle3 = new JButton("取消");
		cancle3.setPreferredSize(preferredSize6);
		//
		creditFrame3.setBackground(Color.darkGray);
		creditFrame3.setTitle("DS酒店管家");
		creditFrame3.setSize(400, 250);
		//
		creditFrame3.setLayout(layout3);
		creditFrame3.add(CUSTOMER3);
		creditFrame3.add(customer3);
		creditFrame3.add(AMOUNT3);
		creditFrame3.add(amount3);
		creditFrame3.add(sure3);
		creditFrame3.add(cancle3);
		layout3.putConstraint(SpringLayout.WEST, CUSTOMER3, (int) (creditFrame3.getWidth()
				- AMOUNT3.getPreferredSize().getWidth() - amount3.getPreferredSize().getWidth() - 10) / 2,
				SpringLayout.WEST, creditFrame3);
		layout3.putConstraint(SpringLayout.NORTH, CUSTOMER3, (int) (creditFrame3.getHeight() / 2 - 60),
				SpringLayout.NORTH, creditFrame3);
		layout3.putConstraint(SpringLayout.WEST, customer3, 10, SpringLayout.EAST, AMOUNT3);
		layout3.putConstraint(SpringLayout.NORTH, customer3, (int) (creditFrame3.getHeight() / 2 - 60),
				SpringLayout.NORTH, creditFrame3);
		layout3.putConstraint(SpringLayout.WEST, AMOUNT3, (int) (creditFrame3.getWidth()
				- AMOUNT3.getPreferredSize().getWidth() - amount3.getPreferredSize().getWidth() - 10) / 2,
				SpringLayout.WEST, creditFrame3);
		layout3.putConstraint(SpringLayout.NORTH, AMOUNT3, (int) (creditFrame3.getHeight() / 2 - 40),
				SpringLayout.NORTH, creditFrame3);
		layout3.putConstraint(SpringLayout.WEST, amount3, 10, SpringLayout.EAST, AMOUNT3);
		layout3.putConstraint(SpringLayout.NORTH, amount3, (int) (creditFrame3.getHeight() / 2 - 40),
				SpringLayout.NORTH, creditFrame3);
		layout3.putConstraint(SpringLayout.WEST, sure3, (int) (creditFrame3.getWidth()
				- sure3.getPreferredSize().getWidth() - cancle3.getPreferredSize().getWidth() - 10) / 2,
				SpringLayout.WEST, creditFrame3);
		layout3.putConstraint(SpringLayout.NORTH, sure3, (int) (creditFrame3.getHeight() / 2 + 20), SpringLayout.NORTH,
				creditFrame3);
		layout3.putConstraint(SpringLayout.WEST, cancle3, 10, SpringLayout.EAST, sure3);
		layout3.putConstraint(SpringLayout.NORTH, cancle3, (int) (creditFrame3.getHeight() / 2 + 20),
				SpringLayout.NORTH, creditFrame3);
		//

		Dimension dm2 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm2 = creditFrame3.getSize();
		if (tm2.width > dm2.width) { // 修正
			tm2.width = dm2.width;
		}
		if (tm2.height > dm2.height) {
			tm2.height = dm2.height;
		}
		creditFrame3.setLocation(dm2.width / 2 - tm2.width / 2, dm2.height / 2 - tm2.height / 2);// 设置尺寸
																									// 为屏幕中央
		creditFrame3.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		creditFrame3.setFont(font);
		creditFrame3.setVisible(false);
		// 对Frame的监听
		table3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				edit3.setVisible(true);
				customer3.setText(table3.getValueAt(table3.getSelectedRow(), 0).toString());
			}
		});
		back3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		search3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				String id = idInput.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入用户ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					long ID = Integer.parseInt(id) + 0;
					CustomerController cc = new CustomerController();
					CustomerVO vo = cc.getCustomer(ID);
					for (int i = 0; i < table.getRowCount(); i++) {
						for (int j = 0; j < n.length; j++) {
							table3.setValueAt("", i, j);
						}
					}

					// table3.setValueAt(vo.getId(), 0, 0);
					// table3.setValueAt(vo.getCustomerName(), 0, 1);
					// table3.setValueAt(vo.getCredit(), 0, 2);
					// table3.setValueAt("", 0, 3);
					// if (vo.getCompanyName().equals("") ||
					// vo.getCompanyName().equals(null)) {
					// table3.setValueAt("非企业会员", 0, 4);
					// } else {
					// table3.setValueAt(vo.getCompanyName(), 0, 4);
					// }
				}
			}
		});
		prePage3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		nextPage3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		edit3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame3.setVisible(true);
			}
		});
		// 对creditFrame的监听
		sure3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (Integer.parseInt(amount3.getText().toString()) % 100 == 0) {
					int exi = JOptionPane.showConfirmDialog(null, "确定充值么？", "提示", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (exi == JOptionPane.YES_OPTION) {
						// 充值操作
						creditFrame3.dispose();
					} else {
						creditFrame3.dispose();
					}
				} else {
					JOptionPane.showMessageDialog(null, "请输入100的倍数", "提示", JOptionPane.PLAIN_MESSAGE);
					amount3.setText("");
				}
			}
		});
		cancle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame3.dispose();
			}
		});
		//

		creditFrame4 = new JFrame();
		SpringLayout layout4 = new SpringLayout();

		panel14 = new JPanel();
		panel14.setLayout(new BorderLayout());
		panel24 = new JPanel();
		panel34 = new JPanel();
		panel44 = new JPanel();

		JTabbedPane tab4 = new JTabbedPane();
		// 容器
		tab4.add(panel14, "未处理订单");
		tab4.add(panel24, "已完成订单");
		tab4.add(panel34, "异常订单");
		tab4.add(panel44, "已撤销订单");
		//order 
		p14 = new JPanel();
		p14.setLayout(layout4);
		p14.setPreferredSize(preferredSize3);
		p24 = new JPanel();
		p34 = new JPanel();
		p34.setLayout(layout4);
		p34.setPreferredSize(preferredSize3);
		//
		back4 = new JButton("返回");
		back4.setPreferredSize(preferredSize6);
		idInput4 = new JTextField();
		idInput4.setPreferredSize(preferredSize2);
		search4 = new JButton("搜索");
		search4.setPreferredSize(preferredSize6);
		search4.setMaximumSize(preferredSize);
		prePage4 = new JButton("上一页");
		prePage4.setPreferredSize(preferredSize);
		nextPage4 = new JButton("下一页");
		nextPage4.setPreferredSize(preferredSize);
		edit4 = new JButton("撤销异常");
		edit4.setPreferredSize(preferredSize2);
		//
		Object[][] p4 = {
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "NORMAL" }, };
		String[] n4 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel4 = new DefaultTableModel(p4, n4);
		JTable table4 = new JTable(defaultModel4);
		table4.setPreferredScrollableViewportSize(new Dimension(780, 220));
		table4.setRowHeight(25);
		JScrollPane scrollPane4 = new JScrollPane(table4);

		p14.add(idInput4);
		p14.add(search4);
		p14.add(back4);
		layout4.putConstraint(SpringLayout.WEST, back4, 10, SpringLayout.WEST, p14);
		layout4.putConstraint(SpringLayout.NORTH, back4, 25, SpringLayout.NORTH, p14);
		layout4.putConstraint(SpringLayout.EAST, search4, -10, SpringLayout.EAST, p14);
		layout4.putConstraint(SpringLayout.NORTH, search4, 25, SpringLayout.NORTH, p14);
		layout4.putConstraint(SpringLayout.EAST, idInput4, -10, SpringLayout.WEST, search4);
		layout4.putConstraint(SpringLayout.NORTH, idInput4, 25, SpringLayout.NORTH, p14);

		p24.add(scrollPane4);

		p34.add(prePage4);
		p34.add(nextPage4);
		p34.add(edit4);
		edit4.setVisible(false);// 选中异常订单时设为true
		layout4.putConstraint(SpringLayout.WEST, prePage4,
				(int) (p34.getPreferredSize().getWidth() / 2 - prePage4.getPreferredSize().getWidth() - 5),
				SpringLayout.WEST, p34);
		layout4.putConstraint(SpringLayout.NORTH, prePage4, 25, SpringLayout.NORTH, p34);
		layout4.putConstraint(SpringLayout.WEST, nextPage4, 10, SpringLayout.EAST, prePage4);
		layout4.putConstraint(SpringLayout.NORTH, nextPage4, 25, SpringLayout.NORTH, p34);
		layout4.putConstraint(SpringLayout.EAST, edit4, -10, SpringLayout.EAST, p34);
		layout4.putConstraint(SpringLayout.NORTH, edit4, 25, SpringLayout.NORTH, p34);
		// 利用了p3的size，需注意
		panel14.add(p14, BorderLayout.NORTH);
		panel14.add(p24, BorderLayout.CENTER);
		panel14.add(p34, BorderLayout.SOUTH);

		//
		order.add(tab4);

		creditFrame4.setBackground(Color.darkGray);
		creditFrame4.setTitle("DS酒店管家");
		creditFrame4.setSize(400, 250);

		Dimension dm4 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm4 = creditFrame4.getSize();
		if (tm4.width > dm4.width) { // 修正
			tm4.width = dm4.width;
		}
		if (tm4.height > dm4.height) {
			tm4.height = dm4.height;
		}
		creditFrame4.setLocation(dm4.width / 2 - tm4.width / 2, dm4.height / 2 - tm4.height / 2);// 设置尺寸
		// 居中 // 为屏幕中央

		creditFrame4.setFont(font);
		creditFrame4.setVisible(false);
		creditFrame4.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame4.setVisible(false);
				} else {
					return;
				}
			}
		});
		// 次级界面

		back4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		table4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (table4.getValueAt(table4.getSelectedRow(), n.length - 1).toString().equals("ABNORMAL")) {
					edit4.setVisible(true);// 选中异常订单时设为true
				} else {
					edit4.setVisible(false);// 未选中异常订单时设为false
				}
			}
		});
		search4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		prePage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		nextPage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		edit4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				creditFrame4.setVisible(true);
			}
		});

	}
}
