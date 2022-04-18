package com.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.dao.RoleDAO;

public interface IRoleRepository extends JpaRepository<RoleDAO, Long>{
	@Transactional
	@Modifying
	@Query(value="update role r set r.name = :name where r.id = :id", nativeQuery = true)
	public void Update(@Param("id") long Id,@Param("name") String name);

}
