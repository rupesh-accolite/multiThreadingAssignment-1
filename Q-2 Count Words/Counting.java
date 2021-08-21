public class Counting extends Thread{
    private String sentence;
    private static int wordCount=0;

    public Counting(){}
    public Counting(String sentence){
        this.sentence = sentence;
    }

    public static int getWordCount() {
        return wordCount;
    }

    synchronized public void count(String sentence){
        String[] words = sentence.split(" ");
        for(String x:words)
            if (x.length() > 0)
                wordCount++;
    }

    public void run(){
        count(sentence);
    }
}
