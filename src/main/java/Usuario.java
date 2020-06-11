import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.time.LocalDate;
import java.util.Date;

public class Usuario {
	List<Sugerencia> sugerencias = new ArrayList<>();
	Sugerencia sugerenciaDelDia;
	String ciudad;
	Map<String,List<String>> alertas;
	String mail;
	
	
	public Usuario(List<Sugerencia> sugerencias, Sugerencia sugerenciaDelDia, String ciudad, String mail){
		this.sugerenciaDelDia = sugerenciaDelDia;
		this.sugerencias = sugerencias;
		this.ciudad = ciudad;
		this.mail = mail;
	}
	
	public void addSugerencias(List<Sugerencia> nuevasSugerencias) {
		Random randomizer = new Random();
		sugerencias.addAll(nuevasSugerencias);
		sugerenciaDelDia = sugerencias.get(randomizer.nextInt(sugerencias.size()));
	}

	@SuppressWarnings("unchecked")
	public void setAlertas(Map<String, List<String>> nuevasAlertas) {
		((List<String>) alertas).addAll((Collection<? extends String>) nuevasAlertas);
		if(alertas == null) {
			throw new RuntimeException("No hay alertas metereológicas.");
		}
		
		if(alertas.containsValue("STORM")) {
			NotificationService.notify("Hay alerta de tormenta, lleve paraguas.");
		}
		
		if(alertas.containsValue("HAIL")) {
			NotificationService.notify("Hay alerta de granizo. No salga en auto.");
		}
		
		MailSender.send(mail,alertas);
	}
	
	public void actualizarSugerenciaDiaria(Sugerencia sugerencia){
		sugerenciaDelDia = sugerencia;
	}
	
	public String getCiudad(){
		return ciudad;
	}
}
