package ApiBiblioteca.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Livro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private int ano;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "autor_id")
	private Autor autor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "editora_id")
	private Editora editora;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "livro_proprietario",
				joinColumns = @JoinColumn(name = "livro_id"),
				inverseJoinColumns = @JoinColumn(name = "proprietario_id"))
	private List<Proprietario> proprietario;
	
	

}
