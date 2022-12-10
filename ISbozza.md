# Progetto E-Commerce di chiavi digitali

## Breve descrizione

Il Sistema (Store online) presenta un catalogo di chiavi digitali (videogiochi) che può essere visualizzato dall’Utente che può filtrare tra le varie categorie.    
Il Sistema deve consentire la registrazione e il login all’Utente.  
L’Utente può eseguire il login per visualizzare lo storico degli acquisti e ricevere notizie ed offerte.    
Il Sistema deve permettere l’acquisto (prelievo della chiave richiesta dal database del Sistema e invio all’Utente tramite mail) di chiavi digitali sia ad Utenti loggati che ad Utenti “Guest” (senza login).  
Il Sistema deve mettere a disposizione un meccanismo di gestione (aggiunta e rimozioni di articoli) del carrello (in caso di utente loggato lo stato del carrello viene salvato, nel caso di utente Guest il carrello viene eliminato alla chiusura del sistema).   
Il sistema deve accettare metodi di pagamento diversificati (carta prepagata, carta di debito/credito ecc…).    
L’Admin può modificare il catalogo del sistema in ogni suo aspetto (Grafica e contenuto).    
Il Sistema avvisa l’Admin nel caso di prodotti esauriti.	   
L’Admin deve poter rifornire il sistema di chiavi digitali acquistandole da un Fornitore interfacciandosi direttamente con il database del fornitore (se nel database fornitore sono presenti chiavi digitali disponibili per l’acquisto, l’Admin preleva -compra- tale chiave e l’aggiunge al proprio database).   
(Per semplicità) Il Fornitore accetta gli stessi metodi di pagamento del Sistema.   


## Attori
- Utente
- Admin
- Fornitore
- Circuiti di pagamento 

## Glossario 
- Data1: Database del sistema con prodotti e credenziali
- Data2: Database fornitore
- Logged: visualizzazione utente registrato
- Manager: visualizzazione Admin registrato
- visualizzazione normale: visualizzazione della piattaforma descritta in caso d'uso 12
- Sinonimi: "prodotto", "articolo", chiave digitali"
- Sinonimi: "negozio", "store", "piattaforma"
 

## Casi D'uso
| ID  | Nome caso d'uso | Attori  | Descrizione | Trigger | Precondizioni | Postcondizioni  | Normal flow | alternative flow  | Eccezioni | Include |
|-----------|-----------|-------------|---------------|-----------------|-----------------|---------------|-----------------|----------------|-------------------|---------------|
| 01  | Modifica rappresentazione sistema     | Utente  | L'utente sfoglia gli articoli e modifica la visione tramite i filtri  |  Interazione dell'utente   |   nessuna  |  modifica interfaccia visualizzata  | l'utente sceglie il filtro da adottare e viene modificata l'interfaccia |  //  |   //  |    12    |
|02| Registrazione| Utente| l'utente effettua una nuova registrazione al sistema| Click su pulsante di registrazione| Utente non ancora registrato| Modifica dello status dell'utente| L'utente si interfaccia al sistema e crea un nuovo account| L'utente ha già un account associato, ne crea uno nuovo con altre credenziali| Account già esistente|//|
|03| Login| Utente, Admin| L'utente/admin accede al sistema| Click sul pulsante di accesso| Account già esistente| // | L'utente/admin usa le proprie credenziali per accedere al sistema| L'utente/admin riprova ad inserire le credenziali in caso di errore di battitura| Account non esistente| 02|
|04| Visualizzazione Profilo| Utente| L'utente visualizza informazioni personali e ne può modificare alcune| Click nella sezione Profilo| account esistente| // | L'utente accede alla sua area personale, visualizza le informazioni su notizie, offerte e storico acquisti e modifica alcune informazioni personali| // |//|03|
|05| Aggiunta Articolo| Utente| L'utente aggiunge un articolo al carrello| Interazione dell'utente con bottone| Nessuna| Modifica carrello| Utente sceglie, sistema controlla e aggiunge al carrello| //| Articolo esaurito| //|
|06| rimozione articolo| Utente| l'utente rimuove un articolo dal carrello| interazione col carrello| almeno un articolo nel carrello| modifica carrello| Utente sceglie cosa rimuovere, sistema rimuove dal carrello| //| //| //|
|07| Check  disponibilità| Utente| il sistema contatta il Data1 che gli restituisce la disponibilita dell'articolo| Richiesta dell'articolo| nessuna| Modifica etichetta articolo| L'Utente sceglie un aritocolo, il sistema fa un controllo con il Data1 che gli restituisce una flag| //| //|//|
|08| Pagamento Utente| Utente, Circuito di pagamento| l'utente deve  pagare con un circuito di pagamento a scelta| Interazione utente con procedura di pagamento| almeno un articolo nel carrello| modifica carrello, modifica data1| utente sceglie di pagare, il  pagamento viene processato, il carrello e i data modificati, e l'articolo viene spedito| pagamento non riuscito, ritorno alla schermata iniziale del carrello| errore pagamento| //|
|09| Modifica sistema| Admin| L'admin modifica il catalogo nella grafica e nei contenuti| Accesso ad area di modifica| Login effettuato| Modifica interfaccia sistema e/o data1| //|//|//| 03
|10| Avviso prodotti esauriti| Admin| Il sistema notifica all'admin l'esaurimento di chiavi specifiche| //| //|//|Il sistema avvisa l'Admin in seguito al rilevamento di prodotti esauriti|//|//|07|
|11| Acquisto da fornitore| Admin, Fornitore, Circuito di pagamento| L'admin acquista dal fornitore chiavi digitali| click su bottone|//|Aggiornamento catalogo| L'Admin preleva dal data2, dopo conferma dal circuito di pagamento, le chiavi acuistate|//|//|//|
|   12   |   Rappresentazione interfaccia sistema   |   Utente  |   L'Utente ha una rappresentazione degli articoli nel sistema  |  Apertura piattaforma    |   //  |   //  |   L'Utente puo navigare nel catalogo  |   //  |   //  |   //  |       
|   13    |   Visualizzazione del carrello    |   Utente    |   Rappresentazione degli articoli nel carrello    |   Interazione dell'utente con l'opzione carrello    |   //    |   //    |   L'utente può modificare e visualizzare gli articoli nel proprio carrello    |   //    |   //    |   //    |

