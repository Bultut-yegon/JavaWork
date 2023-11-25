import com.mysql.cj.x.protobuf.MysqlxSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;

import static com.mysql.cj.x.protobuf.MysqlxSession.*;

public class Cat2Work extends JFrame {
    private JButton btnSubmit;
    private JButton btnClose;
    private JTextField name;
    private JTextField username;
    private JPasswordField passWord;
    private JPasswordField conPassWord;
    private JTextField email;
    private JTextField phoneNumber;
    private JTextField address;
    private JButton btnReset;
    private JPanel cat2Panel;

    public Cat2Work() {
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password=String.valueOf(passWord.getPassword());
                String confirmPassword=String.valueOf(conPassWord.getPassword());
                if(!password.equals(confirmPassword)){
                    JOptionPane.showMessageDialog(null,"Passwords do not match");
                }
                else {
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/formative", "root", "2004");
                        String sql = "INSERT INTO cat2(name, username,email ,password , phone, address) VALUES(?,?,?,?,?,?)";
                        PreparedStatement prepare = connect.prepareStatement(sql);
                        prepare.setString(1, name.getText());
                        prepare.setString(2, username.getText());
                        prepare.setString(3, email.getText());
                        prepare.setString(4, password);
                        prepare.setString(5, phoneNumber.getText());
                        prepare.setString(6, address.getText());
                        int count = prepare.executeUpdate();
                        if (count == 1)
                        {
                            JOptionPane.showMessageDialog(null, "Record added successfully");
                            connect.close();
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "No added record, please try again");
                            connect.close();
                        }
                    }
                    catch (Exception e1)
                    {
                        System.out.println(e1);
                    }
                }
              /*  String theName= name.getText();
                String usersName=username.getName();

                String theEmail=email.getText();
                String theAddress=String.valueOf(address.getText());
                String number=String.valueOf(phoneNumber.getText());*/
            }
        });
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                name.setText("");
                username.setText("");
                passWord.setText("");
                conPassWord.setText("");
                email.setText("");
                phoneNumber.setText("");
                address.setText("");
                // MysqlxSession.Reset.Builder();
            }
        });
    }

    public static void main(String[] args) {
        Cat2Work use= new Cat2Work();
        use.setContentPane(use.cat2Panel);
        use.setTitle("Cat 2 work");
        use.setMaximumSize(new Dimension(300,500));
        use.setVisible(true);
    }
}
