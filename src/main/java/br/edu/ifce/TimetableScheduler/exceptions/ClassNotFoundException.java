package br.edu.ifce.TimetableScheduler.exceptions;

public class ClassNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClassNotFoundException(Long id) {
		super("Não foi possível encontrar a turma de id: " + id);
	}

}
