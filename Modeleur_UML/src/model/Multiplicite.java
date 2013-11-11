package model;

public class Multiplicite {
	private Classe classe;
	private LienMultiple lien;
	private char borneInf;
	private char borneSup;
	private String role;
	
	public Multiplicite(Classe classe, LienMultiple lien) {
		super();
		this.classe = classe;
		this.lien = lien;
		this.borneInf = '0';
		this.borneSup = '*';
		this.role = "monRole";
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public LienMultiple getLien() {
		return lien;
	}

	public void setLien(LienMultiple lien) {
		this.lien = lien;
	}

	public char getBorneInf() {
		return borneInf;
	}

	public void setBorneInf(char borneInf) {
		this.borneInf = borneInf;
	}

	public char getBorneSup() {
		return borneSup;
	}

	public void setBorneSup(char borneSup) {
		this.borneSup = borneSup;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return this.borneInf + ".." + this.borneSup + "/" + this.role;
	}
	
	
}
