# DefectDojo Java Client Library
This repository uses OWASP SecureCodeBox library for API calls against OWASP DefectDojo. It is especially useful for Jenkins builds in the Jenkinsfile.



# Jenkins integration


# Development

* `defectdojo.groovy` simulates Jenkins, all parameters (e.g. token) needs to be adjusted here
* Build libs in engine folder
* Copy libs and run
`/copyLibs.bash && groovy defectdojo.groovy`


# Credits
This project is based on https://github.com/secureCodeBox/engine
