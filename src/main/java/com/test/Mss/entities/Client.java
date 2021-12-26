package com.test.Mss.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "client_id")
	private Long clientId;

	@NotBlank(message = "code is mandatory")
    @Column(name = "code")
    private String code;
	
	@NotBlank(message = "nom is mandatory")
    @Column(name = "nom")
    private String nom;
	
	@NotBlank(message = "prenom is mandatory")
    @Column(name = "prenom")
    private String prenom;
	
	@NotBlank(message = "dateNaissance is mandatory")
    @Column(name = "date_Naissance")
    private Date dateNaissance;
	
	@NotBlank(message = "adresse is mandatory")
    @Column(name = "adresse")
    private String adresse;
	
	@NotBlank(message = "ville is mandatory")
    @Column(name = "ville")
    private String ville;
	
	@NotBlank(message = "codePostal is mandatory")
    @Column(name = "code_Postal")
    private Long codePostal;
	
	@Column(name = "tel")
	private String tel;
	  
	@Column(name = "fax")
	private String fax;
	
	@NotBlank(message = "gsm is mandatory")
    @Column(name = "gsm")
    private String gsm;
	
	@NotBlank(message = "email is mandatory")
    @Column(name = "email")
    private String email;


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Long getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(Long codePostal) {
		this.codePostal = codePostal;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getGsm() {
		return gsm;
	}

	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	 @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	 private List<Commande> commandes = new ArrayList<>();

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	 
	 
	
}
