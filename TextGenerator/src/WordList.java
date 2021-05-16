class WordList {

    Word firstNode;
    int size;
    Word temp;

    WordList(){
        firstNode = null;
        size = 0;
    }

    boolean isEmpty() {
        return (size == 0);
    }

    void add(String word, String nextWord){

        temp = firstNode;
        if(isEmpty())
            firstNode = new Word(word, nextWord);
        else {
            while(temp.nextNode != null) {

                if(temp.word.equals(word)) {
                    temp.addSynapse(nextWord);
                    return;
                }
                temp = temp.nextNode;
            }
            Word newWord = new Word(word, nextWord);
            newWord.nextNode = firstNode;
            firstNode = newWord;
        }
        size++;
    }
}
