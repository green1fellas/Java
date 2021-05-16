import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();
    private static WordList wordList = new WordList();
    private static String[] textArr;
    public static Sentence sentence = new Sentence();

    public static void main(String[] args) {

        //String text = sc.nextLine();
        String text = ""; // This is where it learns from, copy and paste a story or something
        text = text.replaceAll("\n", " ");
        textArr = text.split(" ");
        for(int i = 0; i < textArr.length - 1; i++) {
            wordList.add(textArr[i], textArr[i+1]);
        }
        generate();
    }

    private static void generate(){

        int startingWord = rand.nextInt(wordList.size);
        int depth = 0;
        Word temp = wordList.firstNode;
        Word nextWord;

        System.out.println();

        while(temp != null){
            if(depth == startingWord){
                break;
            }
            temp = temp.nextNode;
            depth++;
        }
        nextWord = temp;
        temp = wordList.firstNode;
        System.out.print(nextWord.word + " ");

        for(int i = 0; i < 50; i++){
            String startingWord2 = nextWord.synapses.get(rand.nextInt(nextWord.synapses.size()));

            while(temp != null){

                if(startingWord2.equals(temp.word)){
                    break;
                }
                temp = temp.nextNode;
            }
            nextWord = temp;
            temp = wordList.firstNode;
            System.out.print(sentence.checkPronoun(nextWord.word) + " ");
            if((i + 1) % 9 == 0)
                System.out.println();
        }
    }

    private static void printData(){

        Word temp = wordList.firstNode;

        while(temp != null){
            System.out.println("-----------\n" + temp.word + "\nSynapses:" +
                    temp.synapses + "\nWeight:" + temp.weights);
            temp = temp.nextNode;
        }
    }
}
