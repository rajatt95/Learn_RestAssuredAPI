package apiTesting.pojo.assignment;

public class Education_Assignment {

	private String course;
	private String marks;

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public Education_Assignment(String course, String marks) {
		super();
		this.course = course;
		this.marks = marks;
	}

}
