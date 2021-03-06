package it.dei.unipd;

public class Consegna {
	private ConsegnaId idConsegna;
	private int quantitąConsegnata;
	private String corriere;
	private boolean completata;

	public Consegna() {

	}

	public Consegna(ConsegnaId idConsegna, int quantitąConsegnata, String corriere, boolean completata) {
		setIdConsegna(idConsegna);
		setQuantitąConsegnata(quantitąConsegnata);
		setCorriere(corriere);
		setCompletata(completata);
	}

	public void setQuantitąConsegnata(int quantitąConsegnata) {
		this.quantitąConsegnata = quantitąConsegnata;
	}

	public void setCorriere(String corriere) {
		this.corriere = corriere;
	}

	public void setCompletata(boolean completata) {
		this.completata = completata;
	}

	public int getQuantitąConsegnata() {
		return quantitąConsegnata;
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
