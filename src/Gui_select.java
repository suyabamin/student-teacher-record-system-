import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui_select {
    Gui_select(){
        JFrame f=new JFrame("Select");
        JLabel l=new JLabel("Select any option to add information ");
        JButton btn1=new JButton("Student");
        JButton btn2=new JButton("Teacher");
        l.setFont(new Font("Serif", Font.PLAIN, 15));
        l.setBounds(20,50,300,40);
        btn1.setBounds(20,100,100,40);
        btn2.setBounds(150,100,100,40);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student_Gui sg=new Student_Gui();
                f.setVisible(false);
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Gui_teacher sg=new Gui_teacher();
                f.setVisible(false);
            }
        });

        f.add(l);
        f.add(btn1);
        f.add(btn2);
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
    }
}
