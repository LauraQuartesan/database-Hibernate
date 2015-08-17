package it.dei.unipd;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Ordine {
	private String numeroFattura;
	private BigDecimal prezzo;
	private Date dataOrdine;
	private Date dataCompletamento;
	private Cliente cliente;
	private Set<Articolo> articoli;

	public Ordine() {

	}

	public Ordine(String numeroFattura, BigDecimal prezzo, Date dataOrdine) {
		setNumeroFattura(numeroFattura);
		setPrezzo(prezzo);
		setDataOrdine(dataOrdine);
	}

	public void setNumeroFattura(String numeroFattura) {
		this.numeroFattura = numeroFattura;
	}

	public void setPrezzo(BigDecimal prezzo) {
		if (prezzo.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException();
		}
		this.prezzo = prezzo;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}

	public void setDataCompletamento(Date dataCompletamento) {
		this.dataCompletamento = dataCompletamento;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void addArticolo(Articolo articolo) {
		if (articoli == null) {
			articoli = new HashSet<Articolo>();
		}
		articoli.add(articolo);
	}

	public String getNumeroFattura() {
		return numeroFattura;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public Date getDataCompletamento() {
		return dataCompletamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	public BigDecimal getPartitaIva() {
		return cliente.getPartitaIva();
	}

	public void setPartitaIva(BigDecimal partitaIva) {
		cliente.setPartitaIva(partitaIva);
	}
}
