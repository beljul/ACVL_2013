package model;

import java.awt.Point;

public class Multiplicite {
	private Classe classe;
	private LienMultiple lien;
	private String borneInf;
	private String borneSup;
	private String role;
	private Point pMult;
	private LinkPosOnClass posLink;
	
	public Multiplicite(Classe classe, LienMultiple lien) {
		super();
		this.classe = classe;
		this.lien = lien;
		this.borneInf = "0";
		this.borneSup = "*";
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

	public LinkPosOnClass getPosLink() {
		return posLink;
	}

	public void setPosLink(LinkPosOnClass posLink) {
		this.posLink = posLink;
	}
	

	public Point getpMult() {
		return pMult;
	}

	public void setpMult(Point pMult) {
		this.pMult = pMult;
	}
	
	public String getBorneInf() {
		return borneInf;
	}

	public void setBorneInf(String string) {
		this.borneInf = string;
	}

	public String getBorneSup() {
		return borneSup;
	}

	public void setBorneSup(String borneSup) {
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
