package modelo;

import java.util.List;

public class Cancion {
    private Long id;
    private String titulo;
    private List<Artista> artistas;

    // Constructores, getters y setters

    public Cancion(Long id, String titulo, List<Artista> artistas) {
        this.id = id;
        this.titulo = titulo;
        this.artistas = artistas;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Artista> getArtistas() {
		return artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

        
    
}

