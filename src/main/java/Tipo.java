import java.util.ArrayList;
import java.util.List;

public abstract class Tipo {
	Categoria categoria;
	List<Material> materialesAdecuados = new ArrayList<>();
	abstract List<Material> getMaterialesAdecuados();
	abstract boolean coincideCategoria();
	Categoria getCategoria(){return categoria;}
}

class Zapato extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.CUERO);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.CALZADO; }
}

class Camisa extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Pantalon extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.PARTEINFERIOR; }
}

class Buzo extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.LANA);
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Remera extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.FIBRA);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.PARTESUPERIOR; }
}

class Medias extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.ALGODON);
		materialesAdecuados.add(Material.LANA);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.PARTEINFERIOR; }
}

class Anteojos extends Tipo{
	List<Material> getMaterialesAdecuados(){
		materialesAdecuados.clear();
		materialesAdecuados.add(Material.VIDRIO);
		materialesAdecuados.add(Material.PLASTICO);
		return materialesAdecuados;
	}
	boolean coincideCategoria(){ return categoria == Categoria.ACCESORIO; }
}