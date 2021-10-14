package structure;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Room {

	@Id
	private String roomCode;

	@ManyToOne
	@JoinColumn(name = "rule", referencedColumnName = "ruleCode")
	private Rule rule;

	@OneToMany
	@JoinColumn(name = "room", referencedColumnName = "roomCode")
	private List<Bed> beds;

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

	public List<Bed> getBeds() {
		return beds;
	}

	public void setBeds(List<Bed> beds) {
		this.beds = beds;
	}

	public Room(String roomCode, Rule rule, List<Bed> beds) {
		this.roomCode = roomCode;
		this.rule = rule;
		this.beds = beds;
	}

	public void register(Room room, Sector sector) {

	}

	public List<Room> list() {

		return new ArrayList<Room>();
	}

}
