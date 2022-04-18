package com.store.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.store.dao.CartDAO;

public interface ICartRepository extends JpaRepository<CartDAO, Long> {
	
	@Transactional
	@Modifying
	@Query(value = "insert into cart_computer value(:cartId, :compId)", nativeQuery = true)
	public void addToCart(@Param("cartId") long cartId,@Param("compId") long compId);
	
	@Transactional
	@Modifying
	@Query(value= "delete from cart_computer cc where cc.cart_id = :cartId and cc.comp_id = :compId", nativeQuery = true)
	public void removeFromCart(@Param("cartId") long cartId,@Param("compId") long compId);

}
