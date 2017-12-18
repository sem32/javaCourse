package animals;

public class GuideDog extends Pet {
    private boolean isTrained;

    public GuideDog(boolean isVaccinated, String name, boolean isTrained) {
        super(isVaccinated, name);
        this.isTrained = isTrained;
    }

    public static void backToHome() {
        System.out.println("Let's start to back home right now");
    }

    @Override
    public void makeVoice() {
        super.makeVoice();
        System.out.println("I can take you home.");
    }
}
