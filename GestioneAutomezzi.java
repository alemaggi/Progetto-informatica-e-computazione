import java.util.Scanner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;


class GestioneAutomezzi {
    //numero auto contenute nel sistema (aggiunto da me in quanto mi sembra una cosa sensata da avere)
    private int numeroAutomezzi;

    //arrayList di tipo automezzi
    private ArrayList<Automezzo> automezzi;

    //creo un arraylist per contenere i veicoli gia stampati
    private ArrayList<Automezzo> automezziSenzaDuplicati;


    //Constructor
    public GestioneAutomezzi() {
        automezzi = new ArrayList<Automezzo>();
        automezziSenzaDuplicati = new ArrayList<Automezzo>();
        numeroAutomezzi = 0;
    }

    //numeroAutomezzi settere & getter
    public void setNumeroAutomezzi(int numeroAutomezzi) {
        this.numeroAutomezzi = numeroAutomezzi;
    }

    public int getNumeroAutomezzi() {
        return numeroAutomezzi;
    }
   
    //metodo per l'aggiunta di nuovi veicoli
    public void aggiungiSingoloAutomezzo() {
        Scanner scannerOne = new Scanner(System.in);
        Automezzo automezzoVuoto = new Automezzo(" ", " ", " ", 0, 0);
        automezzi.add(automezzoVuoto);
        String marca;
        String modello;
        String numeroTarga;
        int annoImmat;
        int annoRev;

        //inserimento marca
        System.out.println("Inserire la marca del veicolo");
        marca = scannerOne.nextLine();
        automezzi.get(automezzi.size() - 1).setMarca(marca);
        //inserimento modello
        System.out.println("Inserire il modello del veicolo");
        modello = scannerOne.next();
        automezzi.get(automezzi.size() - 1).setModello(modello);
        //inserimento numero di targa
        System.out.println("Inserire la targa del veicolo");
        numeroTarga = scannerOne.next();
        automezzi.get(automezzi.size() - 1).setNumeroTarga(numeroTarga);
        //inserimento anno immatricolazione
        System.out.println("Inserire l' anno di immatricolazione del veicolo");
        annoImmat = scannerOne.nextInt();
        automezzi.get(automezzi.size() - 1).setAnnoImmatricolazione(annoImmat);
        //inserimento anno revisione
        System.out.println("Inserire l' anno di revisione del veicolo");
        annoRev = scannerOne.nextInt();
        automezzi.get(automezzi.size() - 1).setAnnoRevisione(annoRev);

        numeroAutomezzi++;
    }

    //metodo per aggiungere N automezzi
    public void aggiungiAutomezzi() {
        Scanner scannerOne = new Scanner(System.in);
        System.out.println("Inserire il numero di automezzi che si vogliono inserire");
        int N = scannerOne.nextInt();
        
        for (int i = 0; i < N; i++) {
            aggiungiSingoloAutomezzo();
        }
        numeroAutomezzi += N;
    }

    //metodo per aggiungere un  nuovo automezzo (quindi con anno immatricolazione e revisione = anno corrente)
    public void aggiungiNuovoAutomezzo() {
        Scanner scannerOne = new Scanner(System.in);
        Automezzo automezzoVuoto = new Automezzo(" ", " ", " ", 0, 0);
        automezzi.add(automezzoVuoto);
        String marca;
        String modello;
        String numeroTarga;
        int annoImmat;
        int annoRev;

        //anno corrente
        Calendar now = Calendar.getInstance();
        int annoCorrente = now.get(Calendar.YEAR);

        //inserimento marca
        System.out.println("Inserire la marca del veicolo");
        marca = scannerOne.nextLine();
        automezzi.get(automezzi.size() - 1).setMarca(marca);
        //inserimento modello
        System.out.println("Inserire il modello del veicolo");
        modello = scannerOne.next();
        automezzi.get(automezzi.size() - 1).setModello(modello);
        //inserimento numero di targa
        System.out.println("Inserire la targa del veicolo");
        numeroTarga = scannerOne.next();
        automezzi.get(automezzi.size() - 1).setNumeroTarga(numeroTarga);
        //inserimento anno immatricolazione
        annoImmat = annoCorrente;
        automezzi.get(automezzi.size() - 1).setAnnoImmatricolazione(annoImmat);
        //inserimento anno revisione
        annoRev = annoCorrente;
        automezzi.get(automezzi.size() - 1).setAnnoRevisione(annoRev);

        numeroAutomezzi++;
    }

    //metodo per la cancellazione di un veicolo data la targa
    public void cancellaAutomezzo() {
        System.out.println("Inserire la targa del veicolo che si desidera cancellare");
        Scanner scannerOne = new Scanner(System.in);
        String targa = scannerOne.next();
        for (int i = 0; i < automezzi.size(); i++) {
            if (targa.equals(automezzi.get(i).getNumeroTarga())) {
                automezzi.remove(i);
                System.out.println("Veicolo rimosso con successo");
            }
        }
    }

