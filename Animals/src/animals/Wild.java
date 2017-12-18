package animals;

public abstract class Wild extends Animal{

    private boolean isPredator;

    public boolean isPredator() {
        return isPredator;
    }

    public void setPredator(boolean predator) {
        isPredator = predator;
    }

    public Wild(boolean isPredator) {
        this.isPredator = isPredator;
    }

    @Override
    public void makeVoice() {
        super.makeVoice();
        System.out.println("I am a wild animal" + (isPredator ? " and I am angry." : ","));
    }
}
