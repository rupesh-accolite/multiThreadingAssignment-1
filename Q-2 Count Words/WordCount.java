import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of lines to read:\n");
        int lineCount = Integer.parseInt(scanner.nextLine());
        List<String> data = new ArrayList<>();
        for(int i=0; i<lineCount; i++){
            data.add(scanner.nextLine());
        }
        System.out.print("Enter the number of threads to use:\n");
        int threadCount = Integer.parseInt(scanner.nextLine());
        if(threadCount>lineCount){
            System.out.println("Enter correct number of threads");
        }
        else{
            int partSize = lineCount / threadCount, extra = 0;
            if(lineCount % threadCount != 0){
                extra = lineCount % threadCount;
            }
            int i=0,cnt=0;
            List<String> split = new ArrayList<>();
            while(i<lineCount){
                if(extra!=0 && cnt+1==threadCount){
                    partSize+=extra;
                }

                StringBuilder stringBuilder = new StringBuilder();
                List<String> sl = data.subList(i,i+partSize);
                for(String x: sl){
                    stringBuilder.append(x);
                    stringBuilder.append(" ");
                }

                split.add(stringBuilder.toString());

                cnt++;
                i+=partSize;
            }

            ArrayList<Counting> counting = new ArrayList<>();
            for(i=0; i<threadCount; i++){
                counting.add(new Counting(split.get(i)));
            }
            long startTime = System.currentTimeMillis();
            for(i=0; i<threadCount; i++){
                counting.get(i).start();
                try {
                    counting.get(i).join();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            long endTime = System.currentTimeMillis();

            System.out.println("Execution time with multi threading: "+(endTime-startTime)+" milliseconds");

            System.out.println("Total number of words:"+ Counting.getWordCount());



        }


    }
}
