pipeline {
    agent any
    stages {
        stage ('Checkout GIT'){
            steps {
                echo 'Pulling... ';
                    git branch : 'hamza',
                    url : 'https://github.com/daamiadem/ProjetDevops.git';
            }
        }

        stage ('clean'){
            steps {
                echo 'cleaning... ';
                sh 'mvn clean';
            }
        }
        stage ('compile'){
            steps {
                echo 'Compiling... ';
                sh 'mvn compile';
            }
        }
        stage ('Nexus') {
            steps {
                echo 'Nexus... ';
                sh 'mvn clean package deploy:deploy-file -DgroupId=com.esprit.examen -DartifactId=ProjetDevops -Dversion=0.0.1-SNAPSHOT -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://http://192.168.1.106:8081//repository/maven-snapshots/ -Dfile=target/ProjetDevops-0.0.1-SNAPSHOT.jar';
            }
        }
        stage ('Test'){
            steps {
                echo 'Testing... ';
                sh 'mvn test';
            }
        }


    }
}
