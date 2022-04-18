package com.store.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dao.CartDAO;
import com.store.dao.ComputerDAO;
import com.store.dto.CartComputerDTO;
import com.store.dto.CartDTO;
import com.store.dto.ComputerDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.interfaces.converter.IDtoConverter;
import com.store.service.ICartService;

@RestController
public class CartApi {
	
	@Autowired
	private ICartService _cartService;
	
	@Autowired
	@Qualifier("cart")
	private IDaoConverter<CartDTO, CartDAO> _daoConverter;
	
	@Autowired
	@Qualifier("cart")
	private IDtoConverter<CartDAO, CartDTO> _dtoConverter;
	
	@Autowired
	@Qualifier("computer")
	private IDtoConverter<ComputerDAO, ComputerDTO> _compdtoConverter;
	
	@PostMapping("/cart")
	public ResponseEntity<String> addToCart(@RequestBody CartComputerDTO clientInput) {
		_cartService.addToCart(clientInput.getCartId(), clientInput.getComputerId());
		ResponseEntity<String> response = new ResponseEntity<String>("Success^-^", HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/cart")
	public ResponseEntity<String> removeFromCart(@RequestBody CartComputerDTO clientInput) {
		_cartService.removeFromCart(clientInput.getCartId(), clientInput.getComputerId());
		ResponseEntity<String> response = new ResponseEntity<String>("Removed T.T", HttpStatus.GONE);
		return response;
	}
	
	@GetMapping("/cart")
	public ResponseEntity<List<ComputerDTO>> listCartComputer(long cartId) {
		List<ComputerDAO> fromDbs = _cartService.getAllCartComputer(cartId);
		List<ComputerDTO> results = new ArrayList<>();
		ResponseEntity<List<ComputerDTO>> response;
		if(fromDbs.isEmpty()) {
			response = new ResponseEntity<List<ComputerDTO>>(HttpStatus.NOT_FOUND);
		} else {
			fromDbs.forEach(comp -> {
				ComputerDTO compDto = _compdtoConverter.Convert(comp);
				results.add(compDto);
			});
			response = new ResponseEntity<List<ComputerDTO>>(results, HttpStatus.OK);
		}
		return response;
	}
}
