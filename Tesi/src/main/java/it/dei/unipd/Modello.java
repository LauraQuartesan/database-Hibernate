package it.dei.unipd;

import java.util.HashSet;
import java.util.Set;

public class Modello {
	private int numero;
	private Cliente cliente;
	private Set<Articolo> articoli;

	public Modello() {

	}

	public Modello(int numero) {
		setNumero(numero);
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	
	public void addArticolo(Articolo articolo) {
		if (articoli == null) {
			articoli = new HashSet<Articolo>();
		}
		articoli.add(articolo);
	}

	public int getNumero() {
		return numero;
	}

	public Cliente getCliente(){
		return cliente;
	}
	
	public Set<Articolo> getArticoli() {
		return articoli;
	}
}
