import java.util.Scanner;

class BookInputTest{
    String title;
    String author;
    int numberOfPages;
}


public class Oop {
    public static void main(String[] args) {
        Scanner self= new Scanner(System.in);


        BookInputTest book = new BookInputTest();
        String y=book.title,z=book.author;
        int a=book.numberOfPages;


        System.out.print("Please enter the author's name: ");
        z=self.nextLine();
        System.out.print("Please enter the title name: ");
        y=self.nextLine();
        System.out.print("Please enter the number of pages: ");
        a=self.nextInt();
        System.out.println("The book title is: "+y);
        System.out.println("The book author is: "+z);
        System.out.println("The book has  "+a+" pages");




    }
}
