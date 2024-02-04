package it.cefi.app.models;
// classe utile per visualizzare la domanda e le risposte passati a javascript come dati json
public class Dati {

	private String domanda;
	private String r1;
	private String r2;
	private String r3;
	private String r4;
	
	private Boolean i1;
	private Boolean i2;
	private Boolean i3;
	private Boolean i4;
	
	
	
	public Dati() {
	}
	
	
	public Boolean getI1() {
		return i1;
	}


	public void setI1(Boolean i1) {
		this.i1 = i1;
	}


	public Boolean getI2() {
		return i2;
	}


	public void setI2(Boolean i2) {
		this.i2 = i2;
	}


	public Boolean getI3() {
		return i3;
	}


	public void setI3(Boolean i3) {
		this.i3 = i3;
	}


	public Boolean getI4() {
		return i4;
	}


	public void setI4(Boolean i4) {
		this.i4 = i4;
	}




	public Dati(String domanda, String r1, String r2, String r3, String r4, Boolean i1, Boolean i2, Boolean i3,
			Boolean i4) {
		super();
		this.domanda = domanda;
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r4 = r4;
		this.i1 = i1;
		this.i2 = i2;
		this.i3 = i3;
		this.i4 = i4;
	}


	public String getDomanda() {
		return domanda;
	}
	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}
	public String getR1() {
		return r1;
	}
	public void setR1(String r1) {
		this.r1 = r1;
	}
	public String getR2() {
		return r2;
	}
	public void setR2(String r2) {
		this.r2 = r2;
	}
	public String getR3() {
		return r3;
	}
	public void setR3(String r3) {
		this.r3 = r3;
	}
	public String getR4() {
		return r4;
	}
	public void setR4(String r4) {
		this.r4 = r4;
	}
	
	
}
