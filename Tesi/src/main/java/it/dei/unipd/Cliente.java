package it.dei.unipd;

import java.util.HashSet;
import java.util.Set;
import java.math.BigDecimal;

public class Cliente {
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	private BigDecimal partitaIva;
	private String email;
	private String nome;
	private String telefono;
	private String indirizzo;
	private Set<Ordine> ordini;
	private Set<Modello> modelli;
	private Set<Tessuto> tessuti;

	public Cliente() {

	}

	public Cliente(BigDecimal partitaIva, String email, String nome, String telefono, String indirizzo) {
		setPartitaIva(partitaIva);
		setEmail(email);
		setNome(nome);
		setTelefono(telefono);
		setIndirizzo(indirizzo);
	}

	public void setPartitaIva(BigDecimal partitaIva) {
		this.partitaIva = partitaIva;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
	}

	public void setModelli(Set<Modello> modelli) {
		this.modelli = modelli;
	}

	public void setTessuti(Set<Tessuto> tessuti) {
		this.tessuti = tessuti;
	}

	public void addOrdine(Ordine ordine) {
		if (ordini == null) {
			ordini = new HashSet<Ordine>();
		}
		ordini.add(ordine);
	}

	public void addModello(Modello modello) {
		if (modelli == null) {
			modelli = new HashSet<Modello>();
		}
		modelli.add(modello);
	}

	public void addTessuto(Tessuto tessuto) {
		if (tessuti == null) {
			tessuti = new HashSet<Tessuto>();
		}
		tessuti.add(tessuto);
	}

	public BigDecimal getPartitaIva() {
		return partitaIva;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public Set<Ordine> getOrdini() {
		if (ordini == null) {
			ordini = new HashSet<Ordine>();
		}
		return ordini;
	}

	public Set<Modello> getModelli() {
		if (modelli == null) {
			modelli = new HashSet<Modello>();
		}
		return modelli;
	}

	public Set<Tessuto> getTessuti() {
		if (tessuti == null) {
			tessuti = new HashSet<Tessuto>();
		}
		return tessuti;
	}
}
