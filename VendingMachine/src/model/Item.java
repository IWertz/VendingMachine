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
@Table(name="Items")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ItemID")
	public int ItemID;
	@Column(name="Quantity")
	public int Quantity;
	@Column(name="Price")
	public double Price;
	
	@ManyToOne
	@JoinColumn(name="MachineID")
	public Machine machine;
}
