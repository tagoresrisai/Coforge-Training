package com.coforge.day6;

@FunctionalInterface
interface MyReference{
	void showMessage();
}

public class MethodReferenceTest {

		void myInstanceMethod() {
			System.out.println("Example for Instance Method Reference");
		}
		static void myStaticMethod() {
			System.out.println("Example for Static Method Reference");
		}
		MethodReferenceTest(){
			System.out.println("Constructior");
		}
		
		public static void main(String[] args) {
			MethodReferenceTest obj = new MethodReferenceTest();
			MyReference reference = obj::myInstanceMethod;
			reference.showMessage();
			
			reference = MethodReferenceTest::myStaticMethod;
			reference.showMessage();
			
			reference = MethodReferenceTest::new;
			reference.showMessage();
		}

}
