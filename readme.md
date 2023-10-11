# Automation gilde Dockerdagavond

## Intro
* slides Welkom + introductie docker
* slides Agenda

## Java project lokaal draaien
* Scope van het project uitleggen
* Project lokaal runnen: `src/test/java/tests/LoginTest.java`
* Openen en in de kantlijn bij regel 10 op de groene vinkjes klikken
* Indien er een foutmelding komt over de verkeerde JDK, dan kun je intelliJ JDK 17 laten downloaden

## Java project in docker draaien
* slides Waarom docker
* slides Docker basics
#### Ons project in een docker container runnen:
1. Image bouwen (eenmalig): `docker build -t polteq/dockerdagavond:v1 .`
2. Container bouwen vanuit image: `docker run polteq/dockerdagavond:v1`
3. Resultaten checken in docker desktop


## Java project in docker draaien met volume
* slides uitleg volumes
* Containers handmatig wissen
* Container bouwen vanuit image:   
  `CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
  `PS: docker run polteq/dockerdagavond:v1`  
  `LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`
* target folder wordt nu getoond in het project in intelliJ
* Containers kunnen nu gelijk verwijderd worden na afsluiten, met behoud van resultaten:  
  `CMD: docker run -v %cd%/target:/docker-gilde/target --rm polteq/dockerdagavond:v1`  
  `PS: docker run --rm polteq/dockerdagavond:v1`  
  `LINUX: docker run -v $(PWD)/target:/docker-gilde/target --rm polteq/dockerdagavond:v1`

## Java project in docker met compose
* slides uitleg docker compose
* docker compose yml runnen: `docker compose -f docker-compose.yml up`

## Java project in docker parallel
* Slides uitleg parallel runnen
* Junit parallellisatie settings aanzetten in `src/test/resources/junit-platform.properties`  
`junit.jupiter.execution.parallel.enabled = true`
`junit.jupiter.execution.parallel.mode.default = concurrent`
* Image opnieuw bouwen: `docker build -t polteq/dockerdagavond:v1 .`
* docker compose yml runnen: `docker compose -f docker-compose.yml up`

## Java project in docker parallel tegen grid
* slides uitleg selenium grid
* slides uitleg docker networking
* slides uitleg omgevingsvariabelen
* Selenium grid optuigen: `docker compose -f docker-compose-selenium-grid.yml up`
* Checken of ie werkt: `http://localhost:4444/ui`
* docker compose yml runnen: `docker compose -f docker-compose-tests-grid.yml up`
* Live feedback tijdens het runnen: `http://localhost:7900/` `secret`