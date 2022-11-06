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
        stage ('Unit Test and Mockito'){
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
        stage('Build backend docker image') {
            steps {
                sh 'docker build -t azzabihamza/backend-service .'
            }
        }

    stage('Push images to Dockerhub') {
            steps {
                script{

                 withCredentials([string(credentialsId: 'azzabihamza', variable: 'docker')])  {
              sh 'docker login -u azzabihamza -p ${docker}'

             }
              sh 'docker push azzabihamza/backend-service'

            }

        }
    }




    stage("Email"){
           steps{
               emailext attachLog: true, body: "${env.BUILD_URL} has result ${currentBuild.result}", compressLog: true, subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'hamza.azzabi@esprit.tn'
           }
    }

    }
    post {
        always {
            junit(testResults: 'target/surefire-reports/*.xml', allowEmptyResults : true)
        }
    }

}