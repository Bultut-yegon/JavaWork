import javax.swing.*;
public class Ui {
    public static void main(String[] args) {
        //import javax.swing.JFrame;

//import javax.swing.JLabel;

//Graphical user interface


                JFrame myFrame= new JFrame("Diplay area");
                JLabel myLabel= new JLabel("I'm a Data Scientist");

                myFrame.getContentPane().add(myLabel);
                myFrame.pack();
                myFrame.setVisible(true);
    }
}
