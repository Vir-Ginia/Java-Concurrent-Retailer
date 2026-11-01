# Concurrent Computer Retailer Simulation

A Java coursework project modelling computer assembly, testing, packaging and dispatch with concurrent workers.

## Project focus

The concurrent implementation uses bounded blocking queues to coordinate work between assembly and dispatch stages. It models producer/consumer behaviour, worker threads, interruption handling and a configurable simulation pipeline.

## Included source

- `coursework/MyComputerRetailer.java`: concurrent retailer implementation and main entry point.
- Additional assembler, packaging and dispatch workers in the `coursework` package.
- `SimulationParameters.java`: stage timing and queue-capacity settings.
- `factory`, `retailer` and `sequential` packages: supplied domain model and sequential reference implementation used by the coursework.
- Maven build files and Checkstyle configuration.

All Java packages are below `src/main/java/uk/ac/keele/csc20004/`.

## Build and run

The Maven project targets Java 11. From the repository root:

```bash
mvn package -DskipTests
java -cp target/classes uk.ac.keele.csc20004.coursework.MyComputerRetailer
```

The simulation starts long-running worker threads. Stop it with Ctrl+C. The full Maven verification lifecycle also applies the supplied Checkstyle rules.

## Provenance and scope

This repository preserves an academic submission together with the supporting coursework framework needed to understand and build it. The original starter README containing submission instructions and generated build artifacts are excluded. The supporting framework is not presented as entirely authored by Virginia.

The Java toolchain was unavailable in the upload environment, so compilation and runtime behaviour have not been reverified for this upload.
