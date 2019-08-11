#!/usr/bin/env groovy

File sourceFile = new File("importToDefectDojo.groovy");
Class groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(sourceFile);
GroovyObject importToDefectDojo = (GroovyObject) groovyClass.newInstance();

importToDefectDojo token: "a50568631d4b09bf009eb4f2116bc5e77bd52e7a", 
  user: "admin",
  dojoUrl: "http://localhost:8080",
  product: "test3",
  reportPath: '/home/tpagel/dependency-check-report.xml',
  branchName: "fix/stuff5",
  lead: 1,
  buildId: "1",
  sourceCodeManagementUri: "https://github.com/DefectDojo/django-DefectDojo/pull/1468"
  
//reportPath: '/home/tpagel/dependency-check-report.xml',