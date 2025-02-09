package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Perfil;
import com.example.demo.modelo.Usuario;
import com.example.demo.servicio.ServicioUsuario;

@SpringBootApplication
public class Tema5Ejericicio5Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Tema5Ejericicio5Application.class, args);
	}
	@Autowired
    private ServicioUsuario usuarioServicio;

    @Override
    public void run(String... args) throws Exception {
        // 1. Insertar el usuario con nombre Pepe Ruiz y correo ppruiz@gmail.com. Con biografia
        // 'perfildepepe' y estado DISPONIBLE.
        System.out.println("1. Insertando a Pepe Ruiz");
        Perfil perfilPepe = new Perfil(null, "perfildepepe", "DISPONIBLE");
        Usuario pepe = new Usuario(null, "Pepe Ruiz", "ppruiz@gmail.com", perfilPepe);
        usuarioServicio.insertarUsuario(pepe);
        System.out.println("Usuario insertado: " + pepe);

        // 2. Insertar el usuario con nombre Andrés Ramírez y correo aramirez@gmail.com. Con
        // biografia 'perfildeandres' y estado NO DISPONIBLE
        System.out.println("2. Insertando a Andrés Ramírez");
        Perfil perfilAndres = new Perfil(null, "perfildeandres", "NO DISPONIBLE");
        Usuario andres = new Usuario(null, "Andrés Ramírez", "aramirez@gmail.com", perfilAndres);
        usuarioServicio.insertarUsuario(andres);
        System.out.println("Usuario insertado: " + andres);

        // 3. Mostrar la lista de todos los usuarios
        System.out.println("3. Listando todos los usuarios");
        usuarioServicio.obtenerTodosLosUsuarios().forEach(System.out::println);

        // 4. Obtener los datos del usuario con el id de Andrés.
        System.out.println("4. Obteniendo datos de Andrés (ID: " + andres.getId() + ")");
        Usuario andresRecuperado = usuarioServicio.obtenerUsuarioPorId(andres.getId());
        System.out.println(andresRecuperado);

        // 5. Dado el id de Pepe Ruiz, actualizar sus datos: correo ppruiz2@gmail.com y estado NO DISPONIBLE
        System.out.println("5. Actualizando datos de Pepe Ruiz (ID: " + pepe.getId() + ") ");
        pepe.setEmail("ppruiz2@gmail.com");
        pepe.setPerfil(new Perfil(pepe.getPerfil().getId(), pepe.getPerfil().getBio(), "NO DISPONIBLE"));
        usuarioServicio.actualizarUsuario(pepe.getId(), pepe);
        System.out.println("Usuario actualizado: " + pepe);

        // 6. Mostrar la lista de todos los usuarios y comprobar la actualización.
        System.out.println(" 6. Listando todos los usuarios (después de la actualización) ");
        usuarioServicio.obtenerTodosLosUsuarios().forEach(System.out::println);

        // 7. Obtener el perfil de Andrés.
        System.out.println(" 7. Obteniendo el perfil de Andrés (ID: " + andres.getId() + ") ");
        Perfil perfilDeAndres = usuarioServicio.obtenerPerfilDeUsuario(andres.getId());
        System.out.println(perfilDeAndres);

        // 8. Mostrar la lista de todos los usuarios cuya biografía contenga la palabra 'perfil'.
        System.out.println("8. Listando usuarios con biografía que contiene 'perfil'");
        usuarioServicio.obtenerUsuariosConBiografiaConteniendo("perfil").forEach(System.out::println);

        // 9. Mostrar el primer usuario disponible.
        System.out.println("9. Obteniendo el primer usuario disponible ");
        Usuario primerUsuarioDisponible = usuarioServicio.obtenerPrimerUsuarioDisponible();
        System.out.println(primerUsuarioDisponible);

        // 10. Mostrar todos los usuarios no disponibles
        System.out.println("10. Listando usuarios no disponibles ");
        usuarioServicio.buscarUsuariosNoDisponibles().forEach(System.out::println);

        // 11. Actualizar todos los usuarios a disponibles.
        System.out.println("11. Actualizando todos los usuarios a disponibles");
        usuarioServicio.ponerTodosLosUsuariosDisponibles();
        usuarioServicio.obtenerTodosLosUsuarios().forEach(System.out::println);

        // 12. Eliminar el usuario de Pepe.
        System.out.println("12. Eliminando el usuario de Pepe (ID: " + pepe.getId() + ") ");
        usuarioServicio.eliminarUsuario(pepe.getId());
        System.out.println("Usuario eliminado.");

        // 13. Actualizar el perfil de Pepe usando el método 6: Con biografia 'perfildeandresModificado' y estado NO DISPONIBLE.
        System.out.println(" 13. Intentando actualizar el perfil de Pepe (ID: " + pepe.getId() + ")");
        Perfil nuevoPerfilPepe = new Perfil(null, "perfildeandresModificado", "NO DISPONIBLE");
        
    }
}
