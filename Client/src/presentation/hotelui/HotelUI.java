package presentation.hotelui;

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


import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;

import javax.swing.JComboBox;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import javax.swing.SpringLayout;
import javax.swing.UIManager;


import javax.swing.table.DefaultTableModel;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;


import org.jvnet.substance.theme.SubstanceOrangeTheme;

import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBinaryWatermark;

import businesslogic.customerbl.CustomerController;
import businesslogic.hotelbl.HotelBL;
import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.roombl.RoomController;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;
import po.MemberType;
import po.OrderState;
import po.RoomPO;
import po.UsageState;
import vo.CustomerVO;
import vo.HotelPromotionVO;
import vo.HotelVO;
import vo.MemberPromotionVO;
import vo.OrderVO;
import vo.RoomVO;
import vo.WebPromotionVO;

public class HotelUI extends JFrame {
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
	Dimension preferredSize5 = new Dimension(75, 20);// 设置尺寸长label,textarea
	Dimension preferredSize7 = new Dimension(850, 550);// 设置尺寸
	private static JFrame frame;
	private JTabbedPane tab;
	private JPanel hotelInformation;
	private JPanel roomInformation;
	private JPanel promotionInformation;
	private JPanel orderInformation;
	
	//hotelInformation
	HotelVO hvo;
	JTextField jth=new JTextField();
	JTextField jth01=new JTextField();
	JTextField jth11=new JTextField();
	JTextField jth13=new JTextField();
	JTextField jth14=new JTextField();
	JTextField jth15=new JTextField();
	JComboBox<String> jc2=new JComboBox<>(new MBox());
	JComboBox<String> jc6=new JComboBox<>(new MyboBox());
	
	//roomInformation
	RoomVO rvo01,rvo02,rvo03,rvo04,rvo05,rvo00;
	JTextField jt100=new JTextField();
	JTextField jt110=new JTextField();
	JTextField jt120=new JTextField();
	
	JTextField jt200=new JTextField();
	JTextField jt210=new JTextField();
	JTextField jt220=new JTextField();
	
	JTextField jt300=new JTextField();
	JTextField jt310=new JTextField();
	JTextField jt320=new JTextField();
	
	JTextField jt400=new JTextField();
	JTextField jt410=new JTextField();
	JTextField jt420=new JTextField();
	
	JTextField jt500=new JTextField();
	JTextField jt510=new JTextField();
	JTextField jt520=new JTextField();
	
	JTextField jt600=new JTextField();
	JTextField jt610=new JTextField();
	JTextField jt620=new JTextField();
	
	//PromotionInformation
	HotelPromotionVO hpvo;
	JTextField jtp22=new JTextField();
	JTextField jtp24=new JTextField();
	JTextField jtp32=new JTextField();
	JTextField jtp42=new JTextField();
	JTextField jtp52=new JTextField();
	JTextField jtp54=new JTextField();
	JTextField jtp56=new JTextField();
	
	//orderInformation
	private JPanel panel12;
	private JPanel panel14;// normal,unexecuted
	private JPanel panel24;// executed
	private JPanel panel34;// abnormal
	private JPanel panel44;// cancled
	
	private JFrame finishFrame4;
	private JPanel p14;
	private JPanel p24;
	private JPanel p34;
	private JButton search4;
	private JButton prePage4;
	private JButton nextPage4;
	private JTextField idInput4;
	private JButton edit4;

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
	

