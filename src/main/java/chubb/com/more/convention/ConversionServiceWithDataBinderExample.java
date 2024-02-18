package chubb.com.more.convention;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.validation.DataBinder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class ConversionServiceWithDataBinderExample {
    public static void main(String[] args) throws ParseException {

        MutablePropertyValues mpv = new MutablePropertyValues();

        Date date = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a")
                .parse("01/20/2022 00:00:00 AM");
        mpv.add("date", date);

        DataBinder dataBinder = new DataBinder(new MyObject());
        DefaultConversionService service = new DefaultConversionService();
        service.addConverter(new DateToLocalDateTimeConverter());
        //commenting the following line will not populate date field
        dataBinder.setConversionService(service);

        dataBinder.bind(mpv);
        dataBinder.getBindingResult()
                .getModel()
                .entrySet()
                .forEach(System.out::println);
    }
}