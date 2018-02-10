package gueiros.lucas.bomsamaritano.service.util.restricoes;

public class NotEmptyNullableRestricao implements Restricao<String>{

	@Override
	public boolean verificar(String string) {
		return string == null || ! string.equals("");
	}
	
	public String restringir(String string) throws ForaDeRestricaoException {
		if(string != null && string.equals("")){
            return null;
        } else {
            return string;
        }
	}

	@Override
	public String getMensagemDeFalha(String string) {
		if(verificar(string)) return null;
		return "Nao pode ser vazio"; // TODO melhorar
	}

}
