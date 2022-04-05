package projeto;

public class Main {

	public static void main(String[] args) {
		Aluno alunoTeste1 = new Aluno("Jaum", "Gastronomia", 2.0);
		Aluno alunoTeste2 = new Aluno("Duda", "Historia", 5.5);
		Aluno alunoTeste3 = new Aluno("Thamy", "Economia", 8.0);
		Aluno alunoTeste4 = new Aluno("Janny", "Medicina", 10.0);
		
		ControleAcademico c = new ControleAcademico();

		c.adicionarAluno(alunoTeste1);
		c.adicionarAluno(alunoTeste2);
		c.adicionarAluno(alunoTeste3);
		c.adicionarAluno(alunoTeste4);
		
		c.getAlunosPorCurso("Gastronomia");
		c.getAlunosPorCurso("Historia");
		c.getAlunosPorCurso("Economia");
		c.getAlunosPorCurso("MEDICINA");
		
		c.getAlunosOrdenadosPorNome();
		c.getAlunosOrdenadosPorMediaDesc();
	}

}
