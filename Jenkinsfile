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
        stage ('compile'){
            steps {
                echo 'Compiling... ';
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetDevops/pom.xml compile';
            }
        }
        stage ('Test'){
            steps {
                echo 'Testing... ';
                sh 'mvn -f /var/lib/jenkins/workspace/ProjetDevops/pom.xml test';
            }
        }


    }
}
