package com.yjiuye.commons;
import org.springframework.core.convert.converter.Converter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTimeConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try{
            Date date = simpleDateFormat.parse(source);
            System.out.println(date);
            return date;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

    }
}
