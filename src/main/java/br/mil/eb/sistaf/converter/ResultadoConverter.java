package br.mil.eb.sistaf.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;

import br.mil.eb.sistaf.model.Militar;
import br.mil.eb.sistaf.model.Resultado;
import br.mil.eb.sistaf.repository.Militares;
import br.mil.eb.sistaf.repository.Resultados;

@FacesConverter(forClass = Resultado.class)
public class ResultadoConverter implements Converter {

	@Inject
	private Resultados resultados;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Resultado retorno = null;
		
		if (StringUtils.isNotEmpty(value)) {
			Long id = new Long(value);
			retorno = resultados.porId(id);
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Resultado resultado = (Resultado) value;
			return resultado.getId() == null ? null : resultado.getId().toString();
		}
		
		return "";
	}

}
