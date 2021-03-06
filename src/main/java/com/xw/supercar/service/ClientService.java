package com.xw.supercar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xw.supercar.dao.BaseDao;
import com.xw.supercar.dao.ClientDao;
import com.xw.supercar.entity.Client;

@Service
public class ClientService extends BaseService<Client>{
	@Autowired
	private ClientDao clientDao;
	
	@Override
	protected BaseDao<Client> getDao() {
		return clientDao;
	}
	
}
