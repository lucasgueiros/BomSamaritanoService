package gueiros.lucas.bomsamaritano.service.util.ui;

public interface Formatador<Tipo> {

	public String formatarToString (Tipo tipo);
	public Tipo formatarToTipo (String entrada);
	public boolean isValid(String entrada);
	public void setPerdeuFoco(boolean valor);
	
}
