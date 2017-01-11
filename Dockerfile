FROM ozsie/wildfly-base
COPY ./target/base.war $DEPLOYMENTS
