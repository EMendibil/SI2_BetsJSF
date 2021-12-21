package bean.eredua;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.event.SelectEvent;


import eredua.businessLogic.BLFacade;
import eredua.domeinua.Event;
import eredua.domeinua.Question;
import eredua.domeinua.User;
import eredua.exceptions.EventFinished;
import eredua.exceptions.QuestionAlreadyExist;
import eredua.exceptions.userExistsException;



public class QueryQuestionsBean {

	private BLFacade facadeBL; 
	private static List<Event> gertaerak = new Vector<Event>();
	private Event gertaera;
	private List<Question> galderak = new Vector<Question>();
	private Question galdera;
	private Date data;
	private float minBet;
	private String questionValue;
	
	private String userlog;
	private String passlog;
	
	private String userreg;
	private String passreg;
	
	private double dirKop;
	private int usMota;


	public QueryQuestionsBean() {
		facadeBL = FacadeBean.getBusinessLogic();
	}

	public List<Event> getGertaerak() {
		return gertaerak;
	}

	public void setGertaerak(Vector<Event> gertaerak) {
		this.gertaerak = gertaerak;
	}

	public List<Question> getGalderak() {
		return galderak;
	}

	public void setGalderak(Vector<Question> galderak) {
		this.galderak = galderak;
	}

	public Question getGaldera() {
		return galdera;
	}

	public void setGaldera(Question galdera) {
		this.galdera = galdera;
	}

	public String getItzuli() {
		return "return";
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Event getGertaera() {
		return gertaera;
	}

	public void setGertaera(Event gertaera) {
		this.gertaera = gertaera;
	}
	
	public static Event getObject(String gertaera) {
		for (Event e : gertaerak) {
			if (gertaera.equals(e.getDescription()))
				return e;
		}
		return null;
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selected date: " + event.getObject()));
		this.gertaerak = facadeBL.getEvents((Date) event.getObject());
	}

	public void onEventSelect(SelectEvent event) {
		this.galderak = this.gertaera.getQuestions();
		this.gertaera = (Event) event.getObject();
		FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
				new FacesMessage("Selected event: " + gertaera.getDescription()));

	}

	public void onQuestionSelect(SelectEvent event) {
		this.galdera = (Question) event.getObject();
		FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
				new FacesMessage("Selected question: " + galdera.getQuestion()));
	}

	public void listener(AjaxBehaviorEvent event) {
		// FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selected
		// event: "));
		this.gertaera = (Event) event.getSource();
	}

	public float getMinBet() {
		return minBet;
	}

	public void setMinBet(float minBetValue) {
		this.minBet = minBetValue;
	}

	public String getQuestionValue() {
		return questionValue;
	}

	public void setQuestionValue(String questionValue) {
		this.questionValue = questionValue;
	}

	public void createQuestion() {
		try {
			facadeBL.createQuestion(this.gertaera, this.questionValue, this.minBet);
		} catch (EventFinished e) {
			FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
					new FacesMessage("Gertaera jada bukatu da."));
		} catch (QuestionAlreadyExist e) {
			FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
					new FacesMessage("Galdera hori jada sortuta dago."));
		}
		FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
				new FacesMessage("Question created: " + this.questionValue));
	}
	
	public String getShEvents(){
		return "show";
	}
	
	public String login() {
		try {
			User u = facadeBL.login(this.userlog, this.passlog);
			this.userlog= u.getUserName();
			this.passlog= u.getPasahitza();
			this.usMota= u.getMota();
			this.dirKop= u.getDirKop();
		} catch (userExistsException e) {
			FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
					new FacesMessage("Izena edo pasahitza okerra da."));
		}
		
		return this.getItzuli();
	}
	public String register() {
		try {
			User u = facadeBL.register(this.userreg, this.passreg);
			this.userlog= u.getUserName();
			this.passlog= u.getPasahitza();
			this.usMota= u.getMota();
			this.dirKop= u.getDirKop();
		} catch (userExistsException e) {
			FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
					new FacesMessage("Erabiltzaile hori jada existitzen da."));
		}
		return this.getItzuli();
	}
	
	public String goLogin(){
		return "login";
	}
	
	public String goRegister(){
		return "register";
	}
	
	public void diruaSartu() {
		if(this.dirKop < 0) {
			FacesContext.getCurrentInstance().addMessage("nireForm:mezuak",
					new FacesMessage("Erabiltzaile hori jada existitzen da."));
		}
		else {
			double dirTot = facadeBL.diruaSartu(this.userlog, this.dirKop);
			this.dirKop= dirTot;
		}
			
	}
}
