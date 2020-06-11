import java.util.List;

public class Sugerencia {
	List<Prenda> prendasSugeridas;
	
	public Sugerencia(List<Prenda> prendasSugeridas) {
		this.prendasSugeridas  = prendasSugeridas;
	}
	
	List<Prenda> getPrendaSugeridas(){
		return prendasSugeridas;
	}

}
