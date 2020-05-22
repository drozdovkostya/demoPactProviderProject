# DemoPactProviderProject
DemoPactConsumerProject is a project created for webinar about contract testing.
Here is developed provider test, that verify pact contract from pact broker.

# Prerequisites
* Java 8
* Maven
## Getting Started

Command to run the test and publish pact contract to pact-broker: 
* run `mvn test -Dpact.verifier.publishResults=true -DpactBrokerUrl=localhost -DskipTests=false`
