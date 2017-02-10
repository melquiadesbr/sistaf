package br.mil.eb.sistaf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.mil.eb.sistaf.model.Pretaf;
import br.mil.eb.sistaf.model.Taf;
import br.mil.eb.sistaf.repository.Pretafs;

@FacesConverter(forClass = Pretaf.class)
public class PretafConverter implements Converter {

	@Inject
	private Pretafs pretafs;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Pretaf retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = pretafs.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Pretaf pretaf = (Pretaf) value;
			return pretaf.getId() == null ? null : pretaf.getId().toString();
		}
		
		return "";
	}

}
