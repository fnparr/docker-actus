FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine-slim
# FROM openjdk:11-jdk-alpine
# -- preference to work with jdk11 
LABEL Francis Parr <fnparr@gmail.com>
RUN echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/main' >> /etc/apk/repositories \
 && echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/community' >> /etc/apk/repositories \
 && apk update \
 && apk add --no-cache curl tar bash procps mongodb mongodb-tools
# mongodb not found - removing this and mongodb-tools
# RUN apk add --no-cache curl tar bash procps 

# Download and install Maven
# 1- define a constant with the version of Maven you want to install 
ARG MAVEN_VERSION=3.6.3

# 2- define a constant with the working directory 
ARG USER_HOME_DIRECTORY=="/root"

# 3- define a SHA key to validate mvn download 
#  --- skip this step - not sure whether key version dependent
#  --- will skip validation step later 

# 4- Define the url where maven can be downloaded from 
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries
#  ---  this site exists and is good 

# 5- Create the directories, download Maven, install, cleanup 
RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
 && echo "Downloading maven" \
 && curl -fsSL -o /tmp/apache-maven.tar.gz $BASE_URL/apache-maven-$MAVEN_VERSION-bin.tar.gz \
 && echo "Unzipping Maven" \
 && tar -xzf  /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
 && echo "Cleaning and setting links" \
 && rm -f /tmp/apache-mvn.tar.gz \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn
ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Download and install Gradle
# 1- Define a constant with version of Gradle we want  
ARG GRADLE_VERSION=4.8.1

# 2- Define the URL where gradle can be downloaded 
ARG GRADLE_BASE_URL=https://services.gradle.org/distributions

# 3- Skip validation check 
# 4- Create the directories download gradle, install, remove , link 
RUN mkdir -p /usr/share/gradle /usr/share/gradle/ref \
  && echo "Downloading gradle" \
  && curl -fsSL -o /tmp/gradle.zip ${GRADLE_BASE_URL}/gradle-${GRADLE_VERSION}-bin.zip \
  && echo "Unzipping gradle" \
  && unzip -d /usr/share/gradle  /tmp/gradle.zip \
  && echo "Cleaning and setting links" \
  && rm -f /tmp/gradle.zip \
  && ln -s /usr/share/gradle/gradle-${GRADLE_VERSION} /usr/bin/gradle

# 5- Define environmet variables needed by gradle
ENV GRADLE_VERSION 4.8.1
ENV GRADLE_HOME /usr/bin/gradle
ENV GRADLE_USER_HOME /cache
ENV PATH $PATH:$GRADLE_HOME/bin
VOLUME  $GRADLE_USER_HOME 

# 6- create user=app avoid running root - copy actus code 
RUN addgroup --system app \
    && adduser --system --ingroup app app
WORKDIR /home/app
COPY app .
RUN chown app:app -R /home/app
# USER app  - comment out for now and run as root 
RUN mkdir /data
RUN mkdir /data/db
EXPOSE 8083
VOLUME /data/db
RUN chown app:app -R /data/db
RUN sh ./actus-webapp/scripts/buildThenRemoveSource.sh
# USER app
CMD ["./run.sh"]  
