package br.com.foodzone.service;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;
import br.com.caelum.vraptor.converter.ConversionError;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;

@Component
@Convert(Date.class)
@RequestScoped
public class MaskToDateConverter implements Converter<Date> {

	@Override
	public Date convert(String value, Class<? extends Date> type,
			ResourceBundle bundle) {
		
		if (StringUtils.isEmpty(value)) {
			return null;
		}

		Set<String> patterns = new HashSet<String>();
		patterns.add("dd/MM/yyyy HH:mm:ss");
		patterns.add("dd/MM/yyyy HH:mm");
		patterns.add("dd/MM/yyyy");		
		
		for(String pattern : patterns){
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
				return simpleDateFormat.parse(value);
			} catch (ParseException pe) {
				
			}
		}
		throw new ConversionError(MessageFormat.format(
				bundle.getString("is_not_a_valid_date"), value));
	}
}