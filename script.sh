PROJECT_ROOT=`pwd`
ENV=dev
SRC_JAVA=src/java
DIST_CLASS=${PROJECT_ROOT}/dist/${ENV}/classes
DIST_BIN=${PROJECT_ROOT}/dist/${ENV}/bin
RES_DIR=${PROJECT_ROOT}/src/res
BIN_NAME=Test.jar

mkdir -p ${DIST_CLASS}

echo -e "\nCompiling..."
find ${SRC_JAVA}/ -name "*.java" > sources.txt
javac @sources.txt -d ${DIST_CLASS}
if [ $? != 0 ]; then exit 1; fi
rm sources.txt

echo -e "\nRuning..."
java -cp ${RES_DIR}:${DIST_CLASS} Main
if [ $? != 0 ]; then exit 1; fi

echo -e "\nMake jar executable..."
mkdir -p ${DIST_BIN}
jar cvfm ${DIST_BIN}/$BIN_NAME MANIFEST.MF -C ${DIST_CLASS} . -C $RES_DIR .
if [ $? != 0 ]; then exit 1; fi

echo -e "\nRuning jar file..."
java -jar ${DIST_BIN}/$BIN_NAME
if [ $? != 0 ]; then exit 1; fi

if [ "$1" == "clean" ]; then
  echo -e "\nClean all class files..."
  rm -rf $DIST_CLASS
fi
