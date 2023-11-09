package br.edu.ifce.TimetableScheduler.exceptions;

public class ScheduleNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ScheduleNotFoundException (Long id) {
		super("Não foi possível encontrar o horário de id: " + id);
	}

}
