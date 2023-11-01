abstract class HumanBodyFunctionalities extends HumanDetails {
    private int remainingEnergyLevel;

    public HumanBodyFunctionalities(String name, int age, String gender, int remainingEnergyLevel) {
        super(name, age, gender);
        this.remainingEnergyLevel = remainingEnergyLevel;
    }

    public void exercise(int durationInMinutes) {
        if (isPersonAlive()) {
            int energyConsumed = durationInMinutes * 5;
            if (remainingEnergyLevel >= energyConsumed) {
                remainingEnergyLevel -= energyConsumed;
                System.out.println(getPersonName() + " ( Age = " + age + ", Gender = " + getPersonGender() + ") and is exercising for " + durationInMinutes + " minutes. Remaining energy level: " + remainingEnergyLevel);
            } else {
                System.out.println(getPersonName() + " is too tired to exercise for " + durationInMinutes + " minutes.");
            }
        } else {
            System.out.println(getPersonName() + " can't exercise because they are not alive.");
        }
    }

    // Inheritance: Overridden method to demonstrate inheritance with age and gender
    public abstract void see();
}
