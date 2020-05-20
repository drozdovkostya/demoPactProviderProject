pipeline {
   agent any
   tools {
      // Install the Maven version configured as "M3" and add it to the path.
      maven "Maven"
   }
   stages {
      stage('Build') {
         steps {
            // Get some code from a GitHub repository
            git 'https://github.com/drozdovkostya/demoPactProviderProject'

            // Run Maven on a Unix agent.
            sh "mvn clean package"

            // To run Maven on a Windows agent, use
            // bat "mvn -Dmaven.test.failure.ignore=true clean package"
         }

      }
      stage('Run contract test') {
          steps{
              sh "mvn verify -Dpact.verifier.publishResults=true -DpactBrokerUrl=pact-broker -Dpact.provider.version=$GIT_COMMIT"
            }
      }
      stage('Deploy to TST') {
          steps{
              sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_provider/versions/$GIT_COMMIT/tags/tst' --header 'Content-Type: application/json'"
            }
      }


      stage('Deploy to ACC') {
          steps{
              sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_provider/versions/$GIT_COMMIT/tags/acc' --header 'Content-Type: application/json'"
            }
      }


      stage('Deploy to PRD') {
          steps{
              sh "curl --location --request PUT 'http://pact-broker/pacticipants/test_provider/versions/$GIT_COMMIT/tags/prd' --header 'Content-Type: application/json'"
            }
      }
   }

   }


