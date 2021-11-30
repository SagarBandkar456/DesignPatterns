/*
 * Commented beacsue alredy implement in same Project.
 *  
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
*/

public class ColorMakerFacade {

	private Color red;
	private Color green;
	ColorMakerFacade()
	{
		red=new Red();
		green=new Green();
	}
	
	public void PrintRed()
	{
		red.print();
	}
	
	public void PrintGreen()
	{
		green.print();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ColorMakerFacade obj=new ColorMakerFacade();
		
		obj.PrintGreen();
		obj.PrintRed();
	}

}
