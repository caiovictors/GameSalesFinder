<h1 align="center">🎮 GameSalesFinder</h1>
<h3 align="center">API to find the best prices for games using Java Spring Boot</h3> 

***
## ℹ About

The Game Sales Finder is an api that uses the <a href="https://apidocs.cheapshark.com/" target="_blank">CheapShark API</a> to find the best price of a given game, returning the price and the store(s) that have the best price. Sign up and sign in are necessary to use the aplication, and you can create your own wishlist of games that returns the best actual prices for the games you add.  

## 💻 Technologies
* Spring Boot
* Java 11
* Maven
* MySQL 8
* JUnit 4
* Mockito
* Docker
* JWT
* Karate
* Swagger

## 🛠 Requirements
* jdk 16
* Maven 4
* Docker

## ✅ Features
* User authentication and authorization with jwt
* Validation and error handling
* External api call (CheapShark Api)
* Game best prices search
* Wishlist services
* Tests with Mockito
* Functional tests with Karate on <a href="https://github.com/caiovictors/gamesalesfinder-functional-tests" target="_blank">this repository</a>
  
## ⚙ Installation and Running
* Clone this repository
```bash
$ git clone https://github.com/caiovictors/GameSalesFinder.git
```
* Start docker 🐋
```bash
$ docker-compose up -d
```
* Check the documentation bellow to use the routes and enjoy! ✌🏻

## 📄 Documentation

  The Swagger documentation can be found by the url:<br> 
  <a> http://localhost:8080/swagger-ui/index.html#/ </a>