    //metodo per ricercare e stampare tutti i veicoli data la targa 
    public void trovaVeicoliDataTarga() {
        System.out.println("Inserire la targa del veicolo che si deisdera ricercare nell' elenco");
        Scanner scannerOne = new Scanner(System.in);
        String targa = scannerOne.next();
        for (int i = 0; i < automezzi.size(); i++) {
            if (targa.equals(automezzi.get(i).getNumeroTarga())) {
                System.out.println("La ricerca sui veicoli data la targa " +targa+ " ha prodotto il seguente risultato:");
                automezzi.get(i).stampaAutomezzo();
            }
        }
    }

    /*metodo per ricercare e stampare  tutti i veicoli in cui l’anno dell’ultima revisione:
    1): coincide con l’anno di immatricolazione ed è antecedente di 4 anni rispetto all’anno corrente, oppure
    2): è antecedente di 2 anni rispetto all’anno corrente*/
    public void trovaVeicoliDataImmatricolazione() {
        /*System.out.println("Inserire l' anno di immatricolazione");
        Scanner scannerOne = new Scanner(System.in);
        String annoImmatricolazione = scannerOne.next();*/

        //anno corrente
        Calendar now = Calendar.getInstance();
        int annoCorrente = now.get(Calendar.YEAR);

        //definisco una variabile che rappresenta l'anno corrente meno due 
        int annoCorMenoQuattro = annoCorrente - 4;
        int annoCorMenoDue = annoCorrente - 2;

        System.out.println("La ricerca sui veicoli dato l'anno di revisione e l'anno corrente " +annoCorrente+ " ha prodotto il seguente risultato:");
        for (int i = 0; i < automezzi.size(); i++) {
            if (((automezzi.get(i).getAnnoRevisione() == automezzi.get(i).getAnnoImmatricolazione()) && (automezzi.get(i).getAnnoRevisione() == annoCorMenoQuattro)) || ((automezzi.get(i).getAnnoRevisione() == annoCorMenoDue))) { 
                automezzi.get(i).stampaAutomezzo();
            }
        }
    }

    //metodo per stampare i veicoli senza ridondanze tra i modelli
    public void stampaVeicoliSenzaRidondanze() {
        for (int a = 0; a < automezzi.size(); a++) {
            automezziSenzaDuplicati.add(a, automezzi.get(a));
        }
        for(int i = 0; i < automezziSenzaDuplicati.size(); i++) {
            for(int j = i + 1; j < automezziSenzaDuplicati.size(); j++) {
                if(automezziSenzaDuplicati.get(i).getModello().equals(automezziSenzaDuplicati.get(j).getModello())){
                    automezziSenzaDuplicati.remove(j);
                    j--;
                }
            }
        }
        for (int k = 0; k < automezziSenzaDuplicati.size(); k++)
            automezziSenzaDuplicati.get(k).stampaAutomezzo();
    }

    //metodo per stampare tutti gli automezzi
    public void stampaTutto() {
        for (int i = 0; i < automezzi.size(); i++)
            automezzi.get(i).stampaAutomezzo();
    }

    //main 
    public static void main(String[] args) {
        
        GestioneAutomezzi auto = new GestioneAutomezzi();

        Scanner reader = new Scanner(System.in);

        boolean continuare = true;

        while (continuare) {
            System.out.println("Selezionare la funzione che si vuole eseguire dalla seguente lista: ");
            System.out.println("1: Aggiunta di N elementi.");
            System.out.println("2: Aggiunta di un singolo elemento.");
            System.out.println("3: Aggiunta di un nuovo elemento (veicolo appena acquistato).");
            System.out.println("4: Eliminazione di un veicolo dall' elenco data la targa.");
            System.out.println("5: Ricerca e stampa a video dei veicoli con una data targa.");
            System.out.println("6: Ricerca e stampa  tutti i veicoli dato l’anno dell’ultima revisione.");
            System.out.println("7: Stampa di tutti i veicoli senza ridondanze tra i modelli.");
            System.out.println("8: Stampa di tutti i veicoli");
           
            System.out.println("Inserire il valore della funzione desiderata");
            int funzioneScelta = reader.nextInt();
            switch (funzioneScelta) {
                case 1:
                    auto.aggiungiAutomezzi();
                    break;
                case 2:
                    auto.aggiungiSingoloAutomezzo();
                    break;
                case 3:
                    auto.aggiungiNuovoAutomezzo();
                    break;
                case 4:
                    auto.cancellaAutomezzo(); 
                    break;
                case 5:
                    auto.trovaVeicoliDataTarga(); 
                    break;
                case 6:
                    auto.trovaVeicoliDataImmatricolazione();
                    break;
                case 7:
                    auto.stampaVeicoliSenzaRidondanze();
                    break;
                case 8:
                    auto.stampaTutto();
                    break;
            }
            
            boolean inputInvalido = true;
            while (inputInvalido) {
                System.out.println("Si desidera continuare ? (si/no)");
                String sceltaUtente = reader.next();

                if ("si".equalsIgnoreCase(sceltaUtente))
                    inputInvalido = false;
                else if ("no".equalsIgnoreCase(sceltaUtente)) {
                    inputInvalido = false;
                    continuare = false;
                }
                else
                    System.out.println("Errore: gli unici valori accettati sono si/no");
            }
        } 
        reader.close();
    }
}