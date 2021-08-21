import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCountWithoutMT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of lines to read:\n");
        int lineCount = Integer.parseInt(scanner.nextLine());
        StringBuilder finalString = new StringBuilder();
        for(int i=0; i<lineCount; i++){
            finalString.append(scanner.nextLine());
            finalString.append(" ");
        }
        long startTime = System.currentTimeMillis();
        Counting counting = new Counting();
        counting.count(finalString.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time without multi threading: "+(endTime-startTime)+" milliseconds");

        System.out.println("Total number of words:"+ counting.getWordCount());

    }

}
