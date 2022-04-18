package com.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.dao.ComputerDAO;

public interface IComputerRepository extends JpaRepository<ComputerDAO, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "update computer c set c.chip = :chip, c.vga = :vga, c.hard_disk = :hardDisk, "
			+ "c.ram = :ram where c.id = :Id", nativeQuery = true)
	public void Update(@Param("Id") long Id,@Param("chip") String chip,@Param("vga") String vga,
					   @Param("hardDisk") String hardDisk,@Param("ram") String ram);

}
