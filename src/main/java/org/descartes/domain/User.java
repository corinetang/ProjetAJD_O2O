package org.descartes.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.descartes.domain.Local;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	
	@Column(name="nom")
	String nom;
	
	@Column(name="prenom")
	String prenom;
	
	@Column(name="email")
	String email;
	
	@Column(name="password")
	String password;
	
	@Column(name="telephone")
	String telephone;
	
	@OneToMany( cascade = CascadeType.ALL)
	Collection<Local> espaceALouer;
	
	@OneToMany(cascade = CascadeType.ALL)
	Collection<Location> espaceLoue;

	public User() {}
	
	public User(String nom, String prenom, String email, String password, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
	}

	public User(String nom) {
		this.nom = nom;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}	

	public void setEspaceALouer(Collection<Local> espaceALouer) {
		this.espaceALouer = espaceALouer;
	}

	public Collection<Local> getEspaceALouer() {
		return espaceALouer;
	}
	
	public void setEspaceLoue(Collection<Location> espaceLoue) {
		this.espaceLoue = espaceLoue;
	}

	public Collection<Location> getEspaceLoue() {
		return this.espaceLoue;
	}
}
