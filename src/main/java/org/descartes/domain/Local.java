package org.descartes.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="local")
public class Local {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	int id;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="address")
	String address;
	
	@Column(name="ville")
	String ville;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	Collection<Espace> espaces;
	
	@Column(name="photo")
	String photo;

	public Local() {}
	
	public Local(String nom, String address, String ville, String photo) {
		super();
		this.nom = nom;
		this.address = address;
		this.ville = ville;
		this.photo = photo;
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getVille() {
		return ville;
	}
	
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public void setEspaces(Collection<Espace> espaces) {
		this.espaces = espaces;
	}
}
