class BodyParts {
    public static void heartFailure(HumanDetails human) {
        if (human.isPersonAlive()) {
            System.out.println(human.getPersonName() + " lost their heart.");
        } else {
            System.out.println(human.getPersonName() + " can't lose their heart because they are not alive.");
        }
    }

    public static void see(HumanDetails human) {
        if (human.isPersonAlive()) {
            System.out.println(human.getPersonName() + " can see things.");
        } else {
            System.out.println(human.getPersonName() + " can't see things because they are not alive.");
        }
    }

    /* Abstraction: Abstracts body parts and their actions, while using the method in
     * OOpsConceptsHumanBody.java, we do not know the functionality behind.
     */
}
