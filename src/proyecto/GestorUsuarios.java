package proyecto;

import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<Usuario> usuarios;

    public GestorUsuarios() {
        usuarios = new ArrayList<>();
        // Agregar usuarios
        usuarios.add(new Usuario("Joseph", "admin123", "administrador"));
        usuarios.add(new Usuario("Erick", "pass123", "usuario"));
        usuarios.add(new Usuario("Sebastian", "pass123", "usuario"));
        usuarios.add(new Usuario("Edinson", "pass123", "usuario"));
    }

    // Método para verificar credenciales
    public Usuario verificarCredenciales(String nombre, String contraseña) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equals(nombre) && usuario.getContraseña().equals(contraseña)) {
                return usuario;
            }
        }
        // Credenciales incorrectas
        return null;
    }
}

