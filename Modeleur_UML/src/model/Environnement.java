package model;

import java.util.HashSet;
import java.util.Set;

public class Environnement {
	private Set<Type> typesEnv;

	public Environnement() {
		super();
		typesEnv = new HashSet<Type>();
		typesEnv.add(Int.getInstance());
		typesEnv.add(Bool.getInstance());
		typesEnv.add(Char.getInstance());
		typesEnv.add(Double.getInstance());
		typesEnv.add(Long.getInstance());
		typesEnv.add(Float.getInstance());
		typesEnv.add(MyString.getInstance());
	}
	
	public Set<Type> getTypesEnv() {
		return typesEnv;
	}

	public void addTypesEnv(Type type) {
		this.typesEnv.add(type);
	}
	

}
