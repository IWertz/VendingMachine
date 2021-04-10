package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Apr 9, 2021
 */
@Entity
@Table(name="Users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserID")
	public int UserID;
	@Column(name="FirstName")
	public String FirstName;
	@Column(name="LastName")
	public String LastName;
	@Column(name="Price")
	public double Price;
	
	@ManyToOne
	@JoinColumn(name="MachineID")
	public Machine machine;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="Wallet",
	 joinColumns={ @JoinColumn(name="MachineID", 
	referencedColumnName="MachineID") },
	 inverseJoinColumns={ @JoinColumn(name="WalletID", 
	referencedColumnName="MachineID", unique=true) }
	 )
	private List<Wallet> ListOfWallets;
}
