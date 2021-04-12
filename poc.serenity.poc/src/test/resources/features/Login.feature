# language: en

Feature: Login

  @test
  Scenario: Realizar login
    Given que juan es un 'cliente'
    When realiza el login
    Then se obtiene un token de autorizacion