	public HotelUI() throws RemoteException{

		frame = new JFrame();

		SubstanceLookAndFeel slaf=new SubstanceLookAndFeel();
		try {  
            //设置外观  
            UIManager.setLookAndFeel(slaf);  
            //设置主题   
            slaf.setCurrentTheme(new SubstanceOrangeTheme());  
            //设置按钮外观  
            slaf.setCurrentButtonShaper(new ClassicButtonShaper());  
            //设置水印  
            slaf.setCurrentWatermark(new SubstanceBinaryWatermark());  
            //设置边框  
            slaf.setCurrentBorderPainter(new StandardBorderPainter());  
            //设置渐变渲染  
            slaf.setCurrentGradientPainter(new StandardGradientPainter());  
            //设置标题  
            slaf.setCurrentTitlePainter(new FlatTitlePainter());  
        } catch (Exception e) {  
            System.out.println(e.getMessage());  
        }
       
		hotelInformation= new JPanel();
		hotelInformation.setPreferredSize(preferredSize7);
		roomInformation= new JPanel();
		roomInformation.setPreferredSize(preferredSize7);
		orderInformation= new JPanel();
		orderInformation.setPreferredSize(preferredSize7);
		promotionInformation= new JPanel();
		promotionInformation.setPreferredSize(preferredSize7);
		tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.setFont(font);
		// 容器

		tab.add(hotelInformation, "酒店信息处理");
		tab.add(roomInformation, "房间信息处理");
		tab.add(promotionInformation, "促销信息处理");
		tab.add(orderInformation, "订单信息处理");

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
		//hotelInformation
				hotelInformation.setLayout(null);
				HotelController hcl;
				try {
					hcl = new HotelController();
//删除注释					hvo=hcl.getHotel(10000);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			    
			    
				JLabel jh=new JLabel();
				jh.setText("酒店管理");
				jh.setFont(font);
				jh.setBounds(240,0,70,50);
				jh.setOpaque(true);
				hotelInformation.add(jh);
				
				
				jth.setBounds(320,15,200,20);
				jth.setFont(font);
				jth.setEditable(false);
				//jth.setText(hvo.getHotelManager());
				hotelInformation.add(jth);
				
				JLabel jh0=new JLabel();
				jh0.setText("管理电话");
				jh0.setFont(font);
				jh0.setBounds(240,50,70,50);
				jh0.setOpaque(true);
				hotelInformation.add(jh0);
				
				
				jth01.setBounds(320,65,200,20);
				jth01.setFont(font);
				jth01.setEditable(false);
				//jth01.setText(hvo.getHotelManPhone());
				hotelInformation.add(jth01);
				
				JLabel jh1=new JLabel();
				jh1.setText("酒店名字");
				jh1.setFont(font);
				jh1.setBounds(240,100,70,50);
				jh1.setOpaque(true);
				hotelInformation.add(jh1);
				
				
				jth11.setBounds(320,115,200,20);
				jth11.setFont(font);
				jth11.setEditable(false);
				//jth11.setText(hvo.getHotelName());
				hotelInformation.add(jth11);
				
				JLabel jh2=new JLabel();
				jh2.setText("所属商圈");
				jh2.setFont(font);
				jh2.setBounds(240,300,70,50);
				jh2.setOpaque(true);
				hotelInformation.add(jh2);
				
				jc2.setBounds(320,315,70,20);
				jc2.setFont(font);
				jc2.setEditable(false);
				hotelInformation.add(jc2);
				
				JLabel jh3=new JLabel();
				jh3.setText("酒店地址");
				jh3.setFont(font);
				jh3.setBounds(240,150,70,50);
				jh3.setOpaque(true);
				hotelInformation.add(jh3);
				
				
				jth13.setBounds(320,165,200,20);
				jth13.setFont(font);
				jth13.setEditable(false);
				//jth13.setText(hvo.getHotelLocation());
				hotelInformation.add(jth13);
				
				JLabel jh4=new JLabel();
				jh4.setText("酒店简介");
				jh4.setFont(font);
				jh4.setBounds(240,200,70,50);
				jh4.setOpaque(true);
				hotelInformation.add(jh4);
				
				
				jth14.setBounds(320,215,200,20);
				jth14.setFont(font);
				jth14.setEditable(false);
				//jth14.setText(hvo.getInstruction());
				hotelInformation.add(jth14);
				
				JLabel j5=new JLabel();
				j5.setText("酒店电话");
				j5.setFont(font);
				j5.setBounds(240,250,70,50);
				j5.setOpaque(true);
				hotelInformation.add(j5);
				
				
				jth15.setBounds(320,265,200,20);
				jth15.setFont(font);
				jth15.setEditable(false);
				//jth15.setText(hvo.getHotelPhone());
				hotelInformation.add(jth15);
				
				JLabel jh6=new JLabel();
				jh6.setText("酒店星级");
				jh6.setFont(font);
				jh6.setBounds(240,350,70,50);
				jh6.setOpaque(true);
				hotelInformation.add(jh6);
				
				
				jc6.setBounds(320,365,70,20);
				jc6.setFont(font);
				jc6.setEditable(false);
				hotelInformation.add(jc6);
				
				JButton b1=new JButton("编辑");
				b1.setBounds(500,380,80,20);
				b1.setFont(font);
				hotelInformation.add(b1);
				b1.addActionListener(new b1Action());
				
				JButton b2=new JButton("确认");
				b2.setFont(font);
				b2.setBounds(600,380,80,20);
				hotelInformation.add(b2);
				b2.addActionListener(new b2Action());
				
				//roomInformation
				roomInformation.setLayout(null);
				
				RoomController rcl = new RoomController();
			/*	rvo00=rcl.getRoom(100000); 
				rvo01=rcl.getRoom(100001);
				rvo02=rcl.getRoom(100002);
				rvo03=rcl.getRoom(100003);
				rvo04=rcl.getRoom(100004);
				rvo05=rcl.getRoom(100005);
				*/
				
				JLabel j10=new JLabel();
				j10.setText("房间类型");
				j10.setFont(font);
				j10.setBounds(10,50,65,50);
				j10.setOpaque(true);
				roomInformation.add(j10);
				
				
				jt100.setBounds(80,65,50,20);
				jt100.setFont(font);
				jt100.setEditable(false);
			    //jt100.setText(rvo00.getRoomType());
				roomInformation.add(jt100);
				
				JLabel j11=new JLabel();
				j11.setText("房间数量");
				j11.setFont(font);
				j11.setBounds(10,90,65,50);
				j11.setOpaque(true);
				roomInformation.add(j11);
				
				
				jt110.setBounds(80,105,50,20);
				jt110.setFont(font);
				jt110.setEditable(false);
				//jt110.setText(rvo00.getRoomAccessNumber()+"");
				roomInformation.add(jt110);
				
				JLabel j12=new JLabel();
				j12.setText("房间价格");
				j12.setFont(font);
				j12.setBounds(10,130,65,50);
				j12.setOpaque(true);
				roomInformation.add(j12);
				
				
				jt120.setBounds(80,145,50,20);
				jt120.setFont(font);
				jt120.setEditable(false);
				//jt120.setText(rvo00.getRoomPrice()+"");
				roomInformation.add(jt120);
				
				//第二，类型数量差40，文本差55，15，大模块差135
				
				
				JLabel j20=new JLabel();
				j20.setText("房间类型");
				j20.setFont(font);
				j20.setBounds(10,200,65,50);
				j20.setOpaque(true);
				roomInformation.add(j20);
				
				
				jt200.setBounds(80,215,50,20);
				jt200.setFont(font);
				jt200.setEditable(false);
				//jt200.setText(rvo01.getRoomType());
				roomInformation.add(jt200);
				
				JLabel j21=new JLabel();
				j21.setText("房间数量");
				j21.setFont(font);
				j21.setBounds(10,240,65,50);
				j21.setOpaque(true);
				roomInformation.add(j21);
				
				
				jt210.setBounds(80,255,50,20);
				jt210.setFont(font);
				jt210.setEditable(false);
				//jt210.setText(rvo01.getRoomAccessNumber()+"");
				roomInformation.add(jt210);
				
				JLabel j22=new JLabel();
				j22.setText("房间价格");
				j22.setFont(font);
				j22.setBounds(10,280,65,50);
				j22.setOpaque(true);
				roomInformation.add(j22);
				
				
				jt220.setBounds(80,295,50,20);
				jt220.setFont(font);
				jt220.setEditable(false);
				//jt220.setText(rvo01.getRoomPrice()+"");
				roomInformation.add(jt220);
				
				//第三
				JLabel j30=new JLabel();
				j30.setText("房间类型");
				j30.setFont(font);
				j30.setBounds(200,50,65,50);
				j30.setOpaque(true);
				roomInformation.add(j30);
				
				
				jt300.setBounds(270,65,50,20);
				jt300.setFont(font);
				jt300.setEditable(false);
				//jt300.setText(rvo02.getRoomType());
				roomInformation.add(jt300);
				
				JLabel j31=new JLabel();
				j31.setText("房间数量");
				j31.setFont(font);
				j31.setBounds(200,90,65,50);
				j31.setOpaque(true);
				roomInformation.add(j31);
				
				
				jt310.setBounds(270,105,50,20);
				jt310.setFont(font);
				jt310.setEditable(false);
				//jt310.setText(rvo02.getRoomAccessNumber()+"");
				roomInformation.add(jt310);
				
				JLabel j32=new JLabel();
				j32.setText("房间价格");
				j32.setFont(font);
				j32.setBounds(200,130,65,50);
				j32.setOpaque(true);
				roomInformation.add(j32);
				
				
				jt320.setBounds(270,145,50,20);
				jt320.setFont(font);
				jt320.setEditable(false);
				//jt320.setText(rvo02.getRoomPrice()+"");
				roomInformation.add(jt320);
				//第四
				JLabel j40=new JLabel();
				j40.setText("房间类型");
				j40.setFont(font);
				j40.setBounds(200,200,65,50);
				j40.setOpaque(true);
				roomInformation.add(j40);
				
				
				jt400.setBounds(270,215,50,20);
				jt400.setFont(font);
				jt400.setEditable(false);
				//jt400.setText(rvo03.getRoomType());
				roomInformation.add(jt400);
				
				JLabel j41=new JLabel();
				j41.setText("房间数量");
				j41.setFont(font);
				j41.setBounds(200,240,65,50);
				j41.setOpaque(true);
				roomInformation.add(j41);
				
				
				jt410.setBounds(270,255,50,20);
				jt410.setFont(font);
				jt410.setEditable(false);
				//jt410.setText(rvo03.getRoomAccessNumber()+"");
				roomInformation.add(jt410);
				
				JLabel j42=new JLabel();
				j42.setText("房间价格");
				j42.setFont(font);
				j42.setBounds(200,280,65,50);
				j42.setOpaque(true);
				roomInformation.add(j42);
				
				
				jt420.setBounds(270,295,50,20);
				jt420.setFont(font);
				jt420.setEditable(false);
				//jt420.setText(rvo03.getRoomPrice()+"");
				roomInformation.add(jt420);
				
				//第五
				JLabel j50=new JLabel();
				j50.setText("房间类型");
				j50.setFont(font);
				j50.setBounds(390,50,65,50);
				j50.setOpaque(true);
				roomInformation.add(j50);
				
				
				jt500.setBounds(460,65,50,20);
				jt500.setFont(font);
				jt500.setEditable(false);
				//jt500.setText(rvo04.getRoomType());
				roomInformation.add(jt500);
				
				JLabel j51=new JLabel();
				j51.setText("房间数量");
				j51.setFont(font);
				j51.setBounds(390,90,65,50);
				j51.setOpaque(true);
				roomInformation.add(j51);
				
				
				jt510.setBounds(460,105,50,20);
				jt510.setFont(font);
				jt510.setEditable(false);
				//jt510.setText(rvo04.getRoomAccessNumber()+"");
				roomInformation.add(jt510);
				
				JLabel j52=new JLabel();
				j52.setText("房间价格");
				j52.setFont(font);
				j52.setBounds(390,130,65,50);
				j52.setOpaque(true);
				roomInformation.add(j52);
				
				
				jt520.setBounds(460,145,50,20);
				jt520.setFont(font);
				jt520.setEditable(false);
				//jt520.setText(rvo04.getRoomPrice()+"");
				roomInformation.add(jt520);
				
				//第六
				JLabel j60=new JLabel();
				j60.setText("房间类型");
				j60.setFont(font);
				j60.setBounds(390,200,65,50);
				j60.setOpaque(true);
				roomInformation.add(j60);
				
				
				jt600.setBounds(460,215,50,20);
				jt600.setFont(font);
				jt600.setEditable(false);
				//jt600.setText(rvo05.getRoomType());
				roomInformation.add(jt600);
				
				JLabel j61=new JLabel();
				j61.setText("房间数量");
				j61.setFont(font);
				j61.setBounds(390,240,65,50);
				j61.setOpaque(true);
				roomInformation.add(j61);
				
				
				jt610.setBounds(460,255,50,20);
				jt610.setFont(font);
				jt610.setEditable(false);
				//jt610.setText(rvo05.getRoomAccessNumber()+"");
				roomInformation.add(jt610);
				
				JLabel j62=new JLabel();
				j62.setText("房间价格");
				j62.setFont(font);
				j62.setBounds(390,280,65,50);
				j62.setOpaque(true);
				roomInformation.add(j62);
				
				
				jt620.setBounds(460,295,50,20);
				jt620.setFont(font);
				jt620.setEditable(false);
				//jt620.setText(rvo05.getRoomPrice()+"");
				roomInformation.add(jt620);
				
				JButton br1=new JButton("编辑");
				br1.setFont(font);
				br1.setBounds(500,380,80,20);
				roomInformation.add(br1);
				br1.addActionListener(new br1Action());
				
				JButton br2=new JButton("确认");
				br2.setFont(font);
				br2.setBounds(600,380,80,20);
				roomInformation.add(br2);
				br2.addActionListener(new br2Action());
				
				
				
				
				
				//promotionInformation
				promotionInformation.setLayout(null);
				//PromotionController pcl=new PromotionController();
				//hpvo=pcl.getHotelPromotion(60000);
				
				JLabel jp2=new JLabel();
				jp2.setText("房间数以及对应的折扣");
				jp2.setFont(font);
				jp2.setBounds(100,50,200,50);
				jp2.setOpaque(true);
				promotionInformation.add(jp2);
				
				JLabel jp21=new JLabel();
				jp21.setText("房间数");
				jp21.setFont(font);
				jp21.setBounds(320,50,55,50);
				jp21.setOpaque(true);
				promotionInformation.add(jp21);
				
				
				jtp22.setBounds(380,65,50,20);
				jtp22.setFont(font);
				jtp22.setEditable(false);
				//jtp22.setText(hpvo.getDiscountForLargerAmount()+"");
				promotionInformation.add(jtp22);
				
				JLabel jp23=new JLabel();
				jp23.setText("折扣");
				jp23.setFont(font);
				jp23.setBounds(450,50,45,50);
				jp23.setOpaque(true);
				promotionInformation.add(jp23);
				
				
				jtp24.setBounds(495,65,50,20);
				jtp24.setFont(font);
				jtp24.setEditable(false);
				//jtp24.setText(hpvo.getDiscountforlargeramount()+"");
				promotionInformation.add(jtp24);
				
				//第二
				JLabel jp3=new JLabel();
				jp3.setText("生日折扣");
				jp3.setFont(font);
				jp3.setBounds(100,100,100,50);
				jp3.setOpaque(true);
				promotionInformation.add(jp3);
				
				JLabel jp31=new JLabel();
				jp31.setText("折扣");
				jp31.setFont(font);
				jp31.setBounds(320,100,55,50);
				jp31.setOpaque(true);
				promotionInformation.add(jp31);
				
				
				jtp32.setBounds(380,115,50,20);
				jtp32.setFont(font);
				jtp32.setEditable(false);
				//jtp32.setText(hpvo.getBirthDiscount()+"");
				promotionInformation.add(jtp32);
				
				//第三
				JLabel jp4=new JLabel();
				jp4.setText("合作企业折扣");
				jp4.setFont(font);
				jp4.setBounds(100,150,100,50);
				jp4.setOpaque(true);
				promotionInformation.add(jp4);
				
				JLabel jp41=new JLabel();
				jp41.setText("折扣");
				jp41.setFont(font);
				jp41.setBounds(320,150,55,50);
				jp41.setOpaque(true);
				promotionInformation.add(jp41);
				
				
				jtp42.setBounds(380,165,50,20);
				jtp42.setFont(font);
				jtp42.setEditable(false);
				//jtp42.setText(hpvo.getCompanyDiscount()+"");
				promotionInformation.add(jtp42);
				
				//第四
				JLabel jp5=new JLabel();
				jp5.setText("特定时间段折扣");
				jp5.setFont(font);
				jp5.setBounds(100,200,150,50);
				jp5.setOpaque(true);
				promotionInformation.add(jp5);
				
				JLabel jp51=new JLabel();
				jp51.setText("起止");
				jp51.setFont(font);
				jp51.setBounds(320,200,55,50);
				jp51.setOpaque(true);
				promotionInformation.add(jp51);
				
				
				jtp52.setBounds(380,215,50,20);
				jtp52.setFont(font);
				jtp52.setEditable(false);
				//jtp52.setText(hpvo.getBeginTime());
				promotionInformation.add(jtp52);
				
				JLabel jp53=new JLabel();
				jp53.setText("结束");
				jp53.setFont(font);
				jp53.setBounds(450,200,45,50);
				jp53.setOpaque(true);
				promotionInformation.add(jp53);
				
				
				jtp54.setBounds(495,215,50,20);
				jtp54.setFont(font);
				jtp54.setEditable(false);
				//jtp54.setText(hpvo.getEndTime());
				promotionInformation.add(jtp54);
				
				JLabel jp55=new JLabel();
				jp55.setText("折扣");
				jp55.setFont(font);
				jp55.setBounds(320,250,55,50);
				jp55.setOpaque(true);
				promotionInformation.add(jp55);
				
				
				jtp56.setBounds(380,265,50,20);
				jtp56.setFont(font);
				jtp56.setEditable(false);
				//jtp56.setText(hpvo.getDiscount()+"");
				promotionInformation.add(jtp56);
				
				JButton p1=new JButton("编辑");
				p1.setFont(font);
				p1.setBounds(500,380,80,20);
				promotionInformation.add(p1);
			    p1.addActionListener(new p1Action());
				
				JButton p2=new JButton("确认");
				p2.setFont(font);
				p2.setBounds(600,380,80,20);
				promotionInformation.add(p2);
				p2.addActionListener(new p2Action());
				
		

		// order

		SpringLayout layout4 = new SpringLayout();
		//panel14未处理订单，panel24已完成订单，panel34异常订单，panel44已撤销订单
		panel14 = new JPanel();
		panel14.setLayout(new BorderLayout());
		panel24 = new JPanel();
		panel24.setLayout(new BorderLayout());
		panel34 = new JPanel();
		panel34.setLayout(new BorderLayout());
		panel44 = new JPanel();
		panel44.setLayout(new BorderLayout());

		JTabbedPane tab4 = new JTabbedPane();
		// 容器
		tab4.add(panel14, "未处理订单");
		tab4.add(panel24, "已完成订单");
		tab4.add(panel34, "异常订单");
		tab4.add(panel44, "已撤销订单");

		orderInformation.add(tab4);
		// order MainFrame

		// 未处理订单
		panel12=new JPanel();
		panel12.setPreferredSize(preferredSize3);
		//将panel14从上到下划分为3个，p14,p24,p34
		p14 = new JPanel();
		p14.setLayout(layout4);
		p14.setPreferredSize(preferredSize3);
		p24 = new JPanel();
		p34 = new JPanel();
		p34.setLayout(layout4);
		p34.setPreferredSize(preferredSize3);
		
		//idInput搜索内容，search4搜索按键
		idInput4 = new JTextField();
		idInput4.setPreferredSize(preferredSize2);
		search4 = new JButton("搜索");
		search4.setPreferredSize(preferredSize6);
		search4.setMaximumSize(preferredSize);
		prePage4 = new JButton("上一页");
		prePage4.setPreferredSize(preferredSize);
		nextPage4 = new JButton("下一页");
		nextPage4.setPreferredSize(preferredSize);
		edit4 = new JButton("完成订单");
		edit4.setPreferredSize(preferredSize2);
		//
		Object[][] p4 = {
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "UNEXECUTE" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "UNEXECUTE" }, };
		String[] n4 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		//两个参数，p4数据内容，n4列表名字
		DefaultTableModel defaultModel4 = new DefaultTableModel(p4, n4) {
			//此方法设置哪些行可以编辑
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table4 = new JTable(defaultModel4);
		table4.setPreferredScrollableViewportSize(new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table4.setRowHeight(25);
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

		panel14.add(p14, BorderLayout.NORTH);
		panel14.add(p24, BorderLayout.CENTER);
		panel14.add(p34, BorderLayout.SOUTH);
		
		// 下为订单完成界面
				finishFrame4 = new JFrame();
				finishFrame4.setBackground(Color.darkGray);
				finishFrame4.setTitle("DS酒店管家");
				finishFrame4.setSize(400, 250);

				Dimension dm4 = Toolkit.getDefaultToolkit().getScreenSize();// 获得屏幕尺寸
				Dimension tm4 = finishFrame4.getSize();
				if (tm4.width > dm4.width) { // 修正
					tm4.width = dm4.width;
				}
				if (tm4.height > dm4.height) {
					tm4.height = dm4.height;
				}
				finishFrame4.setLocation(dm4.width / 2 - tm4.width / 2, dm4.height / 2 - tm4.height / 2);// 设置尺寸
				// 居中 // 为屏幕中央

				finishFrame4.setFont(font);
				finishFrame4.setVisible(false);
				finishFrame4.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				finishFrame4.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						int exi = JOptionPane.showConfirmDialog(null, "确定取消么？", "提示", JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
						if (exi == JOptionPane.YES_OPTION) {
							finishFrame4.setVisible(false);
						} else {
							return;
						}
					}
				});
				
				JPanel panel = new JPanel();
				panel.setLayout(layout4);
				panel.setBorder(BorderFactory.createTitledBorder("确定完成该订单吗？"));
				JButton sure4 = new JButton("确定");
				sure4.setPreferredSize(preferredSize6);
				JButton cancle4 = new JButton("取消");
				cancle4.setPreferredSize(preferredSize6);
				panel.add(sure4);
				panel.add(cancle4);
				
				layout4.putConstraint(SpringLayout.WEST, sure4,
						(int) (finishFrame4.getWidth() / 2 - sure4.getPreferredSize().getWidth() - 7), SpringLayout.WEST,
						panel);
				layout4.putConstraint(SpringLayout.NORTH, sure4, 120, SpringLayout.NORTH, panel);
				layout4.putConstraint(SpringLayout.WEST, cancle4, 14, SpringLayout.EAST, sure4);
				layout4.putConstraint(SpringLayout.NORTH, cancle4, 120, SpringLayout.NORTH, panel);
				finishFrame4.add(panel);

		table4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent e) {
				if ((table4.getValueAt(table4.getSelectedRow(), table4.getColumnCount() - 1).toString()).toLowerCase()
						.equals("unexecute")) {
					edit4.setVisible(true);// 选中异常订单时设为true
				}
			}
		});
		edit4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				finishFrame4.setVisible(true);
			}
		});
		search4.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent arg0) {

					String id = idInput4.getText();
					//返回一个新的字符串，它是通过用 后者替换此字符串中出现的所有前者而生成的
					id.replace(" ", "");
					//如果没有输入
					if (id.equals(null) || id.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入ID", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
						OrderVO vo = oc.getOrder(ID);
						// 获取数据
						String[] ob = { vo.getId() + "", vo.getTotalPrice() + "", vo.getMasterId() + "",
								vo.getCustomerName(), vo.getCustomerPhone(), vo.getHotelName(), vo.getHotelPhone(),
								vo.getStartTime(), vo.getExecuteTime(), vo.getOs() + "" };
						/* 处理值  setValueAt(Object aValue,int rowIndex,int columnIndex)
						
					                                     将 columnIndex 和 rowIndex 位置的单元格中的值设置为 aValue。
					                                      参数：
					    aValue - 新值
					    rowIndex - 要更改的值所在行
					    columnIndex - 要更改的值所在列
						*/
						for (int i = 0; i < ob.length; i++) {
							table4.setValueAt(ob[i], 0, i);
						}
						// 赋值
						//清除其余行？
						for (int i = 1; i < defaultModel4.getRowCount(); i++) {
							for (int j = 0; j < defaultModel4.getColumnCount(); j++) {
								table4.setValueAt("", i, j);
							}
						}
						// 清空多余行
					}
				

			}
		});
		prePage4.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				
					//Object getValueAt(int rowIndex,int columnIndex)返回 columnIndex 和 rowIndex 位置的单元格值
					long ID = Long.parseLong(table4.getValueAt(0, 0).toString()) - 1;
					// 从上一页最后开始
					for (int count = 0; count < defaultModel4.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						//判断订单状态，当订单未完成状态，才获取订单
						while (!vo.getOs().equals(OrderState.unexecute)) {
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
							table4.setValueAt(ob[i], table4.getRowCount() - count - 1, i);
						}
						// 从后到前的设置值
					}
				
			}
		});
		nextPage4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table4.getValueAt(table4.getRowCount() - 1, 0).toString()) + 1;
					// 从下一页第一开始
					for (int count = 0; count < defaultModel4.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
						OrderVO vo = oc.getOrder(ID2);
						while (!vo.getOs().equals(OrderState.unexecute)) {
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
							table4.setValueAt(ob[i], count, i);
						}
						// 从前到后的设置值
					}
				

			}
		});
		
		sure4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					long ORDERGET = Long.parseLong(table4.getValueAt(table4.getSelectedRow(), 0).toString());
					String HOTELGET = table4.getValueAt(table4.getSelectedRow(), 5).toString();
					OrderController oc = new OrderController();
					OrderVO ov=new OrderVO();
					ov=oc.getOrder(ORDERGET);
					oc.cancelOrder(ORDERGET);
					RoomController rc = null;
					RoomVO rv0 = null;
					RoomVO rv1 = null;
					RoomVO rv2 = null;
					RoomVO rv3 = null;
					RoomVO rv4 = null;
					RoomVO rv5 = null;
					try {
						rc = new RoomController();
						rv0 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"0"));
						
						rv1 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"1"));
						
						rv2 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"2"));
						
						rv3 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"3"));

						rv4 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"4"));
						
						rv5 = new RoomVO();
						rv0=rc.getRoom(Long.parseLong(HOTELGET+"5"));
					} catch (NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try {
						if(rv0.getRoomType()==ov.getRoomType()){
							rv0.setRoomAccessNumber(rv0.getRoomAccessNumber()-ov.getRoomNumber());
						}
						if(rv1.getRoomType()==ov.getRoomType()){
							rv1.setRoomAccessNumber(rv1.getRoomAccessNumber()-ov.getRoomNumber());
						}
						if(rv2.getRoomType()==ov.getRoomType()){
							rv2.setRoomAccessNumber(rv2.getRoomAccessNumber()-ov.getRoomNumber());
						}
						if(rv3.getRoomType()==ov.getRoomType()){
							rv3.setRoomAccessNumber(rv3.getRoomAccessNumber()-ov.getRoomNumber());
						}
						if(rv4.getRoomType()==ov.getRoomType()){
							rv4.setRoomAccessNumber(rv4.getRoomAccessNumber()-ov.getRoomNumber());
						}
						if(rv5.getRoomType()==ov.getRoomType()){
							rv5.setRoomAccessNumber(rv5.getRoomAccessNumber()-ov.getRoomNumber());
						}
						
						rc.changeRoom(rv0);
						rc.changeRoom(rv1);
						rc.changeRoom(rv2);
						rc.changeRoom(rv3);
						rc.changeRoom(rv4);
						rc.changeRoom(rv5);
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
				
		});
		
		cancle4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				finishFrame4.dispose();
			}
		});

		// unexecute order

		// 已完成订单

		p15 = new JPanel();
		p15.setLayout(layout4);
		p15.setPreferredSize(preferredSize3);
		p25 = new JPanel();
		p35 = new JPanel();
		p35.setLayout(layout4);
		p35.setPreferredSize(preferredSize3);
		//
		idInput5 = new JTextField();
		idInput5.setPreferredSize(preferredSize2);
		search5 = new JButton("搜索");
		search5.setPreferredSize(preferredSize6);
		search5.setMaximumSize(preferredSize);
		prePage5 = new JButton("上一页");
		prePage5.setPreferredSize(preferredSize);
		nextPage5 = new JButton("下一页");
		nextPage5.setPreferredSize(preferredSize);
		//
		Object[][] p5 = {
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
						"020211134", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "NORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "NORMAL" }, };
		String[] n5 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel5 = new DefaultTableModel(p5, n5) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table5 = new JTable(defaultModel5);
		table5.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table5.setRowHeight(25);
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
						JOptionPane.showMessageDialog(null, "请输入ID", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
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
					}
				
			}
		});
		prePage5.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table5.getValueAt(0, 0).toString()) - 1;
					// 从上一页最后开始
					for (int count = 0; count < defaultModel5.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
				

			}
		});
		nextPage5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
					long ID = Long.parseLong(table5.getValueAt(table5.getRowCount() - 1, 0).toString()) + 1;
					// 从下一页第一开始
					for (int count = 0; count < defaultModel5.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
				

			}
		});
		// excuted,normal

		// 异常订单处理
		p16 = new JPanel();
		p16.setLayout(layout4);
		p16.setPreferredSize(preferredSize3);
		p26 = new JPanel();
		p36 = new JPanel();
		p36.setLayout(layout4);
		p36.setPreferredSize(preferredSize3);
		//
		idInput6 = new JTextField();
		idInput6.setPreferredSize(preferredSize2);
		search6 = new JButton("搜索");
		search6.setPreferredSize(preferredSize6);
		search6.setMaximumSize(preferredSize);
		prePage6 = new JButton("上一页");
		prePage6.setPreferredSize(preferredSize);
		nextPage6 = new JButton("下一页");
		nextPage6.setPreferredSize(preferredSize);
		edit6 = new JButton("撤销异常");
		edit6.setPreferredSize(preferredSize2);
		//
		Object[][] p6 = {
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "ABNORMAL" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "ABNORMAL" }, };
		String[] n6 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel6 = new DefaultTableModel(p6, n6) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table6 = new JTable(defaultModel6);
		table6.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table6.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table6.setRowHeight(25);
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
		edit6.setVisible(false);// 选中异常订单时设为true
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
		subPanel.setBorder(BorderFactory.createTitledBorder("请选择合适的信用返回额度:"));
		JButton sure6 = new JButton("确定");
		sure6.setPreferredSize(preferredSize6);
		JButton cancle6 = new JButton("取消");
		cancle6.setPreferredSize(preferredSize6);
		JRadioButton c1 = new JRadioButton("50%", true);
		JRadioButton c2 = new JRadioButton("100%", false);
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
					edit6.setVisible(true);// 选中异常订单时设为true
				}
			}
		});
		search6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					String id = idInput6.getText();
					id.replace(" ", "");
					if (id.equals(null) || id.equals("")) {
						JOptionPane.showMessageDialog(null, "请输入ID", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
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
					}
				
			}
		});
		prePage6.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table6.getValueAt(0, 0).toString()) - 1;
					// 从上一页最后开始
					for (int count = 0; count < defaultModel6.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
				

			}
		});
		nextPage6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table6.getValueAt(table6.getRowCount() - 1, 0).toString()) + 1;
					// 从下一页第一开始
					for (int count = 0; count < defaultModel6.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
			
					long ORDERGET = Long.parseLong(table6.getValueAt(table6.getSelectedRow(), 0).toString());
					long USERIDGET = Long.parseLong(table6.getValueAt(table6.getSelectedRow(), 2).toString());
					OrderController oc = new OrderController();
					CustomerController cc = new CustomerController();
					CustomerVO vo2 = cc.getCustomer(USERIDGET);
					/*double credit = vo2.getCredit();
					// 获取order与customer
					double CREDITGET = Double.parseDouble(table6.getValueAt(table6.getSelectedRow(), 1).toString());
					// 获取价格——信用值
					if (c1.isSelected()) {// 50%
						vo2.setCredit(credit + CREDITGET / 2);//
					} else {
						vo2.setCredit(credit + CREDITGET);//
					} // 设定返回值
						// 取消异常订单
						 * */
			
					oc.cancelOrder(ORDERGET);
					cc.changeCustomer(vo2);
				
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
		p17.setLayout(layout4);
		p17.setPreferredSize(preferredSize3);
		p27 = new JPanel();
		p37 = new JPanel();
		p37.setLayout(layout4);
		p37.setPreferredSize(preferredSize3);
		//
		idInput7 = new JTextField();
		idInput7.setPreferredSize(preferredSize2);
		search7 = new JButton("搜索");
		search7.setPreferredSize(preferredSize6);
		search7.setMaximumSize(preferredSize);
		prePage7 = new JButton("上一页");
		prePage7.setPreferredSize(preferredSize);
		nextPage7 = new JButton("下一页");
		nextPage7.setPreferredSize(preferredSize);
		//
		Object[][] p7 = {
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666666), new Integer(500), new Integer(300000), "dalin", "13002506325", "如家酒店",
						"07316734520", "2016-12-8", "2016-12-8", "CANCLED" },
				{ new Integer(666667), new Integer(700), new Integer(300001), "hello", "13704195324", "清泉酒店",
						"020211134", "2016-12-8", "2016-12-8", "CANCLED" }, };
		String[] n7 = { "订单ID", "总价", "用户ID", "用户名", "用户电话", "酒店名", "酒店电话", "下单时间", "预计入住时间", "执行状态" };
		DefaultTableModel defaultModel7 = new DefaultTableModel(p7, n7) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		;
		;
		JTable table7 = new JTable(defaultModel7);
		table7.setPreferredScrollableViewportSize(
				new Dimension((int) (panel12.getPreferredSize().getWidth() - 15), 220));
		table7.setRowHeight(25);
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
						JOptionPane.showMessageDialog(null, "请输入ID", "提示", JOptionPane.PLAIN_MESSAGE);
					} else {
						long ID = Long.parseLong(id);
						OrderController oc = new OrderController();
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
					}
				
			}
		});
		prePage7.addActionListener(new ActionListener() {
			@Override
			// *****对于有检索条件的prepage翻页需要从后往前获取数据
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table7.getValueAt(0, 0).toString()) - 1;
					// 从上一页最后开始
					for (int count = 0; count < defaultModel7.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
				

			}
		});
		nextPage7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
					long ID = Long.parseLong(table7.getValueAt(table7.getRowCount() - 1, 0).toString()) + 1;
					// 从下一页第一开始
					for (int count = 0; count < defaultModel7.getRowCount(); count++) {
						OrderController oc = new OrderController();
						long ID2 = ID;
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
				 

			}
		});

		// cancled

	}
	public static void main(String[] args){
		
		
		try {
			HotelUI ui=new HotelUI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class b1Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jth.setEditable(true);
			jth01.setEditable(true);
			jth11.setEditable(true);
			jth13.setEditable(true);
			jth14.setEditable(true);
			jth15.setEditable(true);
			jc2.setEditable(true);
			jc6.setEditable(true);
		}
	}
	class b2Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jth.setEditable(false);
			jth01.setEditable(false);
			jth11.setEditable(false);
			jth13.setEditable(false);
			jth14.setEditable(false);
			jth15.setEditable(false);
			jc2.setEditable(false);
			jc6.setEditable(false);
			
			try {
				hvo.setHotelManager(jth.getText());
				hvo.setHotelManPhone(jth01.getText());
				hvo.setHotelName(jth11.getText());
				hvo.setHotelPhone(jth15.getText());
				hvo.setHotelLocation(jth13.getText());
				hvo.setInstruction(jth14.getText());
				hvo.setTradeArea(String.valueOf(jc2.getSelectedItem()));
				hvo.setStars(String.valueOf(jc6.getSelectedIndex()));
				HotelController hc=new HotelController();
				hc.changeHotel(hvo);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}	
	class MyboBox extends AbstractListModel<String> implements ComboBoxModel<String>{
		String selecteditem=null;//hvo.getStars();
		String[] st={"一星","二星","三星","四星","五星"};
		public String getElementAt(int index){
			return st[index];
		}
		public int getSize(){
			return st.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem(){
			return selecteditem;
		}
	}

	class MBox extends AbstractListModel<String> implements ComboBoxModel<String>{
		String selecteditem=null;//hvo.getTradeArea();
		String[] st={"南京","北京","上海","深圳","天津"};
		public String getElementAt(int index){
			return st[index];
		}
		public int getSize(){
			return st.length;
		}
		public void setSelectedItem(Object item){
			selecteditem=(String)item;
		}
		public Object getSelectedItem(){
			return selecteditem;
		}
	}
	class br1Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jt100.setEditable(true);
			jt110.setEditable(true);
			jt120.setEditable(true);
			jt200.setEditable(true);
			jt210.setEditable(true);
			jt220.setEditable(true);
			jt300.setEditable(true);
			jt310.setEditable(true);
			jt320.setEditable(true);
			jt400.setEditable(true);
			jt410.setEditable(true);
			jt420.setEditable(true);
			jt500.setEditable(true);
			jt510.setEditable(true);
			jt520.setEditable(true);
			jt600.setEditable(true);
			jt610.setEditable(true);
			jt620.setEditable(true);
			
		}
	}
	class br2Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
				jt100.setEditable(false);
				jt110.setEditable(false);
				jt120.setEditable(false);
				jt200.setEditable(false);
				jt210.setEditable(false);
				jt220.setEditable(false);
				jt300.setEditable(false);
				jt310.setEditable(false);
				jt320.setEditable(false);
				jt400.setEditable(false);
				jt410.setEditable(false);
				jt420.setEditable(false);
				jt500.setEditable(false);
				jt510.setEditable(false);
				jt520.setEditable(false);
				jt600.setEditable(false);
				jt610.setEditable(false);
				jt620.setEditable(false);
				
				RoomVO rvo1=new RoomVO();
				RoomVO rvo2=new RoomVO();
				RoomVO rvo3=new RoomVO();
				RoomVO rvo4=new RoomVO();
				RoomVO rvo5=new RoomVO();
				RoomVO rvo6=new RoomVO();
				
				rvo1.setRoomType(jt100.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt110.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo1.setRoomPrice(Double.parseDouble(jt120.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				
				rvo2.setRoomType(jt200.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt210.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo2.setRoomPrice(Double.parseDouble(jt220.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				
				rvo3.setRoomType(jt300.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt310.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo3.setRoomPrice(Double.parseDouble(jt320.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				
				rvo4.setRoomType(jt400.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt410.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo4.setRoomPrice(Double.parseDouble(jt420.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				
				rvo5.setRoomType(jt500.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt510.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo5.setRoomPrice(Double.parseDouble(jt520.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				
				rvo6.setRoomType(jt600.getText());
				try {
					rvo1.setRoomAccessNumber(Integer.parseInt(jt610.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
				try {
					rvo6.setRoomPrice(Double.parseDouble(jt620.getText()));
				} catch (NumberFormatException e) {
				    e.printStackTrace();
				}
		}
	}
	class p1Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jtp22.setEditable(true);
			jtp24.setEditable(true);
			jtp32.setEditable(true);
			jtp42.setEditable(true);
			jtp52.setEditable(true);
			jtp54.setEditable(true);
			jtp56.setEditable(true);
		}
	}
	class p2Action implements ActionListener{
		public void actionPerformed(ActionEvent arg0){
			jtp22.setEditable(false);
			jtp24.setEditable(false);
			jtp32.setEditable(false);
			jtp42.setEditable(false);
			jtp52.setEditable(false);
			jtp54.setEditable(false);
			jtp56.setEditable(false);
			
			HotelPromotionVO hpvo=new HotelPromotionVO();
			try {
				hpvo.setDiscountForMoreRoom(Integer.parseInt(jtp22.getText()));
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
			try {
				hpvo.setDiscountformoreroom(Double.parseDouble(jtp24.getText()));
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
			try {
				hpvo.setBirthDiscount(Double.parseDouble(jtp32.getText()));
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
			try {
				hpvo.setCompanyDiscount(Double.parseDouble(jtp42.getText()));
			} catch (NumberFormatException e) {
			    e.printStackTrace();
			}
			
			hpvo.setBeginTime(jtp52.getText());
			hpvo.setEndTime(jtp54.getText());
			hpvo.setDiscount(Double.parseDouble(jtp56.getText()));
		}
	}
}
