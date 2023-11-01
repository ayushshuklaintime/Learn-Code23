class ConcreteHumanBodyFunctionalities extends HumanBodyFunctionalities {
    public ConcreteHumanBodyFunctionalities(String name, int age, String gender, int remainingEnergyLevel) {
        super(name, age, gender, remainingEnergyLevel);
    }

    @Override
    public void see() {
        System.out.println(getPersonName() + " can see things.");
    }
}
/*
 *  Abstract classes cannot be instantiated directly. Instead, you need to create a concrete subclass that extends the abstract class and then create an instance of the subclass.
 */