package com.ceiba.cafe.adapter.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "computer")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComputerJpaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private Long idStatus;
	@Column
	private Long idCategory;
	@Column
	private String ip;
	@Column
	private String mac;
	@Column
	private String location;

}
