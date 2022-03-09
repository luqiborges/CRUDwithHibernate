package modelo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	String nome;
	Date data_nasc;
	String sexo;
	String logradouro;
	int numero;
	String setor;
	String cidade;
	String uf;
	
	public Usuario(){}
	
	public Usuario(String nome, Date data_nasc, String sexo, String logradouro, int numero, String setor, String cidade, String uf) {
		this.nome = nome;
		this.data_nasc = data_nasc;
		this.sexo = sexo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.setor = setor;
		this.cidade = cidade;
		this.uf = uf;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Override
	public String toString() {
		return "Usuario [id= " + id + ", nome= " + nome + ", data_nasc= " + data_nasc + ", sexo= " + sexo + ", logradouro= "
				+ logradouro + ", numero= " + numero + ", setor= " + setor + ", cidade= " + cidade + ", uf= " + uf + "]";
	}	
	
}
