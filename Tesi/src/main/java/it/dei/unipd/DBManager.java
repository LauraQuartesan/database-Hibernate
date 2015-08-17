package it.dei.unipd;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DBManager {
	private static SessionFactory factory;

	public static void main(String[] args) {
		Configuration config = new Configuration().configure();

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();

		factory = config.buildSessionFactory(serviceRegistry);

		// DBManager dbManager = new DBManager();

		Cliente dior = new Cliente(new BigDecimal("452361897528965"), "dior@gmail.com", "Dior", "0444589623",
				"via Roma 2, 36040 Grisignano di Zocco (VI)");

		// Creo una data sql
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2014);
		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
		cal.set(Calendar.DATE, 25);
		Date sqlDate = new java.sql.Date(cal.getTime().getTime());

		Ordine ordine1 = new Ordine("201401", new BigDecimal(10400), sqlDate);
		ordine1.setCliente(dior);
		
		dior.addOrdine(ordine1);

		Materiale materiale1 = new Materiale(1);

		Modello modello1 = new Modello(150);
		modello1.setCliente(dior);
		
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
		
		modello1.addArticolo(articolo1);
		materiale1.addArticolo(articolo1);
		ordine1.addArticolo(articolo1);
		
		// Creo una data sql
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
		session.beginTransaction();
		session.save(dior);
		session.save(ordine1);
		session.save(modello1);
		session.save(materiale1);
		session.save(tessuto1);
		session.save(filato1);
		session.save(articolo1);
		session.save(consegna1);
		session.getTransaction().commit();
		//session.close();
	}
}
