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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.store.dao.AccountDAO;
import com.store.dao.CartDAO;
import com.store.dao.RoleDAO;
import com.store.dto.AccountDTO;
import com.store.dto.CartDTO;
import com.store.dto.RoleDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.interfaces.converter.IDtoConverter;
import com.store.service.IAccountService;
import com.store.service.IRoleService;

@RestController
public class AccountApi {
	
	@Autowired
	@Qualifier("account") 
	private IDaoConverter<AccountDTO, AccountDAO> _daoConverter;
	
	@Autowired
	@Qualifier("account") 
	private IDtoConverter<AccountDAO, AccountDTO> _dtoConverter;
	
	@Autowired
	@Qualifier("cart")
	private IDtoConverter<CartDAO, CartDTO> _cartDtoConverter;
	
	
	@Autowired
	private IAccountService _accountService;
	
	@PostMapping(value = "/user")
	public ResponseEntity<AccountDTO> Save(@RequestBody AccountDTO clientInput) {
		AccountDAO input = _daoConverter.Convert(clientInput);
		AccountDAO toDB = _accountService.Insert(input);
		AccountDTO result = _dtoConverter.Convert(toDB);
		ResponseEntity<AccountDTO> response = new ResponseEntity<AccountDTO>(result, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping(value = "/user")
	public ResponseEntity<AccountDTO> Get(Long Id) {
		AccountDAO fromDB = _accountService.FindById(Id);
		ResponseEntity<AccountDTO> response;
		if(fromDB != null) {
			AccountDTO result = _dtoConverter.Convert(fromDB);
			response = new ResponseEntity<AccountDTO>(result, HttpStatus.OK);
		} else {
			response = new ResponseEntity<AccountDTO>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping(value = "/users")
	public ResponseEntity<List<AccountDTO>> getAll() {
		List<AccountDAO> fromDbs = _accountService.FindAll();
		List<AccountDTO> results = new ArrayList<>();
		ResponseEntity<List<AccountDTO>> response;
		fromDbs.forEach(acc -> {
			AccountDTO accountDto = _dtoConverter.Convert(acc);
			results.add(accountDto);
		});
		if(results.isEmpty()) {
			response = new ResponseEntity<List<AccountDTO>>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<List<AccountDTO>>(results, HttpStatus.OK);
		}
		return response;
	}
	
	@GetMapping("/user/cart")
	public ResponseEntity<CartDTO> getCartId(long Id) {
		AccountDAO fromDb = _accountService.FindById(Id);
		ResponseEntity<CartDTO> response;
		if(fromDb != null) {
			CartDAO cartDao = fromDb.getCart();
			CartDTO result = _cartDtoConverter.Convert(cartDao);
			response = new ResponseEntity<CartDTO>(result, HttpStatus.OK);
		} else {
			response = new ResponseEntity<CartDTO>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	
	@DeleteMapping(value = "/user")
	public ResponseEntity<String> Delete(long Id) {
		String result = _accountService.Delete(Id);
		return ResponseEntity.ok(result);
	}
	
	@PatchMapping(value = "/user")
	public void Update(@PathVariable long Id,@RequestBody AccountDTO clientInput) {
		_accountService.Update(Id, clientInput.getUsername(), clientInput.getPassword(), clientInput.getBirthday(), clientInput.getRoleId());
	}
	
}
