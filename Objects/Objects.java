package Objects;

public class Objects {

    public static void main(String[] args) {

        Person eddie = new Person("Eddie", 15, 92,
                "Dark Brown", "Grey", "Brown");

        Person Steve = new Person("Steve", 25, 6000,
                "Hazel", "Red", "Blue");

        eddie.printInfo();
        eddie.setAge(eddie.getAge() + 1);
        eddie.setName("Eddy");
        eddie.printInfo();

        Steve.printInfo();

        System.out.println(eddie.getName() + " is his name");

    }
}
