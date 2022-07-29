package com.nathan.spring_api.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "employees")

public class Employe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nom", nullable = false)
	private String nom;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "ville", nullable = false)
	private String ville;
	
	@Column(name = "telephone", nullable = false)
	private String telephone;
	
	
	public Employe() {
		
	}
	
	public Employe(String nom, String email, String ville, String telephone) {
		this.nom = nom;
		this.email = email;
		this.ville = ville;
		this.telephone = telephone;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	@Override
	public String toString() {
		return "Employe [id= " + id + "nom= " + nom + "email= " + email + "telephone= " + telephone + "ville= " + ville + " ]";	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
