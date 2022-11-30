job('demo') {
    steps {
        shell('echo Hello World!')
    }
}
job ('myjob'){
  steps {
  	shell('echo this is another job')
  }
}

pipelineJob('githubecr-demo') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        github('Nimeh/application-repo')
                      	credentials('ecr:us-east-1:AWS')
                    }
                }
            }
            scriptPath('Jenkinsfile')
        }
    }
}

freeStyleJob('test-dsl') {
	steps {
		dsl {
          text ("job('myjob'){ steps { shell('echo this is another job')}}")
              }
}
}
