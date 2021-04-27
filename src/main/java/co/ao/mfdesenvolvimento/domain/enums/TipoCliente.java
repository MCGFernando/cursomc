package co.ao.mfdesenvolvimento.domain.enums;

public enum TipoCliente {
	PESSOAFISICA(1, "Pessoa Fisica"),
	PESSOAJURIDICA(2, "Pessoa Juridica");
	
	private int cod;
	private String descricao;
	
	private TipoCliente(int cod , String descriacao) {
		this.cod = cod;
		this.descricao = descriacao;
	}

	public int getCod() {
		return cod;
	}

	
	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {
		if(cod==null) {
			return null;
		}
		for (TipoCliente x : TipoCliente.values()) {
			if ( cod.equals(x.getCod())) return x;
		}
		
		throw new IllegalArgumentException("Id Inválido: " + cod);
	}
	
}
