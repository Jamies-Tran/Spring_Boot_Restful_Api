package com.store.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.store.dao.RoleDAO;
import com.store.repository.IRoleRepository;
import com.store.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleRepository _repo;
	
	@Override
	public RoleDAO FindById(long Id) {
		Optional<RoleDAO> result = _repo.findById(Id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public RoleDAO Insert(RoleDAO input) {
		if(!_repo.existsById(input.getId())) {
			RoleDAO result = _repo.save(input);
			return result;
		}
		return null;
	}

	@Override
	public String Delete(long Id) {
		RoleDAO fromDb = _repo.getById(Id);
		if(fromDb != null) {
			_repo.delete(fromDb);
			return "Deleted";
		}
		return "Role not found";
	}

	@Override
	public List<RoleDAO> FindAll() {
		List<RoleDAO> results = _repo.findAll();
		return results;
	}

	@Override
	public void Update(long Id, String name) {
		_repo.Update(Id, name);
	}

}
