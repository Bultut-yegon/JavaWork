import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplePayRollSystem extends JFrame{
    private JLabel employeeName;
    private JTextField nameEmployee;
    private JTextField ratePerHr;
    private JTextField hrsPerDay;
    private JTextField daysWorked;
    private JTextField grossSalary;
    private JTextField tax;
    private JTextField philhealth;
    private JTextField sss;
    private JTextField totalDeduction;
    private JTextField grossSal;
    private JTextField netSalary;
    private JButton computeButton;
    private JTextField totDed;
    private JPanel mainPanel;

    public SimplePayRollSystem() {
        computeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Variable initialization
                int ratePH = Integer.parseInt(ratePerHr.getText()),
                        hrsPDay = Integer.parseInt(hrsPerDay.getText()),
                        days = Integer.parseInt(daysWorked.getText());

                int grossPay, totalDed, netPay, taxPay, philhealthPay, sssPay;
                float taxRate = 0.15f, philhealthRate = 0.05f, sssRate = 0.02f;

                grossPay = hrsPDay* days * ratePH;
                taxPay = (int) (taxRate * grossPay);
                philhealthPay = (int) (philhealthRate * grossPay);
                sssPay = (int) (sssRate * grossPay);
                totalDed = taxPay + philhealthPay + sssPay;
                netPay = grossPay - totalDed;

                //Updating UI elements
                grossSal.setText(String.valueOf(grossPay));
                grossSalary.setText(String.valueOf(grossPay));
                totalDeduction.setText(String.valueOf(totalDed));
                totDed.setText(String.valueOf(totalDed));
                netSalary.setText(String.valueOf(netPay));
                tax.setText(String.valueOf(taxPay));
                philhealth.setText(String.valueOf(philhealthPay));
                sss.setText(String.valueOf(sssPay));
            }
        });
    }

    public static void main(String[] args) {
        SimplePayRollSystem m = new SimplePayRollSystem();
        int width = 950, height = 380;
        m.setSize(width, height);

        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        m.setBounds(x, y, width, height);
        m.setContentPane(m.mainPanel);
        m.setVisible(true);
        m.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );
    }
}
