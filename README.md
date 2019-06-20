# RMI-semaphore

**Opis projektu**

W ramach projektu przedstawiona została realizacja zdalnego semafora uogólnionego (zliczającego,
z możliwością opuszczenia/podniesienia o wartość wskazaną jako parametr) do synchronizacji zdalnych procesów.

**Wykorzystane narzędzia** 

Projekt został zrealizowany przy pomocy języka Java i narzędzia RMI.

**Struktura plików**
  
| Pik | Opis |
| ------ | ------ |
| Main.java | Klasa kliencka wykorzystująca zaimplentowane metody semafora |
| RegistryMain.java | Klasa tworząca rejestr |
| IRMISemaphore.java | Interfejs klasy dla zdalnego semafora |
| RMISemaphore.java | Klasa zdalnego semafora, w której zaimplementowane są metody `p` (opuść semafor), `v` (podnieś semafor) |
| IRMISemaphores.java | Interfejs klasy posiadającej metody tworzenia i pobierania zdalnego semafora |
| RMISemaphores.java  | Klasa implementująca metody tworzenia i pobierania zdalnego semafora |

**Opis implementacji klasy RMISemaphore**

Klasa posiada dwa atrybuty `id` i `localSemaphore` typu Semphore pochodzącego z biblioteki java.util.concurrent.
Podczas wykonywania operacji `p` semafor jest opuszczany za pomocą operacji `acquire` o odpowiednią wartość.
Podczas wykonywania operacji `v` semafor jest podnoszony za pomocą operacju `realease` o odpowiednią wartość.
Metody `acquire` i `release` również pochodzą z biblioteki java.util.concurent.

**Opis implementacji klasy RMISemaphores**

Klasa posiada listę utworzonych semaforów.
Umożliwia utworzenie nowego zdalnego semafora za pomocą metody `createSemaphore`, 
a także pobranie już istniejącego - metoda `getSemaphore`.
Za pomocą operacji `createSemaphore` tworzymy semafor i dodajemy go do listy semaforów, jeżeli taki semafor wcześniej nie istniał.

**Kompilacja**

`javac *.java`

**Uruchmomienie**
* rejestr &rarr; `java RegistryMain`
* klient &rarr; `java Main`
