package model;

public class Composition extends LienBinaire {

	public Composition(Classe c1, Classe c2) {
		super(c1, c2);
	}

	@Override
	public boolean isCompo() {
		return true;
	}

}
