package br.edu.ifce.TimetableScheduler.exceptions;

public class DisciplineNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DisciplineNotFoundException(Long id) {
		super("Não foi possível encontrar a disciplina de id: " + id);
	}
}
