package projeto;

import java.util.Comparator;

public class AlunoMediaComparator implements Comparator {
	
	@Override
	public int compare(Object aluno1, Object aluno2) {
		Aluno alunoCast1 = (Aluno) aluno1;
		Aluno alunoCast2 = (Aluno) aluno2;
		if(alunoCast1.getMedia() > alunoCast2.getMedia()) {
			return -1;
		}
		else if(alunoCast1.getMedia() < alunoCast2.getMedia()) {
			return 1;
		} else{
			return 0;
		}
	}

}
