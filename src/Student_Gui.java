import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class Student_Gui {

        Student_Gui(){
            JFrame f=new JFrame("Select");
            JLabel l0=new JLabel("Student Form");
            l0.setFont(new Font("Serif", Font.PLAIN, 20));
            JLabel l1=new JLabel("Student's Name:");
            JLabel l2=new JLabel("ID:");
            JLabel l3=new JLabel("Grades(5):");
            JLabel l4=new JLabel("Scarch Student by Id");
            JLabel l5=new JLabel(" Studebt Information:");
            JLabel l6=new JLabel("Delete any student:");
            JLabel l7=new JLabel("type the student Id");
            JTextField tf1=new JTextField("0");
            JTextField tf2=new JTextField("0");
            JTextField tf3=new JTextField("0");
            JTextField tf4=new JTextField("0");
            JTextField tf5=new JTextField("0");
            JTextField tf6=new JTextField("0");
            JTextField tf7=new JTextField("0");
            JTextField tf8=new JTextField("0");
            JTextField tf9=new JTextField("0");
            JButton btn2=new JButton("Delete");
            btn2.setBackground(Color.RED);
            JButton btn3=new JButton("Back to Silect page");

            JTextArea ar1=new JTextArea("area");

            JButton btn1=new JButton("Add student");
            JButton btn4=new JButton("scarch");

            l0.setBounds(10,100,300,40);
           tf1.setBounds(100,200,200,40);
           l1.setBounds(5,200,100,40);
           tf2.setBounds(100,250,100,40);
           l2.setBounds(10,250,50,40);
           tf3.setBounds(100,300,40,40);
           l3.setBounds(10,300,80,40);

           tf4.setBounds(150,300,40,40);
            tf5.setBounds(200,300,40,40);
            tf6.setBounds(250,300,40,40);
            tf7.setBounds(300,300,40,40);
            btn1.setBounds(150,350,150,40);
            tf8.setBounds(150,400,150,40);
            btn4.setBounds(300,400,150,40);
            l4.setBounds(10,400,150,40);
            ar1.setBounds(150,450,500,100);
            l5.setBounds(10,450,150,40);
            l6.setBounds(10,600,250,40);
            l7.setBounds(10,650,200,40);
            tf9.setBounds(150,650,200,40);
            btn2.setBounds(200,700,100,40);
            btn3.setBounds(400,700,200,40);



            class ar{
                private String Name;
                private String Id;
              private    String g1,g2,g3,g4,g5;

                ar(String Name, String Id, String g1, String g2, String g3, String g4, String g5){
                    this.Name=Name;
                    this.Id=Id;
                    this.g1=g1;
                    this.g2=g2;
                    this.g3=g3;
                    this.g4=g4;
                    this.g5= g5;
                }
            }

            ArrayList<ar>al=new ArrayList<>();

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name=String.valueOf(tf1.getText());
                    String id=String.valueOf(tf2.getText());
                    String g1=String.valueOf(tf3.getText());
                    String g2=String.valueOf(tf4.getText());
                    String g3=String.valueOf(tf5.getText());
                    String g4=String.valueOf(tf6.getText());
                    String g5=String.valueOf(tf7.getText());

                    for (int i = 0; i <1; i++) {
                        al.add(new ar(name,id,g1,g2,g3,g4,g5));
                    }

                    for (int i = 0; i <al.size(); i++) {
                        ar a = al.get(i);

                           try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt", true))) {
                                writer.write("\nName:"+a.Name+"Id: "+a.Id+"  Grade1:"+a.g1+"  Grade2:"+a.g2+"  Grade3:"+a.g3+"  Grade4:"+a.g4+"  Grade5:"+a.g5);

                            } catch (IOException ex) {
                               throw new RuntimeException(ex);
                           }


                    }

                    tf1.setText(" ");
                    tf2.setText(" ");
                    tf3.setText(" ");
                    tf4.setText(" ");
                    tf5.setText(" ");
                    tf6.setText(" ");
                    tf7.setText(" ");

                }
            });

            btn4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ee) {
                    String id = tf8.getText().trim();
                    boolean found = false;
                    try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains(" " + id + " ")) {
                                ar1.setText(line);
                                found = true;
                                break;
                            }
                        }
                        if (!found) {
                            ar1.setText("Student with ID " + id + " not found.");
                        }
                    } catch (IOException ex) {
                        ar1.setText("Error reading the file.");
                        ex.printStackTrace();
                    }
                }
            });

            btn2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id = tf9.getText().trim();
                    ArrayList<String> updatedLines = new ArrayList<>();
                    try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (!line.contains(" " + id + " ")) {
                                updatedLines.add(line);
                            }
                        }
                    } catch (IOException ex) {
                        ar1.setText("Error reading the file.");
                        ex.printStackTrace();
                    }

                    // Write the updated lines (without the deleted student) back to the file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"))) {
                        for (String line : updatedLines) {
                            writer.write(line + "\n");
                        }
                        ar1.setText("Student with ID " + id + " deleted successfully.");
                    } catch (IOException ex) {
                        ar1.setText("Error writing to the file.");
                        ex.printStackTrace();
                    }
                }
            });



            btn3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Gui_select g=new Gui_select();
                    f.setVisible(false);
                }
            });





            f.add(l6);
            f.add(tf9);
            f.add(btn1);
            f.add(l0);
            f.add(l1);
            f.add(tf1);
            f.add(tf2);
            f.add(l2);
            f.add(tf3);
            f.add(l3);
            f.add(tf4);
            f.add(tf5);
            f.add(tf6);
            f.add(tf7);
            f.add(tf8);
            f.add(l4);
            f.add(ar1);
            f.add(l5);
            f.add(l7);
            f.add(btn2);
            f.add(btn3);
            f.add(btn4);
            f.setSize(800,800);
            f.setLayout(null);
            f.setVisible(true);
        }
    }


