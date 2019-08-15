#!/usr/bin/env groovy

File sourceFile = new File("importToDefectDojo.groovy");
Class groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(sourceFile);
GroovyObject importToDefectDojo = (GroovyObject) groovyClass.newInstance();

String token = System.getenv("DD_TOKEN")
if(!token) {
  println "Error: No token"
  return
}
String user = System.getenv("DD_USER")
if(!user) {
  user = "tpagel"
}
String dojoUrl = System.getenv("DD_URL")
if(!dojoUrl) {
  dojoUrl = "http://localhost:8080"
}
String productName = System.getenv("DD_PRODUCT_NAME")
if(!productName) {
  println "Error: No productName"
  return
}
String reportPath = System.getenv("DD_REPORT_PATH")
if(!reportPath) {
  reportPath = "/dependency-check-report.xml"
}
String branchName = System.getenv("DD_BRANCH_NAME")
if(!branchName) {
  println "Error: No branchName"
  return
}
String leadTemp = System.getenv("DD_LEAD")
if(!leadTemp) {
  leadTemp = "1"
}
long lead = (long) leadTemp
String buildId = System.getenv("DD_BUILD_ID")
String sourceCodeManagementUri = System.getenv("SOURCE_CODE_MANAGEMENT_URI")

importToDefectDojo token: token, 
  user: user,
  dojoUrl: dojoUrl,
  product: productName,
  reportPath: reportPath,
  branchName: branchName,
  lead: lead,
  buildId: buildId,
  sourceCodeManagementUri: sourceCodeManagementUri
    
//reportPath: '/home/tpagel/dependency-check-report.xml',
