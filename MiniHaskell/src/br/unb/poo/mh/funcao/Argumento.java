package br.unb.poo.mh.funcao;

import br.unb.poo.mh.Tipo;

public class Argumento {
	private String id;
	private Tipo tipo;
	
	public Argumento(String id, Tipo tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	
	public String getId() {
		return id;
	}
	
	public Tipo getTipo() {
		return tipo;
	} 
}
