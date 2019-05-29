
public class Alumno {
	
	
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer dni;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDni() {
		return dni;
	}
	public void setDni(Integer dni) {
		this.dni = dni;
	}
	
	public Alumno(Integer id, String nombre, String apellido, Integer dni)
	{
		this.id=id;
		this.nombre=nombre;
		this.apellido=apellido;
		this.dni=dni;
	}
	public Alumno(){}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + this.id + " - Nombre: " + this.nombre + " - Apellido: " + this.apellido + " - Dni: " + this.dni;
	}
}
