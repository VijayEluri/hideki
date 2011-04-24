public class Singleton
{
	private static Singleton _instance = null;
	
	public static Singleton instance(){
		if(_instance == null){
			_instance = new Singleton();
		}
		return _instance;
	}

	private Singleton(){
	}
}
