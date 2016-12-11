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
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
import businesslogic.hotelbl.HotelController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.userbl.UserController;
import businesslogic.webworkerbl.WebworkerController;
import po.MemberType;
import po.UsageState;
import po.UserPO;
import vo.CustomerVO;
import vo.HotelVO;
import vo.UserVO;
import vo.WebPromotionVO;
import vo.WebworkerVO;

public class WebManagerUI extends JFrame {

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
	Dimension preferredSize5 = new Dimension(75, 20);// 设置尺寸长label
	Dimension preferredSize41 = new Dimension(50, 20);// 设置尺寸次短label
	Dimension preferredSize51 = new Dimension(100, 20);// 设置尺寸更长label
	Dimension preferredSize7 = new Dimension(850, 550);// 设置尺寸
	private JPanel customer;
	private JPanel hotel;
	private JPanel hotelworker;
	private JPanel webmarketer;
	private JFrame frame;
	private JTabbedPane tab;
	// mainui

	private JFrame creditFrame;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JButton prePage;
	private JButton nextPage;
	private JButton search;
	private JButton edit;
	private JTextField idInput;
	// customer

	private JFrame creditFrame2;
	private JPanel panel12;
	private JPanel panel22;
	private JPanel panel32;
	private JButton prePage2;
	private JButton nextPage2;
	private JButton search2;
	private JButton creat2;
	private JButton edit2;
	private JTextField idInput2;
	// hotel

	private JFrame creditFrame3;
	private JPanel panel13;
	private JPanel panel23;
	private JPanel panel33;
	private JButton prePage3;
	private JButton nextPage3;
	private JButton search3;
	private JButton edit3;
	private JTextField idInput3;
	// hotelworker

	private JFrame creditFrame4;
	private JPanel panel14;
	private JPanel panel24;
	private JPanel panel34;
	private JButton prePage4;
	private JButton nextPage4;
	private JButton search4;
	private JButton creat4;
	private JButton edit4;
	private JTextField idInput4;

	// webmarketer
	public static void main(String[] args) {
		WebManagerUI ui = new WebManagerUI();
	}

