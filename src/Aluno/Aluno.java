package projeto;



public class Aluno {
	private String nome;
	private String curso;
	private double media;
	
	public Aluno(String nome, String curso, double media) {
		this.nome = nome;
		this.curso = curso;
		this.media = media;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	

}
