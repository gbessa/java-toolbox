package br.com.hoptech.nestedclasses;

public class OuterClass {
	
//	https://www.tutorialspoint.com/java/java_innerclasses.htm

	String name = "outer";
	
	public static void main(String[] args) {

		OuterClass outer = new OuterClass();
		System.out.println(outer.name);

		InnerClass inner = outer.new InnerClass();
		System.out.println(inner.name);
		
		AnonymousInner anonymous = new AnonymousInner() {
			public void printFoo() {
				System.out.println("Foo");
			}
		};
		anonymous.printFoo();
		
	}
	
	class InnerClass {
	
		String name = "inner";
		
	}
		
}

abstract class AnonymousInner {
	public abstract void printFoo();
}