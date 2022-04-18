package com.store.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.store.dao.AccountDAO;
import com.store.dao.RoleDAO;
import com.store.repository.IAccountRepository;
import com.store.service.IAccountService;

@Service
public class AccountService implements IAccountService{
	
	@Autowired
	private IAccountRepository _repo;
	
	@Override
	public AccountDAO FindById(long Id) {
		Optional<AccountDAO> result = _repo.findById(Id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	@Override
	public AccountDAO Insert(AccountDAO input) {
		if(!_repo.existsById(input.getId())) {
			AccountDAO saveAccount = _repo.save(input);
			_repo.CreateCart(saveAccount.getId());
			return saveAccount;
		}
		return null;
	}

	@Override
	public String Delete(long Id) {
		AccountDAO fromDB = _repo.getById(Id);
		if(fromDB != null) {
			_repo.delete(fromDB);
			return "Deleted";
		}
		return "Account not found";
	}

	@Override
	public List<AccountDAO> FindAll() {
		List<AccountDAO> results = _repo.findAll();
		return results;
	}

	@Override
	public void Update(long Id,  String username, String password, String birthday, long role) {
		_repo.Update(Id, username, password, birthday, role);
	}

}
