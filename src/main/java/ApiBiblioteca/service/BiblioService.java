package ApiBiblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ApiBiblioteca.entity.Livro;
import ApiBiblioteca.repository.BiblioRepository;

@Service
public class BiblioService {
	
	//---------INJEÇÃO DE DEPENDENCIA POR CONSTRUTOR-----------
	private BiblioRepository biblioRepo;
	
	public BiblioService (BiblioRepository biblioRepo) {
		this.biblioRepo = biblioRepo;
	}
	
	
	//---------------MÉTODOS--------------------------
	
	public String save (Livro livro) {
		this.biblioRepo.save(livro);
		return "Livro salvo com sucesso no banco de dados!";
	}
	
	public String update (Livro livro, long id) {
		livro.setId(id);
		this.biblioRepo.save(livro);
		return "Livro atualizado com sucesso no banco de dados!";
	}
	
	public String delete(long id) {
		this.biblioRepo.deleteById(id);
		return "Livro deletado com sucesso do banco de dados!";
	}
	
	public Livro findById (long id) {
		Livro livro = this.biblioRepo.findById(id).get();
		return livro;
	}
	
	public List<Livro> findAll () {
		List<Livro> livros = this.biblioRepo.findAll();
		return livros;
	}

}
