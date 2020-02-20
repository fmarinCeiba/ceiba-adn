package com.ceiba.cafe.adapter.web;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cafe.app.command.ClientCommand;
import com.ceiba.cafe.app.port.in.CreateClientUseCase;
import com.ceiba.cafe.app.port.in.DeleteClientUseCase;
import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.in.UpdateClientUseCase;
import com.ceiba.cafe.common.WebAdapter;
import com.ceiba.cafe.domain.Client;

import lombok.RequiredArgsConstructor;

@WebAdapter
@RestController
@RequestMapping("cafe-api/client")
@RequiredArgsConstructor
public class ClientController {
	private final CreateClientUseCase newClient;
	private final FindClientUseCase fndClient;
	private final UpdateClientUseCase updClient;
	private final DeleteClientUseCase delClient;

	@PutMapping
	public ResponseEntity<Long> create(@RequestBody ClientCommand client) throws Exception {
		return new ResponseEntity<>(newClient.create(client), HttpStatus.CREATED);
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<List<Client>> getClient(@PathVariable("clientId") Long clientId) throws Exception {
		return new ResponseEntity<>(fndClient.find(clientId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Client>> getClients() throws Exception {
		return new ResponseEntity<>(fndClient.find(null), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Boolean> update(@RequestBody ClientCommand client) throws Exception {
		return new ResponseEntity<>(updClient.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{clientId}")
	public ResponseEntity<Boolean> delete(@PathVariable("clientId") Long clientId) throws Exception {
		return new ResponseEntity<>(delClient.delete(clientId), HttpStatus.OK);
	}
}
