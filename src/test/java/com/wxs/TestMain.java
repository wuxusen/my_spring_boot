package com.wxs;

import com.wxs.model.Person;
import org.joda.time.DateTime;
import org.junit.Test;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;
import org.objenesis.instantiator.ObjectInstantiator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/10.
 */
public class TestMain {




    @Test
    public void testDate(){
        LocalDate date = LocalDate.of(2017,1,21); //2017-01-21



    }

    @Test
    public void testmo(){
        int i = 646504 / 10000;
        System.out.println(i);

    }


    @Test
    public void getDate(){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        Date dateStart = new DateTime(year, month + 1, day, 0, 0, 0).toDate();
        Date dateEnd = new DateTime(year, month + 1, day, 23, 59, 59).toDate();

        System.out.println(dateStart);
        System.out.println(dateEnd);

    }


    @Test
    public void Testobjenesis(){
        Objenesis objenesis = new ObjenesisStd(); // or ObjenesisSerializer
        Person person = (Person) objenesis.newInstance(Person.class);

        System.out.println(person);
        // or (a little bit more efficient if you need to create many objects)

        Objenesis objenesis1 = new ObjenesisStd(); // or ObjenesisSerializer
        ObjectInstantiator thingyInstantiator = objenesis1.getInstantiatorOf(Person.class);



        Person thingy2 = (Person)thingyInstantiator.newInstance();
        Person thingy3 = (Person)thingyInstantiator.newInstance();
        Person thingy4 = (Person)thingyInstantiator.newInstance();

        System.out.println(thingy2);
        System.out.println(thingy3);
        System.out.println(thingy4);

    }

    @Test
    public void testD(){
        boolean b = new BigDecimal("500").divideAndRemainder(new BigDecimal("100"))[1].compareTo(BigDecimal.ZERO) == 0;
        System.out.println(b);
    }


    @Test
    public  void test01(){
        String[] str = new String[]{"asdf"};
        String s = str[0];
        System.out.println(s);
    }

    public void testMa(){
        Map<String ,String> map = new HashMap<>();




    }





}
