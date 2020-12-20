package sibsutis.labyrinth.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import sibsutis.labyrinth.commands.Command;
import sibsutis.labyrinth.commands.StartCommand;
import sibsutis.labyrinth.core.Labyrinth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static sibsutis.labyrinth.examples.LabyrinthExample.*;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
//@Warmup(iterations = 2)
//@Measurement(iterations = 10)
public class BenchmarkLabyrinth {
    private static final Command START_COMMAND = new StartCommand(message -> {
    });

    private List<Labyrinth> dataOne;
    private List<Labyrinth> dataTwo;
    private List<Labyrinth> dataThree;

    @Param({"1"})
    private int N;

    // mvn package
    // java -jar target/benchmarks.jar BenchmarkLabyrinth
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkLabyrinth.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void setup() {
        dataOne = createData(EXAMPLE_ONE);
        dataTwo = createData(EXAMPLE_TWO);
        dataThree = createData(EXAMPLE_THREE);
    }

    @Benchmark
    public void exampleOne(Blackhole bh) {
        for (Labyrinth labyrinth : dataOne) {
            START_COMMAND.execute("start", labyrinth);
        }
    }

    @Benchmark
    public void exampleTwo(Blackhole bh) {
        for (Labyrinth labyrinth : dataTwo) {
            START_COMMAND.execute("start", labyrinth);
        }
    }

    @Benchmark
    public void exampleThree(Blackhole bh) {
        for (Labyrinth labyrinth : dataThree) {
            START_COMMAND.execute("start", labyrinth);
        }
    }

    private List<Labyrinth> createData(Labyrinth src) {
        List<Labyrinth> labyrinths = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Labyrinth labyrinth = new Labyrinth(src.getWidth(), src.getHeight(),
                    Arrays.stream(src.getCore()).map(int[]::clone).toArray(int[][]::new));
            labyrinths.add(labyrinth);
        }
        return labyrinths;
    }

}
