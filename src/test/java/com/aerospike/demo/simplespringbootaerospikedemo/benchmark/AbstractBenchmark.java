package com.aerospike.demo.simplespringbootaerospikedemo.benchmark;

import com.aerospike.demo.simplespringbootaerospikedemo.SimpleSpringbootAerospikeDemoApplication;
import org.junit.Test;
import org.openjdk.jmh.profile.GCProfiler;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

abstract public class AbstractBenchmark {
    /**
     * Any benchmark, by extending this class, inherits this single @Test method for JUnit to run.
     * Enables reuse, should use it carefully in different test cases, where Options might need to differ.
     */
    @Test
    public void executeJmhRunner() throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(this.getClass().getSimpleName() )
                .measurementIterations(1)
                .forks(0) //0 makes debugging possible
                .shouldFailOnError(true)
                .addProfiler(GCProfiler.class)
                .build();
        new Runner(opt).run();
    }
}

