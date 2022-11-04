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
                sh 'mvn compile';
            }
        }
        stage ('Test'){
            steps {
                echo 'Testing... ';
                sh 'mvn test'
            }
        }

    }
}
