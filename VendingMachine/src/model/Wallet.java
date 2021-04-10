package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Apr 9, 2021
 */

@Entity
@Table(name="Wallet")
public class Wallet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WalletID")
	public int WalletID;
	@Column(name="Balance")
	public double Balance;
	
	@ManyToOne
	@JoinColumn(name="UserID")
	public User user;
	public Wallet() {
		super();
		// Added by Levi to test GitHub
	}
}
