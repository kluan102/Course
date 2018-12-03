import java.sql.Time;

public class Course {
	private String courseName;
	private String professor;
	private WeekDay[] occurrences;
	private String time;
	private String roomNumber;
	private String startDate;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public WeekDay[] getOccurrences() {
		return occurrences;
	}
	public void setOccurrences(WeekDay[] occurrences) {
		this.occurrences = occurrences;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	
}
