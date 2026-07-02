compile:
	sbt compile

test:
	sbt test

format:
	sbt scalafmtCheckAll

check:
	sbt scalafmtCheckAll
	sbt test

clean:
	sbt clean