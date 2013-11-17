package controller;

import model.Agregation;
import model.AssociationSimple;
import view.LienAgregationView;
import view.LienAssociationSimpleView;

public class LienAgregationController {
	private Agregation modele;
	private LienAgregationView vue;
	
	public LienAgregationController(LienAgregationView lienAgregationView,
			Agregation a) {
		super();
		this.modele = a;
		this.vue = lienAgregationView;
	}
	
	public void updateView() {
		vue.repaint();
	}
	
}
