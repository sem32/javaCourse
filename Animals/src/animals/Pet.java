package animals;

public abstract class Pet extends Animal {

    private String name;

    boolean isVaccinated;

    public Pet(boolean isVaccinated, String name) {
        this.isVaccinated = isVaccinated;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVaccinated() {
        return isVaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        isVaccinated = vaccinated;
    }

    public void makeVoice() {
        super.makeVoice();
        System.out.print("my name is " + name + ". ");
    }
}
