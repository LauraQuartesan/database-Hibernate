package it.dei.unipd;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.service.ServiceRegistry;

public class DBManager {

	private static SessionFactory factory;

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		factory = config.buildSessionFactory(serviceRegistry);

		Cliente dior = new Cliente(new BigDecimal("452361897528965"), "dior@gmail.com", "Dior", "0444589623",
				"via Roma 2, 36040 Grisignano di Zocco (VI)");

		// Crea una data sql
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal.set(Calendar.DATE, 25);
		Date sqlDate = new java.sql.Date(cal.getTime().getTime());

		Ordine ordine1 = new Ordine("201401", new BigDecimal(10400), sqlDate);
		ordine1.setCliente(dior);

		dior.addOrdine(ordine1);

		Materiale materiale1 = new Materiale(1);
		Materiale materiale2 = new Materiale(2);

		Modello modello1 = new Modello(150);
		modello1.setCliente(dior);

		Modello modello2 = new Modello(300);
		modello2.setCliente(dior);

		dior.addModello(modello1);

		TessutoId idTessuto = new TessutoId(400, "blu");
		Tessuto tessuto1 = new Tessuto(idTessuto);
		tessuto1.addCliente(dior);
		tessuto1.addMateriale(materiale1);

		dior.addTessuto(tessuto1);

		FilatoId filatoId = new FilatoId(30, 517, "Coats Cucirini");
		Filato filato1 = new Filato(filatoId, new BigDecimal(44.00));
		filato1.addMateriale(materiale1);

		materiale1.addFilato(filato1);
		materiale1.addTessuto(tessuto1);

		Articolo articolo1 = new Articolo(589, "giacca", 30, null);
		articolo1.setOrdine(ordine1);
		articolo1.setMateriale(materiale1);
		articolo1.setModello(modello1);

		Articolo articolo2 = new Articolo(470, "cappotto", 50, "punto MF");
		articolo2.setOrdine(ordine1);
		articolo2.setMateriale(materiale2);
		articolo2.setModello(modello2);

		modello1.addArticolo(articolo1);
		materiale1.addArticolo(articolo1);
		ordine1.addArticolo(articolo1);

		modello2.addArticolo(articolo2);
		materiale2.addArticolo(articolo2);
		ordine1.addArticolo(articolo2);

		// Crea una data sql
		cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		cal.set(Calendar.DATE, 22);
		Date sqlDate1 = new java.sql.Date(cal.getTime().getTime());
		ConsegnaId idConsegna = new ConsegnaId(sqlDate1, articolo1);
		Consegna consegna1 = new Consegna(idConsegna, 30, "Bartolini", true);

		ordine1.setDataCompletamento(sqlDate1);
		articolo1.addConsegna(consegna1);

		
		  Session session = factory.getCurrentSession();
		  session.beginTransaction(); session.save(dior);
		  session.save(ordine1); session.save(modello1);
		  session.save(materiale1); session.save(tessuto1);
		  session.save(filato1); session.save(articolo1);
		  session.save(consegna1); session.save(materiale2);
		  session.save(modello2); session.save(articolo2);
		  session.getTransaction().commit();
		 

		articoliDaOrdine("201401");
	}

	public static void articoliDaOrdine(String numeroFatturaOrdine) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Query query = session.createQuery(
				"select a.codice, a.tipo, a.materiale.id, a.quantità, a.lavorazione from Articolo as a where ordine=:fatturaOrdine order by a.codice");
		query.setString("fatturaOrdine", numeroFatturaOrdine);
		@SuppressWarnings("rawtypes")
		Iterator queryIterator = query.list().iterator();
		while (queryIterator.hasNext()) {
			Object[] articolo = (Object[]) queryIterator.next();
			System.out.print("codice: " + articolo[0] + "\t");
			System.out.print("tipo: " + articolo[1] + "\t");
			System.out.print("materiale: " + articolo[2] + "\t");
			System.out.print("quantità: " + articolo[3] + "\t");
			if (articolo[4] == null) {
				System.out.println("lavorazione: nessuna");
			} else {
				System.out.println("lavorazione: " + articolo[4]);
			}
		}
	}
}
