public class TestSingleton
{
	public static void main(String[] args){
		Singleton singleton1 = Singleton.instance();
		Singleton singleton2 = Singleton.instance();
		if(singleton1 == singleton2){
			System.out.println("WORKS!!!");
		}
		else{
			System.out.println("NOT SINGLETON...");
		}
	}
}
