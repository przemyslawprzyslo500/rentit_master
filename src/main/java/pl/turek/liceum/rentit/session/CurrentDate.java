/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.transaction.Transactional;

/**
 *
 * @author miszcz
 */
@Named(value = "currentDate")
@RequestScoped
//@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Transactional

public class CurrentDate {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());

    }
}
