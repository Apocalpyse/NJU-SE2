package presentation.webmarketerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.synth.SynthSpinnerUI;
import javax.swing.table.DefaultTableModel;

import businesslogic.customerbl.CustomerController;
import businesslogic.orderbl.OrderController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.userbl.UserController;
import po.MemberType;
import po.OrderState;
import po.UsageState;
import vo.CustomerVO;
import vo.MemberPromotionVO;
import vo.OrderVO;
import vo.WebPromotionVO;

public class WebMarketerUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Font font = new Font("微软雅黑", Font.BOLD, 14);
	Dimension preferredSize6 = new Dimension(70, 20);// 设置尺寸短button
	Dimension preferredSize = new Dimension(85, 20);// 设置尺寸中button
	Dimension preferredSize2 = new Dimension(95, 20);// 设置尺寸长button
	Dimension preferredSize3 = new Dimension(800, 70);// 设置尺寸
	Dimension preferredSize4 = new Dimension(45, 20);// 设置尺寸短label
	Dimension preferredSize8 = new Dimension(60, 20);// 设置尺寸中label
	Dimension preferredSize5 = new Dimension(75, 20);// 设置尺寸长label,textarea
	Dimension preferredSize7 = new Dimension(850, 550);// 设置尺寸
	long WPIDBegin = 62000;
	long MPIDBegin = 60000;
	long USERIDBegin = 10000;
	long HOTELIDBegin = 20000;
	long WMIDBegin = 30000;
	long WWIDBegin = 40000;
	long ORDERIDBegin = 50000;
	// ID
	private JPanel customer;
	private JPanel member;
	private JPanel order;
	private JPanel promotion;
	private JFrame frame;
	private JTabbedPane tab;
	//
	private JFrame creditFrame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
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
	private JButton prePage2;
	private JButton nextPage2;
	private JButton newLine2;
	private JButton delLine2;
	private JButton search2;
	private JButton apply2;
	private JButton edit2;
	private JButton creat2;
	private JButton save2;
	private JTextField idInput2;
	// member
	private JPanel panel13;
	private JPanel panel23;
	private JPanel panel33;
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

	private JPanel panel14;// normal,unexecuted
	private JPanel panel24;// executed
	private JPanel panel34;// abnormal
	private JPanel panel44;// cancled

	private JPanel p14;
	private JPanel p24;
	private JPanel p34;
	private JButton search4;
	private JButton prePage4;
	private JButton nextPage4;
	private JTextField idInput4;

	// normal
	private JPanel p15;
	private JPanel p25;
	private JPanel p35;
	private JButton search5;
	private JButton prePage5;
	private JButton nextPage5;
	private JTextField idInput5;
	// unexcuted
	private JFrame creditFrame6;
	private JPanel p16;
	private JPanel p26;
	private JPanel p36;
	private JButton search6;
	private JButton prePage6;
	private JButton nextPage6;
	private JButton edit6;
	private JTextField idInput6;
	// abnormal
	private JPanel p17;
	private JPanel p27;
	private JPanel p37;
	private JButton search7;
	private JButton prePage7;
	private JButton nextPage7;
	private JTextField idInput7;

	// cancled
	// THE orders
	public static void main(String[] args) {
		WebMarketerUI ui = new WebMarketerUI();
	}

	public WebMarketerUI() {

		frame = new JFrame();
		frame.setFont(font);
		customer = new JPanel();
		customer.setFont(font);
		customer.setPreferredSize(preferredSize7);
		member = new JPanel();
		member.setFont(font);
		member.setPreferredSize(preferredSize7);
		order = new JPanel();
		order.setFont(font);
		order.setPreferredSize(preferredSize7);
		promotion = new JPanel();
		promotion.setFont(font);
		promotion.setPreferredSize(preferredSize7);
		tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.setFont(font);
		// 容器

		tab.add(promotion, "促销策略制定");
		tab.add(member, "会员策略制定");
		tab.add(customer, "信用充值");
		tab.add(order, "订单处理");

		frame.add(tab);
		tab.setSelectedIndex(0);
		frame.setBackground(Color.darkGray);
		frame.setTitle("DS酒店管家");
		frame.setSize(950, 500);
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
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		// promotion
		panel1 = new JPanel();
		panel1.setFont(font);
		panel1.setPreferredSize(preferredSize3);
		SpringLayout layout = new SpringLayout();
		panel1.setLayout(layout);
		panel2 = new JPanel();
		panel2.setFont(font);
		panel3 = new JPanel();
		panel3.setLayout(layout);
		panel3.setFont(font);
		panel3.setPreferredSize(preferredSize3);
		//
		idInput = new JTextField();
		idInput.setFont(font);
		idInput.setPreferredSize(preferredSize2);
		search = new JButton("搜索");
		search.setFont(font);
		search.setPreferredSize(preferredSize6);
		creat = new JButton("新建");
		creat.setFont(font);
		creat.setPreferredSize(preferredSize6);
		edit = new JButton("编辑");
		edit.setFont(font);
		edit.setPreferredSize(preferredSize6);
		apply = new JButton("应用");
		apply.setFont(font);
		apply.setPreferredSize(preferredSize6);
		prePage = new JButton("上一页");
		prePage.setFont(font);
		prePage.setPreferredSize(preferredSize);
		nextPage = new JButton("下一页");
		nextPage.setFont(font);
		nextPage.setPreferredSize(preferredSize);
		//
		String[][] p = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n = { "ID", "名称", "起始时间", "结束时间", "折扣", "参与商圈", "享折对象", "状态", "创建时间" };
		DefaultTableModel defaultModel = new DefaultTableModel(p, n) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		JTable table = new JTable(defaultModel);
		table.setFont(font);
		table.setPreferredScrollableViewportSize(new Dimension((int) (panel1.getPreferredSize().getWidth() - 15), 220));
		table.setRowHeight(25);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);
		panel1.add(idInput);
		panel1.add(search);
		layout.putConstraint(SpringLayout.EAST, search, -10, SpringLayout.EAST, panel1);
		layout.putConstraint(SpringLayout.NORTH, search, 25, SpringLayout.NORTH, panel1);
		layout.putConstraint(SpringLayout.EAST, idInput, -10, SpringLayout.WEST, search);
		layout.putConstraint(SpringLayout.NORTH, idInput, 25, SpringLayout.NORTH, panel1);

		panel2.add(scrollPane);

		panel3.add(prePage);
		panel3.add(nextPage);
		panel3.add(edit);
		panel3.add(apply);
		panel3.add(creat);
		apply.setEnabled(false);
		layout.putConstraint(SpringLayout.EAST, nextPage,
				(int) -(panel3.getPreferredSize().getWidth() / 2 - nextPage.getPreferredSize().getWidth() - 5),
				SpringLayout.EAST, panel3);
		layout.putConstraint(SpringLayout.NORTH, nextPage, 25, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, prePage, -10, SpringLayout.WEST, nextPage);
		layout.putConstraint(SpringLayout.NORTH, prePage, 25, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, apply, -10, SpringLayout.EAST, panel3);
		layout.putConstraint(SpringLayout.NORTH, apply, 25, SpringLayout.NORTH, panel3);
		layout.putConstraint(SpringLayout.EAST, creat, -10, SpringLayout.WEST, apply);
		layout.putConstraint(SpringLayout.NORTH, creat, 0, SpringLayout.NORTH, apply);
		layout.putConstraint(SpringLayout.EAST, edit, -10, SpringLayout.WEST, creat);
		layout.putConstraint(SpringLayout.NORTH, edit, 0, SpringLayout.NORTH, creat);
		promotion.add(panel1, BorderLayout.NORTH);
		promotion.add(panel2, BorderLayout.CENTER);
		promotion.add(panel3, BorderLayout.SOUTH);
		//
		creditFrame = new JFrame();
		creditFrame.setTitle("DS酒店管家");
		creditFrame.setFont(font);
		creditFrame.setSize(750, 220);
		creditFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		creditFrame.setLayout(layout);
		JLabel label1 = new JLabel("ID:");
		label1.setPreferredSize(preferredSize5);// short label
		JTextArea text1 = new JTextArea();
		text1.setPreferredSize(preferredSize5);
		JLabel label2 = new JLabel("NAME:");
		label2.setPreferredSize(preferredSize5);// short label
		JTextArea text2 = new JTextArea();
		text2.setPreferredSize(preferredSize5);
		JLabel label3 = new JLabel("起始时间:");
		label3.setPreferredSize(preferredSize5);// short label
		JTextArea text3 = new JTextArea();
		text3.setPreferredSize(preferredSize5);
		JLabel label4 = new JLabel("结束时间:");
		label4.setPreferredSize(preferredSize5);// short label
		JTextArea text4 = new JTextArea();
		text4.setPreferredSize(preferredSize5);
		JLabel label5 = new JLabel("折扣:");
		label5.setPreferredSize(preferredSize5);// short label
		JTextArea text5 = new JTextArea();
		text5.setPreferredSize(preferredSize5);
		JLabel label6 = new JLabel("参与商圈:");
		label6.setPreferredSize(preferredSize5);// short label
		JTextArea text6 = new JTextArea();
		text6.setPreferredSize(preferredSize5);
		JLabel label7 = new JLabel("享折对象:");
		label7.setPreferredSize(preferredSize5);// short label
		JTextArea text7 = new JTextArea();
		text7.setPreferredSize(preferredSize5);
		JButton button1 = new JButton("确定");
		button1.setPreferredSize(preferredSize6);
		JButton button2 = new JButton("取消");
		button2.setPreferredSize(preferredSize6);
		text1.setFont(font);
		label1.setFont(font);
		text2.setFont(font);
		label2.setFont(font);
		text3.setFont(font);
		label3.setFont(font);
		text4.setFont(font);
		label4.setFont(font);
		text5.setFont(font);
		label5.setFont(font);
		text6.setFont(font);
		label6.setFont(font);
		text7.setFont(font);
		label7.setFont(font);
		button1.setFont(font);
		button2.setFont(font);

		creditFrame.add(label1);
		creditFrame.add(text1);
		text1.setEditable(false);
		creditFrame.add(label2);
		creditFrame.add(text2);
		creditFrame.add(label3);
		creditFrame.add(text3);
		creditFrame.add(label4);
		creditFrame.add(text4);
		creditFrame.add(label5);
		creditFrame.add(text5);
		creditFrame.add(label6);
		creditFrame.add(text6);
		creditFrame.add(label7);
		creditFrame.add(text7);
		creditFrame.add(button1);
		creditFrame.add(button2);

		layout.putConstraint(SpringLayout.WEST, label1, 45, SpringLayout.WEST, creditFrame);
		layout.putConstraint(SpringLayout.NORTH, label1, 25, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text1, 0, SpringLayout.EAST, label1);
		layout.putConstraint(SpringLayout.NORTH, text1, 25, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label2, 10, SpringLayout.EAST, text1);
		layout.putConstraint(SpringLayout.NORTH, label2, 25, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text2, 0, SpringLayout.EAST, label2);
		layout.putConstraint(SpringLayout.NORTH, text2, 25, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label3, 10, SpringLayout.EAST, text2);
		layout.putConstraint(SpringLayout.NORTH, label3, 25, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text3, 0, SpringLayout.EAST, label3);
		layout.putConstraint(SpringLayout.NORTH, text3, 25, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label4, 10, SpringLayout.EAST, text3);
		layout.putConstraint(SpringLayout.NORTH, label4, 25, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text4, 0, SpringLayout.EAST, label4);
		layout.putConstraint(SpringLayout.NORTH, text4, 25, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label5, 105, SpringLayout.WEST, creditFrame);
		layout.putConstraint(SpringLayout.NORTH, label5, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text5, 0, SpringLayout.EAST, label5);
		layout.putConstraint(SpringLayout.NORTH, text5, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label6, 10, SpringLayout.EAST, text5);
		layout.putConstraint(SpringLayout.NORTH, label6, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text6, 0, SpringLayout.EAST, label6);
		layout.putConstraint(SpringLayout.NORTH, text6, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label7, 10, SpringLayout.EAST, text6);
		layout.putConstraint(SpringLayout.NORTH, label7, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text7, 0, SpringLayout.EAST, label7);
		layout.putConstraint(SpringLayout.NORTH, text7, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, button1,
				(int) (creditFrame.getWidth() / 2 - button1.getPreferredSize().getWidth() - 5), SpringLayout.WEST,
				creditFrame);
		layout.putConstraint(SpringLayout.NORTH, button1, 40, SpringLayout.SOUTH, text7);
		layout.putConstraint(SpringLayout.WEST, button2, 10, SpringLayout.EAST, button1);
		layout.putConstraint(SpringLayout.NORTH, button2, 40, SpringLayout.SOUTH, text7);
		// 初始化位置信息
		Dimension dm1 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm1 = creditFrame.getSize();
		tm1 = creditFrame.getSize();
		if (tm1.width > dm1.width) { // 修正
			tm1.width = dm1.width;
		}
		if (tm1.height > dm1.height) {
			tm1.height = dm1.height;
		}
		creditFrame.setLocation(dm1.width / 2 - tm1.width / 2, dm1.height / 2 - tm1.height / 2);// 设置尺寸
																								// 为屏幕中央

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
		// main frame

		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (!(table.getValueAt(0, 0) == null) && !(table.getValueAt(0, 0).toString().equals(""))) {
					apply.setEnabled(true);
					if (table.getValueAt(table.getSelectedRow(), n.length - 2).toString().equals("Unused")) {
						apply.setText("应用");
					} else {
						apply.setText("退用");
					}
				}
			}
		});

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (idInput.getText().equals("") || idInput.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "请输入促销策略ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						PromotionController pc = new PromotionController();
						long num = Long.parseLong(idInput.getText().toString());
						WebPromotionVO vo = pc.getWebPromotion(num);
						// 获取
						String BD = vo.getBusinessDistrict()[0];
						for (int i = 1; i < vo.getBusinessDistrict().length; i++) {
							BD = BD + "+" + vo.getBusinessDistrict()[i];
						}
						String[] ob = { vo.getID() + "", vo.getPromotionName(), vo.getBeginTime(), vo.getEndTime(),
								vo.getDiscount() * 100 + "%", BD + "", vo.getMemberType() + "",
								vo.getUsageState().toString(), vo.getCreatedTime() };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel.getRowCount(); i++) {
							for (int j = 0; j < defaultModel.getColumnCount(); j++) {
								table.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput.setText("");
				}
			}
		});
		prePage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				long IDBEGIN = WPIDBegin;
				try {
					PromotionController pc = new PromotionController();
					IDBEGIN = Long.parseLong(table.getValueAt(0, 0).toString()) - defaultModel.getRowCount();
					if (IDBEGIN < WPIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多促销策略了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
				for (int line = 0; line < defaultModel.getRowCount(); line++) {
						WebPromotionVO vo = pc.getWebPromotion(IDBEGIN);
						IDBEGIN = IDBEGIN + 1;
						// 获取id
						String BD = vo.getBusinessDistrict()[0];
						for (int i = 1; i < vo.getBusinessDistrict().length; i++) {
							BD = BD + "+" + vo.getBusinessDistrict()[i];
						}
						String[] ob = { vo.getID() + "", vo.getPromotionName(), vo.getBeginTime(), vo.getEndTime(),
								vo.getDiscount() * 100 + "%", BD + "", vo.getMemberType() + "",
								vo.getUsageState().toString(), vo.getCreatedTime() };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table.setValueAt(ob[i], line, i);
						}
					}
						// 赋值
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				long IDBEGIN = WPIDBegin;
				try {
					PromotionController pc = new PromotionController();
					IDBEGIN = Long.parseLong(table.getValueAt(0, 0).toString()) + defaultModel.getRowCount();
					if (IDBEGIN > pc.findMaxId3()) {
						// 后面没有更多了
						JOptionPane.showMessageDialog(null, "后面已经没有更多促销策略了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}

					// ID
					for (int line = 0; line < defaultModel.getRowCount() && IDBEGIN <= pc.findMaxId3(); line++) {
						WebPromotionVO vo = pc.getWebPromotion(IDBEGIN);
						IDBEGIN = IDBEGIN + 1;
						// 获取id
						String BD = vo.getBusinessDistrict()[0];
						for (int i = 1; i < vo.getBusinessDistrict().length; i++) {
							BD = BD + "+" + vo.getBusinessDistrict()[i];
						}
						String[] str = { vo.getID() + "", vo.getPromotionName(), vo.getBeginTime(), vo.getEndTime(),
								vo.getDiscount() * 100 + "%", BD + "", vo.getMemberType() + "",
								vo.getUsageState().toString(), vo.getCreatedTime() };
						// 处理值
						for (int i = 0; i < str.length; i++) {
							table.setValueAt(str[i], line, i);
						}
						// 赋值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		});
		creat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				PromotionController pc = new PromotionController();
				creditFrame.setVisible(true);
				try {
					text1.setText(pc.findMaxId3() + 1 + "");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ***********此处需获取ID
			}
		});
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame.setVisible(true);
				text1.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
				text2.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
				text3.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				text4.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				text5.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
				text6.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
				text7.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
			}
		});
		apply.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 改变创建时间和状态
				try {
					PromotionController pc = new PromotionController();
					WebPromotionVO vo = pc
							.getWebPromotion(Long.parseLong(table.getValueAt(table.getSelectedRow(), 0).toString()));
					// 获取信息
					if (table.getValueAt(table.getSelectedRow(), 6).toString().equals("Using")) {
						vo.setUsageState(UsageState.Unused);
						table.setValueAt("Unused", table.getSelectedRow(), 6);
						apply.setText("应用");
					} else if (table.getValueAt(table.getSelectedRow(), 6).toString().equals("Unused")) {
						vo.setUsageState(UsageState.Using);
						table.setValueAt("Using", table.getSelectedRow(), 6);
						apply.setText("退用");
					}
					JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 状态改变

				// SimpleDateFormat dateFormat = new
				// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// String date;
				// Date now = new Date();
				// date = dateFormat.format(now);
				// vo.setCreatedTime(date);
				// 时间_暂定为不更改
			}
		});
		// main Frame
		// credit Frame
		button1.addActionListener(new ActionListener() {// 确定
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PromotionController pc = new PromotionController();
					WebPromotionVO vo = new WebPromotionVO();
					//
					vo.setID((long) (Integer.parseInt(text1.getText())));
					vo.setPromotionName(text2.getText());
					vo.setBeginTime(text3.getText());
					vo.setEndTime(text4.getText());
					vo.setDiscount(Double.parseDouble(text5.getText().split("%")[0]) / 100);
					// 折扣的标准需注意
					String BD[] = text6.getText().split("+");
					// 分割标准需统一
					vo.setBusinessDistrict(BD);
					if (text7.getText().equals("ALL")) {
						vo.setMemberType(MemberType.All);
					} else if (text7.getText().equals("Average")) {
						vo.setMemberType(MemberType.Average);
					} else if (text7.getText().equals("Birthday")) {
						vo.setMemberType(MemberType.Birthday);
					} else if (text7.getText().equals("CooperationMember")) {
						vo.setMemberType(MemberType.CooperationMember);
					} else if (text7.getText().equals("Member")) {
						vo.setMemberType(MemberType.Member);
					} else if (text7.getText().equals("VIPMember")) {
						vo.setMemberType(MemberType.VIPMember);
					}
					vo.setUsageState(UsageState.Unused);
					//
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String date;
					Date now = new Date();
					date = dateFormat.format(now);
					String[] dates = date.split(" ");
					// 获取时间
					vo.setCreatedTime(dates[0]);

					// 处理值
					if (pc.getWebPromotion(vo.getID()).equals(null)) {
						// 查找不到则为添加
						pc.creatWebPromotion(vo);
					} else {
						// 否则为更改
						pc.changeWebPromotion(vo);
					}
					// 可找到则改，否则添加
					JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text7.setText("");
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				text1.setText("");
				text2.setText("");
				text3.setText("");
				text4.setText("");
				text5.setText("");
				text6.setText("");
				text7.setText("");
				creditFrame.dispose();
			}
		});
		// credit Frame
		// promotion
		// member
		SpringLayout layout2 = new SpringLayout();
		panel12 = new JPanel();
		panel12.setFont(font);
		panel12.setPreferredSize(preferredSize3);
		panel12.setLayout(layout2);
		panel22 = new JPanel();
		panel22.setFont(font);
		panel32 = new JPanel();
		panel32.setFont(font);
		panel32.setLayout(layout2);
		panel32.setPreferredSize(preferredSize3);
		//
		ID2 = new Label("ID:");
		ID2.setFont(font);
		ID2.setPreferredSize(preferredSize4);
		id2 = new Label("");
		id2.setFont(font);
		id2.setPreferredSize(preferredSize5);
		NAME2 = new Label("NAME:");
		NAME2.setFont(font);
		NAME2.setPreferredSize(preferredSize8);
		name2 = new JTextArea("");
		name2.setFont(font);
		name2.setPreferredSize(preferredSize5);
		TIME2 = new Label("TIME:");
		TIME2.setFont(font);
		TIME2.setPreferredSize(preferredSize4);
		time2 = new Label("");
		time2.setFont(font);
		time2.setPreferredSize(preferredSize5);
		STATE2 = new Label("STATE:");
		STATE2.setFont(font);
		STATE2.setPreferredSize(preferredSize8);
		state2 = new Label("");
		state2.setFont(font);
		state2.setPreferredSize(preferredSize5);
		idInput2 = new JTextField();
		idInput2.setFont(font);
		idInput2.setPreferredSize(preferredSize2);
		search2 = new JButton("搜索");
		search2.setFont(font);
		search2.setPreferredSize(preferredSize6);
		edit2 = new JButton("编辑");
		edit2.setFont(font);
		edit2.setPreferredSize(preferredSize6);
		creat2 = new JButton("新建");
		creat2.setFont(font);
		creat2.setPreferredSize(preferredSize6);
		save2 = new JButton("保存");
		save2.setFont(font);
		save2.setPreferredSize(preferredSize6);
		apply2 = new JButton("应用");
		apply2.setFont(font);
		apply2.setPreferredSize(preferredSize6);
		prePage2 = new JButton("上一个");
		prePage2.setFont(font);
		prePage2.setPreferredSize(preferredSize);
		nextPage2 = new JButton("下一个");
		nextPage2.setFont(font);
		nextPage2.setPreferredSize(preferredSize);
		newLine2 = new JButton("新增行");
		newLine2.setFont(font);
		newLine2.setPreferredSize(preferredSize);
		delLine2 = new JButton("删除行");
		delLine2.setFont(font);
		delLine2.setPreferredSize(preferredSize);
		//
		String[][] p2 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n2 = { "等级", "信用值(>=)", "折扣" };
		DefaultTableModel defaultModel2 = new DefaultTableModel(p2, n2);
		JTable table2 = new JTable(defaultModel2);
		table2.setFont(font);
		table2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table2.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table2.setRowHeight(25);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		panel12.add(idInput2);
		panel12.add(search2);
		panel12.add(ID2);
		panel12.add(id2);
		panel12.add(NAME2);
		panel12.add(name2);
		name2.setEditable(false);

		layout2.putConstraint(SpringLayout.EAST, search2, -10, SpringLayout.EAST, panel12);
		layout2.putConstraint(SpringLayout.NORTH, search2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.NORTH, idInput2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.EAST, idInput2, -10, SpringLayout.WEST, search2);
		layout2.putConstraint(SpringLayout.WEST, ID2, 10, SpringLayout.WEST, panel12);
		layout2.putConstraint(SpringLayout.NORTH, ID2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, id2, 0, SpringLayout.EAST, ID2);
		layout2.putConstraint(SpringLayout.NORTH, id2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, NAME2, 5, SpringLayout.EAST, id2);
		layout2.putConstraint(SpringLayout.NORTH, NAME2, 25, SpringLayout.NORTH, panel12);
		layout2.putConstraint(SpringLayout.WEST, name2, 0, SpringLayout.EAST, NAME2);
		layout2.putConstraint(SpringLayout.NORTH, name2, 25, SpringLayout.NORTH, panel12);

		panel22.add(scrollPane2);
		table2.setEnabled(false);
		newLine2.setEnabled(false);
		delLine2.setEnabled(false);

		// 初始设置
		panel32.add(prePage2);
		panel32.add(nextPage2);
		panel32.add(save2);
		panel32.add(apply2);
		panel32.add(STATE2);
		panel32.add(state2);
		panel32.add(TIME2);
		panel32.add(time2);
		panel32.add(creat2);
		panel32.add(edit2);
		panel32.add(newLine2);
		panel32.add(delLine2);
		layout2.putConstraint(SpringLayout.EAST, nextPage2,
				(int) -(panel32.getPreferredSize().getWidth() / 2 - nextPage2.getPreferredSize().getWidth() + 5),
				SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.NORTH, nextPage2, 25, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, prePage2, -10, SpringLayout.WEST, nextPage2);
		layout2.putConstraint(SpringLayout.NORTH, prePage2, 25, SpringLayout.NORTH, panel32);

		layout2.putConstraint(SpringLayout.EAST, apply2, -10, SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.SOUTH, apply2, -10, SpringLayout.SOUTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, save2, -5, SpringLayout.WEST, apply2);
		layout2.putConstraint(SpringLayout.SOUTH, save2, -10, SpringLayout.SOUTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, creat2, -5, SpringLayout.WEST, save2);
		layout2.putConstraint(SpringLayout.SOUTH, creat2, -10, SpringLayout.SOUTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, edit2, -5, SpringLayout.WEST, creat2);
		layout2.putConstraint(SpringLayout.SOUTH, edit2, -10, SpringLayout.SOUTH, panel32);

		layout2.putConstraint(SpringLayout.EAST, delLine2, -10, SpringLayout.EAST, panel32);
		layout2.putConstraint(SpringLayout.NORTH, delLine2, 10, SpringLayout.NORTH, panel32);
		layout2.putConstraint(SpringLayout.EAST, newLine2, -10, SpringLayout.WEST, delLine2);
		layout2.putConstraint(SpringLayout.NORTH, newLine2, 10, SpringLayout.NORTH, panel32);

		layout2.putConstraint(SpringLayout.WEST, STATE2, 10, SpringLayout.WEST, panel32);
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
		// members

		edit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table2.setEnabled(true);
				newLine2.setEnabled(true);
				delLine2.setEnabled(true);
				prePage2.setEnabled(false);
				nextPage2.setEnabled(false);
				name2.setEditable(true);
				apply2.setEnabled(false);
			}
		});
		search2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (idInput2.getText().equals("") || idInput2.getText().equals(null)) {
						JOptionPane.showMessageDialog(null, "请输入会员制度ID", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						PromotionController pc = new PromotionController();
						long num = Long.parseLong(idInput2.getText().toString());
						if (num > pc.findMaxId1() || num < MPIDBegin) {
							JOptionPane.showMessageDialog(null, "查询不到该会员制度ID", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						MemberPromotionVO vo = pc.getMemberPromotion(num);
						// 获取
						long IDGET = vo.getID();
						String NAMEGET = vo.getPromotionName();
						String createdTime = vo.getCreatedTime();
						double credits[] = vo.getCredit();
						int lines = credits.length;// 需要的行数
						double discounts[] = vo.getDiscountForMember();
						UsageState us = vo.getUsageState();
						if (us.equals(UsageState.Unused)) {
							apply2.setText("应用");
						} else {
							apply2.setText("退用");
						}
						String[] ob = {};
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table2.setValueAt(ob[i], 0, i);
						}
						// 赋值
						int rowcount = defaultModel2.getRowCount();// getRowCount返回行数，rowcount<0代表已经没有任何行了。
						while (lines > rowcount) {
							defaultModel2.addRow(new Vector());
							rowcount = rowcount + 1;
							defaultModel2.setRowCount(rowcount);
						} // addrow
						while (lines < rowcount) {
							defaultModel2.removeRow(rowcount);
							rowcount = rowcount - 1;
							defaultModel2.setRowCount(rowcount);
						} // removerow
						table2.revalidate();
						// 改变行数以符合需要
						id2.setText(IDGET + "");
						//
						name2.setText(NAMEGET);
						//
						time2.setText(createdTime);
						//
						if (us.equals(UsageState.Unused)) {
							state2.setText("Unused");
						} else if (us.equals(UsageState.Using)) {
							state2.setText("Using");
						}
						//
						for (int i = 0; i < lines; i++) {
							table2.setValueAt(i + 1, i, 0);
							table2.setValueAt(credits[i], i, 1);
							table2.setValueAt(discounts[i], i, 2);
						}
						// 设置表格内容
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				idInput2.setText("");
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
				int rowcount = defaultModel2.getRowCount();
				defaultModel2.addRow(new Vector());
				defaultModel2.setRowCount(rowcount + 1);
				table2.revalidate();
				table2.setValueAt(rowcount + 1, rowcount, 0);
			}
		});
		// 添加一行

		prePage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PromotionController pc = new PromotionController();
					long num = Long.parseLong(id2.getText().toString()) - 1;
					if (num < MPIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多会员制度信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					MemberPromotionVO vo = pc.getMemberPromotion(num);
					// 获取
					long IDGET = vo.getID();
					String NAMEGET = vo.getPromotionName();
					String createdTime = vo.getCreatedTime();
					double credits[] = vo.getCredit();
					int lines = credits.length;// 需要的行数
					double discounts[] = vo.getDiscountForMember();
					UsageState us = vo.getUsageState();
					if (us.equals(UsageState.Unused)) {
						apply2.setText("应用");
					} else {
						apply2.setText("退用");
					}
					String[] ob = {};
					// 处理值
					for (int i = 0; i < ob.length; i++) {
						table2.setValueAt(ob[i], 0, i);
					}
					// 赋值
					int rowcount = defaultModel2.getRowCount();// getRowCount返回行数，rowcount<0代表已经没有任何行了。
					while (lines > rowcount) {
						defaultModel2.addRow(new Vector());
						rowcount = rowcount + 1;
						defaultModel2.setRowCount(rowcount);
					} // addrow
					while (lines < rowcount) {
						defaultModel2.removeRow(rowcount);
						rowcount = rowcount - 1;
						defaultModel2.setRowCount(rowcount);
					} // removerow
					table2.revalidate();
					// 改变行数以符合需要
					id2.setText(IDGET + "");
					//
					name2.setText(NAMEGET);
					//
					time2.setText(createdTime);
					//
					if (us.equals(UsageState.Unused)) {
						state2.setText("Unused");
					} else if (us.equals(UsageState.Using)) {
						state2.setText("Using");
					}
					//
					for (int i = 0; i < lines; i++) {
						table2.setValueAt(i + 1, i, 0);
						table2.setValueAt(credits[i], i, 1);
						table2.setValueAt(discounts[i], i, 2);
					}
					// 设置表格内容
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		nextPage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PromotionController pc = new PromotionController();
					long num = Long.parseLong(id2.getText().toString()) + 1;
					if (num > pc.findMaxId1()) {
						JOptionPane.showMessageDialog(null, "后面已经没有更多会员制度信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					MemberPromotionVO vo = pc.getMemberPromotion(num);
					// 获取
					long IDGET = vo.getID();
					String NAMEGET = vo.getPromotionName();
					String createdTime = vo.getCreatedTime();
					double credits[] = vo.getCredit();
					int lines = credits.length;// 需要的行数
					double discounts[] = vo.getDiscountForMember();
					UsageState us = vo.getUsageState();
					if (us.equals(UsageState.Unused)) {
						apply2.setText("应用");
					} else {
						apply2.setText("退用");
					}
					String[] ob = {};
					// 处理值
					for (int i = 0; i < ob.length; i++) {
						table2.setValueAt(ob[i], 0, i);
					}
					// 赋值
					int rowcount = defaultModel2.getRowCount();// getRowCount返回行数，rowcount<0代表已经没有任何行了。
					while (lines > rowcount) {
						defaultModel2.addRow(new Vector());
						rowcount = rowcount + 1;
						defaultModel2.setRowCount(rowcount);
					} // addrow
					while (lines < rowcount) {
						defaultModel2.removeRow(rowcount);
						rowcount = rowcount - 1;
						defaultModel2.setRowCount(rowcount);
					} // removerow
					table2.revalidate();
					// 改变行数以符合需要
					id2.setText(IDGET + "");
					//
					name2.setText(NAMEGET);
					//
					time2.setText(createdTime);
					//
					if (us.equals(UsageState.Unused)) {
						state2.setText("Unused");
					} else if (us.equals(UsageState.Using)) {
						state2.setText("Using");
					}
					//
					for (int i = 0; i < lines; i++) {
						table2.setValueAt(i + 1, i, 0);
						table2.setValueAt(credits[i], i, 1);
						table2.setValueAt(discounts[i], i, 2);
					}
					// 设置表格内容
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		creat2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				table2.setEnabled(true);
				newLine2.setEnabled(true);
				delLine2.setEnabled(true);
				prePage2.setEnabled(false);
				nextPage2.setEnabled(false);
				name2.setEditable(true);
				apply2.setEnabled(false);
				defaultModel2.setRowCount(8);
				for (int i = 0; i < table2.getRowCount(); i++) {
					table2.setValueAt(i + 1 + "", i, 0);
					for (int j = 1; j < table2.getColumnCount(); j++) {
						table2.setValueAt("", i, j);
					}
				}
				PromotionController pc = new PromotionController();
				try {
					id2.setText(pc.findMaxId1() + 1 + "");

				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		save2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PromotionController pc = new PromotionController();
					MemberPromotionVO vo = new MemberPromotionVO();
					//
					table2.setEnabled(false);
					newLine2.setEnabled(false);
					delLine2.setEnabled(false);
					prePage2.setEnabled(true);
					nextPage2.setEnabled(true);
					name2.setEditable(false);
					apply2.setEnabled(true);
					// 回归设置_不可后翻

					long IDGET = Long.parseLong(id2.getText());
					String NAMEGET = name2.getText();
					String STATEGET = state2.getText();
					String CREATTIME = time2.getText();

					int rowcount = defaultModel2.getRowCount();
					int RowCount=rowcount;
					for (int i = 0; i < rowcount; i++) {
						if (table2.getValueAt(i, 0).toString().equals("")
								|| table2.getValueAt(i, 0).toString().equals(null)
								|| table2.getValueAt(i, 1).toString().equals("")
								|| table2.getValueAt(i, 1).toString().equals(null)
								|| table2.getValueAt(i, 2).toString().equals("")
								|| table2.getValueAt(i, 2).toString().equals(null)) {
							rowcount = rowcount - 1;
							defaultModel2.removeRow(i);
							defaultModel2.setRowCount(rowcount);
							i = i - 1;

						}
					} // 排除空行
					if(rowcount<RowCount){
						JOptionPane.showMessageDialog(null, "信息不完善！请修改", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					double[] credits = new double[rowcount];
					double[] discounts = new double[rowcount];
					for (int i = 0; i < rowcount; i++) {
						credits[i] = Double.parseDouble((table2.getValueAt(i, 1).toString()));
						// 获取信用值
						discounts[i] = Double.parseDouble((table2.getValueAt(i, 2).toString()).split("%")[0]) / 100;
						// 折扣的转换
					}
					// （限制：需要监测机制）
					// 获取数据
					vo.setID(IDGET);
					vo.setPromotionName(NAMEGET);
					vo.setCreatedTime(CREATTIME);
					if (STATEGET.equals("Using")) {
						vo.setUsageState(UsageState.Using);
					} else if (STATEGET.equals("Unused")) {
						vo.setUsageState(UsageState.Unused);
					}
					vo.setCredit(credits);
					vo.setDiscountForMember(discounts);
					// 设置属性
					if (pc.getMemberPromotion(vo.getID()).equals(null)) {
						pc.creatMemberPromotion(vo);
					} else {
						pc.changeMemberPromotion(vo);
					}
					// 存储数据
					JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		apply2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					PromotionController pc = new PromotionController();
					MemberPromotionVO vo = new MemberPromotionVO();
					//
					long IDGET = Long.parseLong(id2.getText());
					if((IDGET==0)){
						return ;
					}	
					vo = pc.getMemberPromotion(IDGET);
					// 获取数据
					if (vo.getUsageState().equals(UsageState.Using)) {
						vo.setUsageState(UsageState.Unused);
					} else {
						vo.setUsageState(UsageState.Using);
						for (long i = MPIDBegin; i <= pc.findMaxId1(); i++) {
							if (i != IDGET) {
								MemberPromotionVO vo1 = pc.getMemberPromotion(i);
								vo1.setUsageState(UsageState.Unused);
								pc.changeMemberPromotion(vo1);
							}
						}
						// *****同时将其他会员制度设为未应用状态
					}

					// 设置属性
					pc.changeMemberPromotion(vo);

					// 保存修改后的vo
					JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// member promotion

		// credit customer
		creditFrame3 = new JFrame();
		creditFrame3.setFont(font);
		panel13 = new JPanel();
		panel13.setFont(font);
		panel13.setPreferredSize(preferredSize3);
		SpringLayout layout3 = new SpringLayout();
		panel13.setLayout(layout3);
		panel23 = new JPanel();
		panel23.setFont(font);
		panel33 = new JPanel();
		panel33.setFont(font);
		panel33.setPreferredSize(preferredSize3);
		//
		idInput3 = new JTextField();
		idInput3.setFont(font);
		idInput3.setPreferredSize(preferredSize2);
		search3 = new JButton("搜索");
		search3.setFont(font);
		search3.setPreferredSize(preferredSize6);
		edit3 = new JButton("充值");
		edit3.setFont(font);
		edit3.setPreferredSize(preferredSize6);
		edit3.setEnabled(false);
		prePage3 = new JButton("上一页");
		prePage3.setFont(font);
		prePage3.setPreferredSize(preferredSize);
		nextPage3 = new JButton("下一页");
		nextPage3.setFont(font);
		nextPage3.setPreferredSize(preferredSize);
		//
		String[][] p3 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n3 = { "ID", "用户名", "信用值", "用户电话", "所属单位" };
		DefaultTableModel defaultModel3 = new DefaultTableModel(p3, n3) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table3 = new JTable(defaultModel3);
		table3.setFont(font);
		table3.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table3.setRowHeight(25);
		table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		panel13.add(idInput3);
		panel13.add(search3);
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
		AMOUNT3.setFont(font);
		AMOUNT3.setPreferredSize(preferredSize5);
		amount3 = new JTextArea();
		amount3.setFont(font);
		amount3.setPreferredSize(preferredSize2);
		CUSTOMER3 = new JLabel("充值对象:");
		CUSTOMER3.setFont(font);
		CUSTOMER3.setPreferredSize(preferredSize5);
		customer3 = new JLabel();
		customer3.setFont(font);
		customer3.setPreferredSize(preferredSize2);
		sure3 = new JButton("确定");
		sure3.setFont(font);
		sure3.setPreferredSize(preferredSize6);
		cancle3 = new JButton("取消");
		cancle3.setFont(font);
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
		creditFrame3.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		creditFrame3.setFont(font);
		creditFrame3.setVisible(false);
		// 对Frame的监听

		table3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if (!(table3.getValueAt(0, 0) == null) && !(table3.getValueAt(0, 0).toString().equals(""))) {
					edit3.setEnabled(true);
				}

			}
		});
		creditFrame3.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定取消么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame3.dispose();
				} else {
					return;
				}
			}
		});
		search3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String id = idInput3.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入用户ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id);
						UserController uc = new UserController();
						if (ID > uc.findMaxId() || ID < USERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应ID信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						CustomerController cc = new CustomerController();
						CustomerVO vo = cc.getCustomer(ID);
						// 获取数据
						//
						String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "",
								vo.getCustomerPhone(), vo.getCompanyName() };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table3.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel3.getRowCount(); i++) {
							for (int j = 0; j < defaultModel3.getColumnCount(); j++) {
								table3.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput3.setText("");
				}
			}
		});
		prePage3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table3.getValueAt(0, 0).toString();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) - defaultModel3.getRowCount();
						UserController uc = new UserController();
						if ((ID > uc.findMaxId() || ID < USERIDBegin)) {
							JOptionPane.showMessageDialog(null, "未查询到对应ID信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						//
						for (int count = 0; count < defaultModel3.getRowCount() && ID >= USERIDBegin; count++) {
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(ID);
							ID = ID + 1;
							// 获取数据
							//
							String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "",
									vo.getCustomerPhone(), vo.getCompanyName() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table3.setValueAt(ob[i], count, i);
							}
							// 赋值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		nextPage3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table3.getValueAt(0, 0).toString();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) + defaultModel3.getRowCount();
						//
						UserController uc = new UserController();
						if (ID > uc.findMaxId() || ID < USERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应ID信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						for (int count = 0; count < defaultModel3.getRowCount() && ID <= uc.findMaxId(); count++) {
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(ID);
							ID = ID + 1;
							// 获取数据
							String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "",
									vo.getCustomerPhone(), vo.getCompanyName() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table3.setValueAt(ob[i], count, i);
							}
							// 赋值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		edit3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame3.setVisible(true);
				customer3.setText(table3.getValueAt(table3.getSelectedRow(), 0).toString());
			}
		});
		// 对creditFrame的监听
		sure3.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Integer.parseInt(amount3.getText()) % 100 == 0) {
						int exi = JOptionPane.showConfirmDialog(null, "确定充值么？", "提示", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						if (exi == JOptionPane.YES_OPTION) {
							// 充值操作
							double CREDITGET = Double.parseDouble(amount3.getText());
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(Long.parseLong(customer3.getText()));
							//
							CREDITGET = Double.parseDouble(vo.getCredit()) + CREDITGET;
							vo.setCredit(CREDITGET + "");
							//
							cc.changeCustomer(vo);
							// 改变用户信用值
							creditFrame3.dispose();
						} else {
							creditFrame3.dispose();
						}
						JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "请输入100的倍数", "提示", JOptionPane.PLAIN_MESSAGE);
						amount3.setText("");
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cancle3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame3.dispose();
			}
		});
		// credit customer

		// order

		SpringLayout layout4 = new SpringLayout();

		panel14 = new JPanel();
		panel14.setFont(font);
		panel14.setLayout(new BorderLayout());
		panel24 = new JPanel();
		panel24.setFont(font);
		panel24.setLayout(new BorderLayout());
		panel34 = new JPanel();
		panel34.setFont(font);
		panel34.setLayout(new BorderLayout());
		panel44 = new JPanel();
		panel44.setFont(font);
		panel44.setLayout(new BorderLayout());

		JTabbedPane tab4 = new JTabbedPane();
		tab4.setFont(font);
		// 容器
		tab4.add(panel14, "未处理订单");
		tab4.add(panel24, "已完成订单");
		tab4.add(panel34, "异常订单");
		tab4.add(panel44, "已撤销订单");

		order.add(tab4);
		// order MainFrame

		// 未处理订单
		p14 = new JPanel();
		p14.setLayout(layout4);
		p14.setPreferredSize(preferredSize3);
		p24 = new JPanel();
		p34 = new JPanel();
		p34.setLayout(layout4);
		p34.setPreferredSize(preferredSize3);
		//
		idInput4 = new JTextField();
		idInput4.setFont(font);
		idInput4.setPreferredSize(preferredSize2);
		search4 = new JButton("搜索");
		search4.setFont(font);
		search4.setPreferredSize(preferredSize6);
		search4.setMaximumSize(preferredSize);
		prePage4 = new JButton("上一页");
		prePage4.setFont(font);
		prePage4.setPreferredSize(preferredSize);
		nextPage4 = new JButton("下一页");
		nextPage.setFont(font);
		nextPage4.setPreferredSize(preferredSize);
		//
		String[][] p4 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n4 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel4 = new DefaultTableModel(p4, n4) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table4 = new JTable(defaultModel4);
		table4.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table4.setFont(font);
		table4.setRowHeight(25);
		table4.getColumnModel().getColumn(1).setPreferredWidth(50);
		table4.getColumnModel().getColumn(4).setPreferredWidth(110);
		table4.getColumnModel().getColumn(6).setPreferredWidth(110);
		table4.getColumnModel().getColumn(7).setPreferredWidth(110);
		table4.getColumnModel().getColumn(8).setPreferredWidth(110);
		table4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane4 = new JScrollPane(table4);

		p14.add(idInput4);
		p14.add(search4);
		layout4.putConstraint(SpringLayout.EAST, search4, -10, SpringLayout.EAST, p14);
		layout4.putConstraint(SpringLayout.NORTH, search4, 25, SpringLayout.NORTH, p14);
		layout4.putConstraint(SpringLayout.EAST, idInput4, -10, SpringLayout.WEST, search4);
		layout4.putConstraint(SpringLayout.NORTH, idInput4, 25, SpringLayout.NORTH, p14);

		p24.add(scrollPane4);

		p34.add(prePage4);
		p34.add(nextPage4);

		layout4.putConstraint(SpringLayout.WEST, prePage4,
				(int) (p34.getPreferredSize().getWidth() / 2 - prePage4.getPreferredSize().getWidth() - 5),
				SpringLayout.WEST, p34);
		layout4.putConstraint(SpringLayout.NORTH, prePage4, 25, SpringLayout.NORTH, p34);
		layout4.putConstraint(SpringLayout.WEST, nextPage4, 10, SpringLayout.EAST, prePage4);
		layout4.putConstraint(SpringLayout.NORTH, nextPage4, 25, SpringLayout.NORTH, p34);

		panel14.add(p14, BorderLayout.NORTH);
		panel14.add(p24, BorderLayout.CENTER);
		panel14.add(p34, BorderLayout.SOUTH);

		// table4.addMouseListener(new java.awt.event.MouseAdapter() {
		// public void mouseClicked(java.awt.event.MouseEvent e) {
		//
		// }
		// });//无需处理，故不做实现
		search4.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent arg0) {

				String id = idInput4.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入订单ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
						if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应订单信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						OrderVO vo = oc.getOrder(ID);
						// 获取数据
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table4.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel4.getRowCount(); i++) {
							for (int j = 0; j < defaultModel4.getColumnCount(); j++) {
								table4.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput4.setText("");
				}

			}
		});
		prePage4.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table4.getValueAt(0, 0).toString()) - 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从上一页最后开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel4.getRowCount() && ID2 >= ORDERIDBegin; count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.unexecute)) {
							ID2 = ID2 - 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 - 1;
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table4.setValueAt(ob[i], table4.getRowCount() - count - 1, i);
						}
						// 从后到前的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		nextPage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table4.getValueAt(table4.getRowCount() - 1, 0).toString()) + 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "后面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从下一页第一开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.unexecute)) {
							ID2 = ID2 + 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 + 1;
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table4.setValueAt(ob[i], count, i);
						}
						// 从前到后的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		// unexecute order

		// 已完成订单

		p15 = new JPanel();
		p15.setFont(font);
		p15.setLayout(layout4);
		p15.setPreferredSize(preferredSize3);
		p25 = new JPanel();
		p25.setFont(font);
		p35 = new JPanel();
		p35.setFont(font);
		p35.setLayout(layout4);
		p35.setPreferredSize(preferredSize3);
		//
		idInput5 = new JTextField();
		idInput5.setFont(font);
		idInput5.setPreferredSize(preferredSize2);
		search5 = new JButton("搜索");
		search5.setFont(font);
		search5.setPreferredSize(preferredSize6);
		search5.setMaximumSize(preferredSize);
		prePage5 = new JButton("上一页");
		prePage5.setFont(font);
		prePage5.setPreferredSize(preferredSize);
		nextPage5 = new JButton("下一页");
		nextPage5.setFont(font);
		nextPage5.setPreferredSize(preferredSize);
		//
		String[][] p5 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n5 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel5 = new DefaultTableModel(p5, n5) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table5 = new JTable(defaultModel5);
		table5.setFont(font);
		table5.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table5.setRowHeight(25);
		table5.getColumnModel().getColumn(1).setPreferredWidth(50);
		table5.getColumnModel().getColumn(4).setPreferredWidth(110);
		table5.getColumnModel().getColumn(6).setPreferredWidth(110);
		table5.getColumnModel().getColumn(7).setPreferredWidth(110);
		table5.getColumnModel().getColumn(8).setPreferredWidth(110);
		table5.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane5 = new JScrollPane(table5);

		p15.add(idInput5);
		p15.add(search5);
		layout4.putConstraint(SpringLayout.EAST, search5, -10, SpringLayout.EAST, p15);
		layout4.putConstraint(SpringLayout.NORTH, search5, 25, SpringLayout.NORTH, p15);
		layout4.putConstraint(SpringLayout.EAST, idInput5, -10, SpringLayout.WEST, search5);
		layout4.putConstraint(SpringLayout.NORTH, idInput5, 25, SpringLayout.NORTH, p15);

		p25.add(scrollPane5);

		p35.add(prePage5);
		p35.add(nextPage5);
		layout4.putConstraint(SpringLayout.WEST, prePage5,
				(int) (p35.getPreferredSize().getWidth() / 2 - prePage5.getPreferredSize().getWidth() - 5),
				SpringLayout.WEST, p35);
		layout4.putConstraint(SpringLayout.NORTH, prePage5, 25, SpringLayout.NORTH, p35);
		layout4.putConstraint(SpringLayout.WEST, nextPage5, 10, SpringLayout.EAST, prePage5);
		layout4.putConstraint(SpringLayout.NORTH, nextPage5, 25, SpringLayout.NORTH, p35);
		//
		panel24.add(p15, BorderLayout.NORTH);
		panel24.add(p25, BorderLayout.CENTER);
		panel24.add(p35, BorderLayout.SOUTH);

		// table5.addMouseListener(new java.awt.event.MouseAdapter() {
		//
		// public void mouseClicked(java.awt.event.MouseEvent e) {
		//
		// }
		// });
		search5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = idInput5.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入订单ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
						if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应订单信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						OrderVO vo = oc.getOrder(ID);
						// 获取数据
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table5.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel5.getRowCount(); i++) {
							for (int j = 0; j < defaultModel5.getColumnCount(); j++) {
								table5.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput5.setText("");
				}
			}
		});
		
		
		prePage5.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				try {

					long ID = Long.parseLong(table5.getValueAt(0, 0).toString()) - 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从上一页最后开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel5.getRowCount() && ID2 >= ORDERIDBegin; count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.normal)) {
							ID2 = ID2 - 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 - 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table5.setValueAt(ob[i], table5.getRowCount() - count - 1, i);
						}
						// 从后到前的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		nextPage5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table5.getValueAt(table5.getRowCount() - 1, 0).toString()) + 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "后面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从下一页第一开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel5.getRowCount() && ID2 <= oc.findMaxId(); count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.normal)) {
							ID2 = ID2 + 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 + 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table5.setValueAt(ob[i], count, i);
						}
						// 从前到后的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		// excuted,normal

		// 异常订单处理
		p16 = new JPanel();
		p16.setFont(font);
		p16.setLayout(layout4);
		p16.setPreferredSize(preferredSize3);
		p26 = new JPanel();
		p26.setFont(font);
		p36 = new JPanel();
		p36.setLayout(layout4);
		p36.setFont(font);
		p36.setPreferredSize(preferredSize3);
		//
		idInput6 = new JTextField();
		idInput6.setFont(font);
		idInput6.setPreferredSize(preferredSize2);
		search6 = new JButton("搜索");
		search6.setFont(font);
		search6.setPreferredSize(preferredSize6);
		search6.setMaximumSize(preferredSize);
		prePage6 = new JButton("上一页");
		prePage6.setFont(font);
		prePage6.setPreferredSize(preferredSize);
		nextPage6 = new JButton("下一页");
		nextPage6.setFont(font);
		nextPage6.setPreferredSize(preferredSize);
		edit6 = new JButton("撤销异常");
		edit6.setFont(font);
		edit6.setPreferredSize(preferredSize2);
		//
		String[][] p6 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n6 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel6 = new DefaultTableModel(p6, n6) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table6 = new JTable(defaultModel6);
		table6.setFont(font);
		table6.setRowHeight(25);
		table6.getColumnModel().getColumn(1).setPreferredWidth(50);
		table6.getColumnModel().getColumn(4).setPreferredWidth(110);
		table6.getColumnModel().getColumn(6).setPreferredWidth(110);
		table6.getColumnModel().getColumn(7).setPreferredWidth(110);
		table6.getColumnModel().getColumn(8).setPreferredWidth(110);
		table6.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table6.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
	
		JScrollPane scrollPane6 = new JScrollPane(table6);

		p16.add(idInput6);
		p16.add(search6);
		layout4.putConstraint(SpringLayout.EAST, search6, -10, SpringLayout.EAST, p16);
		layout4.putConstraint(SpringLayout.NORTH, search6, 25, SpringLayout.NORTH, p16);
		layout4.putConstraint(SpringLayout.EAST, idInput6, -10, SpringLayout.WEST, search6);
		layout4.putConstraint(SpringLayout.NORTH, idInput6, 25, SpringLayout.NORTH, p16);

		p26.add(scrollPane6);

		p36.add(prePage6);
		p36.add(nextPage6);
		p36.add(edit6);
		edit6.setEnabled(false);// 选中异常订单时设为true
		layout4.putConstraint(SpringLayout.WEST, prePage6,
				(int) (p36.getPreferredSize().getWidth() / 2 - prePage6.getPreferredSize().getWidth() - 5),
				SpringLayout.WEST, p36);
		layout4.putConstraint(SpringLayout.NORTH, prePage6, 25, SpringLayout.NORTH, p36);
		layout4.putConstraint(SpringLayout.WEST, nextPage6, 10, SpringLayout.EAST, prePage6);
		layout4.putConstraint(SpringLayout.NORTH, nextPage6, 25, SpringLayout.NORTH, p36);
		layout4.putConstraint(SpringLayout.EAST, edit6, -10, SpringLayout.EAST, p36);
		layout4.putConstraint(SpringLayout.NORTH, edit6, 25, SpringLayout.NORTH, p36);
		//
		panel34.add(p16, BorderLayout.NORTH);
		panel34.add(p26, BorderLayout.CENTER);
		panel34.add(p36, BorderLayout.SOUTH);

		// 下为信用返回界面
		creditFrame6 = new JFrame();
		creditFrame6.setFont(font);
		creditFrame6.setBackground(Color.darkGray);
		creditFrame6.setTitle("DS酒店管家");
		creditFrame6.setSize(400, 250);

		Dimension dm6 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm6 = creditFrame6.getSize();
		if (tm6.width > dm6.width) { // 修正
			tm6.width = dm6.width;
		}
		if (tm6.height > dm6.height) {
			tm6.height = dm6.height;
		}
		creditFrame6.setLocation(dm6.width / 2 - tm6.width / 2, dm6.height / 2 - tm6.height / 2);// 设置尺寸
		// 居中 // 为屏幕中央

		creditFrame6.setFont(font);
		creditFrame6.setVisible(false);
		creditFrame6.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		creditFrame6.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定取消么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame6.setVisible(false);
				} else {
					return;
				}
			}
		});

		JPanel subPanel = new JPanel();
		subPanel.setLayout(layout4);
		subPanel.setFont(font);
		subPanel.setBorder(BorderFactory.createTitledBorder("请选择合适的信用返回额度:"));
		JButton sure6 = new JButton("确定");
		sure6.setFont(font);
		sure6.setPreferredSize(preferredSize6);
		JButton cancle6 = new JButton("取消");
		cancle6.setFont(font);
		cancle6.setPreferredSize(preferredSize6);
		JRadioButton c1 = new JRadioButton("50%", true);
		c1.setFont(font);
		JRadioButton c2 = new JRadioButton("100%", false);
		c2.setFont(font);
		subPanel.add(c1);
		subPanel.add(c2);
		subPanel.add(sure6);
		subPanel.add(cancle6);
		layout4.putConstraint(SpringLayout.WEST, c1, (int) (creditFrame6.getWidth() / 2 - 30), SpringLayout.WEST,
				subPanel);
		layout4.putConstraint(SpringLayout.NORTH, c1, 35, SpringLayout.NORTH, subPanel);
		layout4.putConstraint(SpringLayout.WEST, c2, (int) (creditFrame6.getWidth() / 2 - 30), SpringLayout.WEST,
				subPanel);
		layout4.putConstraint(SpringLayout.NORTH, c2, 65, SpringLayout.NORTH, subPanel);
		layout4.putConstraint(SpringLayout.WEST, sure6,
				(int) (creditFrame6.getWidth() / 2 - sure6.getPreferredSize().getWidth() - 7), SpringLayout.WEST,
				subPanel);
		layout4.putConstraint(SpringLayout.NORTH, sure6, 120, SpringLayout.NORTH, subPanel);
		layout4.putConstraint(SpringLayout.WEST, cancle6, 14, SpringLayout.EAST, sure6);
		layout4.putConstraint(SpringLayout.NORTH, cancle6, 120, SpringLayout.NORTH, subPanel);
		creditFrame6.add(subPanel);
		// 次级界面

		table6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if ((table6.getValueAt(table6.getSelectedRow(), table6.getColumnCount() - 1).toString()).toLowerCase()
						.equals("abnormal")) {
					edit6.setEnabled(true);// 选中异常订单时设为true
				}
			}
		});
		search6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = idInput6.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入订单ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
						if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应订单信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						OrderVO vo = oc.getOrder(ID);
						// 获取数据
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table6.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel6.getRowCount(); i++) {
							for (int j = 0; j < defaultModel6.getColumnCount(); j++) {
								table6.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput.setText("");
				}
			}
		});
		prePage6.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table6.getValueAt(0, 0).toString()) - 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从上一页最后开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel6.getRowCount() && ID2 >= ORDERIDBegin; count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.abnormal)) {
							ID2 = ID2 - 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 - 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table6.setValueAt(ob[i], table6.getRowCount() - count - 1, i);
						}
						// 从后到前的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		nextPage6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table6.getValueAt(table6.getRowCount() - 1, 0).toString()) + 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "后面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从下一页第一开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel6.getRowCount() && ID2 <= oc.findMaxId(); count++) {
						ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.abnormal)) {
							ID2 = ID2 + 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 + 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table6.setValueAt(ob[i], count, i);
						}
						// 从前到后的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		edit6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				creditFrame6.setVisible(true);
			}
		});
		// abnormal
		// subFrame
		c1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c2.setSelected(false);
			}
		});
		c2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				c1.setSelected(false);
			}
		});
		sure6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ORDERGET = Long.parseLong(table6.getValueAt(table6.getSelectedRow(), 0).toString());
					long USERIDGET = Long.parseLong(table6.getValueAt(table6.getSelectedRow(), 2).toString());
					OrderController oc = new OrderController();
					CustomerController cc = new CustomerController();
					CustomerVO vo2 = cc.getCustomer(USERIDGET);
					double credit = Double.parseDouble(vo2.getCredit());
					// 获取order与customer
					double CREDITGET = Double.parseDouble(table6.getValueAt(table6.getSelectedRow(), 1).toString());
					// 获取价格——信用值
					if (c1.isSelected()) {// 50%
						vo2.setCredit((credit + CREDITGET / 2) + "");//
					} else {
						vo2.setCredit((credit + CREDITGET) + "");//
					} // 设定返回值
						// 取消异常订单
					oc.cancelOrder(ORDERGET);
					cc.changeCustomer(vo2);
					JOptionPane.showMessageDialog(null, "操作成功", "提示", JOptionPane.PLAIN_MESSAGE);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		cancle6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame6.dispose();
			}
		});
		// subFrame

		// 已取消订单
		p17 = new JPanel();
		p17.setFont(font);
		p17.setLayout(layout4);
		p17.setPreferredSize(preferredSize3);
		p27 = new JPanel();
		p27.setFont(font);
		p37 = new JPanel();
		p37.setFont(font);
		p37.setLayout(layout4);
		p37.setPreferredSize(preferredSize3);
		//
		idInput7 = new JTextField();
		idInput7.setFont(font);
		idInput7.setPreferredSize(preferredSize2);
		search7 = new JButton("搜索");
		search7.setFont(font);
		search7.setPreferredSize(preferredSize6);
		search7.setMaximumSize(preferredSize);
		prePage7 = new JButton("上一页");
		prePage7.setFont(font);
		prePage7.setPreferredSize(preferredSize);
		nextPage7 = new JButton("下一页");
		nextPage7.setFont(font);
		nextPage7.setPreferredSize(preferredSize);
		//
		String[][] p7 = { { "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" },
				{ "", "", "", "", "", "", "", "", "", "" }, { "", "", "", "", "", "", "", "", "", "" } };
		String[] n7 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel7 = new DefaultTableModel(p7, n7) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table7 = new JTable(defaultModel7);
		table7.setFont(font);
		table7.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table7.setRowHeight(25);
		table7.getColumnModel().getColumn(1).setPreferredWidth(50);
		table7.getColumnModel().getColumn(4).setPreferredWidth(110);
		table7.getColumnModel().getColumn(6).setPreferredWidth(110);
		table7.getColumnModel().getColumn(7).setPreferredWidth(110);
		table7.getColumnModel().getColumn(8).setPreferredWidth(110);
		table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table7.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane7 = new JScrollPane(table7);

		p17.add(idInput7);
		p17.add(search7);
		layout4.putConstraint(SpringLayout.EAST, search7, -10, SpringLayout.EAST, p17);
		layout4.putConstraint(SpringLayout.NORTH, search7, 25, SpringLayout.NORTH, p17);
		layout4.putConstraint(SpringLayout.EAST, idInput7, -10, SpringLayout.WEST, search7);
		layout4.putConstraint(SpringLayout.NORTH, idInput7, 25, SpringLayout.NORTH, p17);

		p27.add(scrollPane7);

		p37.add(prePage7);
		p37.add(nextPage7);

		layout4.putConstraint(SpringLayout.WEST, prePage7,
				(int) (p37.getPreferredSize().getWidth() / 2 - prePage7.getPreferredSize().getWidth() - 5),
				SpringLayout.WEST, p37);
		layout4.putConstraint(SpringLayout.NORTH, prePage7, 25, SpringLayout.NORTH, p37);
		layout4.putConstraint(SpringLayout.WEST, nextPage7, 10, SpringLayout.EAST, prePage7);
		layout4.putConstraint(SpringLayout.NORTH, nextPage7, 25, SpringLayout.NORTH, p37);

		//
		panel44.add(p17, BorderLayout.NORTH);
		panel44.add(p27, BorderLayout.CENTER);
		panel44.add(p37, BorderLayout.SOUTH);

		// table7.addMouseListener(new java.awt.event.MouseAdapter() {
		// public void mouseClicked(java.awt.event.MouseEvent e) {
		//
		// }
		// });
		search7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = idInput7.getText();
				id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入订单ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
						if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
							JOptionPane.showMessageDialog(null, "未查询到对应订单信息", "提示", JOptionPane.PLAIN_MESSAGE);
							return;
						}
						// 检测
						OrderVO vo = oc.getOrder(ID);
						// 获取数据
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table7.setValueAt(ob[i], 0, i);
						}
						// 赋值
						for (int i = 1; i < defaultModel7.getRowCount(); i++) {
							for (int j = 0; j < defaultModel7.getColumnCount(); j++) {
								table7.setValueAt("", i, j);
							}
						}
						// 清空多余行
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					idInput7.setText("");
				}
			}
		});
		prePage7.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table7.getValueAt(0, 0).toString()) - 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "前面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从上一页最后开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel7.getRowCount() && ID2 >= ORDERIDBegin; count++) {
						ID2 = ID;

						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.normal)) {
							ID2 = ID2 - 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 - 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table7.setValueAt(ob[i], table7.getRowCount() - count - 1, i);
						}
						// 从后到前的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		nextPage7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					long ID = Long.parseLong(table7.getValueAt(table4.getRowCount() - 1, 0).toString()) + 1;
					OrderController oc = new OrderController();
					if (ID > oc.findMaxId() || ID < ORDERIDBegin) {
						JOptionPane.showMessageDialog(null, "后面已经没有更多订单信息了", "提示", JOptionPane.PLAIN_MESSAGE);
						return;
					}
					// 检测
					// 从下一页第一开始
					long ID2 = ORDERIDBegin;
					for (int count = 0; count < defaultModel7.getRowCount() && ID2 <= oc.findMaxId(); count++) {
						ID2 = ID;

						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.normal)) {
							ID2 = ID2 + 1;
							vo = oc.getOrder(ID2);
						}
						ID = ID2 + 1;
						// ****需设置限制，避免订单到顶
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table7.setValueAt(ob[i], count, i);
						}
						// 从前到后的设置值
					}
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		tab.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				int selectedIndex = tab.getSelectedIndex(); // 获得选中的选项卡索引
//				String title = tab.getTitleAt(selectedIndex); // 获得选项卡标签
//				System.out.println(title);
				switch (selectedIndex) {
				case 0: {
					// 网站促销策略
					PromotionController pc = new PromotionController();
					long IDBEGIN = WPIDBegin;
					try {
						for (int line = 0; line < defaultModel.getRowCount() && IDBEGIN <= pc.findMaxId3(); line++) {
							WebPromotionVO vo = pc.getWebPromotion(IDBEGIN);
							IDBEGIN = IDBEGIN + 1;
							// 获取id
							String BD = vo.getBusinessDistrict()[0];
							for (int i = 1; i < vo.getBusinessDistrict().length; i++) {
								BD = BD + "+" + vo.getBusinessDistrict()[i];
							}
							String[] ob = { vo.getID() + "", vo.getPromotionName(), vo.getBeginTime(), vo.getEndTime(),
									vo.getDiscount() * 100 + "%", BD + "", vo.getMemberType() + "",
									vo.getUsageState().toString(), vo.getCreatedTime() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table.setValueAt(ob[i], line, i);
							}
							// 赋值
						}
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}

					// 网站促销策略
					break;
				}

				case 1: {
					// 会员制度
					try {
						PromotionController pc = new PromotionController();
						long IDBEGIN = MPIDBegin;
						MemberPromotionVO vo = pc.getMemberPromotion(IDBEGIN);
						// 获取
						long IDGET = vo.getID();
						String NAMEGET = vo.getPromotionName();
						String createdTime = vo.getCreatedTime();
						double credits[] = vo.getCredit();
						int lines = credits.length;// 需要的行数
						double discounts[] = vo.getDiscountForMember();
						UsageState us = vo.getUsageState();
						if (us.equals(UsageState.Unused)) {
							apply2.setText("应用");
						} else {
							apply2.setText("退用");
						}
						String[] ob = {};
						// 处理值
						for (int i = 0; i < ob.length; i++) {
							table2.setValueAt(ob[i], 0, i);
						}
						// 赋值
						int rowcount = defaultModel2.getRowCount();// getRowCount返回行数，rowcount<0代表已经没有任何行了。
						while (lines > rowcount) {
							defaultModel2.addRow(new Vector());
							rowcount = rowcount + 1;
							defaultModel2.setRowCount(rowcount);
						} // addrow
						while (lines < rowcount) {
							defaultModel2.removeRow(rowcount);
							rowcount = rowcount - 1;
							defaultModel2.setRowCount(rowcount);
						} // removerow
						table2.revalidate();
						// 改变行数以符合需要
						id2.setText(IDGET + "");
						//
						name2.setText(NAMEGET);
						//
						time2.setText(createdTime);
						//
						if (us.equals(UsageState.Unused)) {
							state2.setText("Unused");
						} else if (us.equals(UsageState.Using)) {
							state2.setText("Using");
						}
						//
						for (int i = 0; i < lines; i++) {
							table2.setValueAt(i + 1, i, 0);
							table2.setValueAt(credits[i], i, 1);
							table2.setValueAt(discounts[i], i, 2);
						}
						// 设置表格内容
					} catch (NumberFormatException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					} catch (RemoteException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					break;
					// 会员制度
				}
				case 2: {
					// 用户信息
					try {
						long ID = USERIDBegin;
						UserController uc=new UserController();
						//
						for (int count = 0; count < defaultModel3.getRowCount()&&ID<=uc.findMaxId(); count++) {
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(ID);
							ID = ID + 1;
							// 获取数据
							//
							String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "",
									vo.getCustomerPhone(), vo.getCompanyName() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table3.setValueAt(ob[i], count, i);
							}
							// 赋值
						}
					} catch (NumberFormatException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					} catch (RemoteException e4) {
						// TODO Auto-generated catch block
						e4.printStackTrace();
					}
					// 用户信息
					break;
				}
				case 3: {
					tab4.setSelectedIndex(0);
					try {
						long ID = ORDERIDBegin;
						OrderController oc = new OrderController();
						// 从下一页第一开始
						long ID2 = ORDERIDBegin;
						for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
							ID2 = ID;
							OrderVO vo = oc.getOrder(ID2);
							while (!vo.getOs().equals(OrderState.unexecute)) {
								ID2 = ID2 + 1;
								vo = oc.getOrder(ID2);
							}
							ID = ID2 + 1;
							String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
									vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
									vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 从前到后的设置值
						}
					} catch (NumberFormatException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (RemoteException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					break;
				}
				}

			}
		});
		tab4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e1) {
				int selectedIndex = tab4.getSelectedIndex(); // 获得选中的选项卡索引
//				String title = tab4.getTitleAt(selectedIndex); // 获得选项卡标签
//				System.out.println(title);
				switch(selectedIndex){
				case 0:{
					try {
						long ID = ORDERIDBegin;
						OrderController oc = new OrderController();
						// 从下一页第一开始
						long ID2 = ORDERIDBegin;
						for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
							ID2 = ID;
							OrderVO vo = oc.getOrder(ID2);
							while (!vo.getOs().equals(OrderState.unexecute)) {
								ID2 = ID2 + 1;
								vo = oc.getOrder(ID2);
							}
							ID = ID2 + 1;
							String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
									vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
									vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 从前到后的设置值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 1:{
					try {
						long ID = ORDERIDBegin;
						OrderController oc = new OrderController();
						// 从下一页第一开始
						long ID2 = ORDERIDBegin;
						for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
							ID2 = ID;
							OrderVO vo = oc.getOrder(ID2);
							while (!vo.getOs().equals(OrderState.normal)) {
								ID2 = ID2 + 1;
								vo = oc.getOrder(ID2);
							}
							ID = ID2 + 1;
							String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
									vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
									vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 从前到后的设置值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 2:{
					try {
						long ID = ORDERIDBegin;
						OrderController oc = new OrderController();
						// 从下一页第一开始
						long ID2 = ORDERIDBegin;
						for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
							ID2 = ID;
							OrderVO vo = oc.getOrder(ID2);
							while (!vo.getOs().equals(OrderState.abnormal)) {
								ID2 = ID2 + 1;
								vo = oc.getOrder(ID2);
							}
							ID = ID2 + 1;
							String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
									vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
									vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 从前到后的设置值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				case 3:{
					try {
						long ID = ORDERIDBegin;
						OrderController oc = new OrderController();
						// 从下一页第一开始
						long ID2 = ORDERIDBegin;
						for (int count = 0; count < defaultModel4.getRowCount() && ID2 <= oc.findMaxId(); count++) {
							ID2 = ID;
							OrderVO vo = oc.getOrder(ID2);
							while (!vo.getOs().equals(OrderState.canceled)) {
								ID2 = ID2 + 1;
								vo = oc.getOrder(ID2);
							}
							ID = ID2 + 1;
							String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
									vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
									vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 从前到后的设置值
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				}
				
				}

			}
		});
		// 初始化与刷新
		
		//界面边界及系统名称
		promotion.setBorder(BorderFactory.createTitledBorder("DS酒店预订系统"));
		member.setBorder(BorderFactory.createTitledBorder("DS酒店预订系统"));
		customer.setBorder(BorderFactory.createTitledBorder("DS酒店预订系统"));
		order.setBorder(BorderFactory.createTitledBorder("DS酒店预订系统"));

	}
}
