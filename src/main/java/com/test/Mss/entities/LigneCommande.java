package com.test.Mss.entities;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ligneCommande")
public class LigneCommande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ligneCommande_id")
	private Long ligneCmdId;
	
	@NotBlank(message = "qte is mandatory")
    @Column(name = "qte")
    private Long qte;
	
	@NotBlank(message = "prixUnitaire is mandatory")
    @Column(name = "prix_Unitaire")
    private BigDecimal prixUnitaire;
	
	@NotBlank(message = "prixTotal is mandatory")
    @Column(name = "prix_Total")
    private BigDecimal prixTotal;

	@NotBlank(message = "etat is mandatory")
    @Column(name = "etat")
    private Long etat;
	
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "commande_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private Commande commande;
	 
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "produit_id", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 private Produit produit;

	 
	public Long getQte() {
		return qte;
	}

	public void setQte(Long qte) {
		this.qte = qte;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public BigDecimal getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(BigDecimal prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Long getEtat() {
		return etat;
	}

	public void setEtat(Long etat) {
		this.etat = etat;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	 
}
