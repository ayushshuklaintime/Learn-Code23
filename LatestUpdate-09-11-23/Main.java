public class Main {
    public static void main(String[] args) {
        Human male = new Human("male", "John", 30);
        male.eat("Pizza");
        System.out.println(male.getName() + " is a " + male.getGender() + " and is " + male.getAge() + " years old.");
        System.out.println("\n\n\n");
        Human female = new Human("female", "Jane", 25);
        female.eat("Salad");
        System.out.println(female.getName() + " is a " + female.getGender() + " and is " + female.getAge() + " years old.");
    }
}
