package InheritancePolymorphismInterfaces;

public class Main {

    public static void main(String[] args) {

        Person Billy = new Person ("brown", "blue",
                "5'7",130, "male");

        Programmer Scott = new Programmer("Java","brown","hazel",
                "5'7",128, "male");

        Billy.sayHi();
        Scott.sayHi();

        Billy.eat();
        Scott.writeCode();

    }
}
