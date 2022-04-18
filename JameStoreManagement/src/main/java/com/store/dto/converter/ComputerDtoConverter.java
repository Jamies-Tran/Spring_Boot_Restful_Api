package com.store.dto.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.ComputerDAO;
import com.store.dto.ComputerDTO;
import com.store.interfaces.converter.IDtoConverter;

@Service
@Qualifier("computer")
public class ComputerDtoConverter implements IDtoConverter<ComputerDAO, ComputerDTO>{

	@Override
	public ComputerDTO Convert(ComputerDAO source) {
		ComputerDTO result = new ComputerDTO();
		result.setId(source.getId());
		result.setChip(source.getChip());
		result.setVga(source.getVga());
		result.setHardDisk(source.getHardDisk());
		result.setRam(source.getRam());
		return result;
	}

}
