package presentation.userui;

        import javax.swing.*;
        import java.awt.*;

/**
 * Created by 常德隆 on 2016/11/25.
 */
public class UserUI {
    public static void main(String[] args){
        JFrame mainFrame=new JFrame("DS酒店管家");
        JTextField account=new JTextField();
        JTextField password=new JTextField();
        JPanel pane1=new JPanel();
        JPanel pane2=new JPanel();
        JLabel label1=new JLabel("帐号");
        JLabel label2=new JLabel("密码");
        JButton button1=new JButton("登录");
        JButton button2=new JButton("注册");
        BoxLayout b1=new BoxLayout(pane1,BoxLayout.Y_AXIS);
        BoxLayout b2=new BoxLayout(pane2,BoxLayout.X_AXIS);
        pane1.setLayout(b1);
        pane2.setLayout(b2);
        pane1.setBackground(Color.gray);
        pane2.setBackground(Color.gray);

        account.setBackground(Color.white);
        password.setBackground(Color.white);
        label1.add(account);
        label2.add(password);
        pane1.add(label1);
        pane1.add(label2);
        pane2.add(button1);
        pane2.add(button2);
        mainFrame.add(pane1);
        mainFrame.add(pane2);
        mainFrame.setSize(1600,900);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
