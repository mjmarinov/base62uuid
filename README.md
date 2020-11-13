# base62uuid
UUID to Base62 encoder/decoder

## Building
Build the application using:
```
./gradlew clean build
```

## Usage

### Using the JAR file
The application can be executed either by manually starting the JAR package:
```
java -jar ./build/libs/base62uuid.jar
```
or using the `bash62uuid.sh` script, which does the same.

- If no arguments are provided, the appication generates a random UUID v4 and encodes it in Base62:
```bash
$ ./base62uuid.sh 
Generated UUID : 8248769f-2431-4dff-8fd4-4fa78d843d96
Base62 encoded : 3xq7KyGIsUJ3ATJhGwY4qU
```

- A custom UUID can be provided using the `-u uuid` command line arguments:
```bash
$ ./base62uuid.sh -u 18d1c007-8391-42a8-aab3-a38f8b976910
Provided UUID  : 18d1c007-8391-42a8-aab3-a38f8b976910
Base62 encoded : kpfeqrxz4YsCOeKW9VRfU
```

- Alternatively a Base62-encoded UUID can be provided using `-b base62`:
```bash
$ ./base62uuid.sh -b kpfeqrxz4YsCOeKW9VRfU
Provided Base62 : kpfeqrxz4YsCOeKW9VRfU
Decoded UUID    : 18d1c007-8391-42a8-aab3-a38f8b976910
```

### Using Gradle
The application can also be started using the the Gradle `run` task:
```
./gradlew run
```
In this case the command line arguments can be provided using the `--args` parameter:
```bash
$ ./gradlew run --args="-u 18d1c007-8391-42a8-aab3-a38f8b976910"
> Task :compileJava UP-TO-DATE
> Task :processResources UP-TO-DATE
> Task :classes UP-TO-DATE

> Task :run
Provided UUID  : 18d1c007-8391-42a8-aab3-a38f8b976910
Base62 encoded : kpfeqrxz4YsCOeKW9VRfU

BUILD SUCCESSFUL in 2s
3 actionable tasks: 1 executed, 2 up-to-date
```