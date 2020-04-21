import java.util.ArrayList;
import java.util.List;

enum Color{ AZUL,ROJO,AMARILLO,VERDE,NEGRO,BLANCO,NARANJA,VIOLETA; }

enum Trama{ LISA,RAYADA,CON_LUNARES,A_CUADROS,ESTAMPADO; }

enum Categoria{ PARTESUPERIOR,CALZADO,PARTEINFERIOR,ACCESORIO; }

enum Material{ CUERO,FIBRA,ALGODON,LANA,VIDRIO,PLASTICO; }

abstract class Tipo{
	Categoria categoria;
	List<Material> materialesAdecuados = new ArrayList<>();
	abstract List<Material> getMaterialesAdecuados();
	abstract boolean coindiceCategoria();
	Categoria getCategoria(){return categoria;}
}

class Prenda{
	public static void main(String[] args) {}
	
	Tipo tipo;
	Trama trama = Trama.LISA;
	Material material;
	Color colorPrincipal;
	Color colorSecundario;
	
	Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario){
		this.tipo = tipo;
		this.material = material;
		this.colorPrincipal = colorPrincipal;
		this.colorSecundario = colorSecundario;
	}
	
	{
		//SI POR EJEMPLO UNA REMERA TIENE LA CATEGORIA DE CALZADO, NO SE ANIADE AL ATUENDO
		if(!tipo.coindiceCategoria()){
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
			throw new RuntimeException("El material de la prenda es inconsistente con su tipo");}
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
}

class Uniforme{
	List<Prenda> prendas = new ArrayList<>();
	
	{
		//SI EL UNIFORME NO ESTA COMPUESTO POR TRES PRENDAS, SE LANZA UNA EXCEPCION
		if(prendas.size() != 3){
			throw new RuntimeException("El uniforme debe estar compuesto por TRES prendas");
		}
		
		//SI EL UNIFORME ESTA COMPUESTO POR TRES PRENDAS, PERO NO CUMPLE CON LOS REQUISITOS DE PARTESUPERIOR, INFERIOR Y/O CALZADO, SE LANZA UNA EXCEPCION
		if(prendas.stream().anyMatch(prenda->prenda.getTipo().getCategoria()==Categoria.PARTESUPERIOR) == false) {
			throw new RuntimeException("El uniforme debe tener una prenda de PARTESUPERIOR");
		}
		if(prendas.stream().anyMatch(prenda->prenda.getTipo().getCategoria()==Categoria.PARTEINFERIOR) == false) {
			throw new RuntimeException("El uniforme debe tener una prenda de PARTEINFERIOR");
		}
		if(prendas.stream().anyMatch(prenda->prenda.getTipo().getCategoria()==Categoria.CALZADO) == false) {
			throw new RuntimeException("El uniforme debe tener una prenda de CALZADO");
		}
	}
	
	void setPrendas(Prenda prenda){prendas.add(prenda);}
	List<Prenda> getPrendas(){return prendas;}
}

//ULTIMO REQUERIMIENTO DEL ENUNCIADO
class Colegio{
	Uniforme uniforme;
}

//TIPOS DE LAS PRENDAS
class Zapato extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.CUERO);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.CALZADO; }
}

class Camisa extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Pantalon extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.PARTEINFERIOR; }
}

class Buzo extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.LANA);
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Remera extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Medias extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.LANA);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.PARTEINFERIOR; }
}

class Anteojos extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.VIDRIO);
		materialesAdecuados.add(Material.PLASTICO);
		return materialesAdecuados;
	}
	boolean coindiceCategoria(){ return categoria == Categoria.ACCESORIO; }
}