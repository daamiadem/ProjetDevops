pipeline {
    agent any
    stages {
        stage('checkout GIT') {
         steps {
                echo 'Pulling...';
                    git branch: 'rymatest',
                    url : 'https://github.com/daamiadem/ProjetDevops.git';
               
            }


        }
        stage('Unit tests') {
			steps {
				 sh 'mvn test -Dtest="CategorieProduitControllerTest"'
			}}
    }
}
