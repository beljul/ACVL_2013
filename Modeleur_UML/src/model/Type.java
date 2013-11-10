package model;

public abstract class Type {
	public abstract String getNom();

	@Override
	public String toString() {
		return getNom();
	}
	
}
