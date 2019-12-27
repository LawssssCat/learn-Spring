package book.chapter3.autowire;

public class Target {
	
	private Foo fooOne ; 
	private Foo fooTwo ; 
	private Bar barOne ; 
	
	public Target(Foo fooOne , Bar barOne) {
		System.out.println("construct.. fooOne barOne");
	}
	public Target(Foo fooOne) {
		System.out.println("construct.. fooOne");
	}
	public Target() {
		System.out.println("construct..");
	}
	public void setFooOne(Foo fooOne) {
		System.out.println("set... fooOne");
	}
	public void setFooTwo(Foo fooTwo) {
		System.out.println("set... fooTwo");
	}
	public void setBarOne(Bar barOne) {
		System.out.println("set... barOne");
	}
}
