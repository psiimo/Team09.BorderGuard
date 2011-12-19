package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T23:33:45.171+0200")
@StaticMetamodel(AdminYksus.class)
public class AdminYksus_ extends Piirivalve_ {
	public static volatile SingularAttribute<AdminYksus, String> kood;
	public static volatile SingularAttribute<AdminYksus, String> nimetus;
	public static volatile SingularAttribute<AdminYksus, Date> alates;
	public static volatile SingularAttribute<AdminYksus, Date> kuni;
	public static volatile CollectionAttribute<AdminYksus, Vaeosa> vaeosad;
	public static volatile CollectionAttribute<AdminYksus, AdminAlluvus> ylemadminyksused;
	public static volatile CollectionAttribute<AdminYksus, AdminAlluvus> alamadminyksused;
	public static volatile SingularAttribute<AdminYksus, AdminYksuseLiik> adminYksuseLiik;
}
