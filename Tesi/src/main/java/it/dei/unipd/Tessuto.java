package it.dei.unipd;

import java.util.HashSet;
import java.util.Set;

public class Tessuto {
	private TessutoId idTessuto;
	private Set<Materiale> materiali;
	private Set<Cliente> clienti;

	public Tessuto() {

	}

	public Tessuto(TessutoId idTessuto) {
		setIdTessuto(idTessuto);
	}

	public void addMateriale(Materiale materiale) {
		if (materiali == null) {
			materiali = new HashSet<Materiale>();
		}
		materiali.add(materiale);
	}

	public void addCliente(Cliente cliente) {
		if (clienti == null) {
			clienti = new HashSet<Cliente>();
		}
		clienti.add(cliente);
	}

	public Set<Materiale> getMateriali() {
		return materiali;
	}

	public Set<Cliente> getClienti() {
		return clienti;
	}

	public TessutoId getIdTessuto() {
		return idTessuto;
	}

	public void setIdTessuto(TessutoId idTessuto) {
		this.idTessuto = idTessuto;
	}

	public void setMateriali(Set<Materiale> materiali) {
		this.materiali = materiali;
	}

	public void setClienti(Set<Cliente> clienti) {
		this.clienti = clienti;
	}
}
