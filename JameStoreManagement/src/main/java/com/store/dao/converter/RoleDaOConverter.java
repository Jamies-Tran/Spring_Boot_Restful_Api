package com.store.dao.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.RoleDAO;
import com.store.dto.RoleDTO;
import com.store.interfaces.converter.IDaoConverter;

@Service
@Qualifier("role")
public class RoleDaOConverter implements IDaoConverter<RoleDTO, RoleDAO> {

	@Override
	public RoleDAO Convert(RoleDTO source) {
		RoleDAO result = new RoleDAO();
		result.setName(source.getName());
		return result;
	}

}
