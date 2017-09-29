package com.teste.model;

public final class Usuario extends Pessoa {
	private int id;
	private String login;
	private String senha;
	private String fraseRec;
	
	//Getters e Setters
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getFraseRec() {
		return fraseRec;
	}
	public void setFraseRec(String fraseRec) {
		this.fraseRec = fraseRec;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fraseRec == null) ? 0 : fraseRec.hashCode());
		result = prime * result + id;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (fraseRec == null) {
			if (other.fraseRec != null)
				return false;
		} else if (!fraseRec.equals(other.fraseRec))
			return false;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", senha=" + senha + ", fraseRec=" + fraseRec + ", nome="
				+ nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", endereco=" + endereco + ", email="
				+ email + "]";
	}

	
	
	
	
}
