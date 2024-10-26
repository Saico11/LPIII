class GestorPersonajes {
    private List<Personaje> personajes;
    private String archivo;

    public GestorPersonajes(String archivo) {
        this.archivo = archivo;
        personajes = new ArrayList<>();
        cargarPersonajesDesdeArchivo();
    }

    public void agregarPersonaje(Personaje personaje) {
        if (!personajes.contains(personaje)) {
            personajes.add(personaje);
            guardarCambios();
        } else {
            System.out.println("El personaje ya existe.");
        }
    }

    public void modificarPersonaje(String nombre, Personaje nuevoPersonaje) {
        for (int i = 0; i < personajes.size(); i++) {
            if (personajes.get(i).getNombre().equals(nombre)) {
                personajes.set(i, nuevoPersonaje);
                guardarCambios();
                return;
            }
        }
        System.out.println("Personaje no encontrado.");
    }

    public void eliminarPersonaje(String nombre) {
        personajes.removeIf(p -> p.getNombre().equals(nombre));
        guardarCambios();
    }

    public void mostrarPersonajes() {
        for (Personaje personaje : personajes) {
            System.out.println(personaje);
        }
    }

    private void cargarPersonajesDesdeArchivo() {
        // ... (implementación para leer desde el archivo)
    }

    private void guardarCambios() {
        // ... (implementación para guardar los cambios en el archivo)
    }
}