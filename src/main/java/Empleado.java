import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.time.LocalDate;

public class Empleado {
	List<Sugerencia> sugerencias;
	List<Usuario> usuarios;
	String ciudad;
	AccuWeatherAPI apiClima = new AccuWeatherAPI();
	Map<String,List<String>> alertas = apiClima.getAlerts(ciudad);
	
	public void dispararSugerencias(){
		usuarios.stream().forEach(usuario -> usuario.addSugerencias(sugerencias));
	}
	
	public void publicarAlertas(){
		Random randomizer = new Random();
		usuarios.stream().forEach(usuario -> usuario.setAlertas(alertas));
		usuarios.stream().forEach(usuario -> usuario.actualizarSugerenciaDiaria(sugerencias.get(randomizer.nextInt(sugerencias.size()))));
	}
	
	public Empleado(List<Sugerencia> sugerencias, List<Usuario> usuarios, String ciudad){
		this.sugerencias = sugerencias;
		this.usuarios = usuarios;
		this.ciudad = ciudad;
	}
}
