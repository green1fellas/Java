package Objects;

class Person {

    private String name;
    private int age;
    private int weight;
    private String eyeColor;
    private String shirtColor;
    private String hairColor;

    // Constructor

    Person(String name, int age, int weight, String eyeColor,
           String shirtColor, String hairColor){

        this.name = name;
        this.age = age;
        this.weight = weight;
        this.eyeColor = eyeColor;
        this.shirtColor = shirtColor;
        this.hairColor = hairColor;

    }

    void printInfo(){

        System.out.println(name + " is " + age + " years old, " +
        weight + "lbs, with " + eyeColor + " eyes, a " + shirtColor
                + " shirt and has " + hairColor + " hair.");

    }

    // Getters and Setters

    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    int getWeight(){
        return weight;
    }
    String getEyeColor(){
        return eyeColor;
    }
    String getShirtColor(){
        return shirtColor;
    }
    String getHairColor(){
        return hairColor;
    }
    void setName(String newName){
        name = newName;
    }
    void setAge(int newAge){
        age = newAge;
    }
    void setWeight(int newWeight){
        weight = newWeight;
    }
    void setEyeColor(String newEyeColor){
        eyeColor = newEyeColor;
    }
    void setShirtColor(String newShirtColor){
        shirtColor = newShirtColor;
    }
    void setHairColor(String newHairColor){
        hairColor = newHairColor;
    }


}
