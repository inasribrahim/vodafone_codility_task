# Use Alpine Linux as base image
FROM alpine:latest

# Install basic networking tools
RUN apk update && \
    apk add --no-cache \
        curl \
        wget \
        iputils \
        bind-tools \
        net-tools \
        openssh-client \
        bash \
        ca-certificates \
        openssl \
        tar \
        gzip \
        unzip \
        procps \
        shadow \
        sudo \
        nano \
		git \
		chromium \
		chromium-chromedriver

# Install Java
RUN apk add --no-cache openjdk11-jre

# Install Maven
ENV MAVEN_VERSION=3.9.6
ENV MAVEN_HOME=/usr/lib/maven
ENV PATH=${MAVEN_HOME}/bin:${PATH}
RUN wget -q "https://dlcdn.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz" && \
    mkdir -p /usr/lib/maven && \
    tar -xzf "apache-maven-${MAVEN_VERSION}-bin.tar.gz" -C /usr/lib/maven --strip-components=1 && \
    rm "apache-maven-${MAVEN_VERSION}-bin.tar.gz"

# Install Chrome browser
RUN apk add --no-cache \
    chromium \
    udev \
    ttf-freefont \
    fontconfig

# Set Chrome as the default browser
ENV CHROME_BIN=/usr/bin/chromium-browser

# Cleanup
RUN rm -rf /var/cache/apk/*

# Set the working directory inside the container
WORKDIR /usr/src/work_space

# Clone the Git repository
RUN git clone https://github.com/inasribrahim/google_task_vodafone_codility.git .

CMD ["bash"]