package animals;

public class Cat extends Pet {
    public Cat(boolean isVaccinated, String name) {
        super(isVaccinated, name);
    }

    @Override
    public void makeVoice() {
        super.makeVoice();
        System.out.println("Meow.");
    }
}
