pipeline {
    agent any 
    stages {
        stage ('Checkout GIT'){
            steps {
                echo 'Pulling... '; 
                    git branch : 'Adem', 
                    url : 'https://github.com/daamiadem/ProjetDevops.git'; 
            }
        }
         stage('Quality Gate Status Check'){
                  steps{
                      script{
			      withSonarQubeEnv('sonar') {
			      sh "mvn compile sonar:sonar"
                       	     	}
			      timeout(time: 1, unit: 'HOURS') {
			      def qg = waitForQualityGate()
				      if (qg.status != 'OK') {
					   error "Pipeline aborted due to quality gate failure: ${qg.status}"
				      }
                    		}
		    	    sh "mvn clean install"

                 	}
               	 }
              }
		stage("Maven Build") {
            steps {
                script {
                    sh "mvn package -DskipTests=true"
                }
            }
        }
        
}
}