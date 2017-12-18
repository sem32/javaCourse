import animals.*;

public class AnimalsApp {

    public static void main(String[] args) {
        Animal[] veterinaryСlinic = new Animal[9];

        veterinaryСlinic[0] = new Cat(false, "Tom");
        veterinaryСlinic[1] = new Crocodile();
        veterinaryСlinic[2] = new Dog(true, "Stark");
        veterinaryСlinic[3] = new Fish("Emma");
        veterinaryСlinic[4] = new Giraf();
        veterinaryСlinic[5] = new GuideDog(true, "Eddy", true);
        veterinaryСlinic[6] = new Hamster("Jerry");
        veterinaryСlinic[7] = new Lion();
        veterinaryСlinic[8] = new Volf();

        for (Animal pacient : veterinaryСlinic) {
            pacient.makeVoice();
        }
    }
}
