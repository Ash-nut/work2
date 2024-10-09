package org.example.gq.bean;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
@SpringBootTest
public class StringBenchmark {

    @Test
    @Benchmark
    public void testString() {
        String s = "aa";
        for (int i = 0; i < 100000; i++) {
            s += "bb";
        }
    }
    @Test
    @Benchmark
    public void testStringBuffer() {
        StringBuffer sb = new StringBuffer("aa");
        for (int i = 0; i < 100000; i++) {
            sb.append("bb");
        }
    }
}
