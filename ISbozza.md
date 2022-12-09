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
- Database prodotti disponibili(Data1)
- Database fornitore(Data2)
- Logged: visualizzazione utente registrato
- Manager: visualizzazione Admin registrato
 

## Casi D'uso
|ID|Nome caso d'uso|Attori|Descrizione|Trigger|Precondizioni|Postcondizioni|Normal flow|alternative flow|Eccezioni|Include|
|-----------|-----------|-------------|---------------|-----------------|-----------------|---------------|-----------------|----------------|-------------------|---------------|
|01|Modifica rappresentazione sistema   |Utente|L'utente sfoglia gli articoli e modifica la visione tramite i filtri| Interazione dell'utente   |   nessuna| modifica interfaccia visualizzata|l'utente sceglie il filtro da adottare e viene modificata l'interfaccia| // | // |    12    |
|02| Registrazione| Utente| l'utente effettua una nuova registrazione al sistema| Click su pulsante di registrazione| Utente non ancora registrato| Modifica dello status dell'utente| L'utente si interfaccia al sistema e crea un nuovo account| L'utente ha già un account associato, ne crea uno nuovo con altre credenziali| Account già esistente|//|
|03| Login| Utente, Admin| L'utente/admin accede al sistema| Click sul pulsante di accesso| Account già esistente| // | L'utente/admin usa le proprie credenziali per accedere al sistema| L'utente/admin riprova ad inserire le credenziali in caso di errore di battitura| Account non esistente| 02|
|04| Visualizzazione storico e notizie| Utente| L'utente dopo l'accesso può visualizzare lo storico degli acquisti e le notizie su offerte e promozioni| Click nella sezione Profilo| account esistente| // | L'utente accede alla sua area personale e visualizza le informazioni di interesse| // |//|03|
|05| Aggiunta Articolo| Utente| L'utente aggiunge un articolo al carrello| Interazione dell'utente con bottone| Nessuna| Modifica carrello| Utente sceglie, sistema controlla e aggiunge al carrello| //| Articolo esaurito| //|
|06| rimozione articolo| Utente| l'utente rimuove un articolo dal carrello| interazione col carrello| almeno un articolo nel carrello| modifica carrello| Utente sceglie cosa rimuovere, sistema rimuove dal carrello| //| //| //|
|07| Check  disponibilità| //| il sistema contatta il Data1 che gli restituisce la disponibilita dell'articolo| Richiesta dell'articolo| nessuna| Modifica etichetta articolo| il Data1 restituisce una flag al sistema| //| //|//|
|08| Pagamento Utente| Utente, Circuito di pagamento| l'utente deve  pagare con un circuito di pagamento a scelta| Interazione utente/admin con procedura di pagamento| almeno un articolo nel carrello| modifica carrello, modifica data1| utente sceglie di pagare, il  pagamento viene processato, il carrello e i data modificati, e l'articolo viene spedito| pagamento non riuscito, ritorno alla schermata iniziale del carrello| errore pagamento| //|
|09| Modifica sistema| Admin| L'admin modifica il catalogo nella grafica e nei contenuti| Accesso ad area di modifica| Login effettuato| Modifica interfaccia sistema e/o data1| //|//|//| 03
|10| Avviso prodotti esauriti| Admin| Il sistema notifica all'admin l'esaurimento di chiavi specifiche| Modifica etichetta prodotto| //|//|Il sistema avvisa l'Admin in seguito al rilevamento di prodotti esauriti|//|//|07|
|11| Acquisto da fornitore| Admin, Fornitore, Circuito di pagamento| L'admin acquista dal fornitore chiavi digitali| click su bottone|//|Aggiornamento catalogo| L'Admin preleva dal data2, dopo conferma dal circuito di pagamento, le chiavi acuistate|//|//|//|
|   12   |   Rappresentazione interfaccia sistema   |   Utente  |   L'Utente ha una rappresentazione degli articoli nel sistema  |  Apertura piattaforma    |   //  |   //  |   L'Utente puo navigare nel catalogo  |   //  |   //  |   //  |       

### Normal flow dei casi d'uso

### 01

- L'utente apre la piattaforma
- La piattaforma carica la visualizzazione
- L'utente sceglie il filtro che preferisce per la visualizzazione degli articoli
- Il sistema ricalcola la visualizzazione degli articoli includendo solo quelli che soddisfano i filtri
- L'utente vede la nuova visualizzazione della piattaforma

### 02

- La piattaforma ha già caricato la visualizzazione, con o senza filtri
- L'utente clicca sul bottone con su scritto **registrazione**
- La piattaforma apre una finestra di registrazione in cui sono presenti dei campi da riempire
- L'utente riempie i campi con le proprie informazioni personali 
  - nome
  - cognome
  - email
  - password
- L'utente clicca il bottone di conferma (**conferma**)
- Il sistema memorizza le informazioni sul Data1
- Il sistema chiude la finestra di registrazione
- Il sistema ritorna sulla finestra di visualizzazione articoli come da inizio procedura, aprendo una finestra di **conferma avvenuta registrazione** al di sopra di questa

### 03

(Attore = Admin/Utente)
- La piattaforma ha già caricato la visualizzazione, con o senza filtri
- L'attore clicca sul bottone **accedi** sulla finestra
- Il sistema apre una finestra di accesso con i campi da riempire
- L'attore inserisce i propri dati nei campi
  - email
  - password
- Dopo aver premuto **accedi** i campi riempiti vengono mandati al Data1
- Il Data1 controlla che i dati inseriti siano corretti e fa accedere l'attore al sistema
- Il sistema chiude la finestra di accesso e la finestra iniziale di visualizzazione
- In base al profilo dell'attore vengono aperte delle finestre distinte
- Utente, **Logged**,  visualizzazione normale della piattaforma, con aggiunta di opzione per il **profilo**
- Admin, **Manager**, visualizzazione normale della piattaforma, aggiunta di opzioni
  - Modifica visualizzazione home page
  - Inventario
  - Ordina chiavi fornitore

### 04

- La piattaforma apre la finestra del **profilo**
- la finestra presenta diverse opzioni
  - storico acquisti
 
  - notizie e offerte
  - modifica informazioni personali


