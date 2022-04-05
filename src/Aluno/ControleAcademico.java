package projeto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControleAcademico  {

	private List<Aluno> alunos;

	public ControleAcademico() {
		this.alunos = new ArrayList();
	}
	
	public void adicionarAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	public List<Aluno> getAlunosPorCurso(String curso){
		List<Aluno> result = alunos.stream()
				.filter(aluno -> aluno.getCurso().startsWith(curso))
				.collect(Collectors.toList());
		return result;
	}
	
	public int getQuantidadeDeAprovados() {
		List<Aluno> result = alunos.stream()
				.filter(aluno -> aluno.getMedia() >= 7)
				.collect(Collectors.toList());
		return result.size();
	}

	public List<Aluno> getAlunosOrdenadosPorNome( ){
		List<Aluno> alunosOrdenados = new ArrayList(this.alunos);
		alunosOrdenados.sort(new AlunoNomeComparator());
		return alunosOrdenados;
	}
	
	public List<Aluno> getAlunosOrdenadosPorMediaDesc( ){
		List<Aluno> alunosOrdenados = new ArrayList(this.alunos);
		alunosOrdenados.sort(new AlunoMediaComparator());
		return alunosOrdenados;
	}

	
	
	

}
