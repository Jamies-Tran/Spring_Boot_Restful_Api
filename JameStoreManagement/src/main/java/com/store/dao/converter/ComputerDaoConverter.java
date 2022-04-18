package com.store.dao.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.ComputerDAO;
import com.store.dto.ComputerDTO;
import com.store.interfaces.converter.IDaoConverter;

@Service
@Qualifier("computer")
public class ComputerDaoConverter implements IDaoConverter<ComputerDTO, ComputerDAO>{

	@Override
	public ComputerDAO Convert(ComputerDTO source) {
		ComputerDAO result = new ComputerDAO();
		result.setChip(source.getChip());
		result.setVga(source.getVga());
		result.setHardDisk(source.getHardDisk());
		result.setRam(source.getRam());
		return result;
	}

}
