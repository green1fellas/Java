package InheritancePolymorphismInterfaces;

class Programmer extends Person {

    private String language;

    Programmer(String language, String hairColor, String eyeColor, String height,
               int weight, String gender){

        super(hairColor, eyeColor, height, weight, gender);
        this.language = language;

    }

    void sayHi(){
        System.out.println("Hello world!");
    }

    void writeCode(){
        System.out.println("Okay, I can write code");
    }

    public String getLanguage() {
        return language;
    }
}
