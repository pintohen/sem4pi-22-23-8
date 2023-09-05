#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export ECAFETERIA_CP=shared.board.server/target/shared.board.server-0.1.0.jar:shared.board.server/target/dependency/*;


#REM call the java VM, e.g,
java -cp $ECAFETERIA_CP org.shared.board.server.TcpSrv