### Normal flow dei casi d'uso

### 01

- L'utente si connette ad internet
- L'utente cerca il negozio su browser
- L'utente apre la piattaforma
- La piattaforma carica la visualizzazione
- L'utente sceglie il filtro che preferisce per la visualizzazione degli articoli
- Il sistema ricalcola la visualizzazione degli articoli includendo solo quelli che soddisfano i filtri
- Il sistema mostra la nuova visualizzazione della piattaforma

### 02

- La piattaforma ha già caricato la visualizzazione, con o senza filtri
- L'utente clicca sul bottone di **registrazione**
- La piattaforma apre una finestra di registrazione in cui sono presenti dei campi da riempire
- L'utente riempie i campi con le proprie informazioni personali 
  - nome
  - cognome
  - email
  - password
- L'utente clicca il bottone di **conferma**
- Il sistema memorizza le informazioni sul Data1
- Il sistema chiude la finestra di registrazione
- Il sistema ritorna sulla finestra di visualizzazione articoli come da inizio procedura, aprendo una finestra di **conferma avvenuta registrazione**
  
### 03

(Attore = Admin/Utente)
- La piattaforma ha già caricato la visualizzazione, con o senza filtri
- L'attore clicca sul bottone **accedi** 
- Il sistema apre una finestra di accesso con i campi da riempire
- L'attore inserisce i propri dati nei campi
  - email
  - password
- Dopo aver premuto **accedi** i campi riempiti vengono mandati al Data1
- Il Data1 controlla che i dati inseriti siano corretti e fa accedere l'attore al sistema
- Il sistema chiude la finestra di accesso
- In base al profilo dell'attore viene mostrata un diversa visualizzazione della piattaforma:
  - Utente -> **Logged** e visualizzazione normale della piattaforma
  - Nuove funzioni:
    - Aggiunta dell'opzione **profilo**
    - **rimozione opzioni di regitrazione**-> accedi, registrati
  - Admin -> **Manager**, visualizzazione normale della piattaforma
  - Nuove funzioni:
    - Modifica della visualizzazione home page
    - Gestione Inventario
    - Ordine chiavi da fornitore
    - **rimossa opzione** carrello
    - **rimosse opzioni di regitrazione**-> accedi, registrati

### 04

- L'utente ha già eseguito il login
- La piattaforma apre la finestra del **profilo**
- la finestra presenta diverse opzioni
  - **storico acquisti**: Il sistema fa visualizzare una nuova finestra all'utente, in questa sono presenti tutti gli acquisti passati, con le varie informazioni associate (**data acquisto**, **nome articolo**, **prezzo articolo**)
  
  - **notizie e offerte**: Il sistema fa visualizzare una nuova finestra all'utente, in questa vi sono tutte le notizie riguardanti nuovi articoli presenti nella piattaforma e offerte sui prodotti dispoibili in quel momento
  
  - **modifica informazioni personali**: Il sistema fa visualizzare una nuova finestra all'utente, nella quale sono presenti diversi bottoni con cui l'utente può interagire, che permettono di cambiare alcune informazioni personali(**password**, **indirizzo di fatturazione**, **metodi di pagamento**)
- una volta aperta la rispettiva finestra questa presenta un opzione per tornare indietro alla pagina del profilo

