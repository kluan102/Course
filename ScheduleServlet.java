


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);	
		ArrayList<Course> courseList =(ArrayList<Course>)session.getAttribute("course");
		
		if (courseList ==null) {
			courseList= new ArrayList<Course>();
		}
		
		String courseName = request.getParameter("courseName");
		String professor = request.getParameter("professor");
		String roomNumber = request.getParameter("roomNumber");
		String startDate = request.getParameter("startDate");
		String time= request.getParameter("time");
		String[] weekdays = request.getParameterValues("weekday");
		WeekDay [] occurrences = new WeekDay[weekdays.length];
		for (int i=0; i<weekdays.length; i++) {
			String test= weekdays[i].toLowerCase();
			switch (test)
			{
				case "monday":
					occurrences[i]= WeekDay.MONDAY;
					break;
				case "tuesday":
					occurrences[i]= WeekDay.TUESDAY;
					break;
				case "wednesday":
					occurrences[i]= WeekDay.WEDNESDAY;
					break;
				case "thursday":
					occurrences[i]= WeekDay.THURSDAY;
					break;
				case "friday":
					occurrences[i]= WeekDay.FRIDAY;
					break;
			}
		}
		Course course= new Course();
		
		course.setCourseName(courseName);
		course.setProfessor(professor);
		course.setRoomNumber(roomNumber);
		course.setStartDate(startDate);
		course.setTime(time);
		course.setOccurrences(occurrences);
		courseList.add(course);
		session.setAttribute("course", courseList);
		//List<Course> courses= new ArrayList<Course>;
		
		
		
		RequestDispatcher rs = request.getRequestDispatcher("course.jsp");
		rs.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
