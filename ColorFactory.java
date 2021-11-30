
interface Color {
	void print();
}

class Red implements Color {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("Red Class");
	}

}

class Green implements Color {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.print("Green Class");
	}

}

public class ColorFactory {

	public Color GetColor(String colorType) {
		if (colorType.equals("Red")) {
			return new Red();
		}
		if (colorType.equals("Green")) {
			return new Green();
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ColorFactory obj = new ColorFactory();

		Color red = obj.GetColor("Red");

		red.print();

		Color green = obj.GetColor("Green");

		green.print();
	}

}