	public WebManagerUI() {
		frame = new JFrame();
		frame.setFont(font);
		customer = new JPanel();
		customer.setFont(font);
		customer.setPreferredSize(preferredSize7);
		hotel = new JPanel();
		hotel.setFont(font);
		hotel.setPreferredSize(preferredSize7);
		hotelworker = new JPanel();
		hotelworker.setFont(font);
		hotelworker.setPreferredSize(preferredSize7);
		webmarketer = new JPanel();
		webmarketer.setFont(font);
		webmarketer.setPreferredSize(preferredSize7);
		tab = new JTabbedPane(JTabbedPane.LEFT);
		// 容器

		tab.add(customer, "用户信息管理");
		tab.add(hotel, "酒店信息管理");
		tab.add(hotelworker, "酒店管理人员");
		tab.add(webmarketer, "网站营销人员");

		frame.add(tab);
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
		// 用户信息管理
		panel1 = new JPanel();
		panel1.setPreferredSize(preferredSize3);
		SpringLayout layout = new SpringLayout();
		panel1.setLayout(layout);
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel3.setPreferredSize(preferredSize3);
		panel1.setFont(font);
		panel2.setFont(font);
		panel3.setFont(font);
		//
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
		idInput.setFont(font);
		search.setFont(font);
		edit.setFont(font);
		prePage.setFont(font);
		nextPage.setFont(font);
		//
		Object[][] p = { { new Integer(666666), "A", new Integer(500), "07316734520", "NJU" },
				{ new Integer(666667), "B", new Integer(700), "13007567292", "NJU" },
				{ new Integer(666668), "C", new Integer(500), "13874546528", "NJU" },
				{ new Integer(666669), "D", new Integer(7000), "14777889900", "NJU" },
				{ new Integer(666670), "E", new Integer(500), "13002506630", "NJU" },
				{ new Integer(666671), "F", new Integer(700), "16303532678", "NJU" },
				{ new Integer(666672), "G", new Integer(500), "14723456789", "NJU" },
				{ new Integer(666673), "H", new Integer(700), "17089896767", "NJU" }, };
		String[] n = { "ID", "用户名", "信用值", "用户电话", "所属企业" };
		DefaultTableModel defaultModel = new DefaultTableModel(p, n) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		JTable table = new JTable(defaultModel);
		table.setFont(font);
		table.setPreferredScrollableViewportSize(new Dimension(780, 240));
		table.setRowHeight(25);
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
		edit.setEnabled(false);
		customer.add(panel1, BorderLayout.NORTH);
		customer.add(panel2, BorderLayout.CENTER);
		customer.add(panel3, BorderLayout.SOUTH);
		//
		customer.setPreferredSize(preferredSize7);

		Dimension dm1 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm1 = customer.getSize();
		if (tm1.width > dm1.width) { // 修正
			tm1.width = dm1.width;
		}
		if (tm1.height > dm1.height) {
			tm1.height = dm1.height;
		}
		customer.setLocation(dm1.width / 2 - tm1.width / 2, dm1.height / 2 - tm1.height / 2);// 设置尺寸
		// 为屏幕中央

		customer.setFont(font);

		// 次级界面
		creditFrame = new JFrame();
		creditFrame.setTitle("DS酒店管家");
		creditFrame.setSize(600, 220);
		creditFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		// 布局
		creditFrame.setLayout(layout);
		// 数据栏
		JLabel label1 = new JLabel("ID:");
		label1.setPreferredSize(preferredSize41);// short label
		JTextArea text1 = new JTextArea();
		text1.setPreferredSize(preferredSize51);
		JLabel label2 = new JLabel("NAME:");
		label2.setPreferredSize(preferredSize5);// short label
		JTextArea text2 = new JTextArea();
		text2.setPreferredSize(preferredSize5);
		JLabel label3 = new JLabel("信用值:");
		label3.setPreferredSize(preferredSize5);// short label
		JTextArea text3 = new JTextArea();
		text3.setPreferredSize(preferredSize5);
		JLabel label4 = new JLabel("电话:");
		label4.setPreferredSize(preferredSize41);// short label
		JTextArea text4 = new JTextArea();
		text4.setPreferredSize(preferredSize51);
		JLabel label5 = new JLabel("所属企业:");
		label5.setPreferredSize(preferredSize5);// short label
		JTextArea text5 = new JTextArea();
		text5.setPreferredSize(preferredSize5);
		JLabel label6 = new JLabel("密码:");
		label6.setPreferredSize(preferredSize41);// short label
		JTextArea text6 = new JTextArea();
		text6.setPreferredSize(preferredSize51);
		JButton button1 = new JButton("确定");
		button1.setPreferredSize(preferredSize6);
		JButton button2 = new JButton("取消");
		button2.setPreferredSize(preferredSize6);
		text1.setFont(font);
		text2.setFont(font);
		text3.setFont(font);
		text4.setFont(font);
		text5.setFont(font);
		text6.setFont(font);
		label1.setFont(font);
		label2.setFont(font);
		label3.setFont(font);
		label4.setFont(font);
		label5.setFont(font);
		label6.setFont(font);
		button1.setFont(font);
		button2.setFont(font);
		// 添加
		creditFrame.add(label1);
		creditFrame.add(text1);
		text1.setEditable(false);
		creditFrame.add(label2);
		creditFrame.add(text2);
		creditFrame.add(label3);
		creditFrame.add(text3);
		text3.setEditable(false);
		creditFrame.add(label4);
		creditFrame.add(text4);
		creditFrame.add(label5);
		creditFrame.add(text5);
		creditFrame.add(label6);
		creditFrame.add(text6);
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

		layout.putConstraint(SpringLayout.WEST, label4, 45, SpringLayout.WEST, creditFrame);
		layout.putConstraint(SpringLayout.NORTH, label4, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text4, 0, SpringLayout.EAST, label4);
		layout.putConstraint(SpringLayout.NORTH, text4, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label5, 10, SpringLayout.EAST, text4);
		layout.putConstraint(SpringLayout.NORTH, label5, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text5, 0, SpringLayout.EAST, label5);
		layout.putConstraint(SpringLayout.NORTH, text5, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, label6, 10, SpringLayout.EAST, text5);
		layout.putConstraint(SpringLayout.NORTH, label6, 70, SpringLayout.NORTH, creditFrame);
		layout.putConstraint(SpringLayout.WEST, text6, 0, SpringLayout.EAST, label6);
		layout.putConstraint(SpringLayout.NORTH, text6, 70, SpringLayout.NORTH, creditFrame);

		layout.putConstraint(SpringLayout.WEST, button1,
				(int) (creditFrame.getWidth() / 2 - button1.getPreferredSize().getWidth() - 5), SpringLayout.WEST,
				creditFrame);
		layout.putConstraint(SpringLayout.NORTH, button1, 40, SpringLayout.SOUTH, text5);
		layout.putConstraint(SpringLayout.WEST, button2, 10, SpringLayout.EAST, button1);
		layout.putConstraint(SpringLayout.NORTH, button2, 40, SpringLayout.SOUTH, text5);
		// 初始化位置信息
		//
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
				int exi = JOptionPane.showConfirmDialog(null, "确定取消么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame.dispose();
				} else {
					return;
				}
			}
		});

		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idInput.getText().equals("") || idInput.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "请输入用户ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						CustomerController pc = new CustomerController();
						long num = Long.parseLong(idInput.getText().toString());
						CustomerVO vo = pc.getCustomer(num);
						// 获取
						String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "", vo.getCustomerPhone(),
								vo.getCompanyName() };
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
				}

			}
		});
		prePage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table.getValueAt(0, 0).toString();
				// 最高id
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {

						long ID = Long.parseLong(id) - defaultModel.getRowCount();
						//
						for (int count = 0; count < defaultModel.getRowCount(); count++) {
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(ID);
							ID = ID + 1;
							// 获取数据
							//
							String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "", vo.getCustomerPhone(),
									vo.getCompanyName() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table.setValueAt(ob[i], count, i);
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
		nextPage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table.getValueAt(0, 0).toString();
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {

						long ID = Long.parseLong(id) + defaultModel.getRowCount();
						//
						for (int count = 0; count < defaultModel.getRowCount(); count++) {
							CustomerController cc = new CustomerController();
							CustomerVO vo = cc.getCustomer(ID);
							ID = ID + 1;
							// 获取数据
							//
							String[] ob = { vo.getId() + "", vo.getCustomerName(), vo.getCredit() + "", vo.getCustomerPhone(),
									vo.getCompanyName() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table.setValueAt(ob[i], count, i);
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
		table.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

				edit.setEnabled(true);// 选中时设为true

			}
		});
		edit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					creditFrame.setVisible(true);
					CustomerController cc = new CustomerController();
					text1.setText((table.getValueAt(table.getSelectedRow(), 0).toString()));
					text2.setText((table.getValueAt(table.getSelectedRow(), 1).toString()));
					text3.setText((table.getValueAt(table.getSelectedRow(), 2).toString()));
					text4.setText((table.getValueAt(table.getSelectedRow(), 3).toString()));
					text5.setText((table.getValueAt(table.getSelectedRow(), 4).toString()));
					UserController uc = new UserController();
					UserVO pvo = uc.getUser(table.getValueAt(table.getSelectedRow(), 0).toString());
					text6.setText(pvo.getPasssword());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		// 次级
		button1.addActionListener(new ActionListener() {// 确定
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					CustomerController cc = new CustomerController();
					CustomerVO vo = new CustomerVO();
					//
					vo.setId((Long.parseLong(text1.getText())));
					vo.setCustomerName(text2.getText());
					vo.setCredit(text3.getText());
					//
					vo.setCustomerPhone(text4.getText());
					// 处理值
					vo.setCompanyName(text5.getText());
					cc.changeCustomer(vo);
					creditFrame.dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame.dispose();
			}
		});
		// 用户信息管理

		// 酒店信息管理
		panel12 = new JPanel();
		panel12.setFont(font);
		panel12.setPreferredSize(preferredSize3);
		panel12.setLayout(layout);
		panel22 = new JPanel();
		panel22.setFont(font);
		panel32 = new JPanel();
		panel32.setFont(font);
		panel32.setPreferredSize(preferredSize3);
		//
		idInput2 = new JTextField();
		idInput2.setFont(font);
		idInput2.setPreferredSize(preferredSize2);
		search2 = new JButton("搜索");
		search2.setFont(font);
		search2.setPreferredSize(preferredSize6);
		creat2 = new JButton("新增");
		creat2.setFont(font);
		creat2.setPreferredSize(preferredSize6);
		edit2 = new JButton("编辑");
		edit2.setFont(font);
		edit2.setPreferredSize(preferredSize6);
		prePage2 = new JButton("上一页");
		prePage2.setFont(font);
		prePage2.setPreferredSize(preferredSize);
		nextPage2 = new JButton("下一页");
		nextPage2.setFont(font);
		nextPage2.setPreferredSize(preferredSize);
		//
		Object[][] p2 = { { new Integer(666666), "A", "07316734520", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666667), "B", "13007567292", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666668), "C", "13874546528", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666669), "D", "14777889900", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666670), "E", "13002506630", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666671), "F", "16303532678", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666672), "G", "14723456789", "仙林", "南大仙林", "4", "8.7", "NJU" },
				{ new Integer(666673), "H", "17089896767", "仙林", "南大仙林", "4", "8.7", "NJU" }, };
		String[] n2 = { "ID", "酒店名", "电话", "地址", "所属商圈", "星级", "评价", "合作企业" };
		DefaultTableModel defaultModel2 = new DefaultTableModel(p2, n2) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		JTable table2 = new JTable(defaultModel2);
		table2.setFont(font);
		table2.setPreferredScrollableViewportSize(new Dimension(780, 240));
		table2.setRowHeight(25);
		JScrollPane scrollPane2 = new JScrollPane(table2);
		panel12.add(idInput2);
		panel12.add(search2);
		layout.putConstraint(SpringLayout.EAST, search2, -10, SpringLayout.EAST, panel12);
		layout.putConstraint(SpringLayout.NORTH, search2, 25, SpringLayout.NORTH, panel12);
		layout.putConstraint(SpringLayout.EAST, idInput2, -10, SpringLayout.WEST, search2);
		layout.putConstraint(SpringLayout.NORTH, idInput2, 25, SpringLayout.NORTH, panel12);

		panel22.add(scrollPane2);

		panel32.add(creat2);
		panel32.add(prePage2);
		panel32.add(nextPage2);
		panel32.add(edit2);
		edit2.setEnabled(false);
		hotel.add(panel12, BorderLayout.NORTH);
		hotel.add(panel22, BorderLayout.CENTER);
		hotel.add(panel32, BorderLayout.SOUTH);
		//
		hotel.setSize(850, 450);

		Dimension dm2 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm2 = hotel.getSize();
		if (tm2.width > dm2.width) { // 修正
			tm2.width = dm2.width;
		}
		if (tm2.height > dm2.height) {
			tm2.height = dm2.height;
		}
		hotel.setLocation(dm2.width / 2 - tm2.width / 2, dm2.height / 2 - tm2.height / 2);// 设置尺寸
																							// 为屏幕中央

		creditFrame2 = new JFrame();
		creditFrame2.setBackground(Color.darkGray);
		creditFrame2.setTitle("DS酒店管家");
		creditFrame2.setSize(750, 220);
		//

		creditFrame2.setLayout(layout);
		JLabel label12 = new JLabel("ID:");
		label12.setPreferredSize(preferredSize5);// short label
		JTextArea text12 = new JTextArea();
		text12.setPreferredSize(preferredSize5);
		JLabel label22 = new JLabel("NAME:");
		label22.setPreferredSize(preferredSize5);// short label
		JTextArea text22 = new JTextArea();
		text22.setPreferredSize(preferredSize5);
		JLabel label32 = new JLabel("电话:");
		label32.setPreferredSize(preferredSize5);// short label
		JTextArea text32 = new JTextArea();
		text32.setPreferredSize(preferredSize5);
		JLabel label42 = new JLabel("地址:");
		label42.setPreferredSize(preferredSize5);// short label
		JTextArea text42 = new JTextArea();
		text42.setPreferredSize(preferredSize5);
		JLabel label52 = new JLabel("所属商圈:");
		label52.setPreferredSize(preferredSize5);// short label
		JTextArea text52 = new JTextArea();
		text52.setPreferredSize(preferredSize5);
		JLabel label62 = new JLabel("星级:");
		label62.setPreferredSize(preferredSize5);// short label
		JTextArea text62 = new JTextArea();
		text62.setPreferredSize(preferredSize5);
		JLabel label72 = new JLabel("评价:");
		label72.setPreferredSize(preferredSize5);// short label
		JTextArea text72 = new JTextArea();
		text72.setPreferredSize(preferredSize5);
		JLabel label82 = new JLabel("合作企业:");
		label82.setPreferredSize(preferredSize5);// short label
		JTextArea text82 = new JTextArea();
		text82.setPreferredSize(preferredSize5);
		JButton button12 = new JButton("确定");
		button12.setPreferredSize(preferredSize6);
		JButton button22 = new JButton("取消");
		button22.setPreferredSize(preferredSize6);
		text12.setFont(font);
		text22.setFont(font);
		text32.setFont(font);
		text42.setFont(font);
		text52.setFont(font);
		text62.setFont(font);
		text72.setFont(font);
		text82.setFont(font);
		label12.setFont(font);
		label22.setFont(font);
		label32.setFont(font);
		label42.setFont(font);
		label52.setFont(font);
		label62.setFont(font);
		label72.setFont(font);
		label82.setFont(font);
		button12.setFont(font);
		button22.setFont(font);
		creditFrame2.add(label12);
		creditFrame2.add(text12);
		text12.setEditable(false);
		creditFrame2.add(label22);
		creditFrame2.add(text22);
		creditFrame2.add(label32);
		creditFrame2.add(text32);
		creditFrame2.add(label42);
		creditFrame2.add(text42);
		creditFrame2.add(label52);
		creditFrame2.add(text52);
		creditFrame2.add(label62);
		creditFrame2.add(text62);
		creditFrame2.add(label72);
		creditFrame2.add(text72);
		creditFrame2.add(label82);
		creditFrame2.add(text82);
		creditFrame2.add(button12);
		creditFrame2.add(button22);
		//
		layout.putConstraint(SpringLayout.WEST, label12, 45, SpringLayout.WEST, creditFrame2);
		layout.putConstraint(SpringLayout.NORTH, label12, 25, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text12, 0, SpringLayout.EAST, label12);
		layout.putConstraint(SpringLayout.NORTH, text12, 25, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label22, 10, SpringLayout.EAST, text12);
		layout.putConstraint(SpringLayout.NORTH, label22, 25, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text22, 0, SpringLayout.EAST, label22);
		layout.putConstraint(SpringLayout.NORTH, text22, 25, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label32, 10, SpringLayout.EAST, text22);
		layout.putConstraint(SpringLayout.NORTH, label32, 25, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text32, 0, SpringLayout.EAST, label32);
		layout.putConstraint(SpringLayout.NORTH, text32, 25, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label42, 10, SpringLayout.EAST, text32);
		layout.putConstraint(SpringLayout.NORTH, label42, 25, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text42, 0, SpringLayout.EAST, label42);
		layout.putConstraint(SpringLayout.NORTH, text42, 25, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label52, 45, SpringLayout.WEST, creditFrame2);
		layout.putConstraint(SpringLayout.NORTH, label52, 70, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text52, 0, SpringLayout.EAST, label52);
		layout.putConstraint(SpringLayout.NORTH, text52, 70, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label62, 10, SpringLayout.EAST, text52);
		layout.putConstraint(SpringLayout.NORTH, label62, 70, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text62, 0, SpringLayout.EAST, label62);
		layout.putConstraint(SpringLayout.NORTH, text62, 70, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label72, 10, SpringLayout.EAST, text62);
		layout.putConstraint(SpringLayout.NORTH, label72, 70, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text72, 0, SpringLayout.EAST, label72);
		layout.putConstraint(SpringLayout.NORTH, text72, 70, SpringLayout.NORTH, creditFrame2);

		layout.putConstraint(SpringLayout.WEST, label82, 10, SpringLayout.EAST, text72);
		layout.putConstraint(SpringLayout.NORTH, label82, 70, SpringLayout.NORTH, creditFrame2);
		layout.putConstraint(SpringLayout.WEST, text82, 0, SpringLayout.EAST, label82);
		layout.putConstraint(SpringLayout.NORTH, text82, 70, SpringLayout.NORTH, creditFrame2);
		//
		layout.putConstraint(SpringLayout.WEST, button12,
				(int) (creditFrame2.getWidth() / 2 - button12.getPreferredSize().getWidth() - 5), SpringLayout.WEST,
				creditFrame2);
		layout.putConstraint(SpringLayout.NORTH, button12, 40, SpringLayout.SOUTH, text82);
		layout.putConstraint(SpringLayout.WEST, button22, 10, SpringLayout.EAST, button12);
		layout.putConstraint(SpringLayout.NORTH, button22, 40, SpringLayout.SOUTH, text82);
		// 設置位置
		creditFrame2.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		dm2 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		tm2 = creditFrame2.getSize();
		if (tm2.width > dm2.width) { // 修正
			tm2.width = dm2.width;
		}
		if (tm2.height > dm2.height) {
			tm2.height = dm2.height;
		}
		creditFrame2.setLocation(dm2.width / 2 - tm2.width / 2, dm2.height / 2 - tm2.height / 2);// 设置尺寸
																									// 为屏幕中央

		creditFrame2.setFont(font);
		creditFrame2.setVisible(false);
		creditFrame2.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame2.dispose();
				} else {
					return;
				}
			}
		});

		search2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idInput2.getText().equals("") || idInput2.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "请输入酒店ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						HotelController hc = new HotelController();
						long num = Long.parseLong(idInput2.getText().toString());
						HotelVO vo = hc.getHotel(num);
						// 获取

						String[] ob = { vo.getID() + "", vo.getHotelName(), vo.getHotelPhone(), vo.getHotelLocation(),
								vo.getTradeArea(), vo.getStars(), "评价机制不明", vo.getCooperatateCompany() };
						// 处理值
						for (int i = 0; i < defaultModel2.getColumnCount(); i++) {
							table2.setValueAt(ob[i], 0, i);
						}

						// 赋值
						for (int i = 1; i < defaultModel2.getRowCount(); i++) {
							for (int j = 0; j < defaultModel2.getColumnCount(); j++) {
								table2.setValueAt("", i, j);
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
				}
			}
		});
		prePage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table2.getValueAt(0, 0).toString();
				// 最高id
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) - defaultModel2.getRowCount();
						//
						for (int count = 0; count < defaultModel2.getRowCount(); count++) {
							HotelController cc = new HotelController();
							HotelVO vo = cc.getHotel(ID);
							ID = ID + 1;
							// 获取数据
							String[] ob = { vo.getID() + "", vo.getHotelName(), vo.getHotelPhone(),
									vo.getHotelLocation(), vo.getTradeArea(), vo.getStars(), "评价机制不明",
									vo.getCooperatateCompany() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table2.setValueAt(ob[i], count, i);
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
		nextPage2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table2.getValueAt(0, 0).toString();
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) + defaultModel2.getRowCount();
						//
						for (int count = 0; count < defaultModel2.getRowCount(); count++) {
							HotelController cc = new HotelController();
							HotelVO vo = cc.getHotel(ID);
							ID = ID + 1;
							// 获取数据

							String[] ob = { vo.getID() + "", vo.getHotelName(), vo.getHotelPhone(),
									vo.getHotelLocation(), vo.getTradeArea(), vo.getStars(), "评价机制不明",
									vo.getCooperatateCompany() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table2.setValueAt(ob[i], count, i);
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
		table2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				edit2.setEnabled(true);// 选中时设为true
			}
		});
		creat2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame2.setVisible(true);
				text12.setText("");
				// ********怎么获取ID？？？？？？
				text22.setText("");
				text32.setText("");
				text42.setText("");
				text52.setText("");
				text62.setText("");
				text72.setText("");
				text82.setText("");
			}
		});
		edit2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame2.setVisible(true);
				text12.setText(table2.getValueAt(table2.getSelectedRow(), 0).toString());
				text22.setText(table2.getValueAt(table2.getSelectedRow(), 1).toString());
				text32.setText(table2.getValueAt(table2.getSelectedRow(), 2).toString());
				text42.setText(table2.getValueAt(table2.getSelectedRow(), 3).toString());
				text52.setText(table2.getValueAt(table2.getSelectedRow(), 4).toString());
				text62.setText(table2.getValueAt(table2.getSelectedRow(), 5).toString());
				text72.setText(table2.getValueAt(table2.getSelectedRow(), 6).toString());
				text82.setText(table2.getValueAt(table2.getSelectedRow(), 7).toString());
			}
		});
		button12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					HotelController hc = new HotelController();
					HotelVO vo = new HotelVO();
					vo.setID(Long.parseLong(text12.getText()));
					vo.setHotelName(text22.getText());
					vo.setHotelPhone(text32.getText());
					vo.setHotelLocation(text42.getText());
					vo.settradeArea(text52.getText());
					vo.setStars(text62.getText());
					vo.setGoal(Double.parseDouble(text72.getText()));
					// 设定为酒店评价为及时更新
					vo.setCooperatateCompany(text82.getText());
					if (hc.getHotel(vo.getID()) == null) {
						// *****hotelbl确实添加hotel?????
					} else {
						hc.changeHotel(vo);
					}
					// 添加或者更改
					creditFrame2.dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame2.dispose();
			}
		});
		// 酒店管理

		// 酒店管理人员管理
		panel13 = new JPanel();
		panel13.setFont(font);
		panel13.setPreferredSize(preferredSize3);
		panel13.setLayout(layout);
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
		edit3 = new JButton("编辑");
		edit3.setFont(font);
		edit3.setPreferredSize(preferredSize6);
		prePage3 = new JButton("上一页");
		prePage3.setFont(font);
		prePage3.setPreferredSize(preferredSize);
		nextPage3 = new JButton("下一页");
		nextPage3.setFont(font);
		nextPage3.setPreferredSize(preferredSize);
		//
		Object[][] p3 = { { new Integer(666666), "A", "07316734520", "NJU-尼玛啊" },
				{ new Integer(666667), "B", "13007567292", "XL-老友记" },
				{ new Integer(666668), "C", "13874546528", "XL-杨铭宇" },
				{ new Integer(666669), "D", "14777889900", "XL-coco" },
				{ new Integer(666670), "E", "13002506630", "XL-东北屯" },
				{ new Integer(666671), "F", "16303532678", "XL-麻辣意境" },
				{ new Integer(666672), "G", "14723456789", "XL-青春盛宴" },
				{ new Integer(666673), "H", "17089896767", "XL-辣鸡" }, };
		String[] n3 = { "ID", "用户名", "用户电话", "企业名" };
		DefaultTableModel defaultModel3 = new DefaultTableModel(p3, n3) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		JTable table3 = new JTable(defaultModel3);
		table3.setFont(font);
		table3.setPreferredScrollableViewportSize(new Dimension(780, 220));
		table3.setRowHeight(25);
		JScrollPane scrollPane3 = new JScrollPane(table3);
		panel13.add(idInput3);
		panel13.add(search3);
		layout.putConstraint(SpringLayout.EAST, search3, -10, SpringLayout.EAST, panel13);
		layout.putConstraint(SpringLayout.NORTH, search3, 25, SpringLayout.NORTH, panel13);
		layout.putConstraint(SpringLayout.NORTH, idInput3, 25, SpringLayout.NORTH, panel13);
		layout.putConstraint(SpringLayout.EAST, idInput3, -10, SpringLayout.WEST, search3);

		panel23.add(scrollPane3);
		panel33.add(prePage3);
		panel33.add(nextPage3);
		panel33.add(edit3);
		edit3.setEnabled(false);
		hotelworker.add(panel13, BorderLayout.NORTH);
		hotelworker.add(panel23, BorderLayout.CENTER);
		hotelworker.add(panel33, BorderLayout.SOUTH);
		//
		hotelworker.setSize(850, 450);

		creditFrame3 = new JFrame();
		creditFrame3.setBackground(Color.darkGray);
		creditFrame3.setTitle("DS酒店管家");
		creditFrame3.setSize(600, 220);/////
		//
		creditFrame3.setLayout(layout);
		JLabel label13 = new JLabel("ID:");
		label13.setPreferredSize(preferredSize5);// short label
		JTextArea text13 = new JTextArea();
		text13.setPreferredSize(preferredSize5);
		JLabel label23 = new JLabel("NAME:");
		label23.setPreferredSize(preferredSize5);// short label
		JTextArea text23 = new JTextArea();
		text23.setPreferredSize(preferredSize5);
		JLabel label33 = new JLabel("电话:");
		label33.setPreferredSize(preferredSize5);// short label
		JTextArea text33 = new JTextArea();
		text33.setPreferredSize(preferredSize5);
		JLabel label43 = new JLabel("所属酒店:");
		label43.setPreferredSize(preferredSize5);// short label
		JTextArea text43 = new JTextArea();
		text43.setPreferredSize(preferredSize5);
		JLabel label53 = new JLabel("密码:");
		label53.setPreferredSize(preferredSize5);// short label
		JTextArea text53 = new JTextArea();
		text53.setPreferredSize(preferredSize5);
		JButton button13 = new JButton("确定");
		button13.setPreferredSize(preferredSize6);
		JButton button23 = new JButton("取消");
		button23.setPreferredSize(preferredSize6);
		text13.setFont(font);
		text23.setFont(font);
		text33.setFont(font);
		text43.setFont(font);
		text53.setFont(font);
		label13.setFont(font);
		label23.setFont(font);
		label33.setFont(font);
		label43.setFont(font);
		label53.setFont(font);
		button13.setFont(font);
		button23.setFont(font);
		creditFrame3.add(label13);
		creditFrame3.add(text13);
		text13.setEditable(false);
		creditFrame3.add(label23);
		creditFrame3.add(text23);
		creditFrame3.add(label33);
		creditFrame3.add(text33);
		creditFrame3.add(label43);
		creditFrame3.add(text43);
		creditFrame3.add(label53);
		creditFrame3.add(text53);
		creditFrame3.add(button13);
		creditFrame3.add(button23);
		//
		layout.putConstraint(SpringLayout.WEST, label13, 75, SpringLayout.WEST, creditFrame3);
		layout.putConstraint(SpringLayout.NORTH, label13, 25, SpringLayout.NORTH, creditFrame3);
		layout.putConstraint(SpringLayout.WEST, text13, 0, SpringLayout.EAST, label13);
		layout.putConstraint(SpringLayout.NORTH, text13, 25, SpringLayout.NORTH, creditFrame3);

		layout.putConstraint(SpringLayout.WEST, label23, 10, SpringLayout.EAST, text13);
		layout.putConstraint(SpringLayout.NORTH, label23, 25, SpringLayout.NORTH, creditFrame3);
		layout.putConstraint(SpringLayout.WEST, text23, 0, SpringLayout.EAST, label23);
		layout.putConstraint(SpringLayout.NORTH, text23, 25, SpringLayout.NORTH, creditFrame3);

		layout.putConstraint(SpringLayout.WEST, label33, 10, SpringLayout.EAST, text23);
		layout.putConstraint(SpringLayout.NORTH, label33, 25, SpringLayout.NORTH, creditFrame3);
		layout.putConstraint(SpringLayout.WEST, text33, 0, SpringLayout.EAST, label33);
		layout.putConstraint(SpringLayout.NORTH, text33, 25, SpringLayout.NORTH, creditFrame3);

		layout.putConstraint(SpringLayout.WEST, label43, 125, SpringLayout.WEST, creditFrame3);
		layout.putConstraint(SpringLayout.NORTH, label43, 70, SpringLayout.NORTH, creditFrame3);
		layout.putConstraint(SpringLayout.WEST, text43, 0, SpringLayout.EAST, label43);
		layout.putConstraint(SpringLayout.NORTH, text43, 70, SpringLayout.NORTH, creditFrame3);

		layout.putConstraint(SpringLayout.WEST, text53, 375, SpringLayout.WEST, creditFrame3);
		layout.putConstraint(SpringLayout.NORTH, text53, 70, SpringLayout.NORTH, creditFrame3);
		layout.putConstraint(SpringLayout.EAST, label53, 0, SpringLayout.WEST, text53);
		layout.putConstraint(SpringLayout.NORTH, label53, 70, SpringLayout.NORTH, creditFrame3);

		//
		layout.putConstraint(SpringLayout.WEST, button13,
				(int) (creditFrame3.getWidth() / 2 - button13.getPreferredSize().getWidth() - 5), SpringLayout.WEST,
				creditFrame3);
		layout.putConstraint(SpringLayout.NORTH, button13, 40, SpringLayout.SOUTH, text53);
		layout.putConstraint(SpringLayout.WEST, button23, 10, SpringLayout.EAST, button13);
		layout.putConstraint(SpringLayout.NORTH, button23, 40, SpringLayout.SOUTH, text53);
		// 設置位置

		creditFrame3.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Dimension dm3 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm3 = creditFrame3.getSize();
		if (tm3.width > dm3.width) { // 修正
			tm3.width = dm3.width;
		}
		if (tm3.height > dm3.height) {
			tm3.height = dm3.height;
		}
		creditFrame3.setLocation(dm3.width / 2 - tm3.width / 2, dm3.height / 2 - tm3.height / 2);// 设置尺寸
		// 界面居中设置 // 为屏幕中央

		creditFrame3.setFont(font);
		creditFrame3.setVisible(false);
		creditFrame3.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
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
				if (idInput3.getText().equals("") || idInput3.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "请输入酒店ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						HotelController hc = new HotelController();
						long num = Long.parseLong(idInput3.getText().toString());
						HotelVO vo = hc.getHotel(num);
						// 获取

						String[] ob = { vo.getID() + "", vo.getHotelManager(), vo.getHotelManPhone(),
								vo.getHotelName() };
						// 处理值
						for (int i = 0; i < defaultModel3.getColumnCount(); i++) {
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

				}
			}
		});
		prePage3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table3.getValueAt(0, 0).toString();
				// 最高id
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) - defaultModel3.getRowCount();
						//
						for (int count = 0; count < defaultModel3.getRowCount(); count++) {
							HotelController cc = new HotelController();
							HotelVO vo = cc.getHotel(ID);
							ID = ID + 1;
							// 获取数据
							String[] ob = { vo.getID() + "", vo.getHotelManager(), vo.getHotelManPhone(),
									vo.getHotelName() };
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
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) + defaultModel3.getRowCount();
						//
						for (int count = 0; count < defaultModel3.getRowCount(); count++) {
							HotelController cc = new HotelController();
							HotelVO vo = cc.getHotel(ID);
							ID = ID + 1;
							// 获取数据

							String[] ob = { vo.getID() + "", vo.getHotelManager(), vo.getHotelManPhone(),
									vo.getHotelName() };
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
		table3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				edit3.setEnabled(true);// 选中时设为true
			}
		});
		edit3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					creditFrame3.setVisible(true);
					text13.setText(table3.getValueAt(table3.getSelectedRow(), 0).toString());
					text23.setText(table3.getValueAt(table3.getSelectedRow(), 1).toString());
					text33.setText(table3.getValueAt(table3.getSelectedRow(), 2).toString());
					text43.setText(table3.getValueAt(table3.getSelectedRow(), 3).toString());
					UserController uc = new UserController();
					UserVO vo = uc.getUser(table3.getValueAt(table3.getSelectedRow(), 0).toString());
					text53.setText(vo.getPasssword());
					// ********获取密码??
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					HotelController hc = new HotelController();
					HotelVO vo = hc.getHotel(Long.parseLong(text13.getText()));
					UserController uc = new UserController();
					UserVO uvo = uc.getUser(table3.getValueAt(table3.getSelectedRow(), 0).toString());
					//
					vo.setHotelManager(text23.getText());
					vo.setHotelManPhone(text33.getText());
					hc.changeHotel(vo);
					// 改变信息
					uvo.setPasssword(text43.getText());
					uc.changeUser(uvo);
					// 改变密码
					creditFrame3.dispose();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button23.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame3.dispose();
			}
		});
		// 酒店管理人员管理
		// 网站营销人员
		panel14 = new JPanel();
		panel14.setFont(font);
		panel14.setPreferredSize(preferredSize3);
		panel14.setLayout(layout);
		panel24 = new JPanel();
		panel24.setFont(font);
		panel34 = new JPanel();
		panel34.setFont(font);
		panel34.setPreferredSize(preferredSize3);
		//
		idInput4 = new JTextField();
		idInput4.setFont(font);
		idInput4.setPreferredSize(preferredSize2);
		search4 = new JButton("搜索");
		search4.setFont(font);
		search4.setPreferredSize(preferredSize6);
		creat4 = new JButton("新增");
		creat4.setFont(font);
		creat4.setPreferredSize(preferredSize6);
		edit4 = new JButton("编辑");
		edit4.setFont(font);
		edit4.setPreferredSize(preferredSize6);
		prePage4 = new JButton("上一页");
		prePage4.setFont(font);
		prePage4.setPreferredSize(preferredSize);
		nextPage4 = new JButton("下一页");
		nextPage4.setFont(font);
		nextPage4.setPreferredSize(preferredSize);
		//
		Object[][] p4 = { { new Integer(666666), "A", "07316734520", "NJU-尼玛啊" },
				{ new Integer(666667), "B", "13007567292", "XL-老友记" },
				{ new Integer(666668), "C", "13874546528", "XL-杨铭宇" },
				{ new Integer(666669), "D", "14777889900", "XL-coco" },
				{ new Integer(666670), "E", "13002506630", "XL-东北屯" },
				{ new Integer(666671), "F", "16303532678", "XL-麻辣意境" },
				{ new Integer(666672), "G", "14723456789", "XL-青春盛宴" },
				{ new Integer(666673), "H", "17089896767", "XL-辣鸡" }, };
		String[] n4 = { "ID", "用户名", "用户电话" };
		DefaultTableModel defaultModel4 = new DefaultTableModel(p4, n4) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		JTable table4 = new JTable(defaultModel4);
		table4.setFont(font);
		table4.setPreferredScrollableViewportSize(new Dimension(780, 220));
		table4.setRowHeight(25);
		JScrollPane scrollPane4 = new JScrollPane(table4);
		panel14.add(idInput4);
		panel14.add(search4);
		layout.putConstraint(SpringLayout.EAST, search4, -10, SpringLayout.EAST, panel14);
		layout.putConstraint(SpringLayout.NORTH, search4, 25, SpringLayout.NORTH, panel14);
		layout.putConstraint(SpringLayout.NORTH, idInput4, 25, SpringLayout.NORTH, panel14);
		layout.putConstraint(SpringLayout.EAST, idInput4, -10, SpringLayout.WEST, search4);

		panel24.add(scrollPane4);

		panel34.add(creat4);
		panel34.add(prePage4);
		panel34.add(nextPage4);
		panel34.add(edit4);
		edit4.setEnabled(false);
		webmarketer.add(panel14, BorderLayout.NORTH);
		webmarketer.add(panel24, BorderLayout.CENTER);
		webmarketer.add(panel34, BorderLayout.SOUTH);
		//
		webmarketer.setSize(850, 450);

		creditFrame4 = new JFrame();
		creditFrame4.setBackground(Color.darkGray);
		creditFrame4.setTitle("DS酒店管家");
		creditFrame4.setSize(750, 170);/////
		//
		creditFrame4.setLayout(layout);
		JLabel label14 = new JLabel("ID:");
		label14.setPreferredSize(preferredSize5);// short label
		JTextArea text14 = new JTextArea();
		text14.setPreferredSize(preferredSize5);
		JLabel label24 = new JLabel("NAME:");
		label24.setPreferredSize(preferredSize5);// short label
		JTextArea text24 = new JTextArea();
		text24.setPreferredSize(preferredSize5);
		JLabel label34 = new JLabel("电话:");
		label34.setPreferredSize(preferredSize5);// short label
		JTextArea text34 = new JTextArea();
		text34.setPreferredSize(preferredSize5);
		JLabel label44 = new JLabel("密码:");
		label44.setPreferredSize(preferredSize5);// short label
		JTextArea text44 = new JTextArea();
		text44.setPreferredSize(preferredSize5);
		JButton button14 = new JButton("确定");
		button14.setPreferredSize(preferredSize6);
		JButton button24 = new JButton("取消");
		button24.setPreferredSize(preferredSize6);
		text14.setFont(font);
		text24.setFont(font);
		text34.setFont(font);
		text44.setFont(font);
		label14.setFont(font);
		label24.setFont(font);
		label34.setFont(font);
		label44.setFont(font);
		button14.setFont(font);
		button24.setFont(font);

		creditFrame4.add(label14);
		creditFrame4.add(text14);
		text14.setEditable(false);
		creditFrame4.add(label24);
		creditFrame4.add(text24);
		creditFrame4.add(label34);
		creditFrame4.add(text34);
		creditFrame4.add(label44);
		creditFrame4.add(text44);
		creditFrame4.add(button14);
		creditFrame4.add(button24);
		//
		layout.putConstraint(SpringLayout.WEST, label14, 45, SpringLayout.WEST, creditFrame4);
		layout.putConstraint(SpringLayout.NORTH, label14, 25, SpringLayout.NORTH, creditFrame4);
		layout.putConstraint(SpringLayout.WEST, text14, 0, SpringLayout.EAST, label14);
		layout.putConstraint(SpringLayout.NORTH, text14, 25, SpringLayout.NORTH, creditFrame4);

		layout.putConstraint(SpringLayout.WEST, label24, 10, SpringLayout.EAST, text14);
		layout.putConstraint(SpringLayout.NORTH, label24, 25, SpringLayout.NORTH, creditFrame4);
		layout.putConstraint(SpringLayout.WEST, text24, 0, SpringLayout.EAST, label24);
		layout.putConstraint(SpringLayout.NORTH, text24, 25, SpringLayout.NORTH, creditFrame4);

		layout.putConstraint(SpringLayout.WEST, label34, 10, SpringLayout.EAST, text24);
		layout.putConstraint(SpringLayout.NORTH, label34, 25, SpringLayout.NORTH, creditFrame4);
		layout.putConstraint(SpringLayout.WEST, text34, 0, SpringLayout.EAST, label34);
		layout.putConstraint(SpringLayout.NORTH, text34, 25, SpringLayout.NORTH, creditFrame4);

		layout.putConstraint(SpringLayout.WEST, label44, 10, SpringLayout.EAST, text34);
		layout.putConstraint(SpringLayout.NORTH, label44, 25, SpringLayout.NORTH, creditFrame4);
		layout.putConstraint(SpringLayout.WEST, text44, 0, SpringLayout.EAST, label44);
		layout.putConstraint(SpringLayout.NORTH, text44, 25, SpringLayout.NORTH, creditFrame4);

		//
		layout.putConstraint(SpringLayout.WEST, button14,
				(int) (creditFrame4.getWidth() / 2 - button14.getPreferredSize().getWidth() - 5), SpringLayout.WEST,
				creditFrame4);
		layout.putConstraint(SpringLayout.NORTH, button14, 40, SpringLayout.SOUTH, text44);
		layout.putConstraint(SpringLayout.WEST, button24, 10, SpringLayout.EAST, button14);
		layout.putConstraint(SpringLayout.NORTH, button24, 40, SpringLayout.SOUTH, text44);
		// 設置位置

		creditFrame4.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		Dimension dm4 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
		Dimension tm4 = creditFrame.getSize();
		if (tm4.width > dm4.width) { // 修正
			tm4.width = dm4.width;
		}
		if (tm4.height > dm4.height) {
			tm4.height = dm4.height;
		}
		creditFrame4.setLocation(dm4.width / 2 - tm4.width / 2, dm4.height / 2 - tm4.height / 2);// 设置尺寸
		// 界面居中设置 // 为屏幕中央

		creditFrame4.setFont(font);
		creditFrame4.setVisible(false);
		creditFrame4.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int exi = JOptionPane.showConfirmDialog(null, "确定退出么？", "提示", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (exi == JOptionPane.YES_OPTION) {
					creditFrame4.dispose();
				} else {
					return;
				}
			}
		});

		search4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (idInput4.getText().equals("") || idInput4.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "请输入酒店ID", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						WebworkerController wc = new WebworkerController();
						long num = Long.parseLong(idInput4.getText().toString());
						WebworkerVO vo = wc.getWebworker(num);
						// 获取

						String[] ob = { vo.getID() + "", vo.getWebworkerName(), vo.getWebworkerPhone() };
						// 处理值
						for (int i = 0; i < defaultModel4.getColumnCount(); i++) {
							table4.setValueAt(ob[i], 0, i);
						}

						// 赋值
						for (int i = 1; i < defaultModel4.getRowCount(); i++) {
							for (int j = 0; j < defaultModel4.getColumnCount(); j++) {
								table4.setValueAt("", i, j);
							}
						}
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// 清空多余行

				}
			}
		});
		prePage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table4.getValueAt(0, 0).toString();
				// 最高id
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					try {
						long ID = Long.parseLong(id) - defaultModel4.getRowCount();
						//
						for (int count = 0; count < defaultModel4.getRowCount(); count++) {
							WebworkerController wc = new WebworkerController();
							WebworkerVO vo = wc.getWebworker(ID);
							ID = ID + 1;
							// 获取数据
							String[] ob = { vo.getID() + "", vo.getWebworkerName(), vo.getWebworkerPhone() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
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
		nextPage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String id = table3.getValueAt(0, 0).toString();
				id = id.replace(" ", "");
				if (id.equals(null) || id.equals("")) {
					JOptionPane.showMessageDialog(null, "NOT FIND!", "提示", JOptionPane.PLAIN_MESSAGE);
				} else {
					long ID = 0;
					try {
						ID = Long.parseLong(id) + defaultModel4.getRowCount();
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					//
					for (int count = 0; count < defaultModel4.getRowCount(); count++) {
						try {
							WebworkerController wc = new WebworkerController();
							WebworkerVO vo = wc.getWebworker(ID);
							ID = ID + 1;
							// 获取数据
							String[] ob = { vo.getID() + "", vo.getWebworkerName(), vo.getWebworkerPhone() };
							// 处理值
							for (int i = 0; i < ob.length; i++) {
								table4.setValueAt(ob[i], count, i);
							}
							// 赋值
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		});
		table4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {

				edit4.setEnabled(true);// 选中时设为true

			}
		});
		creat4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// ******获取ID
				creditFrame4.setVisible(true);
			}
		});
		edit4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					creditFrame4.setVisible(true);
					text14.setText(table4.getValueAt(table4.getSelectedRow(), 0).toString());
					text24.setText(table4.getValueAt(table4.getSelectedRow(), 1).toString());
					text34.setText(table4.getValueAt(table4.getSelectedRow(), 2).toString());
					UserController uc = new UserController();
					UserVO uvo = uc.getUser(table4.getValueAt(table4.getSelectedRow(), 0).toString());
					text44.setText(uvo.getPasssword());
					// ********获取密码??
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				UserController uc = new UserController();
				WebworkerController wc = new WebworkerController();
				try {

					if (wc.getWebworker(Long.parseLong(text14.getText())) == null) {// 新增
						WebworkerVO vo = new WebworkerVO();
						UserVO uvo = new UserVO();
						//
						vo.setID(Long.parseLong(text14.getText()));
						vo.setWebworkerName(text24.getText());
						vo.setWebworkerPhone(text34.getText());
						wc.changeWebworker(vo);
						// 信息
						uvo.setId(Long.parseLong(text14.getText()));
						uvo.setPasssword(text44.getText());
						uc.changeUser(uvo);
						// 密码
						// 新增
					} else {
						WebworkerVO vo = wc.getWebworker(Long.parseLong(text14.getText()));
						UserVO uvo = uc.getUser(text14.getText().toString());
						//
						vo.setWebworkerName(text24.getText());
						vo.setWebworkerPhone(text34.getText());
						wc.changeWebworker(vo);
						// 改变信息
						uvo.setPasssword(text44.getText());
						uc.changeUser(uvo);
						// 改变密码
					}

				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 判断改与增
				creditFrame4.dispose();
			}
		});
		// **********用户注册时用户名尚未考虑
		button24.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				creditFrame4.dispose();
			}
		});

	}

}
