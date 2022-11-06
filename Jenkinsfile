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
                
                
                stage('NEXUS') {
            steps {
                sh 'mvn deploy'
                  
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
        
		stage('SonarQube analysis 1') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=ademdaami'
            }
        }
       
        
        stage('JUnit and Mockito Test'){
            steps{
                script
                {
                    if (isUnix())
                    {
                        sh 'mvn --batch-mode test'
                    }
                    else
                    {
                        bat 'mvn --batch-mode test'
                    }
                }
            }
        
    }
    
    
     stage('Building image docker-compose') {
          steps {

              sh "docker-compose up -d"
          }
        }
    	
    	
    	
    	
    	
}}