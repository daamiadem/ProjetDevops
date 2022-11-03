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
        stage('Build,Sonar'){
			steps {
				bat "mvn package -f ProjetDevops"
				bat "mvn deploy -f ProjetDevops"
				bat "mvn sonar:sonar -f ProjetDevops"
					}
    }
}