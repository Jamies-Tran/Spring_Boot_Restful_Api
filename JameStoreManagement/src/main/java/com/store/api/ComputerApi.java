package com.store.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.dao.ComputerDAO;
import com.store.dto.ComputerDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.interfaces.converter.IDtoConverter;
import com.store.service.IComputerService;

@RestController
public class ComputerApi {
	
	@Autowired
	private IComputerService _computerService;
	
	@Autowired
	@Qualifier("computer")
	private IDaoConverter<ComputerDTO, ComputerDAO> _daoConverter;
	
	@Autowired
	@Qualifier("computer")
	private IDtoConverter<ComputerDAO, ComputerDTO> _dtoConverter;
	
	
	@PostMapping("/computer")
	public ComputerDTO Save(@RequestBody ComputerDTO clientInput) {
		ComputerDAO toDb = _daoConverter.Convert(clientInput);
		ComputerDAO saveComp = _computerService.Insert(toDb);
		ComputerDTO result = _dtoConverter.Convert(saveComp);
		return result;
	}
	
	@GetMapping("/computer")
	public ComputerDTO Get(long Id) {
		ComputerDAO fromDb = _computerService.FindById(Id);
		if(fromDb != null) {
			ComputerDTO result = _dtoConverter.Convert(fromDb);
			return result;
		}
		return null;
	}
	
	@GetMapping("/computers")
	public List<ComputerDTO> GetAll() {
		List<ComputerDAO> fromDbs = _computerService.FindAll();
		List<ComputerDTO> results = new ArrayList<>();
		fromDbs.forEach(comp -> {
			ComputerDTO compDto = _dtoConverter.Convert(comp);
			results.add(compDto);
		});
		return results;
	}
	
	@DeleteMapping("/computer")
	public String Delete(long Id) {
		String result = _computerService.Delete(Id);
		return result;
	}
	
	
	@PutMapping("/computer")
	public void Update(long Id,@RequestBody ComputerDTO computer) {
		_computerService.Update(Id, computer.getChip(), computer.getVga(), computer.getHardDisk(), computer.getRam());
	}
	
}
