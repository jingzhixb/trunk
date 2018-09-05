package com.zhuye.ershoufang;

import android.util.Log;

import com.zhuye.ershoufang.bean.Common3Bean;
import com.zhuye.ershoufang.bean.Common5Bean;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void time() throws Exception {
        //assertEquals(4, 2 + 2);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        //simpleDateFormat.format(new Date());
        Log.i("as",simpleDateFormat.format(new Date()));
    }

    @Test
    public void time2() throws Exception {
        //assertEquals(4, 2 + 2);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
//        //simpleDateFormat.format(new Date());
//        Log.i("as",simpleDateFormat.format(new Date()));

        List  dd = new ArrayList();
        dd.add(new Common5Bean());
        dd.add(new Common5Bean());
        dd.add(new Common5Bean());

        
        List  dd1 = new ArrayList();
        dd1.add(new Common3Bean());
        dd1.add(new Common3Bean());
        dd1.add(new Common3Bean());

        List<Common3Bean> temp = null;

        try {
            temp = dd;
        }catch (ClassCastException e){

        }

    }
}