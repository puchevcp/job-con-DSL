job('ejemplo-job-DSL-2') {
	description('Job DSL de ejemplo')
    scm {
      git('https://github.com/puchevcp/job-con-DSL.git', 'main') { node ->
        node / gitConfigName('puchevcp')
        node / gitConfigEmail('puche.vcp@gmail.com')
       }
    }
    parameters {
         stringParam('nombre', defaultValue = 'Dani', description = 'Parametro de cadena para el job booleano')
         choiceParam('planeta',['Martes', 'Venus', 'Tierra'])
         booleanParam('agente', false)
    }
    triggers {
       cron('H/7 * * * *')
    }
    steps {
       shell("bash jobscript.sh")
    }
    
}
