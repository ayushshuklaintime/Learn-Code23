public class OopsConceptsOnHumanBody {
    public static void main(String[] args) {
        HumanDetails person = new HumanDetails("Shaktiman", 24, "Male");

        HumanBodyFunctionalities actions = new HumanBodyFunctionalities("SuperWomen", 25, "Female", 1000);
        actions.exercise(30);

       
        System.out.println("\n=> Using the see() method from the BodyParts class:");
        BodyParts.see(person);

        System.out.println("\n=> Using the see method from the Actions class:");
        actions.see();


        BodyParts.heartFailure(person);

        person.humanDied();

    }
}
