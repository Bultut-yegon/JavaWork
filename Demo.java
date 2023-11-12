import java.util.Scanner;
public class Demo {

        public static final double REGULAR_HOURLY_RATE = 20;
        public static final double OVERTIME_HOURLY_RATE = 1.5 * REGULAR_HOURLY_RATE;
        public static final int REGULAR_HOURS_PER_DAY = 8;
        public static final int DAYS_PER_WEEK = 5;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Collect the time for each day of the first week
            double[] week1Hours = new double[DAYS_PER_WEEK];
            for (int i = 0; i < DAYS_PER_WEEK; i++) {
                System.out.println("Enter the number of hours worked on day " + (i + 1) + " of the first week: ");
                week1Hours[i] = scanner.nextDouble();
            }

            // Calculate the total regular hours and overtime hours for the first week
            double totalRegularHours = 0;
            double totalOvertimeHours = 0;
            for (double dayHours : week1Hours) {
                if (dayHours > REGULAR_HOURS_PER_DAY) {
                    totalOvertimeHours += (dayHours - REGULAR_HOURS_PER_DAY);
                    totalRegularHours += REGULAR_HOURS_PER_DAY;
                } else {
                    totalRegularHours += dayHours;
                }
            }

            // Calculate the regular pay and overtime pay for the first week
            double totalRegularPay = totalRegularHours * REGULAR_HOURLY_RATE;
            double totalOvertimePay = totalOvertimeHours * OVERTIME_HOURLY_RATE;

            // Collect the time for each day of the second week
            double[] week2Hours = new double[DAYS_PER_WEEK];
            for (int i = 0; i < DAYS_PER_WEEK; i++) {
                System.out.println("Enter the number of hours worked on day " + (i + 1) + " of the second week: ");
                week2Hours[i] = scanner.nextDouble();
            }

            // Calculate the total regular hours and overtime hours for the second week
            totalRegularHours = 0;
            totalOvertimeHours = 0;
            for (double dayHours : week2Hours) {
                if (dayHours > REGULAR_HOURS_PER_DAY) {
                    totalOvertimeHours += (dayHours - REGULAR_HOURS_PER_DAY);
                    totalRegularHours += REGULAR_HOURS_PER_DAY;
                } else {
                    totalRegularHours += dayHours;
                }
            }

            // Calculate the regular pay and overtime pay for the second week
            double week2RegularPay = totalRegularHours * REGULAR_HOURLY_RATE;
            double week2OvertimePay = totalOvertimeHours * OVERTIME_HOURLY_RATE;

            // Calculate the total net pay
            double totalNetPay = totalRegularPay + totalOvertimePay + week2RegularPay + week2OvertimePay;

            // Display the results
            System.out.println("Total regular hours: " + totalRegularHours);
            System.out.println("Total overtime hours: " + totalOvertimeHours);
            System.out.println("Regular pay: " + totalRegularPay);
            System.out.println("Overtime pay: " + totalOvertimePay);
            System.out.println("Total net pay: " + totalNetPay);
        }
    }


