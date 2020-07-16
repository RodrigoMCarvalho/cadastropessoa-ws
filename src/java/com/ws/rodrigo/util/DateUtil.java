package com.ws.rodrigo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateUtil extends XmlAdapter<String, Date>{
    
    private String pattern = "dd/MM/yyyy HH:mm:ss";
    
    public Date unmarshal (String dateString) throws ParseException {
        return new SimpleDateFormat(pattern).parse(dateString);
    }
    
    public String marshal(Date date) throws ParseException {
   return new SimpleDateFormat(pattern).format(date);
}
    
}
    