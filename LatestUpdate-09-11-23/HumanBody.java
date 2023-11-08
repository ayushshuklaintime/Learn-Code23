abstract class HumanBody {
    private String[] organs;

    public String[] getOrgans() {
        return organs;
    }

    public void setOrgans(String[] organs) {
        this.organs = organs;
    }

    public String chewFood(String food) {
        System.out.println("Chewing " + food + ".");
        return "Chewed " + food;
    }

    public String swallowFood(String food) {
        System.out.println("Swallowing " + food + ".");
        return "Swallowed " + food;
    }

    public String processStomach(String food) {
        System.out.println("Stomach processes " + food + ".");
        return "Partially digested " + food;
    }

    public String digestSmallIntestine(String food) {
        System.out.println("Small intestine digests " + food + ".");
        return "Digested " + food;
    }

    public String releaseBile(String food) {
        System.out.println("Liver and gallbladder release bile for fat digestion of " + food + ".");
        return "Bile released for " + food;
    }

    public String absorbNutrients(String food) {
        System.out.println("Absorbing nutrients in the small intestine from " + food + ".");
        return "Absorbed nutrients from " + food;
    }

    public String absorbWaterAndElectrolytes(String food) {
        System.out.println("Large intestine absorbs water and electrolytes from " + food + ".");
        return "Absorbed water and electrolytes from " + food;
    }

    public String secretePancreaticJuices(String food) {
        System.out.println("Pancreas secretes digestive juices for " + food + ".");
        return "Pancreatic juices secreted for " + food;
    }
    
    public void ingestFood(String food) {
        System.out.println("Ingesting " + food + ".");
    }
    
    public void processDigestiveSystem() {
        System.out.println("Digestive system process completed.");
    }
    
    public void eliminateWaste() {
        System.out.println("Eliminating waste through the rectum.");
    }

    // Abstract method
    public abstract void performMetabolism(String food);
}