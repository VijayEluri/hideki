clean:
	rm -f *.class *.zip

compile:
	javac *.java

checkstyle:
	checkstyle *.java

findbugs:
	findbugs *.class

zip:
	zip 8puzzle.zip Board.java Solver.java

p4:
	java Solver input/puzzle04.txt

p31:
	java Solver input/puzzle31.txt

us:
	java Solver input/puzzle3x3-unsolvable.txt
