package model;

import view.LienAssociationSimpleView;
import controller.LienAssociationSimpleController;

public class AssociationSimple extends LienBinaire {
	private LienAssociationSimpleView view;
	
	public AssociationSimple(Classe c1, Classe c2) {
		super(c1, c2);
	}

	public LienAssociationSimpleView getView() {
		return view;
	}

	public void setView(LienAssociationSimpleView view) {
		this.view = view;
	}

	@Override
	public boolean isCompo() {
		return false;
	}

}
