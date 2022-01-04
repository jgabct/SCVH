package br.edu.ifs.academico.model.services;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.edu.ifs.academico.model.entities.Rule;


public class RuleInterpreter {

	public boolean isCapacityEnough(Rule rule, int turnIndex) {

		boolean allowed = false;

		List<String> capacityArgs = rule.getCapacityArgs();

		
		String[] args = capacityArgs.get(turnIndex).split(",");
		
		
		for(String arg : args) {
			
			
			
			if(arg.startsWith("maxv")) {
				
				int max = Integer.valueOf(arg.split("=")[1]);
				
				
			} else if(arg.startsWith("")) {
				
				
				
				
				
			}
			
		}
		
		
		return allowed;

	}

	public int allowedVisitTurn(Rule rule, LocalDateTime dateTime) {

		int allowed = -1;

		List<String> turnArgs = rule.getTurnArgs();

		for (int i = 0 ;i < turnArgs.size();i++) {

			String[] times = turnArgs.get(i).split("-");

			LocalTime startTime = LocalTime.of(Integer.valueOf(times[0].split(":")[0]),
					Integer.valueOf(times[0].split(":")[1]));
			LocalTime endTime = LocalTime.of(Integer.valueOf(times[1].split(":")[0]),
					Integer.valueOf(times[1].split(":")[1]));

			LocalTime visitTime = dateTime.toLocalTime();

			if (visitTime.isAfter(startTime) && visitTime.isBefore(endTime)) {

				allowed = i;
				break;

			} else if (visitTime.equals(startTime) || visitTime.equals(endTime)) {

				allowed = i;
				break;

			}

		}

		return allowed;

	}

}
