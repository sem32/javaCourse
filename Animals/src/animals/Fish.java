package animals;

public class Fish extends Pet {

    public Fish(String name) {
        super(false, name);
    }

    @Override
    public void makeVoice() {
        System.out.println("...");
    }
}
