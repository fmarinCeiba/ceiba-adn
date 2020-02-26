package com.ceiba.cafe.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.cafe.adapter.persistence.entity.ComputerJpaEntity;
import com.ceiba.cafe.domain.Computer;

@Component
public class ComputerMapper {

	public Computer mapToDomainEntity(ComputerJpaEntity computer) {
		return Computer.withId(computer.getId()
				, computer.getName()
				, computer.getIdStatus()
				, computer.getIdCategory()
				, computer.getIp()
				, computer.getMac()
				, computer.getLocation()
			);
	}

	public ComputerJpaEntity mapToJpaEntity(Computer computer) {
		return new ComputerJpaEntity(
				computer.getId() == null? null : computer.getId()
				, computer.getName()
				, computer.getStatusId()
				, computer.getCategoryId()
				, computer.getIp()
				, computer.getMac()
				, computer.getLocation()
			);
	}
}
