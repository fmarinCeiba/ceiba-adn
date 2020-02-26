package com.ceiba.cafe.adapter.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cafe.app.command.ComputerCommand;
import com.ceiba.cafe.app.port.in.CreateComputerUseCase;
import com.ceiba.cafe.app.port.in.DeleteComputerUseCase;
import com.ceiba.cafe.app.port.in.FindComputerUseCase;
import com.ceiba.cafe.app.port.in.UpdateComputerUseCase;
import com.ceiba.cafe.common.WebAdapter;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "http://localhost:3000")
@WebAdapter
@RestController
@RequestMapping("cafe-api/computer")
@RequiredArgsConstructor
public class ComputerController {
	private final CreateComputerUseCase newComputer;
	private final FindComputerUseCase fndComputer;
	private final UpdateComputerUseCase updComputer;
	private final DeleteComputerUseCase delComputer;

	@PutMapping
	public ResponseEntity<Long> create(@RequestBody ComputerCommand computer) {
		return new ResponseEntity<>(newComputer.create(computer), HttpStatus.CREATED);
	}

	@GetMapping("/{statusId}")
	public ResponseEntity<List<Computer>> getComputer(@PathVariable("statusId") Long statusId) {
		return new ResponseEntity<>(fndComputer.find(statusId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Computer>> getComputers() {
		return new ResponseEntity<>(fndComputer.find(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Boolean> update(@Valid @RequestBody ComputerCommand computer) {
		return new ResponseEntity<>(updComputer.update(computer), HttpStatus.OK);
	}

	@DeleteMapping("/{computerId}")
	public ResponseEntity<Boolean> delete(@PathVariable("computerId") Long computerId) {
		return new ResponseEntity<>(delComputer.delete(computerId), HttpStatus.OK);
	}

}
