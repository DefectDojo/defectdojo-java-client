#!/bin/bash

ENGINE_PATH="../engine"

CURRENT_PATH=$(pwd)
cd $ENGINE_PATH
mvn clean install -T6 -DskipTests=true -B -Dorg.slf4j.simpleLogger.log.org.apache.maven.cli.transfer.Slf4jMavenTransferListener=warn
exitcode=$?
cd $CURRENT_PATH
exit $exitcode
