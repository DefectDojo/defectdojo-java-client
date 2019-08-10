#!/usr/bin/env groovy

File sourceFile = new File("importToDefectDojo.groovy");
Class groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(sourceFile);
GroovyObject importToDefectDojo = (GroovyObject) groovyClass.newInstance();

importToDefectDojo token: "a66595cd060fabe1e5a339a6cf127134bc64ede7", 
  user: "admin",
  dojoUrl: "http://localhost:8080",
  product: "test3",
  reportPath: '/home/tpagel/dependency-check-report.xml',
  branchName: "fix/stuff5",
  lead: 1,
  buildId: "1",
  sourceCodeManagementUri: "https://github.com/DefectDojo/django-DefectDojo/pull/1468"
  
//  reportPath: '/home/tpagel/git/sda/sda-commons-owasp-dependency-check/build/reports/dependency-check-report.xml',
//reportPath: '/home/tpagel/dependency-check-report.xml',