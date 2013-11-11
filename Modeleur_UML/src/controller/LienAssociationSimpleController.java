package controller;

import view.ClassifieurView;
import view.LienAssociationSimpleView;
import model.AssociationSimple;
import model.Classifieur;

public class LienAssociationSimpleController {
	private AssociationSimple modele;
	private LienAssociationSimpleView vue;
	
	public LienAssociationSimpleController(LienAssociationSimpleView lienAssociationSimpleView,
			AssociationSimple l) {
		super();
		this.modele = l;
		this.vue = lienAssociationSimpleView;
	}
	
	public void updateView() {
		vue.repaint();
	}
	
	

}
