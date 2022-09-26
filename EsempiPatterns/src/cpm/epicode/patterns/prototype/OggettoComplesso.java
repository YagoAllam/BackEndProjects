package cpm.epicode.patterns.prototype;

public class OggettoComplesso {
	private String a;
	private String b;
	private String c;
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public OggettoComplesso(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public OggettoComplesso() {
		super();
	}
	
	public void stampaOggetto() {
		System.out.println( " a = " + a + " b = " + b );
	}

}
