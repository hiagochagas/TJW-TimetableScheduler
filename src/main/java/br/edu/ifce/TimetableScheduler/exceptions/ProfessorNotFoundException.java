package br.edu.ifce.TimetableScheduler.exceptions;

public class ProfessorNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProfessorNotFoundException(Long id) {
		super("Não foi possível encontrar o professor de id: " + id);
	}

}
