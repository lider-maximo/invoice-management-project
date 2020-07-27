package ma.nestideas.invoicemanagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.nestideas.invoicemanagement.exception.ResourceNotFoundException;
import ma.nestideas.invoicemanagement.model.Client;
import ma.nestideas.invoicemanagement.repository.ClientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ClientController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/clients")
	public List<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	@GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable(value = "id") Long clientId)
        throws ResourceNotFoundException {
        Client client = clientRepository.findById(clientId)
          .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id :: " + clientId));
        return ResponseEntity.ok().body(client);
    }
	
	@PostMapping("/clients")
	public Client createClient(@Validated @RequestBody Client client) {
		return clientRepository.save(client);
	}
	
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> updateClient(@PathVariable(value = "id") Long clientId, @Validated @RequestBody Client clientDetails) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
		        .orElseThrow(() -> new ResourceNotFoundException("Client not found for this id : " + clientId));
		client.setCompanyName(clientDetails.getCompanyName());
		client.setContactName(clientDetails.getContactName());
		client.setAddress(clientDetails.getAddress());
		client.setCity(clientDetails.getCity());
		client.setEmail(clientDetails.getEmail());
		client.setPhone(clientDetails.getPhone());
		
		final Client updatedClient = clientRepository.save(client);
		
		return ResponseEntity.ok(updatedClient);
	}
	
	@DeleteMapping("/client/{id}")
	public Map<String, Boolean> deleteClient(@PathVariable(value = "id") Long clientId) throws ResourceNotFoundException {
		Client client = clientRepository.findById(clientId)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found for this id : " + clientId));
		
		clientRepository.delete(client);
		
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
