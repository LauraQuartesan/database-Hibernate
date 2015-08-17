package it.dei.unipd;

import java.util.HashSet;
import java.util.Set;

public class Articolo {
	private int codice;
	private Ordine ordine;
	private String tipo;
	private Materiale materiale;
	private Modello modello;
	private int quantit�;
	private String lavorazione;
	private Set<Consegna> consegne;

	public Articolo() {

	}

	public Articolo(int codice, String tipo, int quantit�, String lavorazione) {
		setCodice(codice);
		setTipo(tipo);
		setQuantit�(quantit�);
		setLavorazione(lavorazione);
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setMateriale(Materiale materiale) {
		// modelloMateriale.setMateriale(materiale);
		this.materiale = materiale;
	}

	public void setQuantit�(int quantit�) {
		if (quantit� < 0) {
			throw new IllegalArgumentException();
		}
		this.quantit� = quantit�;
	}

	public void setLavorazione(String lavorazione) {
		this.lavorazione = lavorazione;
	}

	public void setModello(Modello modello) {
		this.modello = modello;
	}

	public void addConsegna(Consegna consegna) {
		if (consegne == null) {
			consegne = new HashSet<Consegna>();
		}
		consegne.add(consegna);
	}

	public int getCodice() {
		return this.codice;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public String getTipo() {
		return tipo;
	}

	public Materiale getMateriale() {
		return materiale;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public String getLavorazione() {
		return lavorazione;
	}

	public Modello getModello() {
		return modello;
	}

	public void setConsegne(Set<Consegna> consegne) {
		this.consegne = consegne;
	}

	public Set<Consegna> getConsegne() {
		return consegne;
	}
}