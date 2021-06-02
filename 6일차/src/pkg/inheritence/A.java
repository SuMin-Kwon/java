package pkg.inheritence;

public class A {
int sa;
}

class B extends A {}
class C extends A {}

interface X {}
interface Y {}
interface Z extends X {}

class D extends B implements Z,Y {
	int sb;
}   // A와 D는 형변환 가능함

class E extends C {}   // A와 E도 형변환 가능함