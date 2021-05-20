package com.libertas.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libertas.exemplospring.pojo.Agendamento;
import com.libertas.exemplospring.repositorio.AgendamentoRepository;

@RestController
public class SpringBootController {
	
	@Autowired
	private VeiculoRepository _veiculoRepository;
	
	@RequestMapping(value = "/veiculo", method=RequestMethod.GET)
	public List<Veiculo> GetVeiculo() {
		return _veiculoRepository.findAll();
	}
	
	@RequestMapping(value = "/veiculo/{id}", method=RequestMethod.GET)
	public ResponseEntity<Veiculo> GetVeiculoById(@PathVariable(value="id") long id) {
		Optional<Veiculo> veiculo = _veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			return new ResponseEntity<Veiculo>(veiculo.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/veiculo", method=RequestMethod.POST)
	public Veiculo PostVeiculo(@Validated @RequestBody Veiculo veiculo) {
		return _veiculoRepository.save(veiculo);
	}
	
	
	@RequestMapping(value = "/veiculo/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Veiculo> PutVeiculo(@PathVariable(value="id") long id, 
			@Validated @RequestBody Veiculo veiculo) {
		
		Optional<Veiculo> Oldveiculo = _veiculoRepository.findById(id);
		if (Oldveiculo.isPresent()) {
			_veiculoRepository.save(veiculo);
			return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/veiculo/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> PutVeiculo(@PathVariable(value="id") long id) {
		
		Optional<Veiculo> veiculo = _veiculoRepository.findById(id);
		if (veiculo.isPresent()) {
			_veiculoRepository.delete(veiculo.get());
			return new ResponseEntity<>(HttpStatus.OK);
			
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}