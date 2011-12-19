package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T17:55:40.703+0200")
@StaticMetamodel(Piirivalve.class)
public class Piirivalve_ {
	public static volatile SingularAttribute<Piirivalve, Long> id;
	public static volatile SingularAttribute<Piirivalve, String> kommentaar;
	public static volatile SingularAttribute<Piirivalve, String> avaja;
	public static volatile SingularAttribute<Piirivalve, Date> avatud;
	public static volatile SingularAttribute<Piirivalve, String> muutja;
	public static volatile SingularAttribute<Piirivalve, Date> muudetud;
	public static volatile SingularAttribute<Piirivalve, String> sulgeja;
	public static volatile SingularAttribute<Piirivalve, Date> suletud;
}
