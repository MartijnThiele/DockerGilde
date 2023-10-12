# Automation gilde Dockerdagavond

## Java project lokaal draaien
⚙️️ Project lokaal runnen: `src/test/java/tests/LoginTest.java`  
⚙️️ Openen en in de kantlijn bij regel 10 op de groene vinkjes klikken  
⚙️️ Indien er een foutmelding komt over de verkeerde JDK, dan kun je intelliJ JDK 17 laten downloaden  
⚙️️ 2 testen slagen, eentje faalt  
⚙️️ Voer een maven clean uit of verwijder de target folder handmatig

## Java project in docker draaien
👁️‍🗨️ slide 6 - Waarom docker  
👁️‍🗨️ slide 7-9 - Docker basics - dockerfile, images, containers
#### Ons project in een docker container runnen:
⚙️ Image bouwen (eenmalig): `docker build -t polteq/dockerdagavond:v1 .`  
⚙️ Container bouwen vanuit image: `docker run polteq/dockerdagavond:v1`  
⚙️ Resultaten checken in docker desktop  
⚙️ Containers handmatig wissen  
⚙️ Container runnen en naderhand automatisch verwijderen: `docker run --rm polteq/dockerdagavond:v1`
⚙️ Resultaten zijn nu ook direct weg!

## Java project in docker container met shared volume
👁️‍🗨️ slide 10 - Docker basics - shared volumes  
### Container met shared volume bouwen om testresultaten te behouden na verwijderen
⚙️ Container runnen met volume gebaseerd op eerder gebouwd image:  
`CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`PS: docker run -v ${PWD}/target:/docker-gilde/target polteq/dockerdagavond:v1`   
`LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`  
⚙️  target folder openen vanuit het project in intelliJ

## Test fixen en opnieuw runnen
⚙️ In LoginTest.java, verander regel 34 in  
`authenticationPage.login("t3ster@test.com", "1qazxsw2");`  
⚙️ Container opnieuw runnen:   
`CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`PS: docker run -v ${PWD}/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`  
⚙️ Gaat nog steeds fout omdat image niet opnieuw gebouwd is na code change  
⚙️ Image opnieuw bouwen: `docker build -t polteq/dockerdagavond:v1 .`  
⚙️ Container opnieuw runnen:  
`CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`PS: docker run -v ${PWD}/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`  

## Java tests parallel runnen in docker
👁️‍🗨️ Slide 11 - Tests parallel runnen  
### Onze testen parallel laten runnen in een docker container
⚙️ Junit parallellisatie settings aanzetten in `src/test/resources/junit-platform.properties`  
  `junit.jupiter.execution.parallel.enabled = true`
  `junit.jupiter.execution.parallel.mode.default = concurrent`  
⚙️ Image opnieuw bouwen: `docker build -t polteq/dockerdagavond:v1 .`  
⚙️ Container opnieuw runnen:  
`CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`PS: docker run -v ${PWD}/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`  
⚙️ Instabiel? Page crashes? Shared memory verhogen kan dit oplossen:  
`CMD: docker run -v %cd%/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`PS: docker run -v ${PWD}/target:/docker-gilde/target polteq/dockerdagavond:v1`  
`LINUX: docker run -v $(PWD)/target:/docker-gilde/target polteq/dockerdagavond:v1`

## Java project in docker parallel tegen selenium grid
👁️‍🗨️ slide 12 Selenium grid  
👁️‍🗨️ slide 13 Docker basics - docker compose  
👁️‍🗨️ slide 14 Docker basics - networking  
👁️‍🗨️ slide 15 Omgevingsvariabelen  
### Grid opzetten en onze testen ertegenaan runnen
⚙️ Selenium grid opzetten: `docker compose -f docker-compose-selenium-grid.yml up`  
⚙️ Checken of ie werkt: `http://localhost:4444/ui`  
⚙️ Tests runnen tegen grid (in een aparte terminal): `docker compose -f docker-compose.yml up`    
⚙️ Live feedback tijdens het runnen: `http://localhost:7900/` `secret`  

## Grid en tests samen in een compose
⚙️ Huidige grid sluiten (terminal sluiten)  
⚙️ Tests runnen tegen grid: `docker compose -f docker-compose-tests-and-grid.yml up`