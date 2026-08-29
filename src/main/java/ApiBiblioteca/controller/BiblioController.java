package ApiBiblioteca.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ApiBiblioteca.entity.Livro;
import ApiBiblioteca.service.BiblioService;

@RestController
@RequestMapping("/biblioteca")
public class BiblioController {
	
	//-------------INJEÇÃO DE DEPENDENCIA POR CONSTRUTOR--------------
	private BiblioService biblioService;
	
	public BiblioController (BiblioService biblioService) {
		this.biblioService = biblioService;
	}
	
	//-----------------END POINTS--------------
	@PostMapping("/salvarlivro")
	public ResponseEntity<String> save(@RequestBody Livro livro){
		try {
			String resposta = this.biblioService.save(livro);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao salvar", HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PutMapping("/alterar/{id}")
	public ResponseEntity<String> update(@RequestBody Livro livro, @PathVariable long id){
		try {
			String resposta = this.biblioService.update(livro, id);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao atualizar", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/apagar/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			String resposta = this.biblioService.delete(id);
			return new ResponseEntity<String>(resposta, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<String>("Erro ao deletar", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<Livro> findById(@PathVariable long id){
		try {
			Livro livro = this.biblioService.findById(id);
			return new ResponseEntity<Livro>(livro, HttpStatus.OK);
			
		} catch (Exception e) {
			Livro livro = null;
			return new ResponseEntity<Livro>(livro, HttpStatus.OK);
		}
	}
	
	@GetMapping("/listatodos")
	public ResponseEntity<List<Livro>> findAll(){
		try {
			List <Livro> livros = this.biblioService.findAll();
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
			
		} catch (Exception e) {
			List<Livro> livros = null;
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
		}
	}
	
	@GetMapping("/buscaano")
	public ResponseEntity<List<Livro>> findByAno(@RequestParam int ano){
		try {
			List <Livro> livros = this.biblioService.findByAno(ano);
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
			
		} catch (Exception e) {
			List<Livro> livros = null;
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
		}
	}
	
	@GetMapping("/buscaautor")
	public ResponseEntity<List<Livro>> findByAutorNome(@RequestParam String nome){
		try {
			List <Livro> livros = this.biblioService.findByAutorNome(nome);
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
			
		} catch (Exception e) {
			List<Livro> livros = null;
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
		}
	}
	
	@GetMapping("/buscaeditora")
	public ResponseEntity<List<Livro>> findByEditora(@RequestParam long id_editora){
		try {
			List <Livro> livros = this.biblioService.findByEditora(id_editora);
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
			
		} catch (Exception e) {
			List<Livro> livros = null;
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
		}
	}
	
	@GetMapping("/buscaanopos")
	public ResponseEntity<List<Livro>> findBeforeYear(@RequestParam int ano){
		try {
			List <Livro> livros = this.biblioService.findBeforeYear(ano);
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
			
		} catch (Exception e) {
			List<Livro> livros = null;
			return new ResponseEntity<List<Livro>>(livros, HttpStatus.OK);
		}
	}
	
	
}
