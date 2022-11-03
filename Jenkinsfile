pipeline {

        agent any
        stages {
                stage('Check out Git'){
                   
                steps{
                        echo 'Pulling...';
                        git branch: 'Adem',
                        url : 'https://github.com/daamiadem/ProjetDevops.git';
                    }
                }
       
        stage('Testing maven') {
            steps {
                sh """mvn -version"""
                 
            }
        }
       
        stage('MVN CLEAN') {
            steps {
                sh 'mvn clean'
                 
            }
        }
        stage('MVN COMPILE') {
            steps {
                sh 'mvn compile'
                 
            }
        }
        
        stage('Build, Sonar'){
			steps {
				bat "mvn package -f ProjetDevops"
				bat "mvn deploy -f ProjetDevops"
				bat "mvn sonar:sonar -f ProjetDevops"
					}
				}
        
    }
}


