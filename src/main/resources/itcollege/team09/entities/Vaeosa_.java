package itcollege.team09.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-12-19T23:33:45.375+0200")
@StaticMetamodel(Vaeosa.class)
public class Vaeosa_ extends Piirivalve_ {
	public static volatile SingularAttribute<Vaeosa, String> kood;
	public static volatile SingularAttribute<Vaeosa, String> nimetus;
	public static volatile SingularAttribute<Vaeosa, Date> alates;
	public static volatile SingularAttribute<Vaeosa, Date> kuni;
	public static volatile SingularAttribute<Vaeosa, AdminYksus> adminYksus;
	public static volatile CollectionAttribute<Vaeosa, VaeosaAlluvus> ylemvaeosad;
	public static volatile CollectionAttribute<Vaeosa, VaeosaAlluvus> alamvaeosad;
}
