import java.io.IOException;

final class Foo {
	// Lazy initialization 
	private static class Holder {
		static Helper helper = new Helper(5); 
		}

	public static Helper getInstance() { 
		return Holder.helper;
	} 
	
	public void testCase(){
		Thread test = new Thread(new Runnable() {
			public void run() {
				Foo testF = new Foo();
				testF.getInstance();
				}
			});
			   test.start();
	}
	
	public void main(String[] args) throws IOException { 
		
		testCase(); // starts thread 1 
		testCase(); // starts thread 2
	}
}
