public class AmeublementMagasin extends Magasin {

  private AmeublementMagasinCategorie categorie;

  public AmeublementMagasin() {
    super();
  }

  public AmeublementMagasin(String nom, float superficie, float montant, AmeublementMagasinCategorie categorie) {
    super(nom, superficie, montant);
    this.categorie = categorie;
  }

  public AmeublementMagasin(int numero, String nom, float superficie, float montant,
      AmeublementMagasinCategorie categorie) throws CodeIncorrectException {
    super(numero, nom, superficie, montant);
    this.categorie = categorie;
  }

  public AmeublementMagasinCategorie getCategorie() {
    return categorie;
  }

  public void setCategorie(AmeublementMagasinCategorie categorie) {
    this.categorie = categorie;
  }

  @Override
  public String toString() {
    return "AmeublementMagasin { numero = " + getNumero() + ", nom = " + getNom() + ", superficie = " + getSuperficie()
        + ", montant = " + getMontant() + ", categorie = " + categorie.toString()
        + "}";
  }
}
