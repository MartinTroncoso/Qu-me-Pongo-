public class Prenda{
	Tipo tipo;
	Trama trama = Trama.LISA;
	Material material;
	Color colorPrincipal;
	Color colorSecundario;
	Criterio criterio;
	int temperaturaMaximaAdecuada;
	double costo;
	
	@SuppressWarnings("unused")
	Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario, Criterio criterio, int temperaturaMaximaAdecuada, double costo){
		
		//SI POR EJEMPLO UNA REMERA TIENE LA CATEGORIA DE CALZADO, NO SE ANIADE AL ATUENDO
		if(!tipo.coincideCategoria()){
			throw new RuntimeException("La categoria de la prenda no es la real");
		}
	
		//SE VERIFICA QUE LA PRENDA TENGA DEFINIDAS SUS CARACTERISTICAS
		if(tipo.getCategoria() == null){
			throw new RuntimeException("La categoria es obligatoria");
		}
		
		if(colorPrincipal == null){
			throw new RuntimeException("El color principal es obligatorio");
		}
		
		if(colorSecundario == null){
			throw new RuntimeException("El material es obligatorio");
		}
		
		if(tipo == null){
			throw new RuntimeException("El tipo es obligatorio");
		}
		
		//SI EL MATERIAL QUE SE LE DEFINE A LA PRENDA NO ESTA ENTRE LOS ADECUADOS PARA SU TIPO, SE LANZA LA EXCEPCION
		if(!tipo.getMaterialesAdecuados().contains(material)) {
			throw new RuntimeException("El material de la prenda es inconsistente con su tipo");
		}
		
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = colorPrincipal;
		this.colorSecundario = colorSecundario;
		this.criterio = criterio;
		this.temperaturaMaximaAdecuada = temperaturaMaximaAdecuada;
		this.costo = costo;	
	}
	
	String caracteristicas(){
		if(colorPrincipal == colorSecundario){
			return "El tipo de la prenda es " + tipo +  ", su categoria es "+ tipo.getCategoria() + ", su material es " + material + "su color principal es " + colorPrincipal + " y no tiene color secundario."; 
		}
		else
		{
			return "El tipo de la prenda es " + tipo + ", su categoria es "+ tipo.getCategoria() + ", su material es " + material + "su color principal es " + colorPrincipal + " y el secundario " + colorSecundario;
		}
	}

	Tipo getTipo(){return tipo;}
	Trama getTrama(){return trama;}
	Material getMaterial(){return material;}
	Color getColorPrincipal(){return colorPrincipal;}
	Color getColorSecundario(){return colorSecundario;}
	Criterio getCriterio(){return criterio;}
	int getTemperaturaMaximaAdecuada(){return temperaturaMaximaAdecuada;}
	double getCosto(){return costo;}
}