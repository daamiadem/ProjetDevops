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
       
        stage('CLEAN Install') {
            steps {
                sh 'mvn clean'
                sh 'mvn install'
                 
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
        
        stage('Nexus Repository Manager') {
            steps {
                script {
					nexusArtifactUploader artifacts: [[artifactId: 'DevopsProject', classifier: '', file: 'target/DevopsProject-1.0.jar', type: 'jar']], credentialsId: 'NEXUS_CRED', groupId: 'com.esprit.examen', nexusUrl: '192.168.1.122:8081', nexusVersion: 'nexus3', protocol: 'http', repository: 'maven-snapshots', version: '1.0.0-SNAPSHOT'
				}
            }}
       
        
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
    
    
    
   
    	
    	
    	 
        
    
     
       
			stage('Build image') {
           	steps {
       		 sh "docker build -t ademdaami/devopsproject_devopsproject ."
       		}
       		}        
        
        
        
        
        
       
        
        stage('Push image') {
 			steps {
 			    withDockerRegistry([ credentialsId: "DockerHub", url: "" ]) {
 			
        	  sh "docker push ademdaami/devopsproject_devopsproject"
        	}
        	}
        	}
        
      
        
    stage('Cleaning up') {
         steps {
			sh "docker rmi -f ademdaami/devopsproject_devopsproject"
         }
     }   
     
     
     stage("Email"){
           steps{
               emailext attachLog: true, body: "the result is :  ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'adem.daami@esprit.tn'
           }
       } 
     
     
    
}}