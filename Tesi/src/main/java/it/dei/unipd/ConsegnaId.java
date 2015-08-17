package it.dei.unipd;

import java.io.Serializable;
import java.sql.Date;

public class ConsegnaId implements Serializable {
	private static final long serialVersionUID = -1716041327892245929L;
	private Date dataConsegna;
	private Articolo articolo;

	public ConsegnaId() {

	}

	public ConsegnaId(Date dataConsegna, Articolo articolo) {
		setDataConsegna(dataConsegna);
		setArticolo(articolo);
	}

	public void setDataConsegna(Date dataConsegna) {
		this.dataConsegna = dataConsegna;
	}

	public void setArticolo(Articolo articolo) {
		this.articolo = articolo;
	}

	public Date getDataConsegna() {
		return dataConsegna;
	}

	public Articolo getArticolo() {
		return articolo;
	}

	public int getCodice() {
		return articolo.getCodice();
	}

	public void setCodice(int codice) {
		articolo.setCodice(codice);
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (object == null) {
			return false;
		}
		if (getClass() != object.getClass()) {
			return false;
		}
		ConsegnaId other = (ConsegnaId) object;
		if (!(dataConsegna.equals(other.dataConsegna))) {
			return false;
		}
		if (!(articolo.equals(other.articolo))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 7 + dataConsegna.hashCode();
		hash = hash * 7 + articolo.getCodice();
		return hash;
	}

}
