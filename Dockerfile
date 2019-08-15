FROM docker.io/securecodebox/engine:v1.1.0 AS scb
RUN cd /scb-engine/ ; unzip /scb-engine/app.jar

FROM groovy:3.0-jdk12

#RUN mkdir /home/groovy/lib/
COPY --from=scb /scb-engine/app.jar /home/groovy/.groovy/grapes/io.securecodebox.core/app/jars/app-0.0.1-SNAPSHOT.jar
COPY --from=scb /scb-engine/BOOT-INF/lib/sdk-0.0.1-SNAPSHOT.jar /home/groovy/.groovy/grapes/io.securecodebox.core/sdk/jars/sdk-0.0.1-SNAPSHOT.jar
COPY --from=scb /scb-engine/BOOT-INF/lib/ /home/groovy/.groovy/lib/
COPY --from=scb /scb-engine/lib/defectdojo-persistenceprovider-0.0.1-SNAPSHOT-jar-with-dependencies.jar /home/groovy/.groovy/grapes/io.securecodebox.persistenceproviders/defectdojo-persistenceprovider/jars/defectdojo-persistenceprovider-0.0.1-SNAPSHOT.jar

#COPY lib/sdk-0.0.1-SNAPSHOT.jar /home/groovy/.groovy/grapes/io.securecodebox.core/sdk/jars/sdk-0.0.1-SNAPSHOT.jar
#COPY lib/defectdojo-persistenceprovider-0.0.1-SNAPSHOT-jar-with-dependencies.jar /home/groovy/.groovy/grapes/io.securecodebox.persistenceproviders/defectdojo-persistenceprovider/jars/defectdojo-persistenceprovider-0.0.1-SNAPSHOT.jar
COPY defectdojo.groovy /home/groovy/defectdojo.groovy
COPY importToDefectDojo.groovy /home/groovy/importToDefectDojo.groovy
