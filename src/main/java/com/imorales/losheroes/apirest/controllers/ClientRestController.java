package com.imorales.losheroes.apirest.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.imorales.losheroes.apirest.models.entity.Client;
import com.imorales.losheroes.apirest.models.services.IClientService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ClientRestController {
	
	@Autowired
	private IClientService clientService;
	
	@GetMapping("/clients")
	public List<Client> getAll() {
		return clientService.findAll();
	}
	
	@GetMapping("/client/{id}")
	public ResponseEntity<?> get(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Client client = null;
		
		try {
			client = clientService.findById(id);
		} catch (DataAccessException e) {
			response.put("message", "Error al realizar la consulta en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (client == null) {
			response.put("message", "El cliente ID: " + id + " no existe en la base de datos! ");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Client>(client, HttpStatus.OK);
	}
	
	@PostMapping("/client")
	public ResponseEntity<?> create(@RequestBody Client client) {
		Map<String, Object> response = new HashMap<>();
		Client newClient = null;
		
		try {
			newClient = clientService.save(client);
		} catch (DataAccessException e) {
			response.put("message", "Error al realizar el Insert en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ConstraintViolationException e) {
			response.put("message", "Email debe poseer el formato correcto!");
			response.put("error", e.getMessage() + ": " + e.getConstraintViolations().toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		response.put("message", "El cliente ha sido creado exitosamente!");
		response.put("client", newClient);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		Client responseClient = null;
		
		try {
			Client updatedClient = clientService.findById(id);
			
			if (updatedClient == null) {
				response.put("message", "Error: no se pudo editar, el cliente ID: " + id + " no existe en la base de datos! ");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			Date updatedAt = new Date();
			if (client.getCreateAt() != null) {
				updatedAt = client.getCreateAt();
			} 
			updatedClient.setDni(client.getDni());
			updatedClient.setEmail(client.getEmail());
			updatedClient.setName(client.getName());
			updatedClient.setLastName(client.getLastName());
			updatedClient.setCreateAt(updatedAt);
			
			responseClient = clientService.save(updatedClient);
		} catch (DataAccessException e) {
			response.put("message", "Error al actualizar el cliente en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (ConstraintViolationException e) {
			response.put("message", "Email debe poseer el formato correcto!");
			response.put("error", e.getMessage() + ": " + e.getConstraintViolations().toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		response.put("message", "El cliente ha sido actualizado exitosamente!");
		response.put("client", responseClient);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	} 
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		
		try {
			Client client = clientService.findById(id);
			
			if (client == null) {
				response.put("message", "El cliente ID: " + id + " no existe en la base de datos! ");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}
			
			clientService.delete(id);
		} catch (DataAccessException e) {
			response.put("message", "Error al eliminar el cliente en la base de datos!");
			response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("message", "El cliente ha sido eliminado exitosamente!");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
