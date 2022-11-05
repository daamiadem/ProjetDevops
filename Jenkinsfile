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
    
    	stage("Publish to Nexus Repository Manager") {
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: 'nexus3',
                            protocol: 'http',
                            nexusUrl: '192.168.43.146:8081',
                            groupId: 'com.esprit.examen',
                            version: '1.0',
                            repository: 'maven-releases',
                            credentialsId: 'nexus',
                            artifacts: [
                                [artifactId: 'spring-boot-starter-parent',
                                classifier: '',
                                file: DevopsProject,
                                type: pom.packaging],
                                [artifactId: 'pom.DevopsProject',
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
                }
            }
    	
    
    
}
}