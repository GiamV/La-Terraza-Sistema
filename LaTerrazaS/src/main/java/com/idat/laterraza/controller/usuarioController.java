package com.idat.laterraza.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.laterraza.entity.Usuario;
import com.idat.laterraza.service.IUsuarioService;

@CrossOrigin(origins= {"http://localhost/4200"})
@RestController
@RequestMapping("/usuario")
public class usuarioController {

	@Autowired
	private IUsuarioService usuarioService;
	
	//LISTAR USUARIOS
	@GetMapping("/usuarios")
	public List<Usuario> listar(){
		return usuarioService.findAll();
	}
	
	//BUSCAR USUARIO POR ID
	@GetMapping("/usuario/{id}")
	public Usuario usuario (@PathVariable Long id) {
		return usuarioService.findById(id);
	}
	
	//CREAR UN NUEVO USUARIO
	@PostMapping("/usuarionew")
	public Usuario usuarionew (@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return usuarioService.findById(null);
	}
	
	//ACTUALIZAR USUARIO
	@PutMapping("/usuarioupdate/{id}")
	public Usuario actualizar(@RequestBody Usuario usuario,@PathVariable Long id) {
		Usuario usuarioActual=usuarioService.findById(id);
		usuarioActual.setApellido(usuario.getApellido());
		usuarioActual.setNombre(usuario.getNombre());
		usuarioActual.setUsuario(usuario.getUsuario());
		usuarioActual.setContrasena(usuario.getContrasena());
		usuarioActual.setSexo(usuario.getSexo());
		usuarioActual.setDireccion(usuario.getDireccion());
		usuarioActual.setTelefono(usuario.getTelefono());
		usuarioActual.setDni(usuario.getDni());
		
		usuarioService.save(usuarioActual);
		return usuarioService.findById(id);
	}
	
	//ELIMINAR USUARIO
	@DeleteMapping("/usuariodelete/{id}")
	public void delete(@PathVariable Long id) {
		usuarioService.eliminarUsuario(id);
	}
	
}
