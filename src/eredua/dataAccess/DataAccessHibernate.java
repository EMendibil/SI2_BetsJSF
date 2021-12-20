package eredua.dataAccess;

import java.io.File;
import java.util.ArrayList;
//hello
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;

import eredua.HibernateUtil;
import eredua.configuration.ConfigXML;
import eredua.configuration.UtilDate;
import eredua.domeinua.Event;
import eredua.domeinua.Question;
import eredua.domeinua.User;
import eredua.exceptions.QuestionAlreadyExist;
import eredua.exceptions.userExistsException;

/**
 * It implements the data access to the objectDb database
 */
public class DataAccessHibernate implements DataAccessInterface {
	protected static EntityManager  db;
	protected static EntityManagerFactory emf;


	ConfigXML c=ConfigXML.getInstance();

     public DataAccessHibernate(boolean initializeMode)  {
		
		System.out.println("Creating DataAccess instance => isDatabaseLocal: "+c.isDatabaseLocal()+" getDatabBaseOpenMode: "+c.getDataBaseOpenMode());

		//open(initializeMode);
		
		/*if (initializeMode)
			initializeDB();
		*/
	}

	public DataAccessHibernate()  {	
		 /* new DataAccessHibernate(false); */
	}
	
	
	/**
	 * This is the data access method that initializes the database with some events and questions.
	 * This method is invoked by the business logic (constructor of BLFacadeImplementation) when the option "initialize" is declared in the tag dataBaseOpenMode of resources/config.xml file
	 */	
	public void initializeDB(){
		
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		db.beginTransaction();
		
		try {

			
		   Calendar today = Calendar.getInstance();
		   
		   int month=today.get(Calendar.MONTH);
		   month+=1;
		   int year=today.get(Calendar.YEAR);
		   if (month==12) { month=0; year+=1;}  
	    
			Event ev1=new Event("Atlético-Athletic", UtilDate.newDate(year,month,17));
			Event ev2=new Event("Eibar-Barcelona", UtilDate.newDate(year,month,17));
			Event ev3=new Event("Getafe-Celta", UtilDate.newDate(year,month,17));
			Event ev4=new Event("Alavés-Deportivo", UtilDate.newDate(year,month,17));
			Event ev5=new Event("Español-Villareal", UtilDate.newDate(year,month,17));
			Event ev6=new Event("Las Palmas-Sevilla", UtilDate.newDate(year,month,17));
			Event ev7=new Event("Malaga-Valencia", UtilDate.newDate(year,month,17));
			Event ev8=new Event("Girona-Leganés", UtilDate.newDate(year,month,17));
			Event ev9=new Event("Real Sociedad-Levante", UtilDate.newDate(year,month,17));
			Event ev10=new Event("Betis-Real Madrid", UtilDate.newDate(year,month,17));

			Event ev11=new Event("Atletico-Athletic", UtilDate.newDate(year,month,1));
			Event ev12=new Event("Eibar-Barcelona", UtilDate.newDate(year,month,1));
			Event ev13=new Event("Getafe-Celta", UtilDate.newDate(year,month,1));
			Event ev14=new Event("Alavés-Deportivo", UtilDate.newDate(year,month,1));
			Event ev15=new Event("Español-Villareal", UtilDate.newDate(year,month,1));
			Event ev16=new Event("Las Palmas-Sevilla", UtilDate.newDate(year,month,1));
			

			Event ev17=new Event("Málaga-Valencia", UtilDate.newDate(year,month,28));
			Event ev18=new Event("Girona-Leganés", UtilDate.newDate(year,month,28));
			Event ev19=new Event("Real Sociedad-Levante", UtilDate.newDate(year,month,28));
			Event ev20=new Event("Betis-Real Madrid", UtilDate.newDate(year,month,28));
			
			Question q1;
			Question q2;
			Question q3;
			Question q4;
			Question q5;
			Question q6;
			
			User admin = new User("admin", "adminadmin", 1, 0.0); //Admin bat, QueryQuestions eta CreateQuestions-era sarbidea duena.
			db.persist(admin);
					
			if (Locale.getDefault().equals(new Locale("es"))) {
				q1=ev1.addQuestion("¿Quién ganará el partido?",1);
				q2=ev1.addQuestion("¿Quién meterá el primer gol?",2);
				q3=ev11.addQuestion("¿Quién ganará el partido?",1);
				q4=ev11.addQuestion("¿Cuántos goles se marcarán?",2);
				q5=ev17.addQuestion("¿Quién ganará el partido?",1);
				q6=ev17.addQuestion("¿Habrá goles en la primera parte?",2);
			}
			else if (Locale.getDefault().equals(new Locale("en"))) {
				q1=ev1.addQuestion("Who will win the match?",1);
				q2=ev1.addQuestion("Who will score first?",2);
				q3=ev11.addQuestion("Who will win the match?",1);
				q4=ev11.addQuestion("How many goals will be scored in the match?",2);
				q5=ev17.addQuestion("Who will win the match?",1);
				q6=ev17.addQuestion("Will there be goals in the first half?",2);
			}			
			else {
				q1=ev1.addQuestion("Zeinek irabaziko du partidua?",1);
				q2=ev1.addQuestion("Zeinek sartuko du lehenengo gola?",2);
				q3=ev11.addQuestion("Zeinek irabaziko du partidua?",1);
				q4=ev11.addQuestion("Zenbat gol sartuko dira?",2);
				q5=ev17.addQuestion("Zeinek irabaziko du partidua?",1);
				q6=ev17.addQuestion("Golak sartuko dira lehenengo zatian?",2);
				
			}
			
			
			db.persist(q1);
			db.persist(q2);
			db.persist(q3);
			db.persist(q4);
			db.persist(q5);
			db.persist(q6);
	
	        
			db.persist(ev1);
			db.persist(ev2);
			db.persist(ev3);
			db.persist(ev4);
			db.persist(ev5);
			db.persist(ev6);
			db.persist(ev7);
			db.persist(ev8);
			db.persist(ev9);
			db.persist(ev10);
			db.persist(ev11);
			db.persist(ev12);
			db.persist(ev13);
			db.persist(ev14);
			db.persist(ev15);
			db.persist(ev16);
			db.persist(ev17);
			db.persist(ev18);
			db.persist(ev19);
			db.persist(ev20);			
			
			db.getTransaction().commit();
			System.out.println("Db initialized");
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * This method creates a question for an event, with a question text and the minimum bet
	 * 
	 * @param event to which question is added
	 * @param question text of the question
	 * @param betMinimum minimum quantity of the bet
	 * @return the created question, or null, or an exception
 	 * @throws QuestionAlreadyExist if the same question already exists for the event
	 */
	public Question createQuestion(Event event, String question, float betMinimum) throws  QuestionAlreadyExist {
		System.out.println(">> DataAccess: createQuestion=> event= "+event+" question= "+question+" betMinimum="+betMinimum);
		
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		db.beginTransaction();
		
		Query qy = db.createQuery("from Event where eventNumber= :eventZenb");
		int zenb = event.getEventNumber();
		qy.setParameter("eventZenb", zenb);
		List evRes = qy.list();
		
		
		
		Event ev = (Event)evRes.get(0);
		
			
		if (ev.DoesQuestionExists(question)) throw new QuestionAlreadyExist(ResourceBundle.getBundle("Etiquetas").getString("ErrorQueryAlreadyExist"));
			
		db.getTransaction().begin();
		Question q = ev.addQuestion(question, betMinimum);
		db.persist(q);
		db.persist(ev); // db.persist(q) not required when CascadeType.PERSIST is added in questions property of Event class
							// @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.PERSIST)
		db.getTransaction().commit();
		return q;
		
	}
	
	/**
	 * This method retrieves from the database the events of a given date 
	 * 
	 * @param date in which events are retrieved
	 * @return collection of events
	 */
	public List<Event> getEvents(Date date) {
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		db.beginTransaction();
		
		System.out.println(">> DataAccess: getEvents");
		List<Event> res = new ArrayList<Event>();	
	 	
		Query qy = db.createQuery("from Event where eventDate= :eventData");
		qy.setParameter("eventData", date);
		List<Event> evRes = qy.list();
		db.getTransaction().commit();
		for (Event ev:evRes){
	 	   System.out.println(ev.toString());
		   res.add(ev);
		  }
	 	return res;
	}
	
	/**
	 * This method retrieves from the database the dates a month for which there are events
	 * 
	 * @param date of the month for which days with events want to be retrieved 
	 * @return collection of dates
	 */
	public List<Date> getEventsMonth(Date date) {
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		
		System.out.println(">> DataAccess: getEventsMonth");
		List<Date> res = null;	
		
		Date firstDayMonthDate= UtilDate.firstDayMonth(date);
		Date lastDayMonthDate= UtilDate.lastDayMonth(date);
		
		Query qy = db.createQuery("SELECT DISTINCT ev.eventDate FROM Event ev WHERE ev.eventDate BETWEEN :has and :buk");      
		qy.setParameter("has", firstDayMonthDate);
		qy.setParameter("buk", lastDayMonthDate);
		List<Date> dates = qy.list();
		
		
	 	 for (Date d:dates){
	 	   System.out.println(d.toString());		 
		   res.add(d);
		  }
	 	return res;
	}
	
	public User login (String userName, String pasahitza) throws userExistsException{
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		Query qy = db.createQuery("FROM User WHERE username= :izena and pasahitza= :pasahitza");
		qy.setParameter("izena", userName);
		qy.setParameter("pasahitza", pasahitza);
		List<User> emaitza = qy.list();
		if(emaitza != null){
			return emaitza.get(0);
		}
		else{
			throw new userExistsException("Erabiltzailea ez da existitzen!");
		}
	}
	
	public Boolean register (String userName, String pasahitza) throws userExistsException{
		Session db = HibernateUtil.getSessionFactory().getCurrentSession();
		db.beginTransaction();
		
		Query qy = db.createQuery("from User where userName= :izena");
		qy.setParameter("izena", userName);
		List uRes = qy.list();
		
		
		
		if(uRes != null){
			throw new userExistsException("Erabiltzailea jada existitzen da!");
		}
		db.getTransaction().begin();
		User u = new User(userName, pasahitza);
		db.persist(u);
			
		
		db.getTransaction().commit();
		return true;
	}
		
@Override
public void open(){
		
		System.out.println("Opening DataAccess instance => isDatabaseLocal: "+c.isDatabaseLocal()+" getDatabBaseOpenMode: "+c.getDataBaseOpenMode());

		String fileName=c.getDbFilename();
		
		
		if (c.isDatabaseLocal()) {
			  emf = Persistence.createEntityManagerFactory("objectdb:"+fileName);
			  db = emf.createEntityManager();
		} else {
			Map<String, String> properties = new HashMap<String, String>();
			  properties.put("javax.persistence.jdbc.user", c.getUser());
			  properties.put("javax.persistence.jdbc.password", c.getPassword());

			  emf = Persistence.createEntityManagerFactory("objectdb://"+c.getDatabaseNode()+":"+c.getDatabasePort()+"/"+fileName, properties);

			  db = emf.createEntityManager();
    	   }
		
	}

public boolean existQuestion(Event event, String question) {
	System.out.println(">> DataAccess: existQuestion=> event= "+event+" question= "+question);
	
	Session db = HibernateUtil.getSessionFactory().getCurrentSession();
	
	Query qy = db.createQuery("from Event where eventNumber= :eventZenb");
	int zenb = event.getEventNumber();
	qy.setParameter("eventZenb", zenb);
	List evRes = qy.list();
	
	Event ev = (Event)evRes.get(0);
	
	return ev.DoesQuestionExists(question);
	
}
	public void close(){
		db.close();
		System.out.println("DataBase closed");
	}

	

	@Override
	public void emptyDatabase() {
		
		File f=new File(c.getDbFilename());
		f.delete();
		File f2=new File(c.getDbFilename()+"$");
		f2.delete();
		
	}
	
}


