
interface Bird {

	public void Fly();

	public void MakeSound();
}

interface ToyDuck {
	public void Squeak();
}

class Sparrow implements Bird {

	@Override
	public void Fly() {
		// TODO Auto-generated method stub
		System.out.println("Flying");
	}

	@Override
	public void MakeSound() {
		// TODO Auto-generated method stub
		System.out.println("Chirp Chirp");
	}

}

class PlasticToyDuck implements ToyDuck {

	@Override
	public void Squeak() {
		// TODO Auto-generated method stub
		System.out.println("Squeak");
	}

}

public class BirdAdapter implements ToyDuck {

	Bird bird;

	BirdAdapter(Bird b) {
		this.bird = b;
	}

	@Override
	public void Squeak() {
		// TODO Auto-generated method stub
		bird.MakeSound();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sparrow sparrow = new Sparrow();

		PlasticToyDuck duck = new PlasticToyDuck();

		// Wrap a bird in a birdAdapter so that it
		// behaves like toy duck
		ToyDuck birdAdapter = new BirdAdapter(sparrow);

		System.out.println("Sparrow...");
		sparrow.Fly();
		sparrow.MakeSound();

		System.out.println("ToyDuck...");
		duck.Squeak();

		System.out.println("BirdAdapter...");
		birdAdapter.Squeak();
	}
}
