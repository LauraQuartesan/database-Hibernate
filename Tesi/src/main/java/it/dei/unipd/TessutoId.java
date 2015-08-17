package it.dei.unipd;

import java.io.Serializable;

public class TessutoId implements Serializable {
	private static final long serialVersionUID = 4110109318997861803L;
	private int codice;
	private String varianteColore;

	public TessutoId() {

	}

	public TessutoId(int codice, String varianteColore) {
		setCodice(codice);
		setVarianteColore(varianteColore);
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public void setVarianteColore(String varianteColore) {
		this.varianteColore = varianteColore;
	}

	public int getCodice() {
		return codice;
	}

	public String getVarianteColore() {
		return varianteColore;
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
		TessutoId other = (TessutoId) object;
		if (!(codice == other.codice)) {
			return false;
		}
		if (!(varianteColore.equals(other.varianteColore))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = hash * 7 + codice;
		hash = hash * 7 + varianteColore.hashCode();
		return hash;
	}

}
