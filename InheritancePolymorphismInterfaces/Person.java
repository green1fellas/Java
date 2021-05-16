package InheritancePolymorphismInterfaces;

class Person {

    private String hairColor;
    private String eyeColor;
    private String height;
    private int weight;
    private String gender;

    Person(String hairColor, String eyeColor, String height,
           int weight, String gender){

        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.height = height;
        this.weight = weight;
        this.gender = gender;

    }

    void sayHi(){
        System.out.println("Hi!");
    }

    void eat(){
        System.out.println("Okay, I can eat");
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public String getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getGender() {
        return gender;
    }
}
