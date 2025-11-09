## Opis domeny
Poniżej znajduje się opis domeny systemu aplikacji bankowej.
Przedstawione są dwie kluczowe funkcjonalności (przedstawione jako bounded contexts):
- zarządzanie kontem - zawiera encje: konto(korzeń agregatu) oraz klient, a także obiekty wartości jak: stan i rodzaj konta oraz podstawowe i szczegółowe dane klienta.
- przelewy - zawiera encje: nadawcy, odbiorcy oraz zlecenia przelewu, które jest korzeniem agregatu. Dodatkowo obiekty wartości: kwota oraz podstawowe dane klienta. 

## Model
![ddd.svg](Java/spring-thymeleaf-crud-example/ddd.svg)

## Założenia
| Konto      |                        |
|------------|------------------------|
| Nazwa      | "Konto++"              |
| Rodzaj     | ValueObject(Rodzaj)    |
| Stan Konta | ValueObject(StanKonta) |
| Właściciel | Klient                 |

| Stan Konta       |     | Ograniczenie |
|------------------|-----|--------------|
| Część całkowita  | 123 | \>=0         |
| Część dziesiętna | 45  | <0-99>       |

| Klient           |                                     |
|------------------|-------------------------------------|
| Podstawowe dane  | ValueObject(PodstawoweDaneKlienta)  |
| Szczegółowe dane | ValueObject(SzczegółoweDaneKlienta) |

| Podstawowe dane klienta |                    |
|-------------------------|--------------------|
| Imię                    | Jan                |
| Nazwisko                | Kowalski           |
| Adres                   | ValueObject(Adres) |

| Szczegółowe dane klienta |                    | Ograniczenie |
|--------------------------|--------------------|--------------|
| Nr dowodu                | ABC 129420         | XXX 123456   |
| PESEL                    | 01210158902        | 11 cyfr      |
---
| Zlecenie przelewu |                     |
|-------------------|---------------------|
| Tytuł             | "Zaliczenie TBO"    |
| Kwota             | ValueObject(Kwota)  |
| Nadawca           | Klient              |
| Odbiorca          | Klient              |

| Kwota            |     | Ograniczenie |
|------------------|-----|--------------|
| Część całkowita  | 123 | \>=0         |
| Część dziesiętna | 45  | <0-99>       |

