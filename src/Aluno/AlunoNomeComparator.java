package projeto;

import java.util.Comparator;

public class AlunoNomeComparator implements Comparator {
	
	@Override
	public int compare(Object aluno1, Object aluno2) {
		Aluno alunoCast1 = (Aluno) aluno1;
		Aluno alunoCast2 = (Aluno) aluno2;
		return alunoCast1.getNome().compareTo(alunoCast2.getNome());
	}

}
