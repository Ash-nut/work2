package org.example.gq;

import org.example.gq.bean.BaseT;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class test {
    private static final Logger log = LoggerFactory.getLogger(test.class);

    @Test
    public void dateTest()
    {
        LocalDate now = LocalDate.now();
        log.info(now.toString());
        log.info(String.valueOf(now.getDayOfMonth()));
        log.info(String.valueOf(now.getDayOfWeek()));
        log.info(String.valueOf(now.getDayOfYear()));
    }
    @Test
    public void testString(){
        log.info(String.valueOf("aa"=="aa"));
        log.info(String.valueOf("bb".equals("bb")));
        log.info(String.valueOf(new String("aa")== new String("aa")));
        log.info(String.valueOf(new String("aa").equals(new String("aa"))));
        StringBuffer sb = new StringBuffer("aa");
        //测试StringBuffer和String哪个更快
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            sb.append("bb");
        }
        long end = System.currentTimeMillis();
        log.info("StringBuffer:");
        log.info(String.valueOf(end-start));
        start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            String s = "aa";
            s += "bb";
        }
        end = System.currentTimeMillis();
        log.info("String:");
        log.info(String.valueOf(end-start));
    }
    @Test
    void testT(){
        BaseT<String,Integer,String,String> t = new BaseT<>();
        System.out.println(t.getClass());
    }
}
