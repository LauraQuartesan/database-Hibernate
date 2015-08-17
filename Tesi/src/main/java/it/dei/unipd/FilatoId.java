package it.dei.unipd;

import java.io.Serializable;

public class FilatoId implements Serializable {
	private static final long serialVersionUID = 6808725283883470819L;
	private int titolo;
	private int codiceColore;
	private String fornitore;

	public FilatoId() {

	}

	public FilatoId(int titolo, int codiceColore, String fornitore) {
		setTitolo(titolo);
		setCodiceColore(codiceColore);
		setFornitore(fornitore);
	}

	public void setTitolo(int titolo) {
		this.titolo = titolo;
	}

	public void setCodiceColore(int codiceColore) {
		this.codiceColore = codiceColore;
	}

	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}

	public int getTitolo() {
		return titolo;
	}

	public int getCodiceColore() {
		return codiceColore;
	}

	public String getFornitore() {
		return fornitore;
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
		FilatoId other = (FilatoId) object;
		if (!(titolo == other.titolo)) {
			return false;
		}
		if (!(codiceColore == other.codiceColore)) {
			return false;
		}
		if (!(fornitore.equals(other.codiceColore))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 7 + titolo;
		hash = hash * 7 + codiceColore;
		hash = hash * 7 + fornitore.hashCode();
		return hash;
	}
}
