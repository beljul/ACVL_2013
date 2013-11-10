package model;

public enum Visibilite {
		PRIVATE, PUBLIC, PROCTECTED, PACKAGE;
		
		public String getMotif() {
			if (this.equals(Visibilite.PRIVATE))
				return "-";
			else if (this.equals(Visibilite.PUBLIC))
				return "+";
			else if (this.equals(Visibilite.PROCTECTED))
				return "*";
			else
				return "~";
		}
}
