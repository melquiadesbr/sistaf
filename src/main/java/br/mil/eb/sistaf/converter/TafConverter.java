package br.mil.eb.sistaf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.repository.Tafs;

@FacesConverter(forClass = Taf.class)
public class TafConverter implements Converter {

	@Inject
	private Tafs tafs;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Taf retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = tafs.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Taf taf = (Taf) value;
			return taf.getId() == null ? null : taf.getId().toString();
		}
		
		return "";
	}

}
