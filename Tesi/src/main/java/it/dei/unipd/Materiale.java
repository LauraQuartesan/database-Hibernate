package it.dei.unipd;

import java.util.HashSet;
import java.util.Set;

public class Materiale {
	private int id;
	private Set<Tessuto> tessuti;
	private Set<Filato> filati;
	private Set<Articolo> articoli;

	public Materiale() {

	}

	public Materiale(int id) {
		setId(id);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTessuti(Set<Tessuto> tessuti) {
		this.tessuti = tessuti;
	}

	public void setFilati(Set<Filato> filati) {
		this.filati = filati;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	public void addTessuto(Tessuto tessuto) {
		if (tessuti == null) {
			tessuti = new HashSet<Tessuto>();
		}
		tessuti.add(tessuto);
	}

	public void addFilato(Filato filato) {
		if (filati == null) {
			filati = new HashSet<Filato>();
		}
		filati.add(filato);
	}

	public void addArticolo(Articolo articolo) {
		if (articoli == null) {
			articoli = new HashSet<Articolo>();
		}
		articoli.add(articolo);
	}

	public int getId() {
		return id;
	}

	public Set<Tessuto> getTessuti() {
		return tessuti;
	}

	public Set<Filato> getFilati() {
		return filati;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}
}
