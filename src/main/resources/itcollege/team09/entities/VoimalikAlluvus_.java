package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T23:33:45.390+0200")
@StaticMetamodel(VoimalikAlluvus.class)
public class VoimalikAlluvus_ extends Piirivalve_ {
	public static volatile SingularAttribute<VoimalikAlluvus, Date> alates;
	public static volatile SingularAttribute<VoimalikAlluvus, Date> kuni;
	public static volatile SingularAttribute<VoimalikAlluvus, AdminYksuseLiik> yksuseliik;
	public static volatile SingularAttribute<VoimalikAlluvus, AdminYksuseLiik> alamyksus;
}
