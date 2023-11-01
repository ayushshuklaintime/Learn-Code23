class HumanDetails {
    private String name;
    protected int age;
    private String gender;
    private boolean isAlive;

    public HumanDetails(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isAlive = true;
    }

    public void humanDied() {
        isAlive = false;
        System.out.println(name + " has passed away. Rest in peace.");
    }

    public boolean isPersonAlive() {
        return isAlive;
    }

    public String getPersonName() {
        return name;
    }

    protected String getPersonGender() {
        return gender;
    }
}
