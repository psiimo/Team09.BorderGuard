package itcollege.team09.web;

import itcollege.team09.entities.AdminAlluvus;
import itcollege.team09.entities.AdminYksus;
import itcollege.team09.entities.AdminYksuseLiik;
import itcollege.team09.entities.Vaeosa;
import itcollege.team09.entities.VaeosaAlluvus;
import itcollege.team09.entities.VoimalikAlluvus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.roo.addon.web.mvc.controller.RooConversionService;

/**
 * A central place to register application converters and formatters. 
 */
@RooConversionService
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(new AdminAlluvusConverter());
        registry.addConverter(new AdminYksusConverter());
        registry.addConverter(new AdminYksuseLiikConverter());
        registry.addConverter(new VaeosaConverter());
        registry.addConverter(new VaeosaAlluvusConverter());
        registry.addConverter(new VoimalikAlluvusConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }

	static class AdminAlluvusConverter implements Converter<AdminAlluvus, String> {
        public String convert(AdminAlluvus adminAlluvus) {
            return new StringBuilder().append(adminAlluvus.getKommentaar()).append(" ").append(adminAlluvus.getAlates()).append(" ").append(adminAlluvus.getKuni()).toString();
        }
        
    }

	static class AdminYksusConverter implements Converter<AdminYksus, String> {
        public String convert(AdminYksus adminYksus) {
            return new StringBuilder().append(adminYksus.getNimetus()).toString();
        }
        
    }

	static class AdminYksuseLiikConverter implements Converter<AdminYksuseLiik, String> {
        public String convert(AdminYksuseLiik adminYksuseLiik) {
            return new StringBuilder().append(adminYksuseLiik.getNimetus()).toString();
        }
        
    }

	static class VaeosaConverter implements Converter<Vaeosa, String> {
        public String convert(Vaeosa vaeosa) {
            return new StringBuilder().append(vaeosa.getNimetus()).toString();
        }
        
    }

	static class VaeosaAlluvusConverter implements Converter<VaeosaAlluvus, String> {
        public String convert(VaeosaAlluvus vaeosaAlluvus) {
            return new StringBuilder().append(vaeosaAlluvus.getKommentaar()).append(" ").append(vaeosaAlluvus.getAlates()).append(" ").append(vaeosaAlluvus.getKuni()).toString();
        }
        
    }

	static class VoimalikAlluvusConverter implements Converter<VoimalikAlluvus, String> {
        public String convert(VoimalikAlluvus voimalikAlluvus) {
            return new StringBuilder().append(voimalikAlluvus.getKommentaar()).append(" ").append(voimalikAlluvus.getAlates()).append(" ").append(voimalikAlluvus.getKuni()).toString();
        }
        
    }
}
