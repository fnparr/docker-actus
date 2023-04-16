#!/bin/bash

mongod &
cd actus-webapp
./gradlew bootRun
