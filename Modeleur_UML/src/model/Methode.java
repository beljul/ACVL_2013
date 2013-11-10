package model;

import java.util.Set;

public class Methode {
	private Set<Parametre> parametres;
	private String nom;
	private boolean isStatic;
	private boolean isAbstract;
	private Visibilite visibilite;
	private Type returnType;
	public static final Type VOID = new Type() {
		@Override
		public String getNom() {
			return "void";
		}
	};
	
	public Methode(Set<Parametre> parametres, String nom, boolean isStatic,
			boolean isAbstract, Visibilite visibilite, Type returnType) {
		super();
		this.parametres = parametres;
		this.nom = nom;
		this.isStatic = isStatic;
		this.isAbstract = isAbstract;
		this.visibilite = visibilite;
		this.returnType = returnType;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public Visibilite getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(Visibilite visibilite) {
		this.visibilite = visibilite;
	}

	public Type getReturnType() {
		return returnType;
	}

	public void setReturnType(Type returnType) {
		this.returnType = returnType;
	}

	public Set<Parametre> getParametres() {
		return parametres;
	}

	@Override
	public String toString() {
		String str = this.visibilite.getMotif();
		if (isAbstract)
			str += "(a)";
		if (isStatic)
			str += "(s)";
		str += this.nom + " (";
		for (Parametre p : parametres) {
			str += p.getIdentifieur().toString() + ", ";
		}
		if( str.endsWith(", "))
			str = (String) str.subSequence(0, str.length()-2);
		str += ")";
		str += " : " + this.returnType;
		return str;
	}
	
	
	
}
