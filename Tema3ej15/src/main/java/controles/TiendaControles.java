package controles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import modelo.Album;
import modelo.Artista;
import modelo.Cancion;

@RestController
@RequestMapping("/albumes")
public class TiendaControles {

    private List<Album> listaAlbumes;

    public TiendaControles() {
        listaAlbumes = new ArrayList<>();

        List<Artista> artistas1 = new ArrayList<>();
        artistas1.add(new Artista(1L, "Freddie Mercury", "Británico"));
        artistas1.add(new Artista(2L, "Brian May", "Británico"));

        List<Artista> artistas2 = new ArrayList<>();
        artistas2.add(new Artista(3L, "Kurt Cobain", "Americano"));
        artistas2.add(new Artista(4L, "Dave Grohl", "Americano"));

        List<Cancion> canciones1 = new ArrayList<>();
        canciones1.add(new Cancion(1L, "Bohemian Rhapsody", artistas1));
        canciones1.add(new Cancion(2L, "Don't Stop Me Now", artistas1));

        List<Cancion> canciones2 = new ArrayList<>();
        canciones2.add(new Cancion(3L, "Smells Like Teen Spirit", artistas2));
        canciones2.add(new Cancion(4L, "Come As You Are", artistas2));

        listaAlbumes.add(new Album(1L, "A Night at the Opera", "Queen", 1975, canciones1));
        listaAlbumes.add(new Album(2L, "Nevermind", "Nirvana", 1991, canciones2));
    }

    // Mostrar todos los álbumes
    @GetMapping
    public ResponseEntity<List<Album>> obtenerTodosLosAlbumes() {
    	 return ResponseEntity.ok(listaAlbumes);
    }

    // Consultar un álbum por su título
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Album> obtenerAlbumPorTitulo(@PathVariable String titulo) {
        for (Album album : listaAlbumes) {
            if (album.getTitulo().equalsIgnoreCase(titulo)) {
            	return ResponseEntity.ok(album);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Crear un nuevo álbum
    @PostMapping
    public ResponseEntity<Album> crearAlbum(@RequestBody Album album) {
        listaAlbumes.add(album);
        return ResponseEntity.ok(album);
    }

    // Modificar la información de un álbum (completo)
    @PutMapping
    public ResponseEntity<Album> actualizarAlbum( @RequestBody Album albumActualizado) {
        for (int i = 0; i < listaAlbumes.size(); i++) {
            Album album = listaAlbumes.get(i);
            if (album.getId().equals(albumActualizado.getId())) {
                album.setTitulo(albumActualizado.getTitulo());
                album.setArtistaPrincipal(albumActualizado.getArtistaPrincipal());
                album.setAnoLanzamiento(albumActualizado.getAnoLanzamiento());
                album.setCanciones(albumActualizado.getCanciones());
                return ResponseEntity.ok(album);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Modificar la información de un álbum (parcial)
    @PatchMapping("/{id}")
    public ResponseEntity<Album> actualizarParcialmenteAlbum(@PathVariable Long id, @RequestBody Album albumActualizado) {
        for (Album album : listaAlbumes) {
            if (album.getId().equals(id)) {
                if (albumActualizado.getTitulo() != null) {
                    album.setTitulo(albumActualizado.getTitulo());
                }
                if (albumActualizado.getArtistaPrincipal() != null) {
                    album.setArtistaPrincipal(albumActualizado.getArtistaPrincipal());
                }
                if (albumActualizado.getAnoLanzamiento() != 0) {
                    album.setAnoLanzamiento(albumActualizado.getAnoLanzamiento());
                }
                if (albumActualizado.getCanciones() != null) {
                    album.setCanciones(albumActualizado.getCanciones());
                }
                return ResponseEntity.ok(album);
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Eliminar un álbum por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlbum(@PathVariable Long id) {
        
    	 Iterator<Album> iterator = listaAlbumes.iterator();
    	    while (iterator.hasNext()) {
    	        Album album = iterator.next();
    	        if (album.getId().equals(id)) {
    	            iterator.remove();
    	            return ResponseEntity.noContent().build();
    	        }
    	    }
    	    return ResponseEntity.notFound().build();
    }
        
    

    // Obtener todas las canciones de un álbum específico
    @GetMapping("/canciones/{id}")
    public ResponseEntity<List<Cancion>> obtenerCancionesDeAlbum(@PathVariable Long id) {
        for (Album album : listaAlbumes) {
            if (album.getId().equals(id)) {
            	 return ResponseEntity.ok(album.getCanciones());
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener todas las canciones de un artista específico
    @GetMapping("/canciones/artista/{nombre}")
    public ResponseEntity<List<Cancion>> obtenerCancionesPorArtista(@PathVariable String nombre) {
        List<Cancion> cancionesDelArtista = new ArrayList<>();
        for (Album album : listaAlbumes) {
            for (Cancion cancion : album.getCanciones()) {
                for (Artista artista : cancion.getArtistas()) {
                    if (artista.getNombre().equalsIgnoreCase(nombre)) {
                        cancionesDelArtista.add(cancion);
                        break; // No necesitamos seguir buscando en esta canción
                    }
                }
            }
        }
        if (cancionesDelArtista.isEmpty()) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cancionesDelArtista);
    }

    // Obtener todos los artistas de una canción específica
    @GetMapping("/artistas/cancion/{id}")
    public ResponseEntity<List<Artista>> obtenerArtistasDeCancion(@PathVariable Long id) {
        for (Album album : listaAlbumes) {
            for (Cancion cancion : album.getCanciones()) {
                if (cancion.getId().equals(id)) {
                	return ResponseEntity.ok(cancion.getArtistas());
                }
            }
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener la lista de todos los artistas
    @GetMapping("/artistas")
    public ResponseEntity<Set<Artista>> obtenerTodosLosArtistas() {
        Set<Artista> artistas = new HashSet<>();
        for (Album album : listaAlbumes) {
            for (Cancion cancion : album.getCanciones()) {
                for (Artista artista : cancion.getArtistas()) {
                    artistas.add(artista);
                }
            }
        }
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/artistas/canciones")
    public ResponseEntity<Map<String, Integer>> obtenerArtistasConNumeroDeCanciones() {
        Map<String, Integer> artistaConteoCanciones = new HashMap<>();

        for (Album album : listaAlbumes) {
            for (Cancion cancion : album.getCanciones()) {
                for (Artista artista : cancion.getArtistas()) {
                    String nombreArtista = artista.getNombre();
                    if (artistaConteoCanciones.containsKey(nombreArtista)) {
                        artistaConteoCanciones.put(nombreArtista, artistaConteoCanciones.get(nombreArtista) + 1);
                    } else {
                        artistaConteoCanciones.put(nombreArtista, 1);
                    }
                }
            }
        }

        if (artistaConteoCanciones.isEmpty()) {
        	return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(artistaConteoCanciones);
    }
}
