package com.ceiba.cafe.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.cafe.adapter.persistence.entity.StatusJpaEntity;
import com.ceiba.cafe.domain.Status;

@Component
public class StatusMapper {

	public Status mapToDomainEntity(StatusJpaEntity status) {
		return Status.withId(status.getId(), status.getDescription());
	}

}
