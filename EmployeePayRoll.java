import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
*
* Week(float[] days) {
        this.days = days.clone();
    }

    public float calcRegular() {
        float totalHrs = 0.0f;
        for (float day : days) {
            totalHrs += Math.min(day, 8.0f);
        }
        return totalHrs;
    }

    public float calcOvertime() {
        float totalHrs = 0.0f;
        for (float day : days) {
            totalHrs += Math.max(0.0f, day - 8.0f);
        }
        return totalHrs;
    }
}*/class WeekName
{
    public int number_of_days=7;
    public float[] days = new float[number_of_days];
    public WeekName(float[] days)
    {
        days = new float[7];
        System.arraycopy(days, 0, this.days, 0, 7);
    }
    //calculate total regular hours
    public float calculateRegularHours()
    {
        float totalHrs = 0f;
        for (float day : days) { //for each loop
            if (day <= 8) {
                totalHrs += day;
            } else {
                totalHrs += 8;
            }
        }
        return totalHrs;
    }

    //calculate total overtime hours
    public float calculateOverTimeHours()
    {
        float totalHrs = 0f;
        for (float day : days) {
            if (day > 8) {
                totalHrs += day - 8;
            }
        }
        return totalHrs;
    }
};
public class EmployeePayRoll extends JFrame {
    /*Sorry I have named the days so weird.
    f->short form for first
    D->short form for day
    T/t->short form for third
    S/s->short form for second

     */

    private JTextField employeeName;
    private JTextField salPerHour;
    private JTextField FDayWeek1;
    private JTextField SDayWeek1;
    private JTextField TDayWeek1;
    private JTextField FourtDayWeekk1;
    private JTextField fifthDAyWeek1;
    private JTextField SixDayWeek1;
    private JTextField sevenDayWeek1;
    private JTextField fDayWeek2;
    private JTextField sDayWeek2;
    private JTextField tDayWeek2;
    private JTextField fourthDayWeek2;
    private JTextField fifthDayWeek2;
    private JTextField sixthDayWeek2;
    private JTextField sevenDayWeek2;
    private JTextField regularHours;
    private JTextField regularHoursAmount;
    private JTextField overtimeHours;
    private JTextField overtimeAmount;
    private JTextField netPay;
    private JButton processItButton;
    private JButton closeButton;
    private JPanel myPanel;

    public EmployeePayRoll() {
        processItButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float hoursForWeek1 []= {
                        Float.parseFloat(FDayWeek1.getText()),
                        Float.parseFloat(SDayWeek1.getText()),
                        Float.parseFloat(TDayWeek1.getText()),
                        Float.parseFloat(FourtDayWeekk1.getText()),
                        Float.parseFloat(fifthDAyWeek1.getText()),
                        Float.parseFloat(SixDayWeek1.getText()),
                        Float.parseFloat(sevenDayWeek1.getText())
                };
                //Reading week2 data
                float hoursForWeek2 [] = {
                        Float.parseFloat(fDayWeek2.getText()),
                        Float.parseFloat(sDayWeek2.getText()),
                        Float.parseFloat(tDayWeek2.getText()),
                        Float.parseFloat(fourthDayWeek2.getText()),
                        Float.parseFloat(fifthDayWeek2.getText()),
                        Float.parseFloat(sixthDayWeek2.getText()),
                        Float.parseFloat(sevenDayWeek2.getText())};

                //Creating week objects
                Week weekOne = new Week(new float[7]);
                Week weekTwo = new Week(new float[7]);
                //Copying arrays
                System.arraycopy(hoursForWeek1, 0, weekOne.days, 0, 7);
                System.arraycopy(hoursForWeek2, 0, weekTwo.days, 0, 7);
                /*
                This is another method but you will debug it for 25yrs. Just a joke.
                //Create a helper method to copy the contents of one array to another.
               private static void copyArray(float[] src, float[] dest) {
               System.arraycopy(src, 0, dest, 0, src.length);
                }

              // Copy the contents of the hoursForWeek1 and hoursForWeek2 arrays to the days arrays of weekOne and weekTwo, respectively.
               copyArray(hoursForWeek1, weekOne.days);
               copyArray(hoursForWeek2, weekTwo.days);*/

                //Initializing some variables
                float hourlyPayment = Float.parseFloat(salPerHour.getText());
                float regularPayment, overPayment, netPayment, overTimeRate = 152.79f/5.5f;

                //Performing the computation
                regularPayment = (weekOne.calcRegular() + weekTwo.calcRegular()) * hourlyPayment;
                overPayment = (weekOne.calcOvertime() + weekTwo.calcOvertime())* overTimeRate;
                netPayment = regularPayment + overPayment;

                /*Updating the User Interface elements.(%.1f,%.2f represents the number of decimal points.
                I used it basing on the assignment  I was given
                */
                regularHours.setText(String.format("%.1f",  (regularPayment / hourlyPayment)));
                overtimeHours.setText(String.format("%.1f", (overPayment / overTimeRate)));
                regularHoursAmount.setText(String.format("%.2f", regularPayment));
                overtimeAmount.setText(String.format("%.2f", overPayment));
                netPay.setText(String.format("%.2f", netPayment));

            }
        });
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //closing the UI using this simple command
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        EmployeePayRoll pay= new EmployeePayRoll();
        pay.setContentPane(pay.myPanel);
        pay.setTitle("GeorgeTown Cleaning Services-Employee PayRoll");
        //JColorChooser(#FFF);
        int width = 1000, height = 400;
        pay.setSize(width, height);

        int x = (1368 - width) / 2;
        int y = (768 - height) / 2;
        pay.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pay.setVisible(true);

    }
}
