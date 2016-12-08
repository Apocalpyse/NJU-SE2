package presentation.userui;

        import businesslogic.userbl.UserController;
        import presentation.customerui.MainUI;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

/**
 * Created by 常德隆 on 2016/11/25.
 */
public class LoginUI {
    public LoginUI(){
        JFrame mainFrame=new JFrame("DS酒店管家");
        Font font=new Font("微软雅黑",Font.BOLD,16);
        Font font2=new Font("微软雅黑",Font.BOLD,24);
        mainFrame.setFont(font);
        JTextField account=new JTextField();
        account.setFont(font);
        JTextField password=new JTextField();
        password.setFont(font);
        JPanel panel3=new JPanel();
        JPanel panel1=new JPanel();
        JPanel panel2=new JPanel();
        JLabel label1=new JLabel("欢迎使用DS酒店管家");
        label1.setFont(font2);
        JLabel label2=new JLabel("帐号");
        label2.setFont(font);
        JLabel label3=new JLabel("密码");
        label3.setFont(font);
        JButton button1=new JButton("登录");
        button1.setFont(font);
        JButton button2=new JButton("注册");
        button2.setFont(font);
        GridLayout b2=new GridLayout(1,2);

        panel1.setLayout(null);
        panel2.setLayout(b2);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(account);
        panel1.add(password);
        label2.setBounds(0,0,80,55);
        account.setBounds(80,0,520,55);
        label3.setBounds(0,65,80,55);
        password.setBounds(80,65,520,55);
        panel2.add(button1);
        panel2.add(button2);
        panel3.add(label1);
        mainFrame.setLayout(null);
        mainFrame.add(panel1);
        mainFrame.add(panel2);
        mainFrame.add(panel3);
        panel1.setBounds(200,150,600,120);
        panel2.setBounds(400,400,200,50);
        panel3.setBounds(200,50,600,80);
        mainFrame.setSize(1000,600);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserController uc=new UserController();
                if(uc.login(account.getText(),password.getText())){
                    MainUI ui=new MainUI(account.getText(),password.getText());
                    mainFrame.dispose();
                }
                else{
                    Tooltip_one to=new Tooltip_one();
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                RegisterUI rui=new RegisterUI();
            }
        });
    }
    public static void main(String[] args){
        LoginUI ui=new LoginUI();
    }

}
