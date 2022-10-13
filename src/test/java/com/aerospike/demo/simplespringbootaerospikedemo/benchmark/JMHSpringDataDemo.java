package com.aerospike.demo.simplespringbootaerospikedemo.benchmark;

import com.aerospike.demo.simplespringbootaerospikedemo.SimpleSpringbootAerospikeDemoApplication;
import com.aerospike.demo.simplespringbootaerospikedemo.objects.User;
import com.aerospike.demo.simplespringbootaerospikedemo.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.concurrent.TimeUnit;



@SpringBootTest
@RunWith(SpringRunner.class)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.All)
@Warmup(timeUnit = TimeUnit.SECONDS)
@Measurement(timeUnit = TimeUnit.SECONDS)
public class JMHSpringDataDemo {

    volatile ConfigurableApplicationContext context;

    private UserService userService;

    final static int numberOfUsers = Integer.parseInt(System.getenv("numUsers"));

    @Test
    public void contextLoads() throws RunnerException {
        Options jmhRunnerOptions = new OptionsBuilder()
                .include("\\." + this.getClass().getSimpleName() + "\\.")
                .warmupIterations(Integer.parseInt(System.getenv("warmIterNum")))
                .warmupTime(TimeValue.valueOf(System.getenv("warmTime")))
                //.warmupMode(WarmupMode.BULK)
                .measurementIterations(Integer.parseInt(System.getenv("measurementIterations")))
                .forks(Integer.parseInt(System.getenv("forkNum")))
                .threads(Integer.parseInt(System.getenv("numThreads")))
                .shouldDoGC(true)
                .addProfiler(StackProfiler.class)
                .addProfiler(GCProfiler.class)
                 //  .addProfiler(LinuxPerfNormProfiler.class)
                 //      .addProfiler(LinuxPerfAsmProfiler.class)
                 //      .addProfiler(WinPerfAsmProfiler.class)
                 //      .addProfiler(DTraceAsmProfiler.class)
                .verbosity(VerboseMode.EXTRA)
                .jvmArgs("-Xmx10g")
                .jvmArgs("-XX:+UseG1GC")
                //.syncIterations(true)
                .shouldFailOnError(true)
                .resultFormat(ResultFormatType.TEXT)
                .result("/Users/dan/Documents/reports/"+ System.nanoTime()+ ".log")
                .jvmArgs("-server")
                .build();
        new Runner(jmhRunnerOptions).run();
    }

    @Setup
    public void setup() {
        this.context = new SpringApplication(SimpleSpringbootAerospikeDemoApplication.class).run();
        userService = this.context.getBean(UserService.class);
    }


    @Benchmark
    public String addUsers() {
        User user ;
        for (int i = 0; i < numberOfUsers; i++) {
            user = new User(i , "<User Name> ", "<User Email>", i+10);
            userService.addUser(user);
            //System.out.println("User-> " + user);
        }
        return "Success";
    }

    @Benchmark
    public String readUserById() {
        userService.readUserById(2);
        for (int i = 0; i < numberOfUsers; i++) {
            userService.readUserById(i);
        }
        return "Success";
    }

    @Benchmark
    public String removeUsers() {
        User user = null;
        for (int i=0 ; i<numberOfUsers;i++){
            userService.removeUserById(i);
        }
        return "Success";
    }

    @TearDown
    public void tearDown() {
        this.context.close();
    }
}
