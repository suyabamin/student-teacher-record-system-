import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_2 {
    public static void main(String[] args) {
        JFrame f1=new JFrame("Log in");

        JLabel l1=new JLabel("User id");
        JLabel l2=new JLabel("password");
        JTextField tf1=new JTextField("0");
        JTextField tf2=new JTextField("0");
        JButton btn=new JButton("Log in");

        l1.setBounds(100,100,100,40);
        tf1.setBounds(200,100,200,40);
        l2.setBounds(100,150,200,40);
        tf2.setBounds(200,150,200,40);
        btn.setBounds(200,200,100,40);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ui=String.valueOf(tf1.getText());
                String pa=String.valueOf(tf2.getText());

                if(ui!="0" && pa!="0"){
                    Gui_select g=new Gui_select();
                    f1.setVisible(false);
                }
            }
        });

        f1.add(l1);
        f1.add(l2);
        f1.add(tf1);
        f1.add(tf2);
        f1.add(btn);

        f1.setSize(500,500);
        f1.setLayout(null);
        f1.setVisible(true);
    }
}
