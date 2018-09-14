class Automezzo {

    private String marca;
    private String modello;
    private String numeroTarga;
    private int annoImmatricolazione;
    private int annoRevisione;

    //default constructor
    public Automezzo() {
        super();
        marca = " ";
        modello = " ";
        numeroTarga = " ";
        annoImmatricolazione = 0;
        annoRevisione = 0;
    }

    //parametrizied constructor
    public Automezzo(String marca, String modello, String numeroTarga, int annoImmatricolazione, int annoRevisione) {
        super();
        this.marca = marca;
        this.modello = modello;
        this.numeroTarga = numeroTarga;
        this.annoImmatricolazione = annoImmatricolazione;
        this.annoRevisione = annoRevisione;
    }

    //getters and setters
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getModello() {
        return modello;
    }

    public String getNumeroTarga() {
		return numeroTarga;
	}

	public void setNumeroTarga(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}

	public int getAnnoImmatricolazione() {
		return annoImmatricolazione;
	}

	public void setAnnoImmatricolazione(int annoImmatricolazione) {
		this.annoImmatricolazione = annoImmatricolazione;
	}

	public int getAnnoRevisione() {
		return annoRevisione;
	}

	public void setAnnoRevisione(int annoRevisione) {
		this.annoRevisione = annoRevisione;
    }
    
    //print elements
    public void stampaAutomezzo() {
        System.out.println(getMarca() +" "+ getModello() +" "+ getNumeroTarga() +" "+ getAnnoImmatricolazione() +" "+ getAnnoRevisione());
    }
}