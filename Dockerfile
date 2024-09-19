##################### DOCKERFILE diagnosis_view ####################

#################### STAGE 1 : Construction du projet ##########################

# Definition de l'image de base
FROM maven AS build

# Definition du fichier de travail dans le container
WORKDIR /diagnosisview

# Copie du pom et du code source dans le fichier de travail
COPY pom.xml /diagnosisview
COPY src /diagnosisview/src
#COPY src/main/resources/templates /diagnosisview/templates

# Package de l'appli (sans execution des tests - DskipTests)
RUN mvn clean package -DskipTests



#################### STAGE 2 : Execution de l'appli ####################
FROM openjdk:21-jdk-slim

WORKDIR /diagnosisview

# Copie du fichier packagé (jar) vers le fichier de travail
COPY --from=build /diagnosisview/target/diagnosisview-0.0.1-SNAPSHOT.jar /diagnosisview/diagnosisview.jar

# Exposition du port d'accès à l'appli
EXPOSE 8082

#RUN de l'appli (par defaut au demarrage)
ENTRYPOINT ["java", "-jar", "diagnosisview.jar"]





