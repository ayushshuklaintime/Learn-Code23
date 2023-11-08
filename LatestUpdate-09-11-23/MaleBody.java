class MaleBody extends HumanBody implements DigestiveSystem {
    public MaleBody() {
        setOrgans(new String[]{"Mouth", "Esophagus", "Stomach", "Small Intestine", "Liver", "Gallbladder", "Large Intestine"});
    }

    public void ingestFood(String food) {
        food = chewFood(food);
        food = swallowFood(food);
        food = processStomach(food);
        food = digestSmallIntestine(food);
        food = releaseBile(food);
        food = absorbNutrients(food);
        food = absorbWaterAndElectrolytes(food);
        System.out.println("Digestive system processes food in a male body.");
    }

    public void eliminateWaste() {
        System.out.println("Eliminating waste through the rectum.");
    }
    
    // Implementation of the abstract method
    public void performMetabolism(String food) {
        System.out.println("Metabolism in a male body for " + food);
    }

     // Implementation of the processDigestiveSystem method
     public void processDigestiveSystem() {
        System.out.println("Digestive system process completed in a male body.");
    }
}