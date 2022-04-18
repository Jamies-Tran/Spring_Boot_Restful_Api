package com.store.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity(name = "Computer")
public class ComputerDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column
	private String chip;
	
	@Column
	private String vga;
	
	@Column
	private String hardDisk;
	
	@Column
	private String ram;
	
	@ManyToMany(mappedBy = "computers", fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
	private List<CartDAO> carts = new ArrayList<>();

	public ComputerDAO() {
		super();
	}

	public ComputerDAO(long id, String chip, String vga, String hardDisk, String ram, List<CartDAO> carts) {
		super();
		Id = id;
		this.chip = chip;
		this.vga = vga;
		this.hardDisk = hardDisk;
		this.ram = ram;
		this.carts = carts;
	}

	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}

	public String getVga() {
		return vga;
	}

	public void setVga(String vga) {
		this.vga = vga;
	}

	public String getHardDisk() {
		return hardDisk;
	}

	public void setHardDisk(String hardDisk) {
		this.hardDisk = hardDisk;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public List<CartDAO> getCarts() {
		return carts;
	}

	public void setCarts(List<CartDAO> carts) {
		this.carts = carts;
	}

	public long getId() {
		return Id;
	}

}
