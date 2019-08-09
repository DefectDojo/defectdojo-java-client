#!/bin/bash

ENGINE_PATH="../engine"

cp $ENGINE_PATH/scb-sdk/target/sdk-0.0.1-SNAPSHOT.jar lib/ ; cp $ENGINE_PATH/scb-persistenceproviders/defectdojo-persistenceprovider/target/defectdojo-persistenceprovider-0.0.1-SNAPSHOT-jar-with-dependencies.jar lib/ ; rm -Rf $HOME/.groovy/grapes/io.securecodebo*; rm -Rf $HOME./repository/io/securecodebox
