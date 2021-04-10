package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Snipe - iwertz
 * CIS175 - Spring 2021
 * Apr 9, 2021
 */

@Entity
@Table(name="Machines")
public class Machine {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MachineID")
	public int MachineID;
	@Column(name="Details")
	public String Details;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="Items",
	 joinColumns={ @JoinColumn(name="MachineID", 
	referencedColumnName="MachineID") },
	 inverseJoinColumns={ @JoinColumn(name="ItemID", 
	referencedColumnName="MachineID", unique=true) }
	 )
	private List<Item> ListOfItems;
	
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="Items",
	 joinColumns={ @JoinColumn(name="MachineID", 
	referencedColumnName="MachineID") },
	 inverseJoinColumns={ @JoinColumn(name="UserID", 
	referencedColumnName="MachineID", unique=true) }
	 )
	private List<User> ListOfUsers;
}