### 05

- La piattaforma ha già caricato la visualizzazione, con o senza filtri
- a questo punto l'utente sceglie l'articolo che vuole aggiungere al carrello
- l'utente interagisce col bottone **aggiungi al carrello**
- Il sistema comunica col **data1** per controllare la disponibilità dell'articolo
- viene confermata la disponibilità da parte del data1
- Il sistema aggiorna la visualizzazione dell'utente modificando l'icona del carrello ed il suo contenuto

### 06

- L'utente, tramite la relativa icona, accede alla **visualizzazione del carrello**
- l'utente sceglie l'articolo da rimuovere e interagisce col bottone **rimuovi**
- Il sistema aggiorna la visualizzazione del carrello ed il su contenuto rimuovendo l'articolo in questione e mantenendone eventuali altri

### 07

- L'utente si trova gìà nel catalogo
- L'utente sceglie il prodotto da acquistare
- Il sistema comunica con il data1 per verificarne la disponibilità
- Il sistema aggiorna l'etichetta del prodotto

### 08 (c'è anche l'alternative flow)

- L'utente, tramite apposita icona, accede sezione **carrello**
- L'utente procede all'acquisto tramine bottone dedicato
- Viene mostrata una finestra con tutti i metodi di pagamento disponibili
- L'utente ne sceglie uno
- Vengono mostrati i campi da riempire con le relative informazioni
- L'utente inserisce i dati
- Il circuito di pagamento verifica la correttezza dei dati:
  - In caso negativo lo notifica al sistema che ne permette il reinserimento
  - In caso affermativo processa la transazione
- Il circuito di pagamento verifica il saldo disponibile:
  - Se è sufficiente, il circuito di pagamento conferma la transazione detraendo la somma in questione e lo notifica al sistema che si occupa di inviare i/il prodotti/o al cliente
  - Se non è sufficiente, il circuito di pagamento lo notifica al sistema che visualizza una finestra apposita; l'utente viene reindirizzato alla scelta dei metodi di pagamento
- Dopo l'acquisto l'utente viene riportato alla schermata del carrello
- Il data1 viene aggiornato in base ai prodotti che sono stati acquistati e quindi vengono eliminati da quelli disponibili

### 09

- L'admin si collega al negozio tramite browser
- Il sistema mostra la visualizzazione normale
- L'admin accede con le proprie credenziali tramite il bottone **Accedi**
- Il sistema riconosce l'admin dalle credenziali inserite
- Viene mostrata la visualizzazione **Manager** dello store
- L'admin entra nella sezione di **Modifica** tramite apposito bottone
- Vengono mostrate nuove opzioni:
  - Modifica prodotti disonibili (prezzo, quantità E rimozione)
  - Aggiunta nuovi prodotti
  - Modifica grafica del negozio
- In base alle modifiche apportate viene modificato data1
- Al termine delle modifiche viene visualizzata un'anteprima dello store

### 10

- Dopo ogni transazione viene effettuato un controllo
- Il sistema verifica lo stato dei prodotti (tramite apposite etichette)
- Il sistema notifica all'admin i prodotti non più disponibili aggiungendo un messaggio con la lista completa nella sezione dedicata

### 11

- L'admin ha già effettuato l'accesso
- L'admin viene reindirizzato al data2 tramite apposito bottone prensente nella visualizzazione Manager
- L'admin sceglie queli prodotti acquistare
- L'admin sceglie il metodo di pagamento
- L'admin inserisce i dati di pagamento
- Il circuito di pagamento processa la transazione
- Il circuito di pagamento notifica l'avvenuta transazione al sistema
- Il sistema aggiorna il data1 con i nuovi prodotti
- Il data2 viene aggiornato (modifica etichetta relativa alla quantità dei prodotti)
- Al termine del processo, l'admin viene reindirizzato alla visualizzazione del data2


### 12

- L'utente cerca la piattaforma tramite browser
- L'utente apre la piattaforma
- Il sistema carica la visualizzazione iniziale della piattaforma, questa contiene, oltre alla rappresentazione degli articoli del catalogo messi in ordine **di rilevanza**, diverse opzioni
  - **accedi**
  - **registrati**
  - **carrello**
  - **filtra per:**
- L'utente può interagire con ognuno di questi, provocando una modifica della visualizzazione, gestita dal sistema

### 13

- L'utente interagisce con l'opzione carrello a partire dalla visualizzazione normale 
- Il sistema apre la finestra del carrello, questa contiene
  - visualizzazione degli articoli con relativa quantità
  - opzione di rimozione degli articoli, per ogni articolo
  - opzione di pagamento degli articoli presenti nel carrello
- L'utente può interagire con ognuna delle opzioni presenti
- L'utente può decidere di tornare alla visualizzazione precedente tramite la relativa opzione

