package com.store.dto.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.RoleDAO;
import com.store.dto.RoleDTO;
import com.store.interfaces.converter.IDtoConverter;

@Service
@Qualifier("role")
public class RoleDtoConverter implements IDtoConverter<RoleDAO, RoleDTO> {

	@Override
	public RoleDTO Convert(RoleDAO source) {
		RoleDTO result = new RoleDTO();
		result.setId(source.getId());
		result.setName(source.getName());
		return result;
	}

}
