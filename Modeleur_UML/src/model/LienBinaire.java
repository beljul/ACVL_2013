package model;

public abstract class LienBinaire extends LienMultiple {

	public LienBinaire(Classe c1, Classe c2) {
		Multiplicite m1 = new Multiplicite(c1, this);
		Multiplicite m2 = new Multiplicite(c2, this);
		this.getMultiplicites().add(m1);
		this.getMultiplicites().add(m2);
		c1.getMultiplicites().add(m1);
		c2.getMultiplicites().add(m2);
	}

}
