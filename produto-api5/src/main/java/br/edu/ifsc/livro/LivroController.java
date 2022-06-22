package br.edu.ifsc.livro;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class LivroController {
	
	
	@RequestMapping(value = "/add_livro", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro novo(@RequestBody Livro livro) {
		LivroDataSource.adicionar(livro);
		return livro;
	}

	
	@RequestMapping(
			value = "/adicionar_livro/{id}/{isbn}/{titulo}/{autor}/{editora}/{preco}", 
			method = RequestMethod.GET)
	public Livro adicionar(
			@PathVariable(name = "id") int id, 
			@PathVariable(name = "isbn") int isbn, 
			@PathVariable(name = "titulo") String titulo, 
			@PathVariable(name = "autor") String autor, 
			@PathVariable(name = "editora") String editora, 
			@PathVariable(name = "preco") double preco) {
		Livro livro = new Livro(id, isbn, titulo, autor, editora, preco);
		return livro;
	}
	
	@RequestMapping(value = "/todos_livros")
	public List<Livro> getLivros() {
		return LivroDataSource.getListaLivro();
	}
	
	
	@RequestMapping(value = "/livro_isbn/{isbn}")
	public Livro getPorIsbn(
			@PathVariable("isbn") int isbn) {
		return LivroDataSource.getPorIsbn(isbn);
	}
	
	@RequestMapping(value = "/livro_autor/{autor}")
	public List<Livro> getPorAutor(
			@PathVariable("autor") String autor) {
		return LivroDataSource.getPorAutor(autor);
	}
	
	@RequestMapping(value = "/livro_titulo/{titulo}")
	public Livro getPorTitulo(
			@PathVariable("titulo") String titulo) {
		return LivroDataSource.getPorTitulo(titulo);
	}
	
	@RequestMapping(value = "/livro_isbndto/{isbn}")
	public LivroDTO getPorIsbnDTO(
			@PathVariable("isbn") int isbn) {
		return LivroDataSource.getPorIsbnDTO(isbn);
	}
	
	@RequestMapping(value = "/livros_dto")
	public List<LivroDTO> getAllDTO() {
		return LivroDataSource.getAllDTO();
	}
	
	@RequestMapping(value = "/reajustar_preco/{id}/{taxa}")
	public void reajustarPreco(
			@PathVariable(name = "id") int id,
			@PathVariable(name = "taxa") int taxa) {
		LivroDataSource.reajustarPrecoPorId(id, taxa);
	}

	@RequestMapping(value = "/reajustar_preco/{taxa}")
	public void reajustarPreco(
			@PathVariable(name = "taxa") int taxa) {
		LivroDataSource.reajustarPreco(taxa);
	}		
	
}
