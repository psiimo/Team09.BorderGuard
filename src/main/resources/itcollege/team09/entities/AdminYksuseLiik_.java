package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T23:33:45.187+0200")
@StaticMetamodel(AdminYksuseLiik.class)
public class AdminYksuseLiik_ extends Piirivalve_ {
	public static volatile SingularAttribute<AdminYksuseLiik, String> kood;
	public static volatile SingularAttribute<AdminYksuseLiik, String> nimetus;
	public static volatile SingularAttribute<AdminYksuseLiik, Date> alates;
	public static volatile SingularAttribute<AdminYksuseLiik, Date> kuni;
	public static volatile CollectionAttribute<AdminYksuseLiik, VoimalikAlluvus> ylemyksused;
	public static volatile CollectionAttribute<AdminYksuseLiik, VoimalikAlluvus> alamyksused;
	public static volatile CollectionAttribute<AdminYksuseLiik, AdminYksus> adminyksused;
}
