#!/usr/bin/env bash

echo OFF
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH

mvn $1 -DskipTests dependency:copy-dependencies package