# Installation Notes

## Install and configure Helm

### Install Helm (3.1.2)

curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 | bash

### Add stable repo 

helm repo add stable https://kubernetes-charts.storage.googleapis.com/

# Create demo namespace

kubectl create ns demo 

## Install Jenkins 

mkdir jenkins
cd jenkins 

### Fetch Jenkins Chart's default values

helm show values stable/jenkins > values.yaml 

customize values.yaml as necessary. 

install:  helm install jenkins -f values.yaml stable/jenkins 

output: 
NAME: jenkins
LAST DEPLOYED: Wed Apr  1 17:27:43 2020
NAMESPACE: example-voting-app
STATUS: deployed
REVISION: 1
NOTES:
1. Get your 'admin' user password by running:
  printf $(kubectl get secret --namespace demo jenkins -o jsonpath="{.data.jenkins-admin-password}" | base64 --decode);echo
2. Get the Jenkins URL to visit by running these commands in the same shell:
  export POD_NAME=$(kubectl get pods --namespace demo -l "app.kubernetes.io/component=jenkins-master" -l "app.kubernetes.io/instance=jenkins" -o jsonpath="{.items[0].metadata.name}")
  echo http://127.0.0.1:8080
  kubectl --namespace demo port-forward $POD_NAME 8080:8080

3. Login with the password from step 1 and the username: admin

4. Use Jenkins Configuration as Code by specifying configScripts in your values.yaml file, see documentation: http:///configuration-as-code and examples: https://github.com/jenkinsci/configuration-as-code-plugin/tree/master/demos


## create github package registry config 

kubectl create secret docker-registry github-package-registry --docker-server=docker.pkg.github.com --docker-username=steven-terrana --docker-password=c7d71f85302a283ab1955477037865c178294ce0 --docker-email=steventerrana@gmail.com

## install swarm plugin 

## install Sonarqube

helm install sonarqube stable/sonarqube --set service.type=NodePort
