
interface Shape {
	public void Draw();
}

class Circle implements Shape {

	@Override
	public void Draw() {
		System.out.println("Shape: Circle");
	}

}

abstract class ShapeDecorator implements Shape {

	protected Shape decoretedShape;

	ShapeDecorator(Shape decoretedShape) {
		this.decoretedShape = decoretedShape;
	}

	public void draw() {
		decoretedShape.Draw();
	}

}

class RedShapeDecorator extends ShapeDecorator {

    ShapeDecorator decoratedShape = null;
    
	public RedShapeDecorator(Shape decoratedShape)
	{
		//this.decoratedShape=decoratedShape;
		super(decoratedShape);
	}
	
	@Override public void Draw()
    {

        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }
 
    private void setRedBorder(Shape decoratedShape)
    {
      // Display message whenever function is called
        System.out.println("Border Color: Red");
    }
}

public class DecoratorPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape circle = new Circle();
		 
        Shape redCircle
            = new RedShapeDecorator(new Circle());
 
        // Display message
        System.out.println("Circle with normal border");
 
        // Calling the draw method over the
        // object calls as created in
        // above classes
 
        // Call 1
        circle.Draw();
 
        // Display message
        System.out.println("\nCircle of red border");
 
        // Call 2
        redCircle.Draw();

	}

}
