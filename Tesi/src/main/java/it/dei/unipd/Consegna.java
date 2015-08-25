package it.dei.unipd;

public class Consegna {
	private ConsegnaId idConsegna;
	private int quantit‡Consegnata;
	private String corriere;
	private boolean completata;

	public Consegna() {

	}

	public Consegna(ConsegnaId idConsegna, int quantit‡Consegnata, String corriere, boolean completata) {
		setIdConsegna(idConsegna);
		setQuantit‡Consegnata(quantit‡Consegnata);
		setCorriere(corriere);
		setCompletata(completata);
	}

	public void setQuantit‡Consegnata(int quantit‡Consegnata) {
		this.quantit‡Consegnata = quantit‡Consegnata;
	}

	public void setCorriere(String corriere) {
		this.corriere = corriere;
	}

	public void setCompletata(boolean completata) {
		this.completata = completata;
	}

	public int getQuantit‡Consegnata() {
		return quantit‡Consegnata;
	}

	public String getCorriere() {
		return corriere;
	}

	public boolean getCompletata() {
		return completata;
	}

	public ConsegnaId getIdConsegna() {
		return idConsegna;
	}

	public void setIdConsegna(ConsegnaId idConsegna) {
		this.idConsegna = idConsegna;
	}

}
