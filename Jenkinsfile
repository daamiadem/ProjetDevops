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
                sh 'mvn -f /var/lib/jenkins/workspace/SpringIOC/pom.xml compile';
            }
        }
        stage ('Test'){
            steps {
                echo 'Testing... ';
                sh 'mvn test';
            }
        }

        stage('SonarQube analysis ') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=sonar'
            }
        }

        stage('NEXUS') {
            steps {
                sh 'mvn deploy -DskipTests'

            }
        }



    }
    post {
        always {
            junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
        }
    }
}