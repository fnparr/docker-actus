#!/bin/bash

cd actus-core
mvn -U clean install
rm -rf src
cd ..
cd actus-webapp
./gradlew build

