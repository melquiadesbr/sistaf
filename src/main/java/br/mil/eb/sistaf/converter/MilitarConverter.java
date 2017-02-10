package br.mil.eb.sistaf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.repository.Militares;

@FacesConverter(forClass = Militar.class)
public class MilitarConverter implements Converter {

	@Inject
	private Militares militares;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Militar retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = militares.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Militar militar = (Militar) value;
			return militar.getId() == null ? null : militar.getId().toString();
		}
		
		return "";
	}

}
