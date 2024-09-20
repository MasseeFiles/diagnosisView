# DIAGNOSIS APP
# _Microservice VIEW_

DIAGNOSIS est une application d'aide à la détection du diabète de type 2 comportant 5 microservices (Gateway, View, Patient, Risk et Note). Le microservice VIEW a pour rôle de proposer une interface graphique aux utilisateurs de l'appli via des pages HTML. Il utilise le webservice client OpenFeign pour communiquer avec les autres microservices.

### Port
Le microservice VIEW est exposé sur le port 8082

### Docker

Le microservice comporte un fichier Dockerfile à la racine du projet pour la création de son image DOCKER.





