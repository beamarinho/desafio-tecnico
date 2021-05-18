package model;

public class Pratos {
	private String nomePrato;
	private String tipoPrato;

	public Pratos(String nomePrato, String tipoPrato) {
		this.nomePrato = nomePrato;
		this.tipoPrato = tipoPrato;
	}

	public String getNomePrato() {
		return nomePrato;
	}

	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}

	public String getTipoPrato() {
		return tipoPrato;
	}

	public void setTipoPrato(String tipoPrato) {
		this.tipoPrato = tipoPrato;
	}

}
