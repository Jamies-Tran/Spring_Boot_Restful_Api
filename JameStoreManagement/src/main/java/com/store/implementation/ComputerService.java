package com.store.implementation;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.ComputerDAO;
import com.store.repository.IComputerRepository;
import com.store.service.IComputerService;

@Service
public class ComputerService implements IComputerService {
	
	@Autowired
	private IComputerRepository _repo;
	
	@Override
	public ComputerDAO FindById(long Id) {
		Optional<ComputerDAO> result = _repo.findById(Id);		
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public ComputerDAO Insert(ComputerDAO input) {
		if(!_repo.existsById(input.getId())) {
			ComputerDAO result = _repo.save(input);
			return result;
		}
		return null;
	}

	@Override
	public String Delete(long Id) {
		if(_repo.existsById(Id)) {
			ComputerDAO fromDb = _repo.getById(Id);
			_repo.delete(fromDb);
			return "Deleted";
		}
		return "Can't delete computer";
	}

	@Override
	public List<ComputerDAO> FindAll() {
		List<ComputerDAO> results = _repo.findAll();
		return results;
	}

	@Override
	public void Update(long Id, String chip, String vga, String hardDisk, String ram) {
		_repo.Update(Id, chip, vga, hardDisk, ram);
		
	}

}
