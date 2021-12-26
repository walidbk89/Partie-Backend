package com.test.Mss.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "commande")
public class Commande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commande_id")
	private Long commandeId;
	
	@NotBlank(message = "numero is mandatory")
    @Column(name = "numero")
    private String numero;
	
	@NotBlank(message = "date is mandatory")
    @Column(name = "date")
    private Date date;
	
	@NotBlank(message = "prixTotal is mandatory")
    @Column(name = "prix_Total")
    private BigDecimal prixTotal;

	@NotBlank(message = "etat is mandatory")
    @Column(name = "etat")
    private Long etat;
	
	 @OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	 private List<LigneCommande> ligneCommandes = new ArrayList<>();
	 
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "client_id", nullable = false)
	 private Client client;

	 public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	public void setLigneCommandes(List<LigneCommande> ligneCommandes) {
		this.ligneCommandes = ligneCommandes;
	}

	public Commande() {}

	public Commande(String numero, Date date, BigDecimal prixTotal, Long etat) {
		this.numero = numero;
		this.date = date;
		this.prixTotal = prixTotal;
		this.etat = etat;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
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


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
}
