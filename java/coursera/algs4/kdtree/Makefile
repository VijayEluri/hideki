compile:
	javac *.java

checkstyle:
	checkstyle PointSET.java KdTree.java

findbugs:
	findbugs *.class

zip:
	zip kdtree.zip PointSET.java KdTree.java

clean:
	rm -f *.class *.zip

nnv:
	java NearestNeighborVisualizer circle100.txt

rsv:
	java RangeSearchVisualizer circle100.txt

kdtv:
	java KdTreeVisualizer
