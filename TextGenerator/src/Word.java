import java.util.ArrayList;

class Word {

    Word nextNode;
    String word;
    String nextWord;
    // holds words it connects to and weights
    ArrayList<String> synapses = new ArrayList<>();
    ArrayList<Integer> weights = new ArrayList<>();
    boolean wordFound = false;

    Word(String word, String nextWord){
        this.word = word;
        this.nextWord = nextWord;
        nextNode = null;
        addSynapse(nextWord);
    }

    void addSynapse(String nextWord){

        for(int i = 0; i < synapses.size(); i++) {
            if (synapses.get(i).equals(nextWord)) {
                weights.set(i, weights.get(i) + 1);
                wordFound = true;
            }
        }
        if(!wordFound) {
            synapses.add(nextWord);
            weights.add(1);
        }

    }

}
