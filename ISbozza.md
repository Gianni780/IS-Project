# Progetto E-Commerce di chiavi digitali

## Breve descrizione

Il sito deve essere in grado di offrire una vasta gamma di articoli (chiavi digitali) che possono essere sfogliate dall'utente tramite filtri scelti dallo stesso;  
Gli articoli devono poter essere aggiunti e rimossi dal carrello, se questi sono disponibili;  
L'utente deve poter pagare con un circuito di pagamento a scelta tra almeno 2;  
Il sito deve poi offrire un sistema di login dell'utente per eventuali comunicazioni, offerte e visualizzazione dello storico (se sprovvisto di credenziali l'utente puo acquistare da ospite);

## Attori
- Utente
- Database prodotti disponibili(Data1)
- Database credenziali e storico(Data2)
- Database fornitore(Data3)
- Circuiti di pagamento  
 

## Casi D'uso
|ID|Nome caso d'uso|Attori|Descrizione|Trigger|Precondizioni|Postcondizioni|Normal flow|alternative flow|Eccezioni|Include|
|-|-|-|-|-|-|-|-|-|-|-|
01|Rappresentazione interfaccia negozio|Utente|L'utente deve sfogliare gli articoli e modificare la visione tramite i filtri| Interazione dell'utente/apertura pagina web| nessuna| modifica interfaccia|l'utente sceglie il filtro da adattare e viene modificata l'interfaccia| // | // | //|
|02| Aggiunta Articolo| Utente| L'utente aggiunge un articolo al carrello| Interazione dell'utente con bottone| Nessuna| Modifica carrello| Utente sceglie, sistema controlla e aggiunge al carrello| //| Articolo esaurito| //|
03| rimozione articolo| Utente| l'utente rimuove un articolo dal carrello| interazione col carrello| almeno un articolo nel carrello| modifica carrello| Utente sceglie cosa rimuovere, sistema rimuove dal carrello| //| //| //|
04| Check database disponibilità| Data2| il sistema contatta il Data2 che gli restituisce la disponibilita dell'articolo| Richiesta dell'articolo| nessuna| Modifica etichetta articolo| il Data2 restituisce una flag al sistema| //| //|//|
05| Pagamento| Utente, Data2, Data1| l'utente deve poter pagare con un circuito di pagamento a sua scelta| Interazione utente con procedura di pagamento| almeno un articolo nel carrello| modifica carrello, modifica data1 e data2| utente sceglie di pagare, il  pagamento viene processato, il carrello e i data modificati, e l'articolo viene spedito| pagamento non riuscito, ritorno alla schermata iniziale del carrello| errore pagamento| //|

sesso sesso





