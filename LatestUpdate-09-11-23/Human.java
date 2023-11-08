class Human {
    private HumanBody body;
    private String name;
    private int age;
    private String gender;

    public Human(String gender, String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        if (gender.equalsIgnoreCase("male")) {
            body = new MaleBody();
        } else if (gender.equalsIgnoreCase("female")) {
            body = new FemaleBody();
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void eat(String food) {
        body.ingestFood(food);
        body.processDigestiveSystem();
        body.eliminateWaste();
    }
}