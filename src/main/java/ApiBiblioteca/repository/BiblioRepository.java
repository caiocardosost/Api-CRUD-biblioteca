package ApiBiblioteca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ApiBiblioteca.entity.Editora;
import ApiBiblioteca.entity.Livro;

public interface BiblioRepository extends JpaRepository<Livro, Long> {
	
	public List<Livro> findByAno(int ano);
	
	public List<Livro> findByAutorNome(String nome);
	
	public List<Livro> findByEditora(Editora editora);
	
	@Query("SELECT l FROM Livro l WHERE l.ano > :ano")
	public List<Livro> findBeforeYear(int ano);


}
