package heran�a;

public class Cachorro extends Animal{
	private String nome;
	private int idade;
		
	void correr() {
		System.out.println("O cachorro est� correndo...");
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
}


