SRC_DIR=./src
TEST_SRC_DIR=./test-src
BUILD_DIR=./build
CLASS_DIR=$(BUILD_DIR)/classes
TEST_CLASS_DIR=$(BUILD_DIR)/test-classes
JAR_DIR=$(BUILD_DIR)/jar
JAR_FILE=$(JAR_DIR)/snippety.jar
DATA_DIR=./data
DEMO_DOC=$(DATA_DIR)/sushizone_yelp.txt
DEMO_QUERY="delicious sushi"

# ***** NEED TO MODIFY FOR YOUR ENV *****
JUNIT_CLASSPATH=/Users/hideki/java/junit4.8.2/junit-4.8.2.jar


all:clean jar

compile:
	mkdir -p $(CLASS_DIR)
	javac -d $(CLASS_DIR) -sourcepath $(SRC_DIR) $(SRC_DIR)/codetest/*.java

jar: compile
	mkdir -p $(JAR_DIR)
	jar cvf $(JAR_FILE) -C $(CLASS_DIR) codetest

demo: jar
	cat $(DEMO_DOC) | java -classpath $(JAR_FILE) codetest.Demo sushi bar

test-compile:jar
	mkdir -p $(TEST_CLASS_DIR)
	javac -classpath $(JUNIT_CLASSPATH):$(JAR_FILE) -d $(TEST_CLASS_DIR) -sourcepath $(TEST_SRC_DIR) $(TEST_SRC_DIR)/codetest/*.java

test: test-compile
	java -cp $(JUNIT_CLASSPATH):$(JAR_FILE):$(TEST_CLASS_DIR) org.junit.runner.JUnitCore codetest.SnippetyTest

clean:
	rm -rf $(BUILD_DIR)




