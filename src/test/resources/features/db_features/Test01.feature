Feature: DB Test

  @DBTest
  Scenario Outline: user db test

    Given kullanici conection kurar
    And   kullanici tum yeni kayitli bilgileri ceker "<query>" ve "<columnName>"
    Then  kallanici kullanici bilgilerini dogrular

    Examples: test verileri
    |query                      |columnName|
    |select * from public.physician    |id       |