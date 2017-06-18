package org.descartes.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.descartes.domain.Location;
import org.descartes.domain.TypeEspace;

@Entity
@Table(name="espace")
public class Espace {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
	int id;
	
	@NotNull
	@Column(name="superficie")
	int superficie;

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	TypeEspace type;

	@Column(name="prix")
	int prix;

	@Column(name="photo")
	String photo;
	
	@Column(name="titre")
	String titre;
	
	@Column(name="description")
	String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	Collection<Location> locations;
	
	@ManyToOne
	Local local;
	
	public Espace() {}
	
	public Espace(int superficie, TypeEspace type, String photo) {
		super();
		this.superficie = superficie;
		this.type = type;
		this.photo = photo;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public TypeEspace getType() {
		return type;
	}
	
	public void setType(TypeEspace type) {
		this.type = type;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}
	
	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local) {
		this.local = local;
	}
}

