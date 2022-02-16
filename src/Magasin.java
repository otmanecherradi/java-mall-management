public class Magasin {

  private int numero;
  private String nom;
  private float superficie;
  private float montant;

  private static int counter = 0;

  public Magasin() {
    counter += 1;
  }

  public Magasin(String nom, float superficie, float montant) {
    this();

    this.numero = counter;

    this.nom = nom;
    this.superficie = superficie;
    this.montant = montant;
  }

  public Magasin(int numero, String nom, float superficie, float montant) throws CodeIncorrectException {
    this.setNumero(numero);
    this.nom = nom;
    this.superficie = superficie;
    this.montant = montant;
  }

  public static int getCounter() {
    return counter;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) throws CodeIncorrectException {
    if (numero < 0) {
      throw new CodeIncorrectException();
    }
    this.numero = numero;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public float getSuperficie() {
    return superficie;
  }

  public void setSuperficie(float superficie) {
    this.superficie = superficie;
  }

  public float getMontant() {
    return montant;
  }

  public void setMontant(float montant) {
    this.montant = montant;
  }

  public void infosMagasin() {
    System.out.println(toString());
  }

  @Override
  public String toString() {
    return "Magasin { numero = " + numero + ", nom = " + nom + ", superficie = " + superficie + ", montant = " + montant
        + "}";
  }
}
