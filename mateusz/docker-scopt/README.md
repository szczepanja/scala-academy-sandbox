# Args-print

This is a dockerized Scala application that prints out words given as an input separated with a comma (`,`).

## How to build

Build a Docker image using sbt.

```text
sbt docker
```

## How to Run

### help

```text
docker run \
  --rm mateusz/args-print-scopt:0.1.0-SNAPSHOT \
  --help
```

```text
Blabla 1.0.0-alpha
Usage: mateusz [options]

  --help               prints this usage text
  -l, --lines <value>  My name property
```

### lines

```text
docker run \
  --rm mateusz/args-print-scopt:0.1.0-SNAPSHOT \
  --lines hello,world
```
