package br.edu.ifsc.livro;

import java.util.ArrayList;
import java.util.List;


public class LivroDataSource {

	private static List<Livro> listaLivros = new ArrayList<>();
	private static List<Livro> livros;
	
	public static void criarLista() {
		listaLivros.add(new Livro(1, 97608, "HTML 5", "Paulo", "Novatec", 20.00));
		listaLivros.add(new Livro(2, 97522, "Google Android", "César", "Novatec", 35.00));
		listaLivros.add(new Livro(31, 97885, "Padrões Javascript", "Carla", "AltaBooks", 18.00));
		listaLivros.add(new Livro(57, 98231, "Dominando PHP", "Flávia", "Conexões", 85.00));
	}
	
	public static List<Livro> getListaLivro() {
		return listaLivros;
	}
	
	public static void novo(Livro livro) {
		listaLivros.add(livro);
	}
	
	public static List<Livro> getAll() {
		return livros;
	}
	
	public static void setLivros(List<Livro> livros) {
		LivroDataSource.livros = livros;
	}
	
	
	public static Livro getPorIsbn(int isbn) {
		for (Livro livro : listaLivros) {
			if (livro.getIsbn() == isbn) {
				return livro;
			}
		}
		return null;
	}
	
	public static List<Livro> getPorAutor(String autor) {
		List<Livro> resultado = new ArrayList<>();
		for (Livro livro : listaLivros) {
			if (livro.getAutor().equalsIgnoreCase(autor)) {
				resultado.add(livro);
			}
		}
		return resultado;
	}
	
	
	public static Livro getPorTitulo(String titulo) {
		for (Livro livro : listaLivros) {
			if (livro.getTitulo().equalsIgnoreCase(titulo)) {
				return livro;
			}
		}
		return null;
	}
	
	
	public static LivroDTO getPorIsbnDTO(int isbn) {
		LivroDTO livroDTO = null;
		for (Livro livro : listaLivros) {
			if (livro.getIsbn() == isbn) {
				livroDTO = new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
				return livroDTO;
			}
		}
		livroDTO = new LivroDTO("Não encontrado", "Não encontrado", "Não encontrado", 0.0);
		return livroDTO;
	}
	
	public static List<LivroDTO> getAllDTO() {
		List<LivroDTO> listaLivrosDTO = new ArrayList<>();
		for (Livro livro : listaLivros) {
			LivroDTO livroDTO = new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
			listaLivrosDTO.add(livroDTO);
	}
		return listaLivrosDTO;
	}
	
	
	public static void reajustarPrecoPorId(int id, int taxa) {
		for (Livro livro: livros) {
			if (livro.getId() == id) {
				livro.reajustarPreco(taxa);
			}
		}
	}
	
	public static void reajustarPreco(int taxa) {
		for (Livro livro: livros) {
			livro.reajustarPreco(taxa);
		}
	}		
	
	public static Livro adicionar(Livro livro) {
		livros.add(livro);
		return livro;
	}
	
}