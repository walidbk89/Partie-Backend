package com.test.Mss.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "produit")
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getPrix() {
		return prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Long getQte() {
		return qte;
	}

	public void setQte(Long qte) {
		this.qte = qte;
	}


	@NotBlank(message = "code is mandatory")
    @Column(name = "code")
    private String code;
	
	@NotBlank(message = "marque is mandatory")
    @Column(name = "marque")
    private String marque;
	
	@NotBlank(message = "modele is mandatory")
    @Column(name = "modele")
    private String modele;
	
    @Column(name = "prix")
    private BigDecimal prix;
	
    @Column(name = "qte")
    private Long qte;
	
	public Produit() {}
	
	public Produit(String code, String marque, String modele, String caracteristiques, BigDecimal prix, Long qte) {
		this.code = code;
		this.marque = marque;
		this.modele = modele;
		this.prix = prix;
		this.qte = qte;
	}

	
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "categ_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private Categorie categorie;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	
	
}
