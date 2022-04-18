package com.store.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.store.dao.RoleDAO;
import com.store.dto.RoleDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.interfaces.converter.IDtoConverter;
import com.store.service.IRoleService;

@RestController
public class RoleApi {

	@Autowired
	private IRoleService _roleService;
	
	@Autowired
	@Qualifier("role")
	private IDaoConverter<RoleDTO, RoleDAO> _daoConverter;
	
	@Autowired
	@Qualifier("role")
	private IDtoConverter<RoleDAO, RoleDTO> _dtoConverter;
	
	@PostMapping(value="/role")
	public ResponseEntity<RoleDTO> Save(@RequestBody RoleDTO input) {
		RoleDAO saveRole = _daoConverter.Convert(input);
		RoleDAO roleToDb = _roleService.Insert(saveRole);
		RoleDTO result = _dtoConverter.Convert(roleToDb);
		ResponseEntity<RoleDTO> response = new ResponseEntity<RoleDTO>(result, HttpStatus.CREATED);
		return response;
	}
	
	
	@GetMapping(value="/role")
	public ResponseEntity<RoleDTO> Get(long Id) {
		RoleDAO fromDb = _roleService.FindById(Id);
		ResponseEntity<RoleDTO> response;
		if(fromDb != null) {
			RoleDTO result = _dtoConverter.Convert(fromDb);
			response = new ResponseEntity<RoleDTO>(result, HttpStatus.OK);
		} else {
			response = new ResponseEntity<RoleDTO>(HttpStatus.NOT_FOUND);
		}
		return response;
	}
	
	@GetMapping(value="/roles")
	public ResponseEntity<List<RoleDTO>> GetAll() {
		List<RoleDAO> fromDbs = _roleService.FindAll();
		List<RoleDTO> results = new ArrayList<>();
		ResponseEntity<List<RoleDTO>> response;
		fromDbs.forEach(role -> {
			RoleDTO roleDto = _dtoConverter.Convert(role);
			results.add(roleDto);
		});
		if(results.isEmpty()) {
			response = new ResponseEntity<List<RoleDTO>>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<List<RoleDTO>>(results, HttpStatus.OK);
		}
		return response;
	}
	
	@DeleteMapping(value="/role")
	public ResponseEntity<String> Delete(long Id) {
		String result = _roleService.Delete(Id);
		return ResponseEntity.ok(result);
	}
	
	@PutMapping(value="/role")
	public void Update(long Id,@RequestBody RoleDTO role) {
		_roleService.Update(Id, role.getName());
	}
	
}
