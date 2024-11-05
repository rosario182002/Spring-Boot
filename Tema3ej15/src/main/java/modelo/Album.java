package modelo;

import java.util.List;

public class Album {
    private Long id;
    private String titulo;
    private String artistaPrincipal;
    private int anoLanzamiento;
    private List<Cancion> canciones;

    // Constructores, getters y setters

    public Album(Long id, String titulo, String artistaPrincipal, int anoLanzamiento, List<Cancion> canciones) {
        this.id = id;
        this.titulo = titulo;
        this.artistaPrincipal = artistaPrincipal;
        this.anoLanzamiento = anoLanzamiento;
        this.canciones = canciones;
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

	public String getArtistaPrincipal() {
		return artistaPrincipal;
	}

	public void setArtistaPrincipal(String artistaPrincipal) {
		this.artistaPrincipal = artistaPrincipal;
	}

	public int getAnoLanzamiento() {
		return anoLanzamiento;
	}

	public void setAnoLanzamiento(int anoLanzamiento) {
		this.anoLanzamiento = anoLanzamiento;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

}

