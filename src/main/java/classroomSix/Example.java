package classroomSix;

import com.github.javafaker.Faker;

public class Example {
    public static void main(String[] args) {
        System.out.println("This is Maven project");
        Employee employeeOne = new Employee("Janis", "gramatvedis", 10000.32);
        System.out.println(employeeOne.toString());

        Faker faker = new Faker();

        Employee employeeTwo = new Employee(faker.name().firstName(), faker.company().profession(),
                faker.number().randomDouble(2, 100, 2000));
        System.out.println(employeeTwo.toString());

        System.out.println(faker.name().firstName());
        System.out.println(faker.name().lastName());
        System.out.println(faker.company().profession());
        System.out.println(faker.avatar().image());
        System.out.println(faker.friends().character());
        System.out.println(faker.superhero().descriptor());

        Employee employeeThree = new Employee();
        System.out.println(employeeThree);

        Employee employeeX = new Employee();
        for (int i = 0; i < 100; i ++) {
            System.out.println(employeeX.toString());
        }
    }
}
