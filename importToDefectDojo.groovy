#!/usr/bin/env groovy

@GrabConfig(systemClassLoader=true)
@Grab(group='com.fasterxml.jackson.core', module='jackson-core', version='2.9.9')
@Grab(group='com.fasterxml.jackson.core', module='jackson-databind', version='2.9.9.2')
@Grab('io.securecodebox.core:sdk:0.0.1-SNAPSHOT')
@Grab('io.securecodebox.persistenceproviders:defectdojo-persistenceprovider:0.0.1-SNAPSHOT')
@Grab(group='org.codehaus.jackson', module='jackson-mapper-asl', version='1.9.13')


import io.securecodebox.persistence.*
import io.securecodebox.persistence.models.*
import io.securecodebox.model.rest.Report
import io.securecodebox.model.securitytest.SecurityTest
import io.securecodebox.model.execution.Target
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;

def call(args) {
    DefectDojoService defectDojoService = new DefectDojoService()
    DefectDojoResponse<ToolType> responseExisting = new DefectDojoResponse<>()
    DefectDojoPersistenceProvider persistenceProvider = new DefectDojoPersistenceProvider()

    defectDojoService.defectDojoUrl = 'http://localhost:8080'
    defectDojoService.defectDojoApiKey = '3fdbfbacf25c3fe2f6f035a150e4aba36b37b2f9'
    defectDojoService.defectDojoDefaultUserName = 'admin'

    persistenceProvider.defectDojoService = defectDojoService

    String fileContents = new File('/home/tpagel/git/sample-scan-files/dependency_check/dependecy_check_v4.0.2.xml').text
    
    Report report = new Report(Collections.emptyList(), fileContents)

    //needed?
    Target target = new Target()
    target.name = 'dependencycheck'
    target.location = 'Jenkins'

    Map<String, String> metaData = new HashMap<String, String> ()

    SecurityTest securityTest = new SecurityTest()
    securityTest.report = report
    securityTest.target = target
    securityTest.setName 'dependencycheck' // DefectDojo test name?
    securityTest.setContext "test2" // productName
    securityTest.setMetaData(metaData)

    persistenceProvider.persist securityTest

    //println args.foo
}