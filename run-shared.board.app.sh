#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export ECAFETERIA_CP=shared.board.app/target/shared.board.app-0.1.0.jar:shared.board.app/target/dependency/*;


#REM call the java VM, e.g,
java -cp $ECAFETERIA_CP org.shared.board.app.Main localhost