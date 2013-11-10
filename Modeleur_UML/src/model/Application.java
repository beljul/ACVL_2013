package model;

import java.util.HashSet;
import java.util.Set;

import view.DiagrammeClassesView;
import view.ApplicationView;

public class Application {
	private Set<DiagrammeClasses> diagsClasses;
	private static ApplicationView view;

	public Application() {
		super();
		this.diagsClasses = new HashSet<DiagrammeClasses>();
	}

	public Set<DiagrammeClasses> getDiagsClasses() {
		return diagsClasses;
	}

	public void addDiagsClasses(DiagrammeClasses diagrammeClasses) {
		this.diagsClasses.add(diagrammeClasses);
	}
	
	public static void main(String args[])
    {
        Application modele = new Application();
        DiagrammeClasses dc = new DiagrammeClasses(new Environnement());
        modele.addDiagsClasses(dc);
        dc.setView(new DiagrammeClassesView(dc));
//		view = new ApplicationView(modele);
        // Gérer plusieurs diagrammes de classes ?
    }
	
}
