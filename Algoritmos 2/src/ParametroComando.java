
public class ParametroComando{
	private String nombreParametro;
	private String valorParametro;
	
	public ParametroComando(String nombreParametro, String valorParametro){
		this.nombreParametro = nombreParametro;
		this.valorParametro = valorParametro;
	}
	
	public String getNombreParametro() {
		return nombreParametro;
	}
	public void setNombreParametro(String nombreParametro) {
		this.nombreParametro = nombreParametro;
	}
	public String getValorParametro() {
		return valorParametro;
	}
	public void setValorParametro(String valorParametro) {
		this.valorParametro = valorParametro;
	}
	
	@Override
	public String toString(){
		return nombreParametro+":"+valorParametro;
	}
}
