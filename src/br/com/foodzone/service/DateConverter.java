package br.com.foodzone.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.caelum.vraptor.Convert;
import br.com.caelum.vraptor.Converter;

@Convert(Date.class)
public class DateConverter implements Converter<Date> {

	private static final List<String> dateFormats = Arrays.asList(
			"dd/MM/yyyy HH:mm:ss.SSS", "dd/MM/yyyy HH:mm:ss", "dd/MM/yyyy HH:mm", "dd/MM/yyyy", "MM/yyyy","yyyy-MM-dd" );

	@Override
	public Date convert(String valor, Class<? extends Date> classe,
			ResourceBundle resourceBundle) {
		
		return extrairData(valor);
	}

	private Date extrairData(String valor) {

		for (String format : dateFormats) {
			DateFormat formatador = new SimpleDateFormat(format);
			try {
				return formatador.parse(valor);
			} catch (ParseException e) {
//				e.printStackTrace();
			}
		}

		return null;
	}
}