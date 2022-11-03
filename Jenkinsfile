pipeline {
    agent any
    stages {
        stage ('Checkout GIT'){
            steps {
                echo 'Pulling... ';
                    git branch : 'hamza',
                    url : 'https://github.com/daamiadem/ProjetDevops.git';
            }
            steps {
                echo 'Building... ';
                sh 'mvn clean install';
            }
            steps {
                echo 'Compiling... ';
                sh 'mvn compile';
            }
            steps {
                echo 'JUNIT / Mockito... ';
                sh 'mvn test';
            }
        }
    }
}