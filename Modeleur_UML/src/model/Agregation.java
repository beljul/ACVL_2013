package model;

import view.LienAgregationView;
import view.LienAssociationSimpleView;

public class Agregation extends LienBinaire {

	private LienAgregationView view;
	public Agregation(Classe c1, Classe c2) {
		super(c1, c2);
	}

	public LienAgregationView getView() {
		return view;
	}

	public void setView(LienAgregationView view) {
		this.view = view;
	}

	@Override
	public boolean isCompo() {
		return true;
	}
	
}
