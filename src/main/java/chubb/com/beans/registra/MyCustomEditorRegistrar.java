package chubb.com.beans.registra;


import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomNumberEditor;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class MyCustomEditorRegistrar implements PropertyEditorRegistrar {
    @Override
    public void registerCustomEditors (PropertyEditorRegistry registry) {
        NumberFormat numberFormat = new DecimalFormat("##,###.00");
        registry.registerCustomEditor(java.lang.Double.class,
                new CustomNumberEditor(java.lang.Double.class,
                        numberFormat, true));
    }
}