package animals;

public class Hamster extends Pet {
    public Hamster(String name) {
        super(false, name);
    }

    @Override
    public void makeVoice() {
        super.makeVoice();
        System.out.println();
    }
}
