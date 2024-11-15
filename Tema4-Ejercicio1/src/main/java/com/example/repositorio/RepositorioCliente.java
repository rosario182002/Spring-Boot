package com.example.repositorio;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RepositorioCliente {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	//Metodo para obtenenr la lista de clientes
	public List<Cliente> getCliente(){
		Query<Cliente> query = (Query<Cliente>)entityManager.createQuery("select c from cliente c ", Cliente.class);
		
		List<Cliente> lista = query.getResultList();
		return lista;
	}
	//Metodo para insertar cliente
	public Cliente insertarCliente(Cliente cliente){
		entityManager.persist(cliente);
		return cliente;
		
	}
	// Método para obtener un cliente por su id
    public Cliente mostrarCliente(int id) {
        return entityManager.find(Cliente.class, id);  // Usamos el método `find` para buscar por ID
    }
	
 // Método para eliminar un cliente por su id
    public void eliminarCliente(int id) {
        Cliente cliente = entityManager.find(Cliente.class, id);  // Buscamos el cliente por su id
        if (cliente != null) {
            entityManager.remove(cliente);  // Si existe, lo eliminamos
        }
    }

    // Método para actualizar los datos de un cliente
    public Cliente actualizarCliente(int id, Cliente cliente) {
        Cliente clienteExistente = entityManager.find(Cliente.class, id);  // Buscamos el cliente
        if (clienteExistente != null) {
            clienteExistente.setNombre(cliente.getNombre());  // Actualizamos los datos
            clienteExistente.setApellidos(cliente.getApellidos());
            return entityManager.merge(clienteExistente);  // Guardamos los cambios
        }
        return null;  // Si no lo encontramos, devolvemos null
    }

    // Método para actualizar parcialmente los datos de un cliente
    public Cliente actualizarClienteParcial(int id, Cliente cliente) {
        Cliente clienteExistente = entityManager.find(Cliente.class, id);  // Buscamos el cliente
        if (clienteExistente != null) {
            // Solo actualizamos los campos no nulos del cliente recibido
            if (cliente.getNombre() != null) {
                clienteExistente.setNombre(cliente.getNombre());
            }
            if (cliente.getApellidos() != null) {
                clienteExistente.setApellidos(cliente.getApellidos());
            }
            return entityManager.merge(clienteExistente);  // Guardamos los cambios
        }
        return null;  // Si no lo encontramos, devolvemos null
    }

    // Método para buscar clientes por nombre (contiene el texto del nombre)
    public List<Cliente> getClientesPorNombre(String nombre) {
        // Consulta JPQL para buscar clientes cuyo nombre contenga el texto proporcionado
        Query<Cliente> query = (Query<Cliente>) entityManager.createQuery(
                "SELECT c FROM Cliente c WHERE c.nombre LIKE :nombre", Cliente.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();  // Devolvemos la lista de clientes encontrados
    }
	
}
