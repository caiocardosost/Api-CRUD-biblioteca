package ApiBiblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ApiBiblioteca.entity.Livro;

public interface BiblioRepository extends JpaRepository<Livro, Long> {

}
