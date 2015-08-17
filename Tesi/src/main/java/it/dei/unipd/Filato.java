package it.dei.unipd;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Filato {
	private FilatoId idFilato;
	private BigDecimal costo;
	private Set<Materiale> materiali;

	public Filato() {

	}

	public Filato(FilatoId idFilato, BigDecimal costo) {
		setIdFilato(idFilato);
		setCosto(costo);
	}

	public void setIdFilato(FilatoId idFilato) {
		this.idFilato = idFilato;
	}

	public void setCosto(BigDecimal costo) {
		if (costo.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException();
		}
		this.costo = costo;
	}

	public void setMateriali(Set<Materiale> materiali) {
		this.materiali = materiali;
	}

	public void addMateriale(Materiale materiale) {
		if (materiali == null) {
			materiali = new HashSet<Materiale>();
		}
		materiali.add(materiale);
	}

	public FilatoId getIdFilato() {
		return idFilato;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public Set<Materiale> getMateriali() {
		return materiali;
	}
}
