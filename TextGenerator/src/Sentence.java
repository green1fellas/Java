public class Sentence {

    String currPronoun;

    Sentence(){ }

    public String checkPronoun(String word) {

        if (word.contains(".") || word.contains("!") || word.contains("?")) {
            currPronoun = null;
            return word;
        }

        if (currPronoun != null) {
             // he -> she
             if (currPronoun.equals("he")) {

                if (word.toLowerCase().contains("she")) {
                    return "he";
                }
                if (word.toLowerCase().contains("she's")) {
                    return "he's";
                }
                if (word.toLowerCase().contains("her")) {
                    return "him";
                }
                if (word.toLowerCase().contains("her's")) {
                    return "his";
                }
            } else if (currPronoun.equals("she")) {

                if (word.toLowerCase().contains("he")) {
                    return "she";
                }
                if (word.toLowerCase().contains("he's")) {
                    return "she's";
                }
                if (word.toLowerCase().contains("him")) {
                    return "her";
                }
                if (word.toLowerCase().contains("his")) {
                    return "her's";
                }
            }
            return word;
        }
        if(word.toLowerCase().contains("he") || word.toLowerCase().contains("he's") || word.toLowerCase().contains("him") || word.toLowerCase().contains("his")) { currPronoun = "he";}
        if(word.toLowerCase().contains("she") || word.toLowerCase().contains("she's") || word.toLowerCase().contains("her") || word.toLowerCase().contains("her's")) { currPronoun = "she";}
        return word;
    }
}
