FROM openjdk:17-alpine
LABEL maintainer="Francis Parr <fnparr@gmail.com>"
RUN echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/main' >> /etc/apk/repositories \
 && echo 'http://dl-cdn.alpinelinux.org/alpine/v3.6/community' >> /etc/apk/repositories \
 && apk update \
 && apk add --no-cache curl tar bash procps mongodb mongodb-tools
RUN addgroup --system app \
    && adduser --system --ingroup app app
WORKDIR /home/app
# Download and install Maven
# 1- define a constant with the version of Maven you want to install
ARG MAVEN_VERSION=3.6.3

# 2- define a constant with the working directory
RUN mkdir -p /home/app
ARG USER_HOME_DIRECTORY=="/home/app"

# 4- Define the url where maven can be downloaded from
ARG BASE_URL=https://apache.osuosl.org/maven/maven-3/$MAVEN_VERSION/binaries

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
ARG GRADLE_VERSION=7.6.1

ENV GRADLE_HOME /usr/bin/gradle
ENV GRADLE_USER_HOME $USER_HOME_DIRECTORY/cache
ENV PATH $PATH:$GRADLE_HOME/bin
VOLUME  $GRADLE_USER_HOME

# setup writable storable mongodb file and volume
# expose port for actus-server request
# will need exposed front end port 3000 later 
RUN mkdir -p /data/db
VOLUME /data/db
RUN chown app:app -R /data/db
VOLUME /data/db
EXPOSE 8083
COPY app .

RUN sh ./actus-webapp/scripts/buildThenRemoveSource.sh

# User mode choked unable to see/write gradle.lck file so remove 
# USER app
CMD ["./run.sh"]
