package bean.eredua;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("EventConverter")
public class EventConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String newValue) throws ConverterException {
		return QueryQuestionsBean.getObject(newValue);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) throws ConverterException {
		if (value == null)
			return "";
		return value.toString();
	}
}