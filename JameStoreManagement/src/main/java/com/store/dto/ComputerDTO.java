package com.store.dto;

public class ComputerDTO {
	private long Id;
	private String chip;
	private String vga;
	private String hardDisk;
	private String ram;

	public ComputerDTO() {
		super();
	}

	public ComputerDTO(long Id, String chip, String vga, String hardDisk, String ram) {
		super();
		this.Id = Id;
		this.chip = chip;
		this.vga = vga;
		this.hardDisk = hardDisk;
		this.ram = ram;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

}
