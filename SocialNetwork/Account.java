package SocialNetwork;

class Account {

    private String name;
    private int weight;

   Account(String name, int weight){

       this.name = name;
       this.weight = weight;
   }

   String getName(){
       return name;
   }
   int getWeight(){
       return weight;
   }
}
