package com.ensim.MaaApp.Model;

public class Garantie {
	private int id;
	private String nom;
	private int montant;
	private String description;
	
	public Garantie(String nom, int montant, String description) {
		this.nom = nom;
		this.montant = montant;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
