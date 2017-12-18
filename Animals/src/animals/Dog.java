package animals;

public class Dog extends Pet {
    public Dog(boolean isVaccinated, String name) {
        super(isVaccinated, name);
    }

    @Override
    public void makeVoice() {
        super.makeVoice();
        System.out.println("Woof.");
    }
}
