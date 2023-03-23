package ch07.verify.test09;

//07-09-01
public class A {
	
}
class B extends A {}
class C extends A {}
class D extends B {
	int max = 100;
}
class E extends B {}
class F extends C {}