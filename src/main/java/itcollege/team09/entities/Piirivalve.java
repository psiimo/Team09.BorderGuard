package itcollege.team09.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;


@MappedSuperclass
@RooToString
@Transactional
@RooEntity(mappedSuperclass = true)
public abstract class Piirivalve {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    	
	@Size(max=500)
	@NotNull
    private String kommentaar;    
    @Size(max=32)
    protected String avaja;    
    @DateTimeFormat(style="M-")
    protected Date avatud;        
    @Size(max=32)
    protected String muutja;    
    @DateTimeFormat(style="M-")
    protected Date muudetud;        
    @Size(max=32)
    protected String sulgeja;    
    @DateTimeFormat(style="M-")
    protected Date suletud;

        
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKommentaar() {
		return kommentaar;
	}
	public void setKommentaar(String kommentaar) {
		this.kommentaar = kommentaar;
	}	
	
	public static final Calendar surrogate;

	static {
		surrogate = Calendar.getInstance();

		surrogate.set(Calendar.YEAR, 9999);
		surrogate.set(Calendar.MONTH, Calendar.DECEMBER);
		surrogate.set(Calendar.DATE, 31);

		surrogate.set(Calendar.HOUR_OF_DAY, 0);
		surrogate.set(Calendar.MINUTE, 0);
		surrogate.set(Calendar.SECOND, 0);
		surrogate.set(Calendar.MILLISECOND, 0);
	}
	
	@PrePersist	
	public void recordCreated() {	
		String user = GetUser();
		Long date = GetDate();
		
		this.avaja = user;
		this.muutja = user;
		
		this.avatud = new Date(date);
		this.muudetud = new Date(date);
		
		if (suletud == null) {
			suletud = surrogate.getTime();
		} else {
			sulgeja = GetUser();
		}
	}

	@PreUpdate	
	public void recordModified() {	
		this.muutja = GetUser();
		this.muudetud = new Date(GetDate());	
	}	
	
	@PreRemove	
	public void preventRemove() {
		if(suletud != null)
			throw new SecurityException("Seda objekti ei saa enam muuta!");
	}
	
	public void close() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		suletud = new Date();
		sulgeja = auth.getName();
	}

	@Transactional
	public void remove() {
		close();

		if (this.entityManager == null)
			this.entityManager = entityManager();

		entityManager.persist(this);
	}

	@Transactional
	public Piirivalve merge() {
		if (this.entityManager == null)
			this.entityManager = entityManager();

		if (id != null && !entityManager.contains(this)) {
			Piirivalve oldEntity = entityManager.find(getClass(), id);
			oldEntity.close();

			if (avatud == null) {
				avatud = oldEntity.avatud;
				avaja  = oldEntity.avaja;
			}
			
			suletud = null;
			sulgeja = null;

			clearId();
			persist();
			
			return this;
		}

		Piirivalve merged = entityManager.merge(this);
		entityManager.flush();
		return merged;
	}
	
	public void clearId()
	{
		this.id = null;
	}
	
	private String GetUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth.getName();
	}	
	
	private Long GetDate() {
		Date now = new Date();
		return now.getTime();
	}	
}
