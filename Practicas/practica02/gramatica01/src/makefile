all:
	jflex tokens.flex && byaccj -v -Jclass=Parser parser.y
	javac Nodos.java && javac Parser.java

test:
	java Parser ${file}

clean:
	rm -f *.class  *.java* y.tab.c
