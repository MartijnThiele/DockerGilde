# Use an official Java runtime as a parent image
#FROM eclipse-temurin:17
FROM maven:3.9.4-eclipse-temurin-17

# Set environment variable to let project know we are running in CICD
ENV CICD=true

# Set the working directory
WORKDIR /docker-gilde

# Install chrome
RUN apt-get update -qqy
RUN apt-get -qqy install gpg unzip
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
	&& echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google-chrome.list
RUN apt-get update -qqy
RUN apt-get -qqy install google-chrome-stable
RUN rm /etc/apt/sources.list.d/google-chrome.list
RUN rm -rf /var/lib/apt/lists/* /var/cache/apt/*

# Copy the current directory contents into the container at /app
COPY . .

# Define the command to run your tests
CMD ["mvn", "clean", "test", "surefire-report:report-only"]
