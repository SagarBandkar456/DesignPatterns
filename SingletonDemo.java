

class Singleton
{
	private static Singleton instance=null;
	
	private Singleton() {}
	
	public static Singleton GetInstance()
	{
		if(instance==null) instance=new Singleton();
		return instance; 
	}
}

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton x = Singleton.GetInstance();
		 
        // Instantiating Singleton class with variable y
        Singleton y = Singleton.GetInstance();
 
        // Instantiating Singleton class with variable z
        Singleton z = Singleton.GetInstance();
 
        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                           + x.hashCode());
        System.out.println("Hashcode of y is "
                           + y.hashCode());
        System.out.println("Hashcode of z is "
                           + z.hashCode());
 
        // Condition check
        if (x == y && y == z) {
 
            // Print statement
            System.out.println(
                "Three objects point to the same memory location on the heap i.e, to the same object");
        }
 
        else {
            // Print statement
            System.out.println(
                "Three objects DO NOT point to the same memory location on the heap");
        }
		
		
	}

}
