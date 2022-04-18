package com.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.dao.AccountDAO;
import com.store.dao.RoleDAO;

public interface IAccountRepository extends JpaRepository<AccountDAO, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "update account a set a.username = :username, a.password = :password, a.birthday = :birthday, a.role_id = :role "
			+ "where a.id = :id", nativeQuery = true)
	public void Update(@Param("id") long Id,@Param("username") String username,
					   @Param("password") String password,@Param("birthday") String birthday,
					   @Param("role") long role);
	
	@Transactional
	@Modifying
	@Query(value = "insert into cart values(0 ,:accountId)", nativeQuery = true)
	public void CreateCart(@Param("accountId") long accountId);
	
}
