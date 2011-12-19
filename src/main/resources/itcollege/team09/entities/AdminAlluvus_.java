package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T23:33:44.656+0200")
@StaticMetamodel(AdminAlluvus.class)
public class AdminAlluvus_ extends Piirivalve_ {
	public static volatile SingularAttribute<AdminAlluvus, Date> alates;
	public static volatile SingularAttribute<AdminAlluvus, Date> kuni;
	public static volatile SingularAttribute<AdminAlluvus, AdminYksus> adminyksus;
	public static volatile SingularAttribute<AdminAlluvus, AdminYksus> alamadminyksus;
}
