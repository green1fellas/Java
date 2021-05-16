package SocialNetwork;

import java.util.LinkedList;

class Network {

    LinkedList<LinkedList<Account>> vertices = new LinkedList<>();

    Network() {}

    void addEdge(Network network, Account src, Account dest) {

        for (int i = 0; i < network.vertices.size(); i++) {
            if (network.vertices.get(i).get(0).getName().equals(src.getName())) {
                network.vertices.get(i).addLast(dest);
            }
        }
    }

    private static Account[] topSet;
    private static int highestScore;
    private static Account[] currSet;
    private static int currScore;

    void findCompatibility(Network network, int n) {

        topSet = new Account[n];
        highestScore = 0;
        currSet = new Account[n];
        currScore = 0;

        for(int i = 0; i < network.vertices.size() - n+1; i++){
            currSet[n-1] = network.vertices.get(i).get(0);
            currScore += network.vertices.get(i).get(0).getWeight();
            findCompatibilityRec(i+1, n-1);
            currSet[n-1] = null;
        }
        System.out.print("\nTop Set: ");
        for(int i = 0; i < topSet.length; i++) {
            if(topSet[i]!=null)
                System.out.print(topSet[i].getName() + " ");
        }
        System.out.println();
    }

    private void findCompatibilityRec(int startPos, int n){

        for(int i = startPos; i < vertices.size()-n+1; i++){
            currSet[n - 1] = vertices.get(i).get(0);

            if(n==1)
                currScore = buildScore(this, currSet);
            if(n>1){
                findCompatibilityRec(i+1, n-1);
            }else{
                if(currScore>highestScore){
                    for(int j = 0; j < currSet.length; j++) {
                        topSet[j] = currSet[j];
                    }
                    highestScore = currScore;
                }
            }
            currSet[n-1]=null;
            currScore = 0;
        }
    }

    private static int buildScore(Network network, Account[] currSet){

        int temp = 0;

        for(int i = 0; i < network.vertices.size(); i++){
            for(int k = 0; k < currSet.length; k++){
                if(network.vertices.get(i).get(0)!=null && currSet[k]!=null){
                    if(network.vertices.get(i).get(0).getName().equals(currSet[k].getName())) {
                        for (int j = 0; j < network.vertices.get(i).size(); j++) {
                            for (int l = 0; l < currSet.length; l++) {
                                if(network.vertices.get(i).get(j)!=null && currSet[l]!=null) {
                                    if (network.vertices.get(i).get(j).getName().equals(currSet[l].getName())) {
                                        temp += network.vertices.get(i).get(j).getWeight();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return temp;
    }

    void printNetwork(Network network) {

        for (int i = 0; i < network.vertices.size(); i++) {

            System.out.print("Friends of " + network.vertices.get(i).get(0).getName() + ":");
            for (int j = 1; j < network.vertices.get(i).size(); j++) {
                System.out.print(" " + network.vertices.get(i).get(j).getName());
            }
            System.out.println();
        }
    }